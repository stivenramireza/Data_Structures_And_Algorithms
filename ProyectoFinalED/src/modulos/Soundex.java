package modulos;

/**
 * @author Jose Miguel
 * @autor Stiven
 * @author Anderson
 */

public class Soundex {

    /**
     * Devuelve el codigo soundex de la palabra.
     * @param cadena
     * @return
     */
    public String getCadena(String cadena) {
        char[] x = cadena.toUpperCase().toCharArray();
        char primeraLetra = 'B';
        if (x.length > 0) {
            primeraLetra = x[0];
        }

        // Convierte las letras a codigo numerico
        for (int i = 0; i < x.length; i++) {
            switch (x[i]) {

                case 'B':
                case 'F':
                case 'P':
                case 'V':
                    x[i] = '1';
                    break;

                case 'C':
                case 'G':
                case 'J':
                case 'K':
                case 'Q':
                case 'S':
                case 'X':
                case 'Z':
                    x[i] = '2';
                    break;

                case 'D':
                case 'T':
                    x[i] = '3';
                    break;

                case 'L':
                    x[i] = '4';
                    break;

                case 'M':
                case 'N':
                    x[i] = '5';
                    break;

                case 'R':
                    x[i] = '6';
                    break;

                default:
                    x[i] = '0';
                    break;
            }
        }

        // Elimina lo duplicado.
        String salida = "" + primeraLetra;
        for (int i = 1; i < x.length; i++)
            if (x[i] != x[i - 1] && x[i] != '0')
                salida += x[i];

        salida = salida + "0000";
        return salida.substring(0, 4);
    }
}
