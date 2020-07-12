/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class TablaHash {
    
    String nombre;
    ArrayList[] arregloHash;
    
    TablaHash crearTablaHash(String miNombre){
   TablaHash tabla = new TablaHash();
    this.nombre = miNombre;
    arregloHash = new ArrayList[40];
    for(int i=0; i<arregloHash.length;i++){
        ArrayList arbol = new ArrayList();
    }
    return tabla;
}
    
    


int CalcularNumeroDatos(){
   int numeroDatos = 0;
       ArrayList nodo = arregloHash[0];
      for (int i = 0; i < arregloHash.length; i++)
      {
         numeroDatos= numeroDatos + arregloHash[i].size();
      }
      return numeroDatos;
}


int ElegirIndice(int entero){
    int indice = ((int)entero)%(arregloHash.length);
    return indice;
}

public void IngresarValor(Recorrido recorrido){
    arregloHash[ElegirIndice(recorrido.getId())].add(recorrido);
    Rehashing();
}

void   Rehashing(){
    int tamTabla= arregloHash.length;
    int carga = ( CalcularNumeroDatos() / arregloHash.length)*100;
    if(carga>60){
        tamTabla = tamTabla+10;
        arregloHash= new ArrayList[tamTabla];
        
    }
}


}


