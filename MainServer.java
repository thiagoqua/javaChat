import java.util.Scanner;

public class MainServer{

    public static void main(String[] args){
        EnvidoServer es = new EnvidoServer(5010);
        Scanner sc = new Scanner(System.in);
        String entrada,recibo;
        entrada = recibo = new String();

        while((recibo = es.receive()) != null){
            System.out.println(recibo);
            entrada = sc.nextLine();
            es.send("servidor: " + entrada);
        }
        System.out.println("sali");

        es.close();
    }
}