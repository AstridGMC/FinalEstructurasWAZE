/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.io.FileReader;
import java.io.IOException;
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
    
    
    
    
    //<origen>|<destino>|<tiempo_vehiculo>|<tiempo_pie>|<consumo_gas>|<desgaste_persona>
    public boolean IdentificarDatos(String path){
        datos = new ArrayList();
        String separarLineas[];
        String texto = leerArchivo(path); 
        separarLineas= texto.split("\n");
        String separador = Pattern.quote("|");
        for (int i = 0; i < separarLineas.length; i++) {
             String[] separarDatos= separarLineas[i].split(String.valueOf(separador));
            if(separarDatos.length ==6){
                Dato dato = new Dato();
                dato.origen = separarDatos[0];
                String destino =separarDatos[1];
                dato.setDestino(destino);
                dato.tiempoVehiculo = Double.parseDouble(separarDatos[2]);
                dato.tiempoPie = Double.parseDouble(separarDatos[3]);
                dato.consumoGas = Double.parseDouble(separarDatos[4]);
                dato.desgastePersona = Double.parseDouble(separarDatos[5]);
                datos.add(dato);
                System.out.println(datos.size()+ "lecArDato");
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
    
    
    public void separarDaatos(String datosASeparar[]){
        for (int j = 0; j < datosASeparar.length; j++) {
                    if(j==0){
                    }else if(j==1){
                        
                    }else if(j==2){
                        
                    }else if(j==3){
                        
                    }else if(j==4){
                        
                    }else if(j==5){
                        
                    }else if(j==6){
                        
                    }
    }
    }
}
