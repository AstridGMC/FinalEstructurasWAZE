/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

public class Nodo {

    int numClaves = 5;
    int numHijos = numClaves + 1;
    int minimoHijos;
    public boolean tengoHijos = false;
    public Recorrido claves[];
    public Nodo hijos[];
    public Nodo padre;
    
    public Nodo(){
        CalcularMinClaves();
        claves = new Recorrido[numClaves];
        hijos = new Nodo[numHijos];
    }

public void CalcularMinClaves() {
    if (numClaves % 2 != 0) {
        minimoHijos = numClaves/2 +1;
    } else {
        minimoHijos = numClaves/2;
    }
}

    public int ObtenerHijosOcupadas(Nodo[] nodos){
        int j=0;
        for (int i = 0; i < nodos.length; i++) {
            if(nodos[i]!=null);
            j++;
        }
        return j;
    }
    
        public int ObtenerValoresOcupadas(Recorrido[] recorridos){
        int j=0;
        for (int i = 0; i < recorridos.length; i++) {
            if(recorridos[i]!=null);
            j++;
        }
        return j;
    }

}
