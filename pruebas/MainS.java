import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainS {
    public static void main(String[] args) {
        try{
            ServerSocket ss = new ServerSocket(3333);
            Socket s = ss.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());
            String envio = new String("buzz lightyear"),recibo = new String();

            recibo = din.readUTF();
            System.out.println("el cliente dice " + recibo);
            dout.writeUTF(envio);
            dout.flush();
            
            ss.close();
            s.close();
            dout.close();
            din.close();
        } catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
}
