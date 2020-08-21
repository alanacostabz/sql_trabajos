/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package base;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.StringTokenizer;

/**
 *
 * @author atellechea
 */
public class Base {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        long inicio = System.currentTimeMillis();

        lineas();
        palabras();

        hash();
        long end = System.currentTimeMillis();
        System.out.println("Tiempo de ejecucion: " + (end - inicio) + " milisegundos.");

    }

    public static void lineas() throws FileNotFoundException, IOException {
        BufferedReader reader = new BufferedReader(new FileReader("DonQuijote.txt"));
        int lineas = 0;
        while (reader.readLine() != null) {
            lineas++;
        }
        System.out.println("Numero de lineas: " + lineas);
        reader.close();
    }

    public static void palabras() throws FileNotFoundException {
        File file = new File("DonQuijote.txt");
        String palabraContador = null;
        try (Scanner sc = new Scanner(new FileInputStream(file))) {
            int palabras = 0;
            while (sc.hasNext()) {
                palabraContador = sc.toString();
                palabraContador.replaceAll("[^a-zA-Z]", "");
                if (!palabraContador.equals("")) {

                    sc.next();
                    palabras++;
                }
            }
            
        }
    }

    public static void hash() {
        FileReader archivo;
        BufferedReader inputFile = null;
        HashMap<String, Integer> tabla = new HashMap(); //aqui declaras el hashmap
        int contadorPalabras = 0;

        try {
            archivo = new FileReader("DonQuijote.txt");
            inputFile = new BufferedReader(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir al archivo");
            System.exit(0);
        }
        String cadena;
        String pal;

        try {
            while ((cadena = inputFile.readLine()) != null) {
                StringTokenizer t = new StringTokenizer(cadena); // inicializas una variable tokenizer que La clase StringTokenizer nos ayuda a dividir un string en substrings o tokens, en base a otro string (normalmente un carácter) separador entre ellos denominado delimitador.

                while (t.hasMoreTokens()) {//mientras encuentre palabras (tokens) el while sigue
                    pal = t.nextToken().toLowerCase();//haces minusculas todas las palabras para contarlas por igual
                    pal = pal.replaceAll("[^a-zA-Z]", "");//limpas los signos o numeros que haya en la palabra
                    if (!pal.equals("")) { //este if hace que si se limpio la variable pal que contenia texto que no eran letras no las cuente como palabras
                        contadorPalabras++;
                        if (tabla.containsKey(pal)) {//mientras que en el hashmap haya una palabra
                            int contador = tabla.get(pal);//agarrar la clave de la palabra
                            
                            tabla.put(pal, contador += 1); //agregas la palabra, y le sumas el numero de veces que se repita
                            
                        } else {
                            tabla.put(pal, 1); //si nomas se encuentra una vez
                           
                        }
                    }

                }

            }
            System.out.println("Numero de palabras: " + contadorPalabras + " asdsa");
            Set<String> keySet = tabla.keySet(); //creas un keyset para crear una tabla con las claves del hashmap
            ArrayList<String> listaClaves = new ArrayList<>(keySet); //ese keyset lo conviertes en un arraylist 
            Integer nRepeticiones = null;
            Collections.sort(listaClaves); //ordena el array list por orden alfabetico
            for (int i = 0; i < tabla.size(); i++) {
               
                for (int j = 0; j < tabla.size(); j++) {
                    nRepeticiones = tabla.get(listaClaves.get(i));// jalas las claves de la lista, este caso las claves son el numero de repetciones de cada palabra
                }   

                System.out.println(listaClaves.get(i) + "," + nRepeticiones);

            }
            System.out.println(contadorPalabras);
            
        } catch (IOException ex) {
            System.out.println("Error al cargar el archivo");
            System.exit(0);
        }

    }

}
