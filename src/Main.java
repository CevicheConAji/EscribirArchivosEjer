import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args)  {
        String archivo = "data.csv";
        baseFileWrite(archivo);
        pedirInfo(archivo);
        printList(leerGuardarLinked(archivo));
    }

    public static void baseFileWrite(String archivo) {
        File file = new File(archivo);

        try (FileWriter fw = new FileWriter(file, false)) {
            //true para añadirlo al final y false para sobreEscribir
            fw.write("NIA;NOMBRE;DIRECCIÓN");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void pedirInfo(String archivo) {
        System.out.println("Introduzca NIA");
        String nia = sc.nextLine();
        System.out.println("Introduzca su nombre");
        String nombre = sc.nextLine();
        System.out.println("Introduzca su direccion");
        String direccion = sc.nextLine();

        String texto = nia + ";" + nombre + ";" + direccion;
        try (FileWriter fw = new FileWriter(archivo, true)) {
            fw.write("\n" + texto.toLowerCase());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<String> leerGuardarLinked(String archivo)  {
        ArrayList<String> lista = new ArrayList<>();

        File f = new File(archivo);

        if (f.exists()) {
            if (f.isFile()) {

                try {
                    FileReader fr = null;
                    fr = new FileReader(archivo);
                    BufferedReader bf = new BufferedReader(fr);
                    String cad;
                    System.out.println("***IMPRIMIENDO ARCHIVO " + archivo + "***");
                    while ((cad = bf.readLine()) != null) {
                        //System.out.printf(cad + "\n");
                        lista.add(cad.toLowerCase());
                    }
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else System.out.print("Es un directorio");
        }else System.out.println("El fichero no existe");


        return lista;
    }
    public static void printList(ArrayList<String> lista) {
        for (String s : lista) {
            System.out.println(s);
        }
    }
}