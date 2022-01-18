public class MainServer{

    public static void main(String[] args){
        EnvidoServer es = new EnvidoServer(3333);
        String recibo = es.receive();               //recibo un hashcode
        Carta buscada = new Carta(),mata = new Carta();
        Mazo mazo = new Mazo();

        buscada = mazo.search(Integer.parseInt(recibo));    //busco la carta correspondiente al hashcode recibido
        System.out.println("recibo la carta " + buscada);
        mata = mazo.whoKillsIt(buscada);    //me fijo que carta mata a la que me envió el cliente
        es.send(mata.hashCode());           //se la envío

        es.close();
    }
}