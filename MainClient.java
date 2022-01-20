import java.util.Scanner;

public class MainClient{

    public static void main(String[] args) {
        EnvidoClient ec = new EnvidoClient("localhost",5010);
        String recibo = new String();

        recibo = ec.receive();
        
        System.out.println("recibimos '" + recibo + "'");

        ec.close();
    }
}