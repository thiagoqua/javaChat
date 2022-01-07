import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class EnvidoServer{
    
    ServerSocket server;
    Socket listener;
    DataInputStream din;
    DataOutputStream dout;

    public EnvidoServer(int port){
        try{
            server = new ServerSocket(port);
            System.out.println("server succesfully created");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public String receive(){
        String readed = new String();
        try{
            listener = server.accept();
            din = new DataInputStream(listener.getInputStream());
            readed = din.readUTF();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    return readed;}

    public void send(Object o){
        try{
            dout = new DataOutputStream(listener.getOutputStream());
            dout.writeUTF(o.toString());
            dout.flush();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public void closeAll(){
        try{
            server.close();
            listener.close();
            din.close();
            dout.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}