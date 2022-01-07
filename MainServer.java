public class MainServer{

    public static void main(String[] args){
        EnvidoServer es = new EnvidoServer(3333);
        String recibo = es.receive();

        System.out.println("recibimos " + recibo);

        es.send("woody");
        es.send("anda padre?");
    }
}