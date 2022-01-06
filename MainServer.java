public class MainServer{

    public static void main(String[] args){
        EnvidoServer server = new EnvidoServer(3333,3334);
        String using = new String();
        //RECIBIMOS
        using = server.welcome();
        System.out.println("recibimos\t->\t" + using);
        //ENVIAMOS
        using = "woody";
        server.send(using);
        server.close();
    }
}