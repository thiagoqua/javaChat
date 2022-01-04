public class Main{
    public static void main(String[] args){
        int hcode,times;
        Mazo mazo = new Mazo();
        String arrived;
        Carta toSend = new Carta(1,"espada");
        EnvidoServer es = new EnvidoServer(3333);
        hcode = times = 0;
        while((arrived = es.recieve()) != null){
            try{
                hcode = Integer.valueOf(arrived);       //convierto el string a int para ver su hashcode
            } catch(NumberFormatException nfe){
                System.out.println("lo recibido no es un numero");
            }
            System.out.println("recibido:\ncarta:\t" + mazo.search(hcode) + "\nhashcode:\t" + arrived);    //busco la carta que corresponde al hashcode
            ++times;
            System.out.println(times);
        }
        System.out.println(times);
        es.send(toSend.toString());
        es.close();
    }
}