public class Main{
    public static void main(String[] args){
        int hcode;
        Mazo mazo = new Mazo();
        String arrived;
        EnvidoServer es = new EnvidoServer(3333);
        hcode = es.start();
        arrived = mazo.search(hcode);
        System.out.println("carta:\t" + arrived + "\nhashcode:\t" + hcode);
        es.close();
    }
}