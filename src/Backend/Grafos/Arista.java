/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Grafos;

import Backend.Dato;
import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Arista {
    private Vertice ver1;
    private Vertice ver2;
    private int peso;
    private Dato Dato;

    public Arista() {
    }
    
    
    
    public Dato getDato() {
        return Dato;
    }

    public void setDato(Dato Dato) {
        this.Dato = Dato;
    }

    public Vertice getVer1() {
        return ver1;
    }

    public void setVer1(Vertice ver1) {
        this.ver1 = ver1;
    }

    public Vertice getVer2() {
        return ver2;
    }

    public void setVer2(Vertice ver2) {
        this.ver2 = ver2;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
    
    

    public Arista(Vertice ver1, Vertice ver2) {
        this.ver1 = ver1;
        this.ver2 = ver2;
    }
   
     public Arista(Vertice vertice1, Vertice vertice2, int peso)
    {
	this.ver1 = vertice1;
	this.ver2 = vertice2;
     	this.peso = peso;
		
    }
     
     public Vertice ObtenerAdyacente(Vertice vertice){
         if(vertice.equals(this.ver1)){
             return ver2;
         }else if(vertice.equals(this.ver2)){
             return ver1;
         }else{
             return null;
         }
    }
     
     public boolean EsIgual(Arista ar)
    {
	if(!(ar instanceof Arista))
	    return false;

	Arista arista2 = (Arista) ar;

	if(arista2.getVer2().equals(this.ver2)) {
            if (arista2.getVer1().equals(this.ver1)) {
                return true;
            }
        }

	return false;
    }
    
     public double DistanciaEntreMatrices( Vertice uno, Vertice dos){
        double distancia;
        for (int i = 0; i < uno.getAdyacentes().size(); i++) {
            if(uno.getAdyacentes().get(i).getVer2() == dos){
                distancia = uno.getAdyacentes().get(i).getDato().getDistancia();
                return distancia;
            }else{
                return -1;
            }
        }
        return -1;
     }
     
     public int ObtenerIndiceArista(ArrayList<Arista> aristas, Vertice vt){
         for (int i = 0; i < aristas.size(); i++) {
            if(aristas.get(i).getVer2()==vt){
                System.out.println("la salida encontrada es "+ vt.getNombre());
                 return i;
            }else{
                System.out.println(aristas.get(i).getVer2().getNombre()+"......la salida NOOOOO encontrada es "+ vt.getNombre()+ aristas.size());
            }
         }
         return -1;
     }
}
