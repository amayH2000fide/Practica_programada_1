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

    private boolean hasSolidCrust; // Primera característica para el planeta rocoso 
    private String tipo = "Rocoso";


    public PlanetaRocoso(String name, double mass, double orbitalvelocity, 
            boolean boundOrbit, double rotationPerDay, double objectRadius, OrbitType orbit, 
            double distanceToSun, int numberOfMoons, double size,boolean hasSolidCrust) {
        super(name, mass, orbitalvelocity, boundOrbit, rotationPerDay, 
                objectRadius, orbit, distanceToSun, numberOfMoons, size);
        this.hasSolidCrust = hasSolidCrust;
    }
    

    @Override
    public String toString() {
        return super.toString() + "\nTipo de Planeta: " + tipo
                + "\nPosee corteza sólida: " + (hasSolidCrust ? "Sí" : "No");
    }
}
