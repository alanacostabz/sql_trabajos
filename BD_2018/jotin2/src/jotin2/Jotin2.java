package jotin2;

import java.io.*;

import java.util.*;

public class Jotin2 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        FileReader archivoPlayers, archivoTeams;
        BufferedReader inputFile = null, inputFileDos = null;

        try {
            archivoPlayers = new FileReader("jugadores.csv");
            inputFile = new BufferedReader(archivoPlayers);

            archivoTeams = new FileReader("equipos.csv");
            inputFileDos = new BufferedReader(archivoTeams);
        } catch (FileNotFoundException ex) {
            System.out.println("Error al abrir al archivo");
            System.exit(0);
        }

        String[] campos = {"Nombre: ", "Equipo:", "Posición:", "Estatura(inch):", "peso(lbs):", "Edad:"};
        double aux;
        String[] respuesta = new String[campos.length];

        for (int i = 0; i < campos.length; i++) {
            System.out.print("Ingrese " + campos[i]);
            respuesta[i] = sc.nextLine();

        }

        String registro = null, registroDos = null;

        ArrayList<String> tabla = new ArrayList<>();
        int ban = 0;

        while (((registro = inputFile.readLine()) != null)) {

            String[] result = registro.split(",");

            for (int i = 0; i < result.length; i += 6) {
                tabla.add(result[0] + "," + result[1] + "," + result[2] + "," + result[3] + "," + result[4]
                        + "," + result[5]);
                while (ban != 1) {
                        tabla.add(respuesta[0] + "," + respuesta[1] + "," + respuesta[2] + "," + respuesta[3] + "," + respuesta[4] + "," + respuesta[5]);
                        ban++;
                    }
                
            }

        }

        ArrayList<String> tablaDos = new ArrayList<>();

        while (((registroDos = inputFileDos.readLine()) != null)) {

            String[] resultDos = registroDos.split(",");
            for (int i = 0; i < resultDos.length; i += 4) {
                tablaDos.add(resultDos[0] + "," + resultDos[1] + "," + resultDos[2] + "," + resultDos[3]);
                
            }

        }

        ArrayList<String> tablaTres = new ArrayList<>();

        tablaTres.add(tabla.get(0) + "," + tablaDos.get(0));
        for (int i = 1; i < tabla.size(); i += 6) {

            for (int j = 1; j < tablaDos.size(); j++) {
                tablaTres.add(tabla.get(i) + "," + tablaDos.get(j));
            }
        }

        try {
            File f = new File("lista.csv");
            FileOutputStream list = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(list));

            for (int i = 0; i < tablaTres.size(); i++) {
                bw.write(tablaTres.get(i));
                bw.newLine();
            }

            inputFile.close();
            bw.close();
        } catch (IOException ex) {

            System.out.println("Error al crear el archivo");

            System.exit(0);

        }

        for (int i = 0; i < tablaTres.size(); i++) {
            System.out.println(tablaTres.get(i));
        }
        System.out.println("\nRegistro agregado con exito!!!");

    }

}
