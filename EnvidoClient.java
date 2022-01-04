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

    public EnvidoClient(String ip,int port){
        try{
            s = new Socket("localhost",port);
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    public String recieve(){
        String leido = new String();
        try{
            in = s.getInputStream();
            din = new DataInputStream(in);
            if((leido = din.readUTF()) != null)
                return leido;
        } catch(IOException ie){
            System.out.println("no pudimos leer");
        }
    return null;}

    public boolean send(Object o){
        try{
            out = s.getOutputStream();
            dout = new DataOutputStream(out);
            dout.writeUTF(o.toString());
            dout.flush();
        } catch(IOException e){
            return false;
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
        Carta toSend = m.sacar();
        EnvidoClient ec = new EnvidoClient("",3333);
        ec.send(Integer.toString(toSend.hashCode()));
        leimos = ec.recieve();
        System.out.println("DESDE CLIENTE\nleimos " + leimos);
        ec.close();
    }
}