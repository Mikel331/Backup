package Backup2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

public class Backup2{
    public static void main(String[] args){
        FileInputStream fis = null; // declaramos el FileInputStream 
        try{
        File fichero = new File("presupuesto.pdf"); // fichero del cual cogemos los datos
        fis = new FileInputStream(fichero);
        int i;
        FileOutputStream fos = new FileOutputStream("copia_presupuesto.pdf"); // fichero donde se guardara la copia

        while((i = fis.read())!=-1){ // bucle para leer el fichero byte a byte
            System.out.printf("%02X\n", i);  // se imprime en hexadecimales
            fos.write(i); // escribe el byte en la copia
        }
        fos.close(); 
        }catch(FileNotFoundException e){ // excepción si el archivo no existe
            e.printStackTrace();
        }catch(IOException e){ // excepción de lectura y escritura
            e.printStackTrace();
        }finally{
            try{
                if (fis != null) { // si el archivo es diferente a null se cierra
                    fis.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }
        }
    }
}