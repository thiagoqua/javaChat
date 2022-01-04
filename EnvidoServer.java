import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutput;
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
    private DataInputStream din;
    private DataOutputStream dout;
    private boolean isInitIn;
    private boolean isInitOut;

    public EnvidoServer(int port){
        try{
            ss = new ServerSocket(port);
            isInitIn = isInitOut = false;
            System.out.println("Server created successfully.");
        } catch(IOException e){}
    }

    private void inicializeIn(){
        try{
            cl = ss.accept();
            in = cl.getInputStream();
            din = new DataInputStream(in);
            isInitIn = true;
        } catch(IOException ie){
            System.out.println("no se pudo inicializar input");
        }
    }

    private void inicializeOut(){
        try{
            out = cl.getOutputStream();
            dout = new DataOutputStream(out);
            isInitOut = true;
        } catch(IOException ie){
            System.out.println("no se pudo inicializar output");
        }
    }

    public String recieve(){                             //go del servidor devuelve lo leido
        String leido = new String();
        if(!isInitIn)
            inicializeIn();
        try{
            if((leido = din.readUTF()) != null)
                return leido;
        } catch(IOException e){
            System.out.println("no pudimos leer");
        }
    return null;}

    public boolean send(Object o){
        if(!isInitOut)
            inicializeOut();
        try{
            dout.writeUTF(o.toString());
            dout.flush();
        } catch(IOException ie){
            return false;
        }
    return true;}

    public void close(){
        try{
            ss.close();
            cl.close();
            in.close();
            out.close();
            din.close();
            dout.close();
        } catch(IOException e){
            System.out.println("cannot close");
        }
    }
}