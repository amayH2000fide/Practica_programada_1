/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.practicaevaluada_1;

/**
 *
 * @author zid
 */
public class PlanetaRocoso extends Planeta {

    private boolean tieneCortezaSolida; // Primera característica para el planeta rocoso 
    private String tipo = "Rocoso";

    public PlanetaRocoso(String nombre, double masa, double velocidadOrbital,
            double radio, double distanciaAlSol, int numeroDeLunas,
            double tamanio, boolean tieneCortezaSolida) {

        super(nombre, masa, velocidadOrbital, true, 0, radio, null,
                distanciaAlSol, numeroDeLunas, tamanio);
        this.tieneCortezaSolida = tieneCortezaSolida;
    }

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Planeta: " + tipo
                + "\nPosee corteza sólida: " + (tieneCortezaSolida ? "Sí" : "No");
    }
}
