public class MainClient{

    public static void main(String[] args) {
        EnvidoClient client = new EnvidoClient("localhost",3334,3333);
        String using = new String("buzz lightyear");
        //ENVIAMOS
        client.send(using);
        //RECIBIMOS
        using = client.welcome();
        System.out.println("recibimos\t->\t" + using);
        client.close();
    }
}