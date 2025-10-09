package com.mycompany.practicaevaluada_1;

public class CuerpoCeleste {
    
    //constantes
    public static final double solarMass = 1.989e30;
    public static final double earthMass = 5.972e24;
    public static final double jupiterMass = 1.898e27;
    public static final double G = 6.67430e-11; //constante gravitacional 
    
    //tipos de orbita
    public enum orbitType {
        elliptical, 
        circular,
        hyperbolic,
        parabolic
    }
    
    //variables
    private String name; 
    private double mass;  //kg
    private double orbitalvelocity; // m/s 
    private boolean boundOrbit; //si orbita un objeto o esta libre
    private double rotationPerDay;
    private double objectRadius; //radio del objeto.
    private orbitType orbit; 

    public CuerpoCeleste() {
        
    }

    public CuerpoCeleste(String name, double mass, double orbitalvelocity, boolean boundOrbit, double rotationPerDay, double objectRadius, orbitType orbit) {
        this.name = name;
        this.mass = mass;
        this.orbitalvelocity = orbitalvelocity;
        this.boundOrbit = boundOrbit;
        this.rotationPerDay = rotationPerDay;
        this.objectRadius = objectRadius;
        this.orbit = orbit;
    }
    
    //g como acceleracion gravitacional
    public double CalculateG(){
        double g = 0;
        g = (G * mass)/Math.pow(objectRadius, 2);
        return g;
    };
    
    public double CalculateEarthMass(){
        double result = 0; 
        result = mass / earthMass;
        return result;
    }
    
    public double CalculateSolarMass(){
        double result = 0;
        result = mass / solarMass;
        return result; 
    }
    
    public double CalculateJupiterMass(){
        double result = 0;
        result = mass / jupiterMass;
        return result;
    }
    
    //getters
    public String getName() {
        return name;
    }

    public double getMass() {
        return mass;
    }

    public double getOrbitalvelocity() {
        return orbitalvelocity;
    }

    public boolean isBoundOrbit() {
        return boundOrbit;
    }

    public double getRotationPerDay() {
        return rotationPerDay;
    }

    public double getObjectRadius() {
        return objectRadius;
    }

    public orbitType getOrbit() {
        return orbit;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public void setOrbitalvelocity(double orbitalvelocity) {
        this.orbitalvelocity = orbitalvelocity;
    }

    public void setBoundOrbit(boolean boundOrbit) {
        this.boundOrbit = boundOrbit;
    }

    public void setRotationPerDay(double rotationPerDay) {
        this.rotationPerDay = rotationPerDay;
    }

    public void setObjectRadius(double objectRadius) {
        this.objectRadius = objectRadius;
    }

    public void setOrbit(orbitType orbit) {
        this.orbit = orbit;
    }

    @Override
    public String toString() {
        return  "=== Información del Planeta ==="
                + "\nNombre: " + getName()
                + "\nMasa: " + getMass() + " kg"
                + "\nVelocidad orbital: " + getOrbitalvelocity() + " m/s"
                + "\nÓrbita ligada: " + (isBoundOrbit() ? "Sí" : "No")
                + "\nRotación por día: " + getRotationPerDay() + " h"
                + "\nRadio del objeto: " + getObjectRadius() + " m"
                + "\nTipo de órbita: " + getOrbit();
    }
    
    
}