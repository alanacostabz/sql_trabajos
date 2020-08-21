/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jotin;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bryan
 */
public class Jotin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileReader archivoPlayers;
            BufferedReader inputFile = null;
            Scanner sc = new Scanner(System.in);
            try {
                archivoPlayers = new FileReader("jugadores.csv");
                inputFile = new BufferedReader(archivoPlayers);
            } catch (FileNotFoundException ex) {
                System.out.println("Error al abrir al archivo");
                System.exit(0);
            }
            String registro = null;
            
            //AGGH
            
            ArrayList<String> tabla = new ArrayList<String>();
            
             while ((registro = inputFile.readLine()) != null) {

                String[] result = registro.split(",");

                for (int i = 0; i < result.length; i += 6) {

                    tabla.add(result[0] + "," + result[1] + "," + result[2] + "," + result[3] + "," + result[4] + "," + result[5]);
                    

                }

            }
             
             try {
                File f = new File("messi.csv");
                FileOutputStream reviews = new FileOutputStream(f);
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(reviews));

                for (int i = 0; i < tabla.size(); i++) {
                    bw.write(tabla.get(i));
                    bw.newLine();
                }

                inputFile.close();
                bw.close();
            } catch (IOException ex) {

                System.out.println("Error al cerrar el archivo");

                System.exit(0);

            }

            for (int i = 0; i < tabla.size(); i++) {
                System.out.println(tabla.get(i));
            }

            System.out.println("\nRegistro agregado con exito!!!");
            
            
    }
    
}
