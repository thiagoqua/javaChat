import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EnvidoClient{

    private DatagramSocket client;
    private DatagramPacket pack;
    private byte[] info;
    private int port;
    private InetAddress host;

    public EnvidoClient(String ip,int port){
        try{
            client = new DatagramSocket();
            info = new byte[128];
            this.port = port;
            //host = InetAddress.getByName(ip);
            host = InetAddress.getLocalHost();
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    public String welcome(){
        try{
            client = new DatagramSocket(port);
            pack = new DatagramPacket(info,info.length);
            client.receive(pack);
        } catch(IOException ioe){
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
            System.out.println("no encontramos el host");
        } catch(IOException ioe){
            System.out.println("no se pudo enviar");
            return false;
        } 
    return true;}

    public void close(){client.close();}

    public static void main(String[] args) {
        String leimos = new String();
        Mazo m = new Mazo();
        EnvidoClient client = new EnvidoClient("192.168.0.211",3333);
        Carta toSend = m.sacar(),using = new Carta();
        client.send("marcianitos");
        client.close();
        EnvidoClient sclient = new EnvidoClient("",3334);
        leimos = sclient.welcome();
        System.out.println("recibimos\t->\t" + leimos);
    }
}