import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class Client {
    private Socket cliente;
    private int puerto;
    //private int rpuerto;

    public Client(int puerto){
        try{
            cliente = new Socket("localhost",puerto);
            this.puerto = puerto;
        } catch(IOException ioe){
            System.out.println("no pudimos inicializar al cliente");
        }
    }

    public void envio(String s){
        try{
            OutputStream out = cliente.getOutputStream();
            DataOutputStream dout = new DataOutputStream(out);
            dout.writeUTF(s);
            dout.flush();
        } catch(IOException ioe){
            System.out.println("no pudimos enviar");
        }
    }
}