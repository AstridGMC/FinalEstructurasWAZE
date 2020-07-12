/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend.Grafos;

import Backend.Dato;
import java.util.ArrayList;
import Backend.Grafos.Vertice;
import Backend.Recorrido;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;

/**
 *
 * @author astridmc
 */
public class Grafos {

    ArrayList<ArrayList<Vertice>> caminosRecorridos;
    boolean[][] matrizAdyacencia;
    ArrayList<Vertice> vertices = new ArrayList();
    Dato inicio;
    Dato fin;
    int distancia;

    public ArrayList<ArrayList<Vertice>> getCaminosRecorridos() {
        return caminosRecorridos;
    }

    public void setCaminosRecorridos() {
        caminosRecorridos = new ArrayList();
    }

    public boolean[][] getMatrizAdyacencia() {
        return matrizAdyacencia;
    }

    public void setMatrizAdyacencia(boolean[][] matrizAdyacencia) {
        this.matrizAdyacencia = matrizAdyacencia;
    }

    public ArrayList<Vertice> getVertices() {
        return vertices;
    }

    public void setVertices(ArrayList<Vertice> vertices) {
        this.vertices = vertices;
    }

    public void CrearMatrizAdyacencia() {
        matrizAdyacencia = new boolean[vertices.size()][vertices.size()];

        for (int i = 0; i < vertices.size(); i++) {
            int indice = -1;
            // System.out.println(vertices.get(i).getAdyacentes().size() + "numAdyacentes.................");
            for (int j = 0; j < vertices.size(); j++) {
                for (int l = 0; l < vertices.get(i).getAdyacentes().size(); l++) {
                    // System.out.println("\n\n probando" + vertices.get(i).getAdyacentes().get(l).getVer2().getNombre() + " adyacente de " + vertices.get(i).getNombre());
                    if (vertices.get(i).getAdyacentes() != null) {
                        if (vertices.get(i).getAdyacentes().get(l).getVer2() == vertices.get(j)) {
                            //System.out.println(vertices.get(i).getAdyacentes().get(l).getVer2().getNombre() + " y " + vertices.get(j).getNombre());
                            //System.out.println("entrando Matriz............" + "\n");
                            String nodo = vertices.get(i).getAdyacentes().get(l).getVer2().getNombre();
                            //indice = CalcularIndice(vertices, nodo);
                            // System.out.println(indice);
                            matrizAdyacencia[i][j] = true;
                            break;
                        } else {
                            //System.out.println(vertices.get(i).getAdyacentes().get(l).getVer2().getNombre() + "  no es igual a " + vertices.get(j).getNombre());
                            indice = -1;
                            if (matrizAdyacencia[i][j] != true) {

                                matrizAdyacencia[i][j] = false;
                            }
                        }
                    }
                }
            }
        }
        for (int i = 0; i < matrizAdyacencia.length; i++) {
            for (int j = 0; j < matrizAdyacencia.length; j++) {
                //  System.out.print(matrizAdyacencia[i][j]);
            }
            //System.out.println("\n");
        }
    }

    public void CrearRecorridos(Vertice uno, Vertice fin) {
        caminosRecorridos = new ArrayList();
        int intVer = ObtenerIndiceVertice(uno.getNombre());
        int intfin = ObtenerIndiceVertice(fin.getNombre());
        ArrayList<Vertice> vertices = new ArrayList();
        CaminosR(vertices, intVer, intfin);
    }

    /*
    public void CalcularCaminos(boolean matriz[][]){
        Arista  arista = new Arista();
        float matrizDistancias[][]=null;
        int verticesN = matriz.length;
        boolean matriz1[][] = matriz;
        //Vertice caminos[][] = new Vertice [vertices.size()][vertices.size()];
        ArrayList<Vertice> caminos = new ArrayList();
        String caminosAux[][] = new  String [verticesN][verticesN];
        String recorrido;
        String cadena;
        Vertice caminitos;
        double distancia1=0;
        double distancia2=0;
        double distancia3=0;
        double minimo;
        boolean aux1, aux2, aux3, min;
        int i=0;
        int j=0;
        int k=0;
        
        for (i = 0; i < verticesN; i++) {
            for ( j = 0; j < verticesN; j++) {
                caminos = null;
                caminosAux[i][j]=null;
                           
            }
        }
        for (k = 0; k < verticesN; k++) {
            for ( i = 0; i < verticesN; i++) {
                for (j = 0; j < verticesN; j++) {
                    aux1 = matriz1[i][j];
                    aux2 = matriz[i][k];
                    aux3 = matriz[k][j];
                    if(aux1){
                        distancia1 = arista.DistanciaEntreMatrices(vertices.get(i), vertices.get(j));
                    } 
                    if(aux2){
                        distancia2 = arista.DistanciaEntreMatrices(vertices.get(i), vertices.get(k));
                    }
                    distancia3 = distancia1 + distancia2;
                    minimo = Math.min(distancia1, distancia3);
                    if(distancia1!= minimo){
                        if(minimo == distancia3){
                            caminosAux[i][j] = k + "";
                            caminos= caminoR(i,k, caminos);
                        }
                    }
                    matrizDistancias[i][j]= (float) minimo;
                    
                }
            }
 
        }
        
         for (i = 0; i < verticesN; i++) {
            for ( j = 0; j < verticesN; j++) {
                cadena = cadena + "[";
            }
        }
        
    }*/
    public boolean contiene(ArrayList<Vertice> caminos2, Vertice vertice) {

        for (int i = 0; i < caminos2.size(); i++) {
            //System.out.println("tam CONTIENE ..........."+caminos2.size());
            if (caminos2.get(i).getNombre() == vertice.getNombre()) {
                //  System.out.println("COMPARANDO........."+caminos2.get(i).getNombre()+" = "+vertice.getNombre());
                return true;
            } else {
                // System.out.println("COMPARANDO........."+caminos2.get(i).getNombre()+" =! "+vertice.getNombre());
                return false;
            }
        }
        return false;
    }

    public void CaminosR(ArrayList<Vertice> caminos2, int indiceInicio, int indiceFin) {

        if (!contiene(caminos2, vertices.get(indiceInicio))) {
            caminos2.add(vertices.get(indiceInicio));
        }

        //System.out.println(vertices.get(indiceInicio).getNombre() + "  nombre inicio ");
        //System.out.println(vertices.get(indiceFin).getNombre() + "   nombre fin ");
        //for (int i = 0; i < matrizAdyacencia.length; i++) {
        if (matrizAdyacencia[indiceInicio][indiceFin] == true) {
            //System.out.println("Hay coincidencias de " + vertices.get(indiceInicio).getNombre() + "->>> " + vertices.get(indiceFin).getNombre());
            // caminos2 = CaminosR(caminos2, j, indiceFin);
            if (!contiene(caminos2, vertices.get(indiceFin))) {
                caminos2.add(vertices.get(indiceFin));
            }
            ArrayList<Vertice> misVertices = pasarArreglo(caminos2);
            caminosRecorridos.add(misVertices);
            caminos2.remove(vertices.get(indiceFin));
            //System.out.println(caminosRecorridos.get(0).size()+" datos: "+caminosRecorridos.get(0).get(0).getNombre()+"  "+caminosRecorridos.get(0).get(1).getNombre() );
        }
        for (int j = 0; j < matrizAdyacencia.length; j++) {
            if (matrizAdyacencia[indiceInicio][j] == true) {
                //System.out.println( vertices.get(indiceInicio).getNombre()+"probando  "+ vertices.get(j).getNombre()+ "tammm "+ caminos2.size());
                ArrayList<Vertice> verticesAux = pasarArreglo(caminos2);
                if (!contiene(caminos2, vertices.get(j))) {
                    CaminosR(caminos2, j, indiceFin);
                }
                caminos2 = pasarArreglo(verticesAux);

            }

        }

        // }
    }

    public ArrayList<Vertice> pasarArreglo(ArrayList<Vertice> viejo) {
        ArrayList<Vertice> nuevo = new ArrayList();
        for (int i = 0; i < viejo.size(); i++) {
            if (i > 0) {
                if (viejo.get(i).getNombre() != viejo.get(i - 1).getNombre()) {
                    nuevo.add(viejo.get(i));
                }
            } else {
                nuevo.add(viejo.get(i));
            }
        }
        return nuevo;
    }

    // carro = true, pie = false;
    public ArrayList<Recorrido> CalcularMenorRecorrido(int opcion, boolean medio) {
        System.out.println("OPCION ............." + opcion);
        for (int i = 0; i < caminosRecorridos.size(); i++) {
            String imprimir = "";
            for (int j = 0; j < caminosRecorridos.get(i).size(); j++) {
                imprimir = imprimir + caminosRecorridos.get(i).get(j).getNombre() + "->>>";
                // System.out.println(caminosRecorridos.get(i).size());
            }

            System.out.print(imprimir);
        }
        ArrayList<Recorrido> recorridosC = new ArrayList();
        double minimo = 0;
        Arista arista = new Arista();
        if (medio = true) {
            double suma = 0;
            if (opcion == 0) {
                suma = 0;
                for (int i = 0; i < caminosRecorridos.size(); i++) {
                    Recorrido recorrido = new Recorrido();
                    recorrido.setVertices(caminosRecorridos.get(i));
                    recorrido.setId(i + 1);
                    recorrido.setDestino(caminosRecorridos.get(i).get(0));
                    recorrido.setOrigen(caminosRecorridos.get(i).get(caminosRecorridos.get(i).size() - 1));
                    for (int j = 0; j < caminosRecorridos.get(i).size() - 1; j++) {
                        if (j < caminosRecorridos.size()) {
                            Vertice vertice = caminosRecorridos.get(i).get(j);
                            Vertice verticeSal = caminosRecorridos.get(i).get(j + 1);
                            //System.out.println("entrada " + vertice.getNombre() + "  salida: " + verticeSal.getNombre());
                            if (arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal) > -1) {
                                suma = suma + vertice.getAdyacentes().get(arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal)).getDato().getConsumoGas();
                                //System.out.println("SUMA = " + suma);
                            }
                        }
                    }
                    recorrido.setPeso(suma);
                    recorridosC.add(recorrido);
                }
            } else if (opcion == 1) {
                suma = 0;
                for (int i = 0; i < caminosRecorridos.size(); i++) {
                    Recorrido recorrido = new Recorrido();
                    recorrido.setVertices(caminosRecorridos.get(i));
                    recorrido.setId(i + 1);
                    recorrido.setDestino(caminosRecorridos.get(i).get(0));
                    recorrido.setOrigen(caminosRecorridos.get(i).get(caminosRecorridos.get(i).size() - 1));
                    for (int j = 0; j < caminosRecorridos.get(i).size() - 1; j++) {
                        Vertice vertice = caminosRecorridos.get(i).get(j);
                        Vertice verticeSal = caminosRecorridos.get(i).get(j + 1);
                        System.out.println("entrada " + vertice.getNombre() + "  salida: " + verticeSal.getNombre());
                        if (arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal) > -1) {
                            suma = suma + vertice.getAdyacentes().get(arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal)).getDato().getTiempoVehiculo();

                        }

                    }
                    recorrido.setPeso(suma);
                    recorridosC.add(recorrido);
                }
            } else {
                suma = 0;
                for (int i = 0; i < caminosRecorridos.size(); i++) {
                    Recorrido recorrido = new Recorrido();
                    recorrido.setVertices(caminosRecorridos.get(i));
                    recorrido.setId(i + 1);
                    recorrido.setDestino(caminosRecorridos.get(i).get(0));
                    recorrido.setOrigen(caminosRecorridos.get(i).get(caminosRecorridos.get(i).size() - 1));
                    for (int j = 0; j < caminosRecorridos.get(i).size() - 1; j++) {
                        Vertice vertice = caminosRecorridos.get(i).get(j);
                        Vertice verticeSal = caminosRecorridos.get(i).get(j + 1);
                        System.out.println("entrada " + vertice.getNombre() + "  salida: " + verticeSal.getNombre());
                        if (arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal) > -1) {
                            suma = suma + vertice.getAdyacentes().get(arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal)).getDato().getDistancia();
                        }

                    }
                    recorrido.setPeso(suma);
                    recorridosC.add(recorrido);
                }
            }
        } else {
            double suma = 0;
            if (opcion == 0) {
                for (int i = 0; i < caminosRecorridos.size(); i++) {

                    Recorrido recorrido = new Recorrido();
                    recorrido.setVertices(caminosRecorridos.get(i));
                    recorrido.setId(i + 1);
                    recorrido.setDestino(caminosRecorridos.get(i).get(0));
                    recorrido.setOrigen(caminosRecorridos.get(i).get(caminosRecorridos.get(i).size() - 1));
                    for (int j = 0; j < caminosRecorridos.get(i).size() - 1; j++) {
                        Vertice vertice = caminosRecorridos.get(i).get(j);
                        Vertice verticeSal = caminosRecorridos.get(i).get(j + 1);
                        //System.out.println("entrada " + vertice.getNombre() + "  salida: " + verticeSal.getNombre());
                        if (arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal) > -1) {
                            suma = suma + vertice.getAdyacentes().get(arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal)).getDato().getTiempoPie();

                        }
                    }
                    recorrido.setPeso(suma);
                    recorridosC.add(recorrido);

                }
            } else if (opcion == 1) {
                suma = 0;
                for (int i = 0; i < caminosRecorridos.size(); i++) {
                    Recorrido recorrido = new Recorrido();
                    recorrido.setVertices(caminosRecorridos.get(i));
                    recorrido.setId(i + 1);
                    recorrido.setDestino(caminosRecorridos.get(i).get(0));
                    recorrido.setOrigen(caminosRecorridos.get(i).get(caminosRecorridos.get(i).size() - 1));
                    for (int j = 0; j < caminosRecorridos.get(i).size() - 1; j++) {
                        Vertice vertice = caminosRecorridos.get(i).get(j);
                        Vertice verticeSal = caminosRecorridos.get(i).get(j + 1);
                        //System.out.println("entrada " + vertice.getNombre() + "  salida: " + verticeSal.getNombre());
                        if (arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal) > -1) {
                            suma = suma + vertice.getAdyacentes().get(arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal)).getDato().getDesgastePersona();
                        }
                    }
                    recorrido.setPeso(suma);
                    recorridosC.add(recorrido);
                }
            } else {
                suma = 0;
                for (int i = 0; i < caminosRecorridos.size(); i++) {
                    Recorrido recorrido = new Recorrido();
                    recorrido.setVertices(caminosRecorridos.get(i));
                    recorrido.setId(i + 1);
                    recorrido.setDestino(caminosRecorridos.get(i).get(0));
                    recorrido.setOrigen(caminosRecorridos.get(i).get(caminosRecorridos.get(i).size() - 1));
                    for (int j = 0; j < caminosRecorridos.get(i).size() - 1; j++) {
                        Vertice vertice = caminosRecorridos.get(i).get(j);
                        Vertice verticeSal = caminosRecorridos.get(i).get(j + 1);
                        //System.out.println("entrada " + vertice.getNombre() + "  salida: " + verticeSal.getNombre());
                        if (arista.ObtenerIndiceArista(vertice.getAdyacentes(), verticeSal) > -1) {
                            //Vertice vertice = caminosRecorridos.get(i).get(j);
                            suma = suma + vertice.getAdyacentes().get(CalcularIndice(vertices, caminosRecorridos.get(i).get(j + 1).getNombre())).getDato().getDistancia();

                        }

                    }
                    recorrido.setPeso(suma);
                    recorridosC.add(recorrido);
                }
            }
        }
        return recorridosC;
    }

    public ArrayList<Recorrido> ordenarRecorridos(ArrayList<Recorrido> recorridos) {
        Collections.sort(recorridos, new ComparatorByCodigo(false));
        recorridos.sort(Comparator.comparing(Recorrido::getPeso));
        return recorridos;
    }

    class ComparatorByCodigo implements Comparator<Recorrido> {

        private boolean asc;

        ComparatorByCodigo(boolean asc) {
            this.asc = asc;
        }

        @Override
        public int compare(Recorrido o1, Recorrido o2) {
            int ret;
            if (asc) {
                ret = String.valueOf(o1.getPeso()).compareTo(String.valueOf(o2.getPeso()));
            } else {
                ret = String.valueOf(o2.getPeso()).compareTo(String.valueOf(o1.getPeso()));
            }
            return ret;
        }
    }

    private int CalcularIndice(ArrayList<Vertice> vertices, String dato) {
        for (int i = 0; i < vertices.size(); i++) {
            if (dato.equals(vertices.get(i).getNombre())) {
                return i;
            } else {
                return -1;
            }
        }
        return -1;
    }

    public void InsertarVertices(ArrayList<Dato> datos, String transporte) {
        for (int i = 0; i < datos.size(); i++) {
            if (!ExisteVertice(datos.get(i).getOrigen())) {
                //System.out.println("insertando Vertice " + datos.get(i).getOrigen() + i);
                Vertice vertice = new Vertice();
                vertice.setId(i);
                vertice.setNombre(datos.get(i).getOrigen());
                vertices.add(vertice);
            }
        }
        for (int i = 0; i < datos.size(); i++) {
            if (!ExisteVertice(datos.get(i).getDestino())) {
                Vertice vertice = new Vertice();
                vertice.setId(i);
                vertice.setNombre(datos.get(i).getDestino());
                vertices.add(vertice);
            }
        }

        for (int i = 0; i < vertices.size(); i++) {
            //System.out.println(vertices.get(i).getNombre());
        }

        InsertarAristas(datos);

        CrearMatrizAdyacencia();
        if ("A Pie".equals(transporte)) {
            //System.out.println("grafo no dirigido ");
            CrearImagenGrafoNODirigido();
        } else {
            CrearImagenGrafoDirigidoPrincipal();
        }

    }

    public boolean InsertarAristas(ArrayList<Dato> datos) {
        boolean insertado = false;
        System.out.println("\n");
        for (int i = 0; i < datos.size(); i++) {
            int indiceOrigen = ObtenerIndiceVertice(datos.get(i).getOrigen());
            int indiceDestino = ObtenerIndiceVertice(datos.get(i).getDestino());
            //System.out.println(indiceOrigen + " " + datos.get(i).getOrigen() + " " + indiceDestino + "    " + datos.get(i).getDestino());
            if (indiceOrigen > -1 && indiceDestino > -1) {
                //System.out.println("insertando arista entre " + datos.get(i).getOrigen() + "     " + datos.get(i).getDestino());
                if (insertaArista(vertices.get(indiceOrigen), vertices.get(indiceDestino), datos.get(i))) {
                    insertado = true;
                } else {
                    insertado = false;
                }
            } else {
            }
        }
        return insertado;
    }

    public boolean insertaArista(Vertice v1, Vertice v2, Dato dato) {

        if (!ExisteArista(v1, v2)) {
            if (v1.getNombre() != v2.getNombre()) {
                Arista arista = new Arista(v1, v2);
                v1.InsertarCamino(arista);
                arista.setDato(dato);
                return true;
            } else {
                return false;
            }

        } else {
            //System.out.println("Ya existe una arista entre:" + v1 + " y " + v2);
            return false;
        }
    }

    public boolean ExisteArista(Vertice v1, Vertice v2) {
        if (v1.getAdyacentes() != null) {
            for (int i = 0; i < v1.getAdyacentes().size(); i++) {
                if (v1.getAdyacentes().get(i).getVer2() == v2) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        return false;
    }

    public boolean ExisteVertice(String nombre) {
        for (int i = 0; i < vertices.size(); i++) {
            if (vertices.get(i).nombre.equals(nombre)) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    public int ObtenerIndiceVertice(String nombre) {
        int oo = -1;
        //System.out.println("\n  " + vertices.size());
        for (int i = 0; i < vertices.size(); i++) {
            if (nombre.contains(vertices.get(i).getNombre())) {

                oo = i;
                break;
            } else {
                oo = -1;
            }
        }
        return oo;
    }

    boolean existeUnion(ArrayList<String> uniones, String union) {
        for (int i = 0; i < uniones.size(); i++) {
            if (uniones.get(i) == null ? union == null : uniones.get(i).equals(union)) {
                return true;
            }
        }
        return false;
    }

    public void CrearImagenGrafoDirigido() {
        ArrayList<String> uniones = new ArrayList();
        String flecha = " ->  ";
        String archivoDot = " digraph G \n  {  "
                + "node [shape=circle];\n"
                + " node [style=filled];\n"
                + " node [fillcolor=\"#EEEEEE\"];\n"
                + " node [color=\"#EEEEEE\"];\n"
                + " edge [color=\"#31CEF0\"];";
        String fin = "rankdir=LR;\n" + "}";
        String verticesS = "\n";
        for (int i = 0; i < vertices.size(); i++) {
            Vertice verticeA = vertices.get(i);
            for (int j = 0; j < verticeA.getAdyacentes().size(); j++) {
                if (verticeA.getAdyacentes() != null) {
                    Arista arista = verticeA.getAdyacentes().get(j);
                    verticeA.getAdyacentes().remove(j);
                    j = j - 1;
                    if (j > 0) {
                        if (arista.getVer1().getNombre() != arista.getVer2().getNombre()) {
                            String un = arista.getVer1().getNombre() + flecha + arista.getVer2().getNombre();
                            if (existeUnion(uniones, un)) {
                                verticesS = verticesS + un + " ;\n";
                                uniones.add(un);
                            }

                        } else {
                            System.out.println("quitando");
                        }
                    } else {
                        String un = arista.getVer1().getNombre() + flecha + arista.getVer2().getNombre();
                        if (existeUnion(uniones, un)) {
                            verticesS = verticesS + un + " ;\n";
                            uniones.add(un);
                        }
                    }

                }

            }
        }

        creador(archivoDot + verticesS + fin);

    }
    
     public void CrearImagenGrafoDirigidoPrincipalRECORRIDO(ArrayList<Recorrido> recorridos) {
        String flecha = " ->  ";
        String archivoDot = " digraph G \n  {  "
                + "node [shape=circle];\n"
                + " node [style=filled];\n"
                + " node [fillcolor=\"#EEEEEE\"];\n"
                + " node [color=\"#EEEEEE\"];\n"
                + " edge [color=\"#31CEF0\"];";
        String label= "labelloc=\"t\";\n" +
                "    label=\"MEJOR RUTA:"+ObtenerCaminos(recorridos)+"\";";
        String fin = "rankdir=LR;\n" + "}";
        String verticesS = "\n";
       for (int i = 0; i < recorridos.size(); i++) {
            verticesS += ObtenerCaminosVer(recorridos.get(i).getVertices());
        }

        creador(archivoDot + verticesS +label+ fin);

    }

    public void CrearImagenGrafoNODirigidoRECORRIDO(ArrayList<Recorrido> recorridos) {
        String flecha = " ->  ";
        String archivoDot = " digraph G \n  {  "
                + "edge[dir = none];\n graph[ordering = \"out\"];";
        String fin = "rankdir=LR;\n" + "}";
        String label= "labelloc=\"t\";\n" +
                "    label=\"MEJOR RUTA:"+ObtenerCaminos(recorridos)+"\";";
        String verticesS = "\n";
        for (int i = 0; i < recorridos.size(); i++) {
            verticesS += ObtenerCaminosVer(recorridos.get(i).getVertices());
        }

        creador(archivoDot + verticesS + label+fin);

    }
    public String ObtenerCaminosVer(ArrayList<Vertice> vertices) {
        String flecha = " ->  ";
        String caminos = "";
        for (int i = 0; i < vertices.size(); i++) {
            if (i == vertices.size() - 1) {
                caminos += vertices.get(i).getNombre().toLowerCase() + ";\n";
            } else {
                caminos += vertices.get(i).getNombre().toLowerCase() + flecha;
            }
        }
        return caminos;
    }
    public String ObtenerCaminos(ArrayList<Recorrido> recorridos) {
        String flecha = " -  ";
        String caminos = "";
        for (int j = 0; j < 1; j++) {
            for (int i = 0; i < recorridos.get(j).getVertices().size(); i++) {
            if (i == recorridos.get(j).getVertices().size() - 1) {
                caminos += recorridos.get(j).getVertices().get(i).getNombre().toLowerCase() + ";";
            } else {
                caminos +=  recorridos.get(j).getVertices().get(i).getNombre().toLowerCase() + flecha;
            }
        }
        }
        
        return caminos;
    }
    public void CrearImagenGrafoDirigidoPrincipal() {
        String flecha = " ->  ";
        String archivoDot = " digraph G \n  {  "
                + "node [shape=circle];\n"
                + " node [style=filled];\n"
                + " node [fillcolor=\"#EEEEEE\"];\n"
                + " node [color=\"#EEEEEE\"];\n"
                + " edge [color=\"#31CEF0\"];";
        
        String fin = "rankdir=LR;\n" + "}";
        String verticesS = "\n";
        for (int i = 0; i < vertices.size(); i++) {
            Vertice verticeA = vertices.get(i);
            for (int j = 0; j < verticeA.getAdyacentes().size(); j++) {
                if (verticeA.getAdyacentes() != null) {
                    Arista arista = verticeA.getAdyacentes().get(j);
                    verticesS = verticesS + arista.getVer1().getNombre() + flecha + arista.getVer2().getNombre() + " ;\n";
                }

            }
        }

        creador(archivoDot + verticesS + fin);

    }

    public void CrearImagenGrafoNODirigido() {
        String flecha = " ->  ";
        String archivoDot = " digraph G \n  {  "
                + "edge[dir = none];\n graph[ordering = \"out\"];";
        String fin = "rankdir=LR;\n" + "}";
        String verticesS = "\n";
        for (int i = 0; i < vertices.size(); i++) {
            Vertice verticeA = vertices.get(i);
            for (int j = 0; j < verticeA.getAdyacentes().size(); j++) {
                if (verticeA.getAdyacentes() != null) {
                    Arista arista = verticeA.getAdyacentes().get(j);
                    verticesS = verticesS + arista.getVer1().getNombre() + flecha + arista.getVer2().getNombre() + " ;\n";
                }

            }
        }

        creador(archivoDot + verticesS + fin);

    }

    public String direccionPng;

    public boolean creador(String texto) {
        try {
            File miDir = new File(".");
            String ruta = miDir.getCanonicalPath() + "/dibujo.dot";
            //System.out.println(miDir.getCanonicalPath());
            String contenido = texto;
            File file = new File(ruta);
            // Si el archivo no existe es creado
            if (!file.exists()) {
                file.createNewFile();
            } else {

            }
            FileWriter fw = new FileWriter(file);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write("");
            bw.write(contenido);
            bw.close();

            direccionPng = miDir.getCanonicalPath() + "/grafo.png";
            dibujar(ruta, direccionPng);
            //System.out.println("se ha dibujado la Ruta");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public static void dibujar(String direccionDot, String direccionPng) {
        try {
            ProcessBuilder pbuilder;

            pbuilder = new ProcessBuilder("dot", "-Tpng", "-o", direccionPng, direccionDot);
            pbuilder.redirectErrorStream(true);
            //Ejecuta el proceso
            pbuilder.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
