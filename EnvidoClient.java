import java.io.BufferedReader;
import java.io.BufferedWriter;
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

    public EnvidoClient(String ip,int port){
        try{
            s = new Socket("localhost",port);
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    public void start(){
        BufferedReader br;
        BufferedWriter bw;
        String escribo = new String("ANDA PADRE");
        try{
            in = s.getInputStream();
            out = s.getOutputStream();
            br = new BufferedReader(new InputStreamReader(in));
            bw = new BufferedWriter(new OutputStreamWriter(out));
            bw.write(escribo);
            bw.newLine();
            bw.flush();
        } catch(IOException e){}
    }

    public void close(){
        try{
            s.close();
            in.close();
            out.close();
        } catch(IOException e){
            System.out.println("cannot close");
        }
    }

    public static void main(String[] args) {
        EnvidoClient ec = new EnvidoClient("",3333);
        ec.start();
        ec.close();
    }
}