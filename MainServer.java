import java.util.Scanner;

public class MainServer{

    public static void main(String[] args){
        EnvidoServer es = new EnvidoServer(5010);
        Scanner sc = new Scanner(System.in);
        String entrada,recibo;
        entrada = recibo = new String();

        if(!es.somebodyIsConnected())
            System.out.println("no se conecto ningun cliente");

        while((recibo = es.receive()) != null){
            System.out.println(recibo);
            entrada = sc.nextLine();
            es.send("servidor: " + entrada);
        }

        es.close();
    }
}