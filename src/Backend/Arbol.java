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
public class Arbol {

    static int orden = 5;
    int numeroDatos = 0;
    int numHijos = orden + 1;
    Nodo raiz;
    boolean esRaiz;
    public ArrayList<Recorrido> datosAlmacenados = new ArrayList();

    public void cerearArbol(ArrayList<Recorrido> datos) {
        for (int i = 0; i < datos.size(); i++) {
            InsertarNodo(datos.get(i));
        }
        System.out.println("el tama;o de datos en El arbol de recorrridos es "+ datos.size());
    }

    public void InsertarNodo(Recorrido recorrido) {
        if (raiz == null) {
            numeroDatos++;
            raiz = new Nodo();
            raiz.claves[0] = recorrido;
        } else {
            numeroDatos++;
            int i = 0;
            if (raiz.tengoHijos == false) {
                for (int j = 0; j < raiz.claves.length; j++) {
                    if (raiz.hijos[j] == null) {
                        raiz.claves[i] = recorrido;
                        datosAlmacenados.add(recorrido);
                        j = i;
                        ordenarBurbuja(raiz.claves, 0);
                        break;
                    }
                }
                if (i == orden) {
                    dividirYAcomodar(raiz);
                }
            } else {
                SetTengoHijos(raiz);
                IngresarEnHijos(raiz, recorrido);
            }
        }
    }

    public Nodo buscarHijoMenorDato(Nodo nodo) {
        for (int i = 0; i < nodo.claves.length; i++) {
            if (nodo.hijos[0].claves != null) {
                return nodo.hijos[0];
            } else {
                return null;
            }
        }
        return null;
    }

    public Recorrido buscarMayorDato(Nodo nodo) {
        for (int i = nodo.claves.length; i == 0; i++) {
            if (nodo.claves[i] != null) {
                return nodo.claves[i];
            } else {
                return null;
            }
        }
        return null;
    }

    public Recorrido buscarMenorDato(Nodo nodo) {
        for (int i = 0; i == nodo.claves.length; i++) {
            if (nodo.claves[0] != null) {
                return nodo.claves[0];
            } else {
                return null;
            }
        }
        return null;
    }

    public Recorrido buscarEnNodo(Nodo nodo, int id) {
        for (int i = 0; i < nodo.claves.length; i++) {
            if (id == nodo.claves[i].id) {
                return nodo.claves[i];
            }
        }
        return null;
    }

    public boolean verificarHijos(Nodo nodo) {
        if (nodo.hijos.length > 0) {
            return true;
        } else {
            return false;
        }

    }

    public void ordenarBurbuja(Recorrido arr[], int longitud) {
        longitud = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != null) {
                longitud++;
            } else {
                break;
            }
        }
        for (int ord = 0; ord < longitud; ord++) {
            for (int ord1 = 0; ord1 < longitud - 1; ord1++) {
                if (arr[ord1].id > arr[ord1 + 1].id) {
                    Recorrido tmp = arr[ord1];
                    arr[ord1] = arr[ord1 + 1];
                    arr[ord1 + 1] = tmp;
                }
            }
        }
    }

    public void dividirYAcomodar(Nodo nodo) {
        Nodo hijoIzq = new Nodo();
        Nodo hijoDer = new Nodo();

        if (nodo.hijos[0] == null) {
            for (int i = 0; i == CalcularCiclo(orden); i++) {
                hijoIzq.hijos[i] = nodo.hijos[i];
                hijoIzq.hijos[i].padre = hijoIzq;
                nodo.hijos[i] = null;
                if (nodo.hijos[i + CalcularCiclo(orden)] != null) {
                    hijoDer.hijos[i] = nodo.hijos[i + CalcularCiclo(orden) + 1];
                    hijoDer.hijos[i].padre = hijoDer;
                }
                nodo.hijos[i + i + CalcularCiclo(orden) + 1] = null;
            }
        }
        for (int i = 0; i < CalcularCiclo(orden); i++) {
            hijoIzq.claves[i] = nodo.claves[i];
            nodo.claves[i] = null;
            hijoDer.claves[i] = nodo.claves[i + CalcularCiclo(orden) + 1];
            nodo.claves[i + CalcularCiclo(orden) + 1] = null;
        }
        nodo.claves[0] = nodo.claves[CalcularCiclo(orden)];
        nodo.claves[CalcularCiclo(orden)] = null;
        nodo.hijos[0] = hijoIzq;
        nodo.hijos[0].padre = nodo;
        nodo.hijos[1] = hijoDer;
        nodo.hijos[1].padre = nodo;
        SetTengoHijos(raiz);
        OrdenarNodos(nodo);
        // subie el valor del padre
        if (nodo.padre != null) {
            boolean subido = false;
            for (int i = 0; i < nodo.padre.claves.length && subido == false; i++) {
                if (nodo.padre.claves[i] == null) {
                    nodo.padre.claves[i] = nodo.claves[0];
                    nodo.claves[0] = null;
                    subido = true;
                    ordenarBurbuja(nodo.padre.claves, 0);
                }
            }
            int posHijo = 0;
            for (int i = 0; i == orden + 3; i++) {
                if (nodo.padre.hijos[i] != null) {
                    posHijo++;
                } else {
                    break;
                }
            }
            nodo.padre.hijos[posHijo] = nodo.hijos[0];
            nodo.padre.hijos[posHijo + 1] = nodo.hijos[1];
            nodo.padre.hijos[posHijo].padre = nodo.padre;
            nodo.padre.hijos[posHijo + 1].padre = nodo.padre;

            int aux = 0;
            for (int i = 0; i < orden + 3 && nodo.padre.hijos[i] != null; i++) {
                if (nodo.padre.hijos[i].claves[0] == nodo.claves[0]) {
                    aux = i;
                }
            }
            Nodo papa = nodo.padre;
            nodo = null;
            int j = aux;
            while (j < orden + 2 && papa.hijos[j] != null && papa.hijos[j + 1] != null) {
                papa.hijos[j] = papa.hijos[j + 1];
                j++;
            }
            papa.hijos[j] = null;
            ordenarBurbuja(papa.claves, 0);
            OrdenarNodos(papa);
            if (papa.claves[orden] != null) {
                dividirYAcomodar(papa);
            }

        }

    }

    public int CalcularCiclo(int num) {
        if (num % 2 != 0) {
            int ciclo = num / 2 + 1;
            return ciclo;
        } else {
            int ciclo = num / 2;
            return ciclo;
        }
    }

    public void SetTengoHijos(Nodo nodo) {
        if (nodo == raiz) {
            if (raiz.hijos[0] != null) {
                raiz.tengoHijos = true;
            }
        }
        for (int i = 0; i < nodo.hijos.length; i++) {
            if (nodo.hijos[i] != null) {
                nodo.tengoHijos = true;
                SetTengoHijos(nodo.hijos[i]);
            }
        }
    }

    public void OrdenarNodos(Nodo nodo) {
        int i = 0;
        int j;
        Nodo aux;

        while (i < orden + 3 && nodo.hijos[i] != null) {
            j = 0;
            while (j < orden + 2 && nodo.hijos[j] != null && nodo.hijos[j + 1] != null) {
                if (nodo.hijos[j].claves[0].id > nodo.hijos[j + 1].hijos[j + 1].claves[0].id) {
                    aux = nodo.hijos[j];
                    nodo.hijos[j] = nodo.hijos[j + 1];
                    nodo.hijos[j + 1] = aux;
                }
                j++;
            }
            i++;
        }
    }

    public void EncontrarValorArreglo(Nodo nodo, Recorrido recorrido) {
        int cont = 0;
        while (cont <= orden) {
            if (nodo.claves[cont] == null) {
                nodo.claves[cont] = recorrido;
                ordenarBurbuja(nodo.claves, 0);
                datosAlmacenados.add(recorrido);
                if (cont == orden) {
                    dividirYAcomodar(nodo);
                }
                break;
            }
            cont++;
        }
    }

    public void IngresarEnHijos(Nodo nodoWHijos, Recorrido dato) {
        boolean agregado = false;
        if (nodoWHijos != null && !nodoWHijos.tengoHijos) {
            EncontrarValorArreglo(nodoWHijos, dato);
            agregado = true;
        }
        for (int i = 0; nodoWHijos != null && i < orden + 1 && !agregado; i++) {
            if (dato.id < nodoWHijos.claves[i].id || nodoWHijos.claves[i].id == 0) {
                agregado = true;
                IngresarEnHijos(nodoWHijos.hijos[i], dato);
                i = orden;
            }
        }
    }
    int aux1 = 1;
    int nivel = 1;

    public ArrayList<Recorrido> RecorrerArbol(Nodo nodo1) {
        ArrayList<Recorrido> recorridos = new ArrayList();
        for (int i = 0; i < orden + 1; i++) {
            if (nodo1.hijos[i] != null) {
                if (i == 0) {
                    nivel++;
                    aux1++;
                } else {
                    aux1++;
                }
                RecorrerArbol(nodo1.hijos[i]);
            }

            for (int j = 0; nodo1.hijos[i] != null && j < nodo1.hijos[i].claves.length; j++) {
                if (nodo1.hijos[i] != null) {
                    recorridos.add(nodo1.hijos[i].claves[j]);
                }
            }
        }
        return recorridos;
    }

    // busca el nodo que contiene el elemento a eliminar
    public Nodo buscarNodoContenedor(Recorrido recorrido, Nodo nodo) {
        for (int i = 0; i < nodo.claves.length; i++) {
            if (recorrido.id == nodo.claves[i].id) {
                return nodo;
            } else if (recorrido.id < nodo.claves[i].id) {
                return buscarNodoContenedor(recorrido, nodo.hijos[i]);
            } else if (recorrido.id > nodo.claves[i].id) {
                return buscarNodoContenedor(recorrido, nodo.hijos[i]);
            }
        }
        return null;
    }

    public void EliminarDato(Recorrido recorrido) {
        boolean aux = false;
        int j = 0;
        for (int i = 0; i < datosAlmacenados.size() && !aux; i++) {
            if (datosAlmacenados.get(i) == recorrido) {
                aux = true;
            }
        }
        if (aux == true) {
            datosAlmacenados.remove(j);
        } else {
            System.out.println("valor No Encontrado");

        }
        Nodo nodoAEliminar = buscarNodoContenedor(recorrido, raiz);
        if (!nodoAEliminar.tengoHijos) {
            eliminarDeNodosClaves(recorrido, nodoAEliminar);
        }

        if (nodoAEliminar.claves.length > nodoAEliminar.minimoHijos) {
            eliminarDeNodosClaves(recorrido, nodoAEliminar);
        } else if (nodoAEliminar.claves.length > nodoAEliminar.minimoHijos) {
            
        }
    }

    public int ValorMayor(Recorrido[] arreglo) {
        int num = arreglo.length;
        for (int i = num; i > 0; i--) {
            if (arreglo[num - 1] != null) {
                num = i - 1;
            } else {
                num = -1;
            }
        }
        return num;
    }

    public boolean TieneNodoHijos(Nodo nodo, Recorrido rec) {
        boolean tiene = false;
        for (int i = 0; i < nodo.claves.length; i++) {
            if (rec == nodo.claves[i]) {
                if (i > nodo.hijos.length) {
                    tiene = true;
                }
            }
        }
        return tiene;
    }

    public void eliminarDeNodosClaves(Recorrido rec, Nodo nodo) {
        if (!nodo.tengoHijos) {
            if (nodo.claves.length > nodo.minimoHijos) {
                EliminarClave(rec, nodo);
            } else {
                if (Reequilibrar(nodo, rec.id)) {
                    System.out.println("eliminado");
                } else {
                    System.out.println("NO ELIMINADO");
                }
            }
        } else if (nodo.tengoHijos) {
            if (nodo != raiz) {
                if (Reequilibrar(nodo, rec.id)) {
                    System.out.println("eliminadoooooo");
                } else {
                       System.out.println("no ELIMINADO "); 
                }
            }
        }

    }

    public Recorrido[] EliminarClave(Recorrido rec, Nodo nodo) {
        Recorrido[] recorridos = nodo.claves;
        Recorrido aux = null;
        for (int i = 0; i < recorridos.length; i++) {

            if (rec == recorridos[i] && recorridos[i + 1] != null) {
                aux = recorridos[i + 1];
                if (recorridos[i + 1] == null) {
                    recorridos[i] = recorridos[i + 1];
                } else {
                    recorridos[i] = null;
                }
            } else if (aux != null && recorridos[i + 1] != null) {
                aux = recorridos[i + 1];
                recorridos[i] = recorridos[i + 1];
            } else if (recorridos[i + 1] == null) {
                recorridos[i] = null;
            }
        }
        return recorridos;
    }

    public void ReEquilibrar() {

    }

    // busca el numero menor a el en el padre
    public int BuscarIndicePadreMenor(Nodo padre, int id) {
        for (int i = 0; i < padre.claves.length; i++) {
            if (id < padre.claves[i].id) {
                return i;
            }
        }
        return 0;
    }

    public int BuscarIndicePadreMayor(Nodo padre, int id) {
        for (int i = 0; i < padre.claves.length; i++) {
            if (id <= padre.claves[i].id) {
                return i + 1;
            } else {
                return -1;
            }
        }
        return 0;
    }

    public void subirHijo(Nodo nodo, int id) {
        Nodo padre = nodo.padre;
        int indice = BuscarIndicePadreMenor(padre, id);

        if (padre.hijos[indice].claves.length > padre.minimoHijos) {
            padre.claves[indice] = buscarMenorDato(nodo);
            eliminarDeNodosClaves(buscarMenorDato(nodo), nodo);
        } else if (padre.hijos[indice + 1].claves.length > padre.minimoHijos) {
            padre.claves[indice] = buscarMenorDato(nodo);
            eliminarDeNodosClaves(buscarMenorDato(nodo), nodo);
        } else if (padre.hijos[indice + 1].claves.length == padre.minimoHijos && padre.hijos[indice].claves.length == padre.minimoHijos) {

        }
    }
    
    public boolean SuboHijo(Nodo NodoDeHijoASubir, Nodo padre, int indice){
        if(NodoDeHijoASubir.claves.length> NodoDeHijoASubir.minimoHijos){
            Recorrido aux = buscarMenorDato(NodoDeHijoASubir);
            EliminarClave( aux, NodoDeHijoASubir);
            padre.claves[indice]= aux;
            return true;
        }else{
            return false;
        }
       
    }

    public int BuscarIndiceNodo(Nodo padre, Nodo nodo) {
        for (int i = 0; i < padre.hijos.length; i++) {
            if (padre.hijos[i] == nodo) {
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public void InsertarValorArreglo(Nodo nodo, Recorrido recorrido) {
        int cont = 0;
        while (cont <= orden) {
            if (nodo.claves[cont] == null) {
                nodo.claves[cont] = recorrido;
                ordenarBurbuja(nodo.claves, 0);
                break;
            }
            cont++;
        }
    }

    public boolean Reequilibrar(Nodo nodo, int id) {

        Nodo padre = nodo.padre;
        if (padre.claves.length > padre.minimoHijos) {
            if (BuscarIndicePadreMenor(padre, id) >= 0) {
                int indice = BuscarIndicePadreMenor(padre, id);
                nodo.claves[nodo.minimoHijos - 1] = padre.claves[indice];
                nodo.padre.claves = EliminarClave(padre.claves[indice], padre);
                ordenarBurbuja(nodo.claves, 0);
            } else if (BuscarIndicePadreMayor(padre, id) >= 0) {
                int indice = BuscarIndicePadreMayor(padre, id);
                nodo.claves[nodo.minimoHijos - 1] = padre.claves[indice];
                nodo.padre.claves = EliminarClave(padre.claves[indice], padre);
                ordenarBurbuja(nodo.claves, 0);
            }
            
                if(padre.hijos[BuscarIndiceNodo(padre, nodo)+1]!= null){
                    SuboHijo(padre.hijos[BuscarIndiceNodo(padre, nodo)+1], padre, BuscarIndicePadreMenor(padre, id));
                    System.out.println("eliminado nodo+1");
                }else if(padre.hijos[BuscarIndiceNodo(padre, nodo)]!= null){
                    SuboHijo(padre.hijos[BuscarIndiceNodo(padre, nodo)], padre, BuscarIndicePadreMenor(padre, id));
                    System.out.println("eliminado nodo ");
                }else if(JuntarArreglo(nodo, padre.hijos[BuscarIndiceNodo(padre, nodo)+1])!= null){
                    System.out.println("eliminadi juntar arreglo");
                }else {
                    return false;
                }
           
            return true;
        } else {
            return false;
        }
    }

    public Nodo JuntarArreglo(Nodo arreglo1, Nodo arreglo2) {
        Nodo nodo = new Nodo();
        if (arreglo1.claves.length + arreglo2.claves.length <= orden-1) {
            if (!arreglo1.tengoHijos && !arreglo2.tengoHijos) {
                Recorrido[] rec = new Recorrido[orden - 1];
                for (int i = 0; i < arreglo1.claves.length; i++) {
                    rec[i] = arreglo1.claves[i];
                }
                for (int i = arreglo1.claves.length - 1; i < (arreglo1.claves.length + arreglo2.claves.length); i++) {
                    rec[i] = arreglo1.claves[i];
                }
                nodo.claves = rec;
                nodo.hijos = null;
                nodo.tengoHijos = false;
            } else if (arreglo1.tengoHijos && !arreglo2.tengoHijos) {
                Recorrido[] rec = new Recorrido[orden - 1];
                for (int i = 0; i < arreglo1.claves.length; i++) {
                    rec[i] = arreglo1.claves[i];
                }
                for (int i = arreglo1.claves.length - 1; i < (arreglo1.claves.length + arreglo2.claves.length); i++) {
                    rec[i] = arreglo1.claves[i];
                }
                nodo.claves = rec;
                nodo.hijos = arreglo1.hijos;
                nodo.tengoHijos = true;
            } else if (arreglo1.tengoHijos && !arreglo1.tengoHijos) {
                Recorrido[] rec = new Recorrido[orden - 1];
                for (int i = 0; i < arreglo1.claves.length; i++) {
                    rec[i] = arreglo1.claves[i];
                }
                for (int i = arreglo1.claves.length - 1; i < (arreglo1.claves.length + arreglo2.claves.length); i++) {
                    rec[i] = arreglo1.claves[i];
                }
                nodo.claves = rec;
                nodo.hijos = arreglo2.hijos;
                nodo.tengoHijos = true;
            } else if (arreglo1.tengoHijos && arreglo2.tengoHijos) {
                Recorrido[] rec = new Recorrido[orden - 1];
                for (int i = 0; i < arreglo1.claves.length; i++) {
                    rec[i] = arreglo1.claves[i];
                }
                for (int i = arreglo1.claves.length - 1; i < (arreglo1.claves.length + arreglo2.claves.length); i++) {
                    rec[i] = arreglo1.claves[i];
                }
                for (int i = arreglo1.hijos.length - 1; i < arreglo2.hijos.length; i++) {
                    arreglo1.hijos[i] = arreglo2.hijos[arreglo1.hijos.length - 1 - i];
                }
                nodo.claves = rec;
                nodo.hijos = arreglo1.hijos;
                nodo.tengoHijos = true;
            }
            return nodo;
        }else{
            return null;
        }
    }

}
