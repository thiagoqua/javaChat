import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EnvidoServer{

    private DatagramSocket server;
    private DatagramPacket pack;
    private byte[] info;
    private int port;

    public EnvidoServer(int port){
        try{
            this.port = port;
            server = new DatagramSocket(this.port);
            info = new byte[128];
            System.out.println("Server created successfully.");
        } catch(IOException e){}
    }

    public String welcome(){                             //go del servidor devuelve lo leido
        try{
            pack = new DatagramPacket(info,info.length);
            server.receive(pack);
        } catch(IOException e){
            System.out.println("no pudimos recibir");
            return null;
        }
    return new String(pack.getData());}

    public boolean send(Object o){
        String toSend = o.toString();
        try{
            DatagramSocket sendIt = new DatagramSocket();
            pack = new DatagramPacket(toSend.getBytes(),toSend.length(),InetAddress.getLocalHost(),port);
            sendIt.send(pack);
        } catch(UnknownHostException uhe){
            System.out.println("host no encontrado");
        } catch(IOException ioe){
            System.out.println("no se pudo enviar");
            return false;
        }
    return true;}

    public void close(){server.close();}
}