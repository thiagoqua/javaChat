import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class EnvidoClient{

    private Socket client;
    private InputStream in;
    private OutputStream out;
    private BufferedReader breader;
    private BufferedWriter bwriter;
    private boolean isEnabled;

    public EnvidoClient(String ip,int port){
        try{
            client = new Socket(InetAddress.getByName(ip),port);
            isEnabled = false;
            System.out.println("client succesfully connected");
        } catch(IOException ioe){
            System.out.println("no pudimos crear el cliente. abortamos.");
            System.exit(2);
        }
    }

    public String receive(){
        String readed = new String();
        if(!isEnabled)
            this.enable();
        try{
            System.out.println("estoy esperando respuesta");
            readed = breader.readLine();
        } catch(IOException ioe){
            System.out.println("no pudimos recibir el paquete. abortamos.");
            System.exit(3);
        }
    return readed;}

    public void send(Object o){
        try{
            if(!isEnabled)
                this.enable();
            bwriter.write(o.toString());
            bwriter.newLine();
            bwriter.flush();
        } catch(IOException ioe){
            System.out.println("no pudimos enviar el paquete. abortamos.");
            System.exit(4);
        }
    }

    public void enable(){
        try{
            in = client.getInputStream();
            out = client.getOutputStream();
            breader = new BufferedReader(new InputStreamReader(in));
            bwriter = new BufferedWriter(new OutputStreamWriter(out));
        } catch(IOException ioe){
            System.out.println("no pudimos habilitar al cliente. abortamos.");
            System.exit(9);
        }
        isEnabled = true;
    }

    public void close(){
        try{
            client.close();
            in.close();
            out.close();
            breader.close();
            bwriter.close();
        } catch(IOException ioe){
            System.out.println("no pudimos cerrar el cliente. abortamos.");
            //System.exit(2);
        }
    }
}