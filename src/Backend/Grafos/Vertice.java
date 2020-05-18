
package Backend.Grafos;

import java.util.ArrayList;

/**
 *
 * @author astridmc
 */
public class Vertice {
    private ArrayList<Arista> adyacentes;
    private ArrayList<String> nombreDestinos;
    public String nombre;
    public int id;

    public Vertice() {
        adyacentes = new ArrayList();
        nombreDestinos = new ArrayList();
    }
    
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ArrayList<Arista> getAdyacentes() {
        return adyacentes;
    }

    public void setAdyacentes(ArrayList<Arista> adyacentes) {
        this.adyacentes = adyacentes;
    }

    
    public void InsertarCamino(Arista arista){
       
        if(!Contiene(adyacentes, arista)){
            System.out.println("insertoArrista...........");
            this.adyacentes.add(arista);
        }
    }
    
    public boolean Contiene(ArrayList<Arista> adyacentes, Arista arista){
        if(adyacentes!=null){
            for (int i = 0; i < adyacentes.size(); i++) {
            if(this.adyacentes.get(i)== arista){
                return true;
            }else{
                return false;
            }
        }
        }
        
        return false;
    }
}
