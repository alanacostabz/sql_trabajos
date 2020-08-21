package anadircsv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AnadirCSV {

    public static void main(String[] args) throws IOException {
        int pregunta;
do{
        FileReader archivo;
        BufferedReader inputFile = null;
        Scanner sc = new Scanner(System.in);
        try {
            archivo = new FileReader("maruchan.csv");
            inputFile = new BufferedReader(archivo);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir al archivo");
            System.exit(0);
        }
        String registro = null;

        String[] campos = {" # de reseña: ", " marca: ", " variedad: ", " estilo: ", " pais: ", " estrellas: "};
        double aux;
        String[] respuesta = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {
            System.out.print("Ingrese" + campos[i]);
            respuesta[i] = sc.nextLine();
            if (i == 5) {
                aux = Double.parseDouble(respuesta[i]);
                while (aux < 1 || aux > 5) {
                    System.out.print("Su calificacion se encuentra fuera del rango(1-5), favor de ingresarla de nuevo: ");
                    respuesta[i] = sc.nextLine();
                    aux = Double.parseDouble(respuesta[i]);
                }
            }
        }

        System.out.println("");

        ArrayList<String> tabla = new ArrayList<String>();
        int ban = 0;

        while ((registro = inputFile.readLine()) != null) {

            String[] result = registro.split(",");

            for (int i = 0; i < result.length; i += 6) {

                tabla.add(result[0] + "," + result[1] + "," + result[2] + "," + result[3] + "," + result[4] + "," + result[5]);
                while (ban != 1) {
                    tabla.add(respuesta[0] + "," + respuesta[1] + "," + respuesta[2] + "," + respuesta[3] + "," + respuesta[4] + "," + respuesta[5]);
                    ban++;
                }

            }

        }

        try {
            File f = new File("maruchan.csv");
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
        System.out.println("Desea agregar otro registro SI[1] o NO[2]");
        pregunta = sc.nextInt();

    } while( pregunta == 1);
        System.out.println("\nFin de la aplicacion!!!");
}
}
