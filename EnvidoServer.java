import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class EnvidoServer{

    private DatagramSocket server;
    private DatagramSocket receiver;
    private DatagramPacket pack;
    private byte[] info;
    private int sport;                  //puerto por el cual va a mandar
    private int rport;                  //puerto por el cual va a recibir

    public EnvidoServer(int sport,int rport){
        try{
            this.sport = sport;
            this.rport = rport;
            server = new DatagramSocket(this.sport);
            info = new byte[128];
            System.out.println("Server created successfully.");
        } catch(IOException e){}
    }

    public String welcome(){                             //go del servidor devuelve lo leido
        try{
            receiver = new DatagramSocket(rport);
            pack = new DatagramPacket(info,info.length);
            receiver.receive(pack);
            receiver.close();
            System.out.println("recibo desde el puerto " + pack.getPort());
        } catch(IOException e){
            System.out.println("no pudimos recibir");
            return null;
        }
    return new String(pack.getData());}

    public boolean send(Object o){
        String toSend = o.toString();
        try{
            pack = new DatagramPacket(toSend.getBytes(),toSend.length(),InetAddress.getLocalHost(),sport);
            server.send(pack);
            System.out.println("envio desde el puerto " + pack.getPort());
        } catch(UnknownHostException uhe){
            System.out.println("host no encontrado");
        } catch(IOException ioe){
            System.out.println("no se pudo enviar");
            return false;
        }
    return true;}

    public void close(){server.close();}
}