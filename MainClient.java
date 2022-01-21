import java.util.Scanner;

public class MainClient{

    public static void main(String[] args) {
        EnvidoClient ec = new EnvidoClient("localhost",5010);
        Scanner sc = new Scanner(System.in);
        String entrada,recibo;
        entrada = recibo = new String();
        
        while(sc.hasNextLine()){
            entrada = sc.nextLine();
            ec.send("cliente: " + entrada);
            recibo = ec.receive();
            System.out.println(recibo);
        }

        ec.close();
    }
}