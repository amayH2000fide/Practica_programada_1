package com.mycompany.practicaevaluada_1;

/**
 *
 * @author zid
 */
public class PlanetaGaseoso extends Planeta {

    private boolean tieneAnillos;
    private String composicionAtmosferica;

    public PlanetaGaseoso() {
        super();
    }

    public PlanetaGaseoso(String name, double mass, double orbitalvelocity, boolean boundOrbit,
            double rotationPerDay, double objectRadius, orbitType orbit,
            double distanceToSun, int numberOfMoons, double size,
            boolean tieneAnillos, String composicionAtmosferica) {

        super(name, mass, orbitalvelocity, boundOrbit, rotationPerDay, objectRadius, orbit,
                distanceToSun, numberOfMoons, size);
        this.tieneAnillos = tieneAnillos;
        this.composicionAtmosferica = composicionAtmosferica;
    }

    public boolean isTieneAnillos() {
        return tieneAnillos;
    }

    public void setTieneAnillos(boolean tieneAnillos) {
        this.tieneAnillos = tieneAnillos;
    }

    public String getComposicionAtmosferica() {
        return composicionAtmosferica;
    }

    public void setComposicionAtmosferica(String composicionAtmosferica) {
        this.composicionAtmosferica = composicionAtmosferica;
    }

     @Override


    public double timeToSunCalculus() {
        double T = (2 * Math.PI * getDistancetoSun()) / getOrbitalvelocity();
        return T * 1.1; // se ajusta un poco para representar su órbita más lenta
    }

    @Override
    public String toString() {
        return "\n=== Planeta Gaseoso ==="
                + super.toString()
                + "\nTiene anillos: " + (tieneAnillos ? "Sí" : "No")
                + "\nComposición atmosférica: " + composicionAtmosferica;
    }
}
