package com.mycompany.practicaevaluada_1;

/**
 *
 * @author zid
 */
public class PlanetaGaseoso extends Planeta {

    private boolean hasRings;
    private String atmosphericComposition;

    public PlanetaGaseoso() {
        super();
    }

    public PlanetaGaseoso(String name, double mass, double orbitalvelocity, boolean boundOrbit,
            double rotationPerDay, double objectRadius, OrbitType orbit,
            double distanceToSun, int numberOfMoons, double size,
            boolean hasRings, String atmosphericComposition) {

        super(name, mass, orbitalvelocity, boundOrbit, rotationPerDay, objectRadius, orbit,
                distanceToSun, numberOfMoons, size);
        this.hasRings = hasRings;
        this.atmosphericComposition = atmosphericComposition;
    }

    public boolean ishasRings() {
        return hasRings;
    }

    public void setTieneAnillos(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public String getatmosphericComposition() {
        return atmosphericComposition;
    }

    public void setatmosphericComposition(String atmosphericComposition) {
        this.atmosphericComposition = atmosphericComposition;
    }

    //Calculo distinto para los planetas gaseosos
    @Override
    public double timeToSunCalculus() {
        double T = (2 * Math.PI * getDistancetoSun()) / getOrbitalvelocity();
        return T * 1.1; // se ajusta un poco para representar su órbita más lenta
    }

    //To string con super para mostrar la información
    @Override
    public String toString() {
        return super.toString()
                + "\nTiene anillos: " + (hasRings ? "Sí" : "No")
                + "\nComposición atmosférica: " + atmosphericComposition;
    }
}
