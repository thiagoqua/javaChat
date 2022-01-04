import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
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
    BufferedReader br;
    BufferedWriter bw;

    public EnvidoServer(int port){
        try{
            ss = new ServerSocket(port);
            System.out.println("Server created successfully.");
        } catch(IOException e){}
    }

    public String welcome(){                             //go del servidor devuelve lo leido
        String leido = new String();
        try{
            cl = ss.accept();
            in = cl.getInputStream();
            br = new BufferedReader(new InputStreamReader(in));
            if((leido = br.readLine()) != null){
                return leido;
            }
        } catch(IOException e){
            System.out.println("no pudimos leer");
        }
    return null;}

    public boolean send(Object o){
        try{
            out = cl.getOutputStream();
            DataOutputStream dos = new DataOutputStream(out);
            dos.writeUTF(o.toString());
            dos.flush();
        } catch(IOException ie){
            return false;
        }
    return true;}

    public void close(){
        try{
            ss.close();
            cl.close();
            in.close();
            //out.close();
        } catch(IOException e){
            System.out.println("cannot close");
        }
    }
}