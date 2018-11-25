package arbol;

import modulos.Nodo;
import modulos.Soundex;

import java.util.*;

/**
 * @author Jose Miguel
 * @author Stiven
 * @author Anderson
 */
public class Arbol {
    //Raiz de arbol.
    private Nodo raiz;
    private Map<String, LinkedList<String>> mapa;
    private StringBuffer fonetica;
    private Soundex soundex;
    /**
     * Constructor de la clase Arbol, que inicializa la raiz.
     */
    public Arbol() {
        raiz = new Nodo();
        raiz.setNodoHijoIzq(new Nodo());
        mapa = new HashMap<>();
        fonetica = new StringBuffer();
        soundex = new Soundex();
    }

    /**
     * Inserta una palabra en el arbol, empezando a analizar desde la raiz cada
     * uno de sus hijos.
     *
     * @param raiz
     * @param palabra
     * @param cnt
     */
    private void llenarArbol(Nodo raiz, String palabra, int cnt) {
        if (palabra.length() == 0) {
            return;
        }
        if (cnt >= palabra.length()) {
            return;
        }
        if (raiz.getCaracter() != palabra.charAt(cnt)) {
            if (raiz.getNodoHijoDer() == null) {
                if (cnt == palabra.length() - 1) {
                    raiz.getNodoPadre().setNodoHijoIzq(new Nodo(palabra.charAt(cnt), palabra));
                    return;
                }
                raiz.getNodoPadre().setNodoHijoIzq(new Nodo(palabra.charAt(cnt)));
                llenarArbol(raiz.getNodoHijoDer(), palabra, cnt);
                return;
            }
            llenarArbol(raiz.getNodoHijoDer(), palabra, cnt);
            return;
        }
        if (cnt == palabra.length() - 1) {
            raiz.setPalabra(palabra);
            return;
        }

        if (raiz.getNodoHijoIzq() == null) {
            raiz.setNodoHijoIzq(new Nodo(palabra.charAt(cnt + 1)));
            llenarArbol(raiz.getNodoHijoIzq(), palabra, cnt + 1);
            return;
        }
        llenarArbol(raiz.getNodoHijoIzq(), palabra, cnt + 1);
    }

    /**
     * Adicciona las palabras que suenan igual al mapa.
     * @param cadena
     * @param palabra
     */
    public void crearArbolFonetico(String cadena, String palabra) {
        cadena = soundex.getCadena(cadena);
        if(mapa.containsKey(cadena)){
            mapa.get(cadena).add(palabra);
        }else{
            mapa.put(cadena, new LinkedList<>());
        }
    }

    /**
     * Busca las palabras que coinciden fonceticamente con la palabra.
     * @param palabra
     * @return
     */
    public StringBuffer buscarFonetica(String palabra){
        palabra = soundex.getCadena(palabra);
        if(!mapa.containsKey(palabra)){
            return new StringBuffer("");
        }
        LinkedList<String> lista = mapa.get(palabra);
        for(String opcion: lista){
            fonetica.append(opcion).append("\n");
        }
        return fonetica;
    }
    /**
     * Inserta la palabra en el arbol.
     * @param palabra
     */
    public void llenarArbol(String palabra) {
        this.llenarArbol(raiz.getNodoHijoIzq(), palabra, 0);
    }

    /**
     * Busca una palabra en el arbol, empezando a analizarlo desde la raiz.
     *
     * @param raiz
     * @param palabra
     * @param cnt
     * @return String
     * @throws RuntimeException
     */
    private String buscar(Nodo raiz, String palabra, int cnt) {
        if (raiz.getCaracter() != palabra.charAt(cnt)) {
            if (raiz.getNodoHijoDer() == null) {
		return "";
            }
            return buscar(raiz.getNodoHijoDer(), palabra, cnt);
        }
        if (cnt == palabra.length() - 1) {
            if (raiz.getPalabra() == null) {

                return avanzar(raiz.getNodoHijoIzq());
            }
            return raiz.getPalabra() + "\n" + avanzar(raiz.getNodoHijoIzq());
        }
        if (raiz.getNodoHijoIzq() == null) {
            return "";
        }
        return buscar(raiz.getNodoHijoIzq(), palabra, cnt + 1);
    }


    /**
     * Busca la palabra que pasa el usuario.
     *
     * @param palabra
     * @return String
     * @throws RuntimeException
     */
    public String buscar(String palabra) {
        return buscar(raiz.getNodoHijoIzq(), palabra, 0);
    }

    /**
     * Va añadiendo las palabras que va encontrando a la busqueda
     * total del sistema.
     * @param inicio
     * @return String
     */
    private String avanzar(Nodo inicio) {
        if (inicio == null) {
            return "";
        }
        String s;
        if (inicio.getPalabra() == null) {
            s = "";
        } else {
            s = inicio.getPalabra() + "\n";
        }
        s += avanzar(inicio.getNodoHijoIzq());
        s += avanzar(inicio.getNodoHijoDer());
        return s;
    }

}
