import java.util.Scanner;

public class MainServer{

    public static void main(String[] args){
        EnvidoServer es = new EnvidoServer(5010);
        Scanner sc = new Scanner(System.in);
        String leido = new String();

        leido = sc.nextLine();

        es.send(leido);

        es.close();
    }
}