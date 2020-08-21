package sopareview;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class SopaReview {

    public static final int REVIEW = 0;

    public static final int BRAND = 1;

    public static final int VARIETY = 2;

    public static final int STYLE = 3;

    public static final int COUNTRY = 4;

    public static final int STARS = 5;

    public static void main(String[] args) {

        FileReader archivo;

        BufferedReader inputFile = null;

        try {

            // TODO code application logic here
            archivo = new FileReader("maruchan.csv");

            inputFile = new BufferedReader(archivo);

        } catch (FileNotFoundException ex) {

            System.out.println("Error al abrir el archivo");

            System.exit(0);

        }

        String registro = null;
        String marca = null;
        String stars = null;
        ArrayList<String> res = new ArrayList<String>();
        HashMap<String, Integer> tabla = new HashMap();
        String tat = "";
        try {

            // Leer el archivo linea x linea
            registro = inputFile.readLine();

            while ((registro = inputFile.readLine()) != null) {

                // mostrar registro completo
                String[] campos = registro.split(",");
                tat = campos[1];
                marca = campos[BRAND];
                stars = campos[STARS];

                if (tabla.containsKey(stars)) {

                    Integer m = tabla.get(marca);

                    tabla.replace(marca, new Integer(m.intValue() + 1));

                } else {

                    tabla.put(marca, 1);

                }

            }

            Iterator<String> iterator = tabla.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                res.add(key);

            }
            inputFile.close();
        } catch (IOException ex) {

            System.out.println("Error al cerrar el archivo");

            System.exit(0);

        }

        try {

            // TODO code application logic here
            archivo = new FileReader("maruchan.csv");

            inputFile = new BufferedReader(archivo);

        } catch (FileNotFoundException ex) {

            System.out.println("Error al abrir el archivo");

            System.exit(0);

        }

        try {

            // Leer el archivo linea x linea
            registro = inputFile.readLine();

            String[] result = null;

            ArrayList<String> marca2 = new ArrayList<String>();
            ArrayList<Double> star = new ArrayList<Double>();
            HashMap<String, Double> tabla2 = new HashMap();

            int cont = 0;
            while ((registro = inputFile.readLine()) != null) {

                result = registro.split(",");

                marca2.add(result[1]);
                star.add(Double.parseDouble(result[5]));

                cont++;

            }
            Double sum = 0.0;

            int cont2 = 0;
            for (int i = 0; i < res.size(); i++) {
                String brand = res.get(i);
                cont2 = 0;
                for (int j = 0; j < marca2.size(); j++) {
                    if (brand.equals(marca2.get(j))) {

                        sum += star.get(j);
                        cont2++;
                    }
                }
                tabla2.put(brand, (sum / cont2));
                cont2 = 0;
                sum = 0.0;
            }
            DecimalFormat redondeo = new DecimalFormat("#.00");
            System.out.println("Brand,Stars");
            for (int i = 0; i < res.size(); i++) {
                System.out.print(res.get(i) + "," + redondeo.format(tabla2.get(res.get(i))));
                System.out.println("");
            }
            File f = new File("reviews.csv");
            FileOutputStream reviews = new FileOutputStream(f);
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(reviews));

            for (int i = 0; i < res.size(); i++) {
                bw.write(res.get(i) + "," + redondeo.format(tabla2.get(res.get(i))));
                bw.newLine();
            }

            inputFile.close();
            bw.close();
        } catch (IOException ex) {

            System.out.println("Error al cerrar el archivo");

            System.exit(0);

        }

    }

}
