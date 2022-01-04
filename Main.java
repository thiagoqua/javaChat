public class Main{
    public static void main(String[] args){
        int hcode = 0;
        Mazo mazo = new Mazo();
        String arrived;
        Carta toSend = new Carta(1,"espada");
        EnvidoServer es = new EnvidoServer(3333);
        arrived = es.welcome();
        try{
            hcode = Integer.valueOf(arrived);       //convierto el string a int para ver su hashcode
        } catch(NumberFormatException nfe){
            System.out.println("lo recibido no es un numero");
        }
        System.out.println("recibido:\ncarta:\t" + arrived + "\nhashcode:\t" + mazo.search(hcode));    //busco la carta que corresponde al hashcode
        if(!es.send(toSend.toString()))
            System.out.println("error de enviado");
        else
            System.out.println("ancho de espada enviado");
        es.close();
    }
}