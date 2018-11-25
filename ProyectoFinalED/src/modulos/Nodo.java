package modulos;

/**
 * @author Jose Miguel
 * @autor Stiven
 * @author Anderson
 */
public class Nodo {
    //Nodo Hijo en la Izquierda
    private Nodo nodoHijoIzq;
    //Padre
    private Nodo nodoPadre;
    //Nodo hijo en la Derecha
    private Nodo nodoHijoDer;
    //Contenido del nodo
    private char caracter;
    //Palabra que vamos a manejar.
    private String palabra;
    //Soundex
    private String fonetica;

    private Nodo tmp;
    /**
     * Cosntructor por defecto.
     */
    public Nodo() {
    }

    /**
     * Caracter que va en el nodo actual.
     * @param caracter
     */
    public Nodo(char caracter) {
        this.caracter = caracter;
    }

    /**
     * Caracter que va en el nodo actual.
     * Palabra que vamos a evaluar.
     * @param caracter
     * @param palabra
     */
    public Nodo(char caracter, String palabra) {
        this.caracter = caracter;
        this.palabra = palabra;
    }
    public String getFonetica() {
        return fonetica;
    }

    public void setFonetica(String fonetica) {
        this.fonetica = fonetica;
    }

    public Nodo getNodoHijoIzq() {
        return nodoHijoIzq;
    }

    public void setNodoHijoIzq(Nodo nodoHijoIzq) {
        nodoHijoIzq.setNodoPadre(Nodo.this);
        //Nodo tmp = null;
        if(this.nodoHijoIzq == null){
            this.nodoHijoIzq = nodoHijoIzq;
            tmp = nodoHijoIzq;
        }else{
            tmp.setNodoHijoDer(nodoHijoIzq);
            tmp = nodoHijoIzq;
        }
    }

    public Nodo getNodoPadre() {
        return nodoPadre;
    }

    public void setNodoPadre(Nodo nodoPadre) {
        this.nodoPadre = nodoPadre;
    }

    public char getCaracter() {
        return caracter;
    }

    public void setCaracter(char caracter) {
        this.caracter = caracter;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public Nodo getNodoHijoDer() {
        return nodoHijoDer;
    }

    public void setNodoHijoDer(Nodo nodoHijoDer) {
        this.nodoHijoDer = nodoHijoDer;
    }
}
