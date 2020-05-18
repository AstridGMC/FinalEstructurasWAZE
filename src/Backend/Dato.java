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

public class Dato {
    int id;
    String origen;
    String destino;
    double tiempoVehiculo;
    double tiempoPie;
    double desgastePersona;
    double consumoGas;
    double distancia;    
    boolean dobleVia;

    public Dato() {
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public boolean isDobleVia() {
        return dobleVia;
    }

    public void setDobleVia(boolean dobleVia) {
        this.dobleVia = dobleVia;
    }

    public double getTiempoVehiculo() {
        return tiempoVehiculo;
    }

    public void setTiempoVehiculo(double tiempoVehiculo) {
        this.tiempoVehiculo = tiempoVehiculo;
    }

    public double getTiempoPie() {
        return tiempoPie;
    }

    public void setTiempoPie(double tiempoPie) {
        this.tiempoPie = tiempoPie;
    }

    public double getDesgastePersona() {
        return desgastePersona;
    }

    public void setDesgastePersona(double desgastePersona) {
        this.desgastePersona = desgastePersona;
    }

    public double getConsumoGas() {
        return consumoGas;
    }

    public void setConsumoGas(double consumoGas) {
        this.consumoGas = consumoGas;
    }
    
    
    
}
