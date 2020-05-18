/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import Backend.Grafos.Vertice;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Recorrido {
    ArrayList<Vertice> vertices;
    int id;
    Vertice Destino;
    Vertice Origen;
    double peso;
    
    
    
    /*
    public Dato generarRecorridos(ArrayList<Dato> datos, String destino, String origen){
        Dato dato=null;
        for (int i = 0; i < datos.size(); i++) {
            id++;
            if(datos.get(i).origen.equals(origen)){
                //for (int j = 0; j < datos.get(i).destino.size(); j++) {
                    if (datos.get(i).destino.get(j).equals(destino)){
                        dato = datos.get(i);
                        nodos.add(datos.get(i));
                    }else if(i+1 == datos.size()){
                         return dato;
                    } else{
                         dato = generarRecorridos(datos, destino , datos.get(i).destino.get(j));
                        if(dato!=null){
                            nodos.add(dato);
                        }
                       
                    }
                }
            }
        }
        return dato;
    }*/

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vertice getDestino() {
        return Destino;
    }

    public void setDestino(Vertice Destino) {
        this.Destino = Destino;
    }

    public Vertice getOrigen() {
        return Origen;
    }

    public void setOrigen(Vertice Origen) {
        this.Origen = Origen;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    
}
