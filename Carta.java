public class Carta{

	private int numero;
    private String palo;
    private static final Carta[] ORDEN = new Carta[14];

    public Carta(){
        this(0,"");
    }

    public Carta(int numero,String palo){   //sino ya seteo el número y el palo
        this.numero = numero;
        this.palo = new String(palo);
    }

    public int getNumero(){return numero;}

    public String getPalo(){return palo;}
    
    public void setNumero(int numero) {
		this.numero = numero;
	}

	public void setPalo(String palo) {
		this.palo = palo;
	}

    public static Carta builder(Carta c){          //crea y devuelve una copia de la carta que se le pasa
        Carta temp = new Carta();
        temp.numero = c.numero;
        temp.palo = c.palo;
    return temp;}

    private static void initOrden(){
        ORDEN[0] = new Carta(1,"espada");
        ORDEN[1] = new Carta(1,"basto");
        ORDEN[2] = new Carta(7,"espada");
        ORDEN[3] = new Carta(7,"oro");
        ORDEN[4] = new Carta(3,"");
        ORDEN[5] = new Carta(2,"");
        ORDEN[6] = new Carta(1,"");
        ORDEN[7] = new Carta(12,"");
        ORDEN[8] = new Carta(11,"");
        ORDEN[9] = new Carta(10,"");
        ORDEN[10] = new Carta(7,"");
        ORDEN[11] = new Carta(6,"");
        ORDEN[12] = new Carta(5,"");
        ORDEN[13] = new Carta(4,"");
    }
	
    
    public static int returnOrden(Carta c){
    	int i=0;
    	
        /*ANALIZO LAS CARTAS IMPORTANTES PRIMERO*/
        
        for(int j=0;j<4;j++) {
        	
            if(c.getNumero() == ORDEN[i].getNumero() && c.getPalo().equals(ORDEN[i].getPalo())) {
            	return i;
            }
            else {
            	i++;
            }
        	
        }
        for(int j=0;j<10;j++) {
        	if(c.getNumero() == ORDEN[i].getNumero()) {
            	return i;
            }
            else {
            	i++;
            }
        }
        
        return -1;
    
    }
    
    
	@Override
	public String toString() {
		return ( "(" + this.numero + "," + this.palo + ")" );
	}
	
    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Carta){
            Carta c = (Carta) obj;
            return numero == c.getNumero() && palo.equals(c.getPalo());
        }
    return false;}

    public boolean isGood(){
        int index;
        Carta mine = new Carta();
        mine.setNumero(numero);
        mine.setPalo(palo);
        if(ORDEN[0] == null)                                    //si no esta inicializado el arreglo de orden
            initOrden();
        for(index = 0;index < ORDEN.length;++index)             //busco el orden de mi carta
            if(mine.equals(ORDEN[index]))
                break;
        if(index <= 5)                                          //si mi carta es un 2 o mos grande
            return true;
    return false;}

    @Override
    public int hashCode(){return numero * (int)this.palo.charAt(0);}
}