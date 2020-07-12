/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.regex.Pattern;

/**
 *
 * @author astridmc
 */
public class LectorArchivo {
    public ArrayList<Dato> datos;
    public ArrayList<Recorrido> recorridos;

    public ArrayList<Dato> getDatos() {
        return datos;
    }

    public void setDatos(ArrayList<Dato> datos) {
        this.datos = datos;
    }

    public ArrayList<Recorrido> getRecorridos() {
        return recorridos;
    }

    public void setRecorridos(ArrayList<Recorrido> recorridos) {
        this.recorridos = recorridos;
    }
    
    
    
    
    //<origen>|<destino>|<tiempo_vehiculo>|<tiempo_pie>|<consumo_gas>|<desgaste_persona>|<distancia>
    public boolean IdentificarDatos(String path){
        datos = new ArrayList();
        String separarLineas[];
        String texto = leerArchivo(path); 
        separarLineas= texto.split("\n");
        String separador = Pattern.quote("|");
        for (int i = 0; i < separarLineas.length; i++) {
             String[] separarDatos= separarLineas[i].split(String.valueOf(separador));
            if(separarDatos.length ==7){
                Dato dato = new Dato();
                dato.origen = limpiarAcentos(separarDatos[0]);
                String destino =limpiarAcentos(separarDatos[1]);
                dato.setDestino(destino);
                dato.tiempoVehiculo = Double.parseDouble(separarDatos[2]);
                dato.tiempoPie = Double.parseDouble(separarDatos[3]);
                dato.consumoGas = Double.parseDouble(separarDatos[4]);
                dato.desgastePersona = Double.parseDouble(separarDatos[5]);
                dato.distancia = Double.parseDouble(separarDatos[5]);
                datos.add(dato);
                //System.out.println(datos.size()+ "lecArDato");
            }   
        }
        if( separarLineas.length > 0){
         return true;
        }else{
            return false;
        }
    }
    
    public String  leerArchivo(String path) {
        String texto="";
        try (FileReader entrada = new FileReader(path)) {
            int c = 0;
            while (c != -1) {
                c = entrada.read();
                char letra = (char) c;
                texto += letra;
            }
            return texto;
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo");
            return "";
        }
    }

    public static String limpiarAcentos(String cadena) {
    String limpio =null;
    if (cadena !=null) {
        String valor = cadena;
        valor = valor.toUpperCase();
        // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
        limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
        // Quitar caracteres no ASCII excepto la enie, interrogacion que abre, exclamacion que abre, grados, U con dieresis.
        limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
        // Regresar a la forma compuesta, para poder comparar la enie con la tabla de valores
        limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
    }
    return limpio;
}
}
