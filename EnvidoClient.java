import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EnvidoClient{

    private DatagramSocket client;
    private DatagramSocket receiver;
    private DatagramPacket pack;
    private InetAddress host;
    private byte[] info;
    private int sport;              //puerto por el que va a enviar
    private int rport;              //puerto por el que va a recibir

    public EnvidoClient(String ip,int sport,int rport){
        try{
            client = new DatagramSocket();
            info = new byte[128];
            this.sport = sport;
            this.rport = rport;
            host = InetAddress.getByName("ip");
            System.out.println("Client connected succesfully.");            
        } catch(IOException e){}
    }

    public String welcome(){
        try{
            receiver = new DatagramSocket(rport);
            pack = new DatagramPacket(info,info.length);
            client.receive(pack);
            receiver.close();
        } catch(IOException ioe){
            System.out.println("no pudimos recibir");
            System.out.println("puerto de recepcion " + rport);
            ioe.printStackTrace();
            return null;
        }
    return new String(pack.getData());}

    public boolean send(Object o){
        String toSend = o.toString();
        try{
            pack = new DatagramPacket(toSend.getBytes(),toSend.length(),InetAddress.getLocalHost(),sport);
            client.send(pack);
            System.out.println("envio desde el puerto " + pack.getPort());
        } catch(UnknownHostException uhe){
            System.out.println("no encontramos el host");
        } catch(IOException ioe){
            System.out.println("no se pudo enviar");
            return false;
        } 
    return true;}

    public void close(){client.close();}
}