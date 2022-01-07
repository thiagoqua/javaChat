public class MainClient{

    public static void main(String[] args) {
        EnvidoClient ec = new EnvidoClient("localhost",3333);
        Mazo mazo = new Mazo();
        Carta c = mazo.sacar();
        String recibo = new String();

        ec.send(c.hashCode());

        recibo = ec.receive();

        System.out.println("recibi la carta\t" + mazo.search(Integer.parseInt(recibo)));

        ec.closeAll();
    }
}