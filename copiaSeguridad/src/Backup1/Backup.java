package Backup1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Backup {
    
    public static void main (String[]args){ 
        /* RUTA DEL FICHERO CSV*/
        File archivoContactos = new File("C:\\Users\\ikmsuarez23\\Desktop\\Backup\\copiaSeguridad\\src\\Contacto (res.partner).csv");

        /*TRY */
        try{
            /*LECTURA DEL FICHERO CSV */
            BufferedReader leerArchivo = new BufferedReader(new FileReader(archivoContactos));
            /*Variable string */
            String linea;
            /*Bucle para leer todo el fichero */
            while((linea = leerArchivo.readLine())!=null){
               System.out.println(linea);
            }
        /*Cierre de la variable que leemos */
        leerArchivo.close();
    /*CATCH */
    }catch(IOException e){
        e.printStackTrace();
    }
    
    }

}
