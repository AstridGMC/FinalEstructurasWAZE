/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.ListaEnlazada;

import Backend.Recorrido;

/**
 *
 * @author astridmc
 * @param <Objeto>
 */
public class ListaEnlazadaDobleC<Objeto> {

    Nodo<Objeto> inicio = null;

    public Nodo<Objeto> getInicio() {
        return inicio;
    }

    public void setInicio(Nodo<Objeto> inicio) {
        this.inicio = inicio;
    }
    
    public Recorrido ObtenerCaminoFavorito(ListaEnlazadaDobleC<Recorrido> recorridos, String Destino, String Origen){
        int indice=0;
        int numeros=0;
        for (int i = 0; i < recorridos.Size(); i++) {
            if(recorridos.obtenerObjeto(i).getDestino().getNombre().equals(Destino) &&recorridos.obtenerObjeto(i).getOrigen().getNombre().equals(Origen)){
                if(recorridos.obtenerNodo(i).getNumeroUsos()>=numeros){
                    indice =i;
                    numeros= recorridos.obtenerNodo(i).getNumeroUsos();
                }
            }
        }
        if(recorridos.Size()>0){
            System.out.println("RECORRIDO.........");
            return recorridos.obtenerObjeto(indice);
        }else{
            System.out.println("nula.........");
            return null;
        }
    }
    
    public boolean VerifcarCaminoFavorito(ListaEnlazadaDobleC<Recorrido> recorridos, String Destino, String Origen, Recorrido recorrido){
        int indice=0;
        int numeros=0;
        for (int i = 0; i < recorridos.Size(); i++) {
            if(recorridos.obtenerObjeto(i).getDestino().getNombre().equals(Destino) &&recorridos.obtenerObjeto(i).getOrigen().getNombre().equals(Origen)){
                if(recorridos.obtenerNodo(i).getNumeroUsos()>=numeros){
                    indice =i;
                    numeros= recorridos.obtenerNodo(i).getNumeroUsos();
                }
            }
        }
        boolean es = false;
        if(recorrido.equals(recorridos.obtenerObjeto(indice)) ){
            es=true;
        }
        
        return es;
    }

    public void insertarInicio(Objeto objeto) {
        Nodo<Objeto> nodoNuevo = new Nodo(objeto);
        if (inicio == null) {
            inicio = nodoNuevo;
        } else {
            nodoNuevo.setSiguiente(inicio);
            inicio.setAnterior(nodoNuevo);
            inicio = nodoNuevo;
        }
    }

    public void insertarFinal(Objeto objeto) {
        Nodo<Objeto> nuevoNodo = new Nodo(objeto);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            Nodo auxiliar = inicio;
            while (auxiliar.getSiguiente() != null) {
                auxiliar = auxiliar.getSiguiente();
            }
            auxiliar.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(auxiliar);
        }
    }

    public void EliminarNodo(Objeto valor) {
        if (inicio != null) {
            Nodo<Objeto> auxiliar = inicio;
            Nodo<Objeto> anterior = null;
            while (auxiliar != null) {
                if (auxiliar.getDato() == valor) {
                    if (anterior == null) {
                        inicio = inicio.getSiguiente();
                        auxiliar.setSiguiente(null);
                        auxiliar = inicio;
                    } else {
                        anterior.setSiguiente(auxiliar.getSiguiente());
                        auxiliar.setSiguiente(null);
                        auxiliar = anterior.getSiguiente();
                    }
                } else {
                    anterior = auxiliar;
                    auxiliar = auxiliar.getSiguiente();
                }
            }
        }
    }

    public boolean buscar(Objeto objeto) {
        if (inicio != null) {
            Nodo<Objeto> auxiliar = null;
            int contador = 0;
            while (auxiliar != null) {
                if (auxiliar.getDato() == objeto) {
                    contador++;
                    auxiliar = auxiliar.getSiguiente();
                    return true;
                }
            }
        }
        return false;
    }

    public Objeto obtenerObjeto(int i) {
        int contador =0;
        if (inicio != null) {
            Nodo<Objeto> auxiliar = inicio;
            while (auxiliar != null && contador <= i) {
                if(contador == i){
                    System.out.println(i);
                    return auxiliar.getDato();
                }
                auxiliar = auxiliar.getSiguiente();
                contador++;
            }
        }
        return null;
    }
    
    public int obtenerNumero(int i) {
        int contador =0;
        if (inicio != null) {
            Nodo<Objeto> auxiliar = inicio;
            while (auxiliar != null && contador <= i) {
                if(contador == i){
                    System.out.println(i);
                    return auxiliar.getNumeroUsos();
                }
                auxiliar = auxiliar.getSiguiente();
                contador++;
            }
        }
        return 0;
    }
    public Nodo obtenerNodo(int i) {
        int contador =0;
        if (inicio != null) {
            Nodo<Objeto> auxiliar = inicio;
            while (auxiliar != null && contador <= i) {
                if(contador == i){
                    System.out.println(i);
                    return auxiliar;
                }
                auxiliar = auxiliar.getSiguiente();
                contador++;
            }
        }
        return null;
    }
    
    public int Size(){
        int contador =0;
        if (inicio != null) {
            Nodo<Objeto> auxiliar = inicio;
            while (auxiliar != null) {
                    System.out.println(contador);
                auxiliar = auxiliar.getSiguiente();
                contador++;
            }
            
        }
        return contador;
    }

}
