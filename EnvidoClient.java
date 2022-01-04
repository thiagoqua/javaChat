import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
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
    BufferedReader br;
    BufferedWriter bw;

    public EnvidoClient(String ip,int port){
        try{
            s = new Socket("localhost",port);
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    public String welcome(){
        String leido = new String();
        try{
            in = s.getInputStream();
            DataInputStream dis = new DataInputStream(in);
            leido = dis.readUTF();
        } catch(IOException ie){
            System.out.println("no pudimos leer");
        }
    return leido;}

    public boolean send(Object o){
        try{
            out = s.getOutputStream();
            bw = new BufferedWriter(new OutputStreamWriter(out));
            bw.write(o.toString());
            bw.newLine();
            bw.flush();
        } catch(IOException e){
            return false;
        }
    return true;}

    public void close(){
        try{
            s.close();
            //in.close();
            out.close();
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
        leimos = ec.welcome();
        System.out.println("DESDE CLIENTE\nleimos " + leimos);
        ec.close();
    }
}