package Backup3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Backup3 {

    public static void main(String[]args){

        /*RUTA DEL FICHERO CSV */
        File listaContactos = new File("C:\\Users\\ikmsuarez23\\Desktop\\Backup\\copiaSeguridad\\src\\Contacto (res.partner).csv");
        /*RUTA DEL FICHERO TXT DONDE MODIFICAREMOS DATOS */
        File modificarContactos = new File("C:\\Users\\ikmsuarez23\\Desktop\\Backup\\copiaSeguridad\\src\\Backup3\\listaContactosModificado.txt");
        /*SCANNER */
        Scanner sc = new Scanner(System.in);

        /*TRY */
        try{
            /*LECTURA DEL FICHERO */
            BufferedReader leerContactos = new BufferedReader( new FileReader(listaContactos));
            /*ESCRITURA DEL FICHERO */
            BufferedWriter EscribirContactos = new BufferedWriter(new FileWriter(modificarContactos));

            /*PRIMERA VARIABLE PARA MODIFICAR */
            System.out.println("Introduce el nuevo nombre");
            String nuevoNombre = sc.nextLine();

            /*SEGUNDA VARIABLE PARA MODIFICAR */
            System.out.println("Introduce el numero de telefono");
            int nuevoTelefono = sc.nextInt();

            /*SALTO DE LINEA */
            sc.nextLine();

            /*TERCERA VARIABLE PARA MODIFICAR */
            System.out.println("Introduce el nuevo mail");
            String nuevoEmail = sc.nextLine();

            /*Variable string */
            String linea;
            /*Variable int */
            int contador=0;

             /*Bucle para leer todo el fichero */
            while((linea = leerContactos.readLine())!=null){
                contador++;
            
                /*Hago un if para indicarle que cuando llegue a la linea 3 me modifique la linea entera */
                if(contador==3){
                    linea = nuevoNombre + "," + nuevoTelefono + "," + nuevoEmail;
                }

                /*Que me lo escriba en el fichero indicado */
                EscribirContactos.write(linea);
                EscribirContactos.newLine();
                /*Que me lo muestre en la terminal */
                System.out.println(linea);
            }

            /*Cierres de variables */
            sc.close();
            leerContactos.close();
            EscribirContactos.close();

            /*Catch */
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
}
