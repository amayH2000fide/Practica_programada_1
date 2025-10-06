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

    private double distanceToSun;
    private int numberOfMoons;
    private double size;

    public Planeta(String name, double mass, double orbitalvelocity, boolean boundOrbit,
            double rotationPerDay, double objectRadius, orbitType orbit,
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

    @Override
    public double timeToSunCalculus() {
        double T = (2 * Math.PI * this.distanceToSun) / super.getOrbitalvelocity();
        return T;
    }

    @Override
    public String toString() {
        return super.toString()+ "\nDistancia al Sol: " + this.distanceToSun + " km"
                + "\nNúmero de lunas: " + this.numberOfMoons
                + "\nTamaño (diámetro): " + this.size + " km"
                + "\nAño planetario (días terrestres): " + timeToSunCalculus();
    }

}
