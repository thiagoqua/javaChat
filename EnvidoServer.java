import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EnvidoServer{
    private ServerSocket ss;
    private Socket cl;
    private InputStream in;
    private OutputStream out;

    public EnvidoServer(int port){
        try{
            ss = new ServerSocket(port);
            System.out.println("Server created successfully.");
        } catch(IOException e){}
    }

    public void start(){
        BufferedReader br;
        BufferedWriter bw;
        String leido;
        try{
            cl = ss.accept();
            in = cl.getInputStream();
            out = cl.getOutputStream();
            br = new BufferedReader(new InputStreamReader(in));
            bw = new BufferedWriter(new OutputStreamWriter(out));
            if((leido = br.readLine()) != null){
                // bw.write(leido);
                // bw.newLine();
                // bw.flush();
                System.out.println(leido);
            }
        } catch(IOException e){}
    }

    public void close(){
        try{
            ss.close();
            cl.close();
            in.close();
            out.close();
        } catch(IOException e){
            System.out.println("cannot close");
        }
    }

    public static void main(String[] args){
        EnvidoServer es = new EnvidoServer(3333);
        es.start();
        es.close();
    }
}