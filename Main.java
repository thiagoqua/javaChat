public class Main{

    public static void main(String[] args){
        int hcode = 0;
        Mazo mazo = new Mazo();
        String arrived = new String();
        Carta using,toSend;
        EnvidoServer server = new EnvidoServer(3333);
        arrived = server.welcome();
        System.out.println("recibimos\t->\t" + arrived);
        server.close();

        EnvidoServer sserver = new EnvidoServer(3334);
        sserver.send("buzz lightyear");
    }
}