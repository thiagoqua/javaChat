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

    public int start(){                             //start del servidor devuelve lo leido
        BufferedReader br;
        BufferedWriter bw;
        int leido = -1;
        try{
            cl = ss.accept();
            in = cl.getInputStream();
            out = cl.getOutputStream();
            br = new BufferedReader(new InputStreamReader(in));
            bw = new BufferedWriter(new OutputStreamWriter(out));
            if((leido = br.read()) < 0){
                System.out.println(leido);
            }
        } catch(IOException e){
            System.out.println("no pudimos leer");
        }
    return leido;}

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
}