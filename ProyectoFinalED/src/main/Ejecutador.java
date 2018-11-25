package main;

import arbol.Arbol;
import modulos.Soundex;

import java.io.*;

import static java.lang.Runtime.*;

/**
 * @author Jose Miguel
 * @autor Stiven
 * @author Anderson
 */

public class Ejecutador implements Runnable{

    private Arbol arbol;
    private BufferedReader lector;
    private File archivo;
    private FileReader obtArchivo;
    /**
     * Constructor por defecto.
     */
    public Ejecutador(){

    }
    @Override
    public void run() {
        inicializar();
        leer();
    }

    /**
     * Lee las palabras de words.txt
     */
    private void leer(){
        String entrada;
        try{
            while((entrada = lector.readLine()) != null){
                arbol.llenarArbol(entrada);
                arbol.crearArbolFonetico(entrada, entrada);
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Inicializa las variables de la clase.
     */
    private void inicializar() {
        arbol = new Arbol();
        archivo = new File("words.txt");
        if(!archivo.exists()){
            throw new RuntimeException("Hay errores en la lectura del archivo words.txt");
        }
        try {
            obtArchivo = new FileReader(archivo);
            lector = new BufferedReader(obtArchivo);
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    /**
     * Realiza las operaciones en el sistema, con los
     * parametros obtenidos.
     * @param args
     */
    public void ejecutar(String[] args){
        inicializar();
        leer();
        if(args.length < 2){
            System.out.println("Error, uso: ");
            System.out.println("java -cp ./bin <list_packages>.ProgramName.java arg1 arg2");
            System.out.println("arg1 = -a | -f | -fonetic | -automplete");
            System.out.println("arg2 = (String)");
        }
        String res = "";
        if(args[0].equalsIgnoreCase("-a") || args[0].equalsIgnoreCase("-autocomplete")){
            res = arbol.buscar(args[1]);
        }else if(args[0].equalsIgnoreCase("-f") || args[0].equalsIgnoreCase("-fonetic")){
            res = new String(arbol.buscarFonetica(args[1]));
        }
        System.out.println(res);
    }
}
