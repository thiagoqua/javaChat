import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EnvidoClient{

    private Socket client;
    private DataInputStream din;
    private DataOutputStream dout;

    public EnvidoClient(String ip,int port){
        try{
            client = new Socket(InetAddress.getByName(ip),port);
            System.out.println("client succesfully connected");
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }

    public String receive(){
        String readed = new String();
        try{
            din = new DataInputStream(client.getInputStream());
            readed = din.readUTF();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    return readed;}

    public void send(String str){
        try{
            dout = new DataOutputStream(client.getOutputStream());
            dout.writeUTF(str);
            dout.flush();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}