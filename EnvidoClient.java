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
            host = InetAddress.getByName(ip);
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    public String welcome(){
        try{
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
            pack = new DatagramPacket(toSend.getBytes(),toSend.length(),InetAddress.getLocalHost(),port);
        } catch(UnknownHostException uhe){
            System.out.println("no encontramos el host");
        }
        try{
            client.send(pack);
        } catch(IOException ioe){
            System.out.println("no se pudo enviar");
            return false;
        }
    return true;}

    public void close(){client.close();}

    public static void main(String[] args) {
        String leimos = new String();
        Mazo m = new Mazo();
        EnvidoClient client = new EnvidoClient("",3333);
        Carta toSend = m.sacar(),using = new Carta();
        //client.send("se envia desde cliente");
        leimos = client.welcome();
        System.out.println(leimos);
        client.close();
    }
}