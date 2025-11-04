package Backup6;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class ejercicio6 {
    public static void main(String[] args) {
        //Creacion del objeto en formato lista
        List<Contacto> contactos = new ArrayList<>();
        //Try con el bufferedReader y la ruta de donde tenemos el csv
        try (BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\ikmsuarez23\\Desktop\\Backup\\copiaSeguridad\\src\\Contacto (res.partner).csv"))) {
            
            br.readLine(); 

            String linea;
            while ((linea = br.readLine()) != null) {

                
                String[] partes = linea.split("\",\"");

                // limpiamos comillas
                for (int i = 0; i < partes.length; i++) {
                    partes[i] = partes[i].replace("\"", "").trim();
                }

                if (partes.length >= 8) {
                    String nombre = partes[5];
                    String email = partes[4];
                    String telefono = partes[7];

                    contactos.add(new Contacto(nombre, telefono, email));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Datos reales de INCIBE
        Map<String, Object> incibe = new LinkedHashMap<>();
        incibe.put("organizacion", "INCIBE - Instituto Nacional de Ciberseguridad");
        incibe.put("telefono", "017");
        incibe.put("web", "https://www.incibe.es");
        incibe.put("email", "info@incibe.es");

        // JSON final
        Map<String, Object> jsonFinal = new LinkedHashMap<>();
        jsonFinal.put("contactos", contactos);
        jsonFinal.put("contacto_incibe", incibe);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonGenerado = gson.toJson(jsonFinal);

        //Try/catch 
        try {
            Files.writeString(Path.of("Contacto.json"), jsonGenerado);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("JSON creado correctamente -> Contacto.json");
    }
}
