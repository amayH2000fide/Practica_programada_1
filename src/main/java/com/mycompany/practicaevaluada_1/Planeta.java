/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practicaevaluada_1;

/**
 *
 * @author zid
 */
public class Planeta extends CuerpoCeleste implements IPlaneta {
    //Distacia al sol
    private double distanceToSun;
    //Número de lunas
    private int numberOfMoons;
    //Tamaño en diámetro
    private double size;

    public Planeta(String name, double mass, double orbitalvelocity, boolean boundOrbit,
            double rotationPerDay, double objectRadius, OrbitType orbit,
            double distanceToSun, int numberOfMoons, double size) {

        super(name, mass, orbitalvelocity, boundOrbit, rotationPerDay, objectRadius, orbit);
        this.distanceToSun = distanceToSun;
        this.numberOfMoons = numberOfMoons;
        this.size = size;
    }

    public Planeta() {
    }

    @Override
    public double getSize() {
        return size;
    }

    @Override
    public double getDistancetoSun() {
        return distanceToSun;
    }

    @Override
    public int getNumberofMoons() {
        return numberOfMoons;
    }
    //Uso de contrado para el cálculo de tiempo en distancia al sol
    @Override
    public double timeToSunCalculus() {
        double distanciaMetros = this.distanceToSun * 1000; // de (km) a (m)
        double T = (2 * Math.PI * distanciaMetros) / super.getOrbitalvelocity();
        return T / (60 * 60 * 24); // se convierte de segundos a días terrestres
    }
    //toString con super para mostrar la información
    @Override
    public String toString() {
        return super.toString() + "\nDistancia al Sol: " + this.distanceToSun + " km"
                + "\nNúmero de lunas: " + this.numberOfMoons
                + "\nTamaño (diámetro): " + this.size + " km"
                + "\nAño planetario (días terrestres): " + timeToSunCalculus();
    }
}
