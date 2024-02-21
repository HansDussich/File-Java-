package org.example;

import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    //Crear una variable
    public static File archivo;

    //Metodo main
    public static void main(String[] args) {
        //llamar a los metodos
        crearArchivo();
        escribirEnArchivo();
        leerArchivo();
        modificarArchivo();
        leerArchivo();

    }

    // Metodo para crear el archivo
    public static void crearArchivo() {
        // Crear un objeto file
        archivo = new File("archivo.txt");

        try {
            // intentar crear el archivo
            if (archivo.createNewFile()) {
                System.out.println("se creo el archivo exitosamente");

            } else {
                System.out.println("el archivo no se pudo crear");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // Metodo para escribir en el archivo
    public static void escribirEnArchivo(){
        try {
            // escribir texto en el archivo,
            // true para agregar texto al final en vez de reemplazar el contenido
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));

            String contenido = "Hola, TEXTO de prueba.  ";
            writer.write(contenido);
            writer.close();
            System.out.println("Se ha escrito en el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    // metodo para leer el archivo en la consola
    public static void leerArchivo(){
        try {
            // Leer el archivo
            BufferedReader leer = new BufferedReader(new FileReader(archivo));
            String linea;
            // leer el archivo linea por linea, y mostrarlo en la consola
            while ((linea = leer.readLine()) != null) {
                System.out.println(linea);
            }
            leer.close();
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo.");
            e.printStackTrace();
        }
    }

    // metodo para modificar el archivo
    public static void modificarArchivo(){
        try {
            // Escribir en el archivo
            BufferedWriter writer = new BufferedWriter(new FileWriter(archivo, true));
            String nuevoContenido = "  modifique el archivo...";

            writer.write(nuevoContenido);
            writer.close();
            System.out.println("Se ha modificado el archivo.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al modificar el archivo.");
            e.printStackTrace();
        }
    }
}
