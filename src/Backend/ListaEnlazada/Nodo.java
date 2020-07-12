/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.ListaEnlazada;

/**
 *
 * @author astridmc
 */
public class Nodo<Objeto>{
    private Nodo anterior;
    private Nodo siguiente;
    private Objeto dato;
    private int numeroUsos=1;

    public Nodo(Objeto dato) {
        this.dato = dato;
    }

    public Nodo getAnterior() {
        return anterior;
    }

    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }

    public Objeto getDato() {
        return dato;
    }

    public void setDato(Objeto dato) {
        this.dato = dato;
    }
    
      public int getNumeroUsos() {
        return numeroUsos;
    }

    public void setNumeroUsos(int numeroUsos) {
        this.numeroUsos = numeroUsos;
    }
    
    
}
