import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class EnvidoClient{
    private Socket s;
    private InputStream in;
    private OutputStream out;                   
    private DataInputStream din;
    private DataOutputStream dout;
    private boolean isInitIn;
    private boolean isInitOut;

    public EnvidoClient(String ip,int port){
        try{
            s = new Socket("localhost",port);
            isInitIn = isInitOut = false;
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    private void inicializeOut(){
        try{
            out = s.getOutputStream();
            dout = new DataOutputStream(out);
            isInitOut = true;
        } catch(IOException ie){
            System.out.println("no se pudo iniciializar output");
        }
    }

    private void inicializeIn(){
        try{
            in = s.getInputStream();
            din = new DataInputStream(in);
            isInitIn = true;
        } catch(IOException ie){
            System.out.println("no se pudo inicializar input");
        }
    }

    public String recieve(){
        String leido = new String();
        if(!isInitIn)
            inicializeIn();
        try{
            if((leido = din.readUTF()) != null)
                return leido;
        } catch(IOException ie){
            System.out.println("no pudimos leer");
        }
    return null;}

    public boolean send(Object o){
        if(!isInitOut)
            inicializeOut();
        try{
            dout.writeUTF(o.toString());
            dout.flush();
        } catch(IOException e){
            System.out.println("no pudimos enviar");
        }
    return true;}

    public void close(){
        try{
            s.close();
            in.close();
            out.close();
            din.close();
            dout.close();
        } catch(IOException e){
            System.out.println("cannot close");
        }
    }

    public static void main(String[] args) {
        String leimos = new String();
        Mazo m = new Mazo();
        EnvidoClient ec = new EnvidoClient("",3333);
        Carta toSend = new Carta();
        for(int i = 0;i<3;++i){
            toSend = m.sacar();
            ec.send(toSend.hashCode());
        }
        leimos = ec.recieve();
        System.out.println("\nleimos " + leimos);
        ec.close();
    }
}