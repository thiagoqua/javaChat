import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class MainC {
    public static void main(String[] args) {
        try{
            Socket s = new Socket("localhost",3333);
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String envio = new String("woody"),recibo = new String();

            dout.writeUTF(envio);
            dout.flush();
            recibo = din.readUTF();
            System.out.println("server dice " + recibo);
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}