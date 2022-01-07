import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private ServerSocket servidor;
    private Socket listener;
    private int rpuerto;
    private int epuerto;

    public Server(int rpuerto){
        try{
            servidor = new ServerSocket(rpuerto);
            this.rpuerto = rpuerto;
            //this.rpuerto = rpuerto;
            System.out.println("servidor creado correctamente");
        } catch(IOException ie){
            System.out.println("no pudimos crear el servidor");
        }
    }

    public String recibo(){
        String leimos = new String();
        try{
            listener = servidor.accept();
            
            InputStream in = listener.getInputStream();
            DataInputStream din = new DataInputStream(in);
            leimos = din.readUTF();
        } catch(IOException ioe){
            System.out.println("no se pudo recibir");
        }
    return leimos;}

    public void envio(String s){
        try{
            
        } catch(IOException ioe){
            System.out.println("no se pudo enviar");
        }
    }
}
