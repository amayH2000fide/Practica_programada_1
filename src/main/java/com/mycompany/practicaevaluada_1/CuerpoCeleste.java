package com.mycompany.practicaevaluada_1;

public abstract class CuerpoCeleste {
    
    //constantes
    public static final double solarMass = 1.989e30;
    public static final double earthMass = 5.972e24;
    public static final double jupiterMass = 1.898e27;
    public static final double G = 6.67430e-11; //constante gravitacional 
    
    
    //variables
    private String name; 
    private double mass;  //kg
    private double orbitalvelocity; // m/s 
    private boolean boundOrbit; //si orbita un objeto o esta libre
    private double rotationPerDay; //rotacines comparadas a un dia de la tierra.
    private double objectRadius; //radio del objeto.
    private OrbitType orbit; 

    public CuerpoCeleste() {
        
    }

    public CuerpoCeleste(String name, double mass, double orbitalvelocity, boolean boundOrbit, double rotationPerDay,
            double objectRadius, OrbitType orbit) {
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
    //Calculo de masa de la tierra
    public double CalculateEarthMass(){
        double result = 0; 
        result = mass / earthMass;
        return result;
    }
    //calculo de la masa solar
    public double CalculateSolarMass(){
        double result = 0;
        result = mass / solarMass;
        return result; 
    }
    //Calculo de la masa de jupiter
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
    public OrbitType getOrbit() {
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

    public void setOrbit(OrbitType orbit) {
        this.orbit = orbit;
    }
    
    //To string para mostrar la información 
    @Override
    public String toString() {
        return  "=== Información del Planeta ==="
                + "\nNombre: " + getName()
                + "\nMasa: " + getMass() + " kg"
                + "\nVelocidad orbital: " + getOrbitalvelocity() + " m/s"
                + "\nÓrbita ligada: " + (isBoundOrbit() ? "Sí" : "No")
                + "\nRotación por día: " + getRotationPerDay() + " /24h"
                + "\nRadio del objeto: " + getObjectRadius() + " m"
                + "\nTipo de órbita: " + getOrbit();
    }
    
    
}