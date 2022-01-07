public class MainClient{

    public static void main(String[] args) {
        EnvidoClient ec = new EnvidoClient("localhost",3333);
        String recibo = new String();
        ec.send("buzz lightyear");

        recibo = ec.receive();
        System.out.println("recibimos " + recibo);
        recibo = ec.receive();
        System.out.println("recibimos " + recibo);
    }
}