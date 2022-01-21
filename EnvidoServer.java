import java.io.BufferedReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EnvidoServer{
    
    private ServerSocket server;
    private Socket listener;
    private InputStream in;
    private OutputStream out;
    private BufferedReader breader;
    private BufferedWriter bwriter;
    private boolean isConnected;

    public EnvidoServer(int port){
        try{
            server = new ServerSocket(port);
            isConnected = false;
            System.out.println("server succesfully created");
        } catch(IOException ioe){
            System.out.println("no pudimos crear el servidor. abortamos.");
            System.exit(5);
        }
    }

    public String receive(){
        String readed = new String();
        if(!isConnected)
            this.enable();
        try{
            System.out.println("estoy esperando respuesta");
            readed = breader.readLine();
        } catch(IOException ioe){
            System.out.println("no pudimos recibir el paquete. abortamos.");
            System.exit(6);
        }
    return readed;}

    public void send(Object o){
        if(!isConnected)
            this.enable();
        try{
            bwriter.write(o.toString());
            bwriter.newLine();
            bwriter.flush();
        } catch(IOException ioe){
            System.out.println("no pudimos enviar el paquete. abortamos.");
            System.exit(7);
        }
    }

    public void enable(){
        try{
            in = listener.getInputStream();
            out = listener.getOutputStream();
            breader = new BufferedReader(new InputStreamReader(in));
            bwriter = new BufferedWriter(new OutputStreamWriter(out));
        } catch(IOException ioe){
            System.out.println("no pudimos habilitar al servidor. abortamos.");
            System.exit(8);
        }
        isConnected = true;
    }

    public boolean somebodyIsConnected(){
        try{
            listener = server.accept();
            if(listener.isConnected()){
                System.out.println("cliente con ip '" + listener.getInetAddress() + " conectado al puerto " +
                listener.getPort() + " de manera exitosa.");
                return true;
            }
        } catch(IOException ioe){}
    return false;}

    public void close(){
        try{
            server.close();
            listener.close();
            in.close();
            out.close();
            breader.close();
            bwriter.close();
        } catch(IOException ioe){
            System.out.println("no pudimos cerrar el servidor. abortamos.");
            //System.exit(2);
        }
    }
}