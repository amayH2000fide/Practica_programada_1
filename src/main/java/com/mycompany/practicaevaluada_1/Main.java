/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.practicaevaluada_1;

import javax.swing.JOptionPane;

/**
 *
 * @author zid
 */
public class Main {

    public static void main(String[] args) {
        Planeta[] planetas = new Planeta[2];

        // Preguntar tipo de planeta
        int tipo;
        double masa = 0;
        double velOrb = 0;
        double radio = 0;
        double distSol = 0;
        int lunas = 0;
        double size = 0;
        boolean corteza;
        boolean anillos;
        int opcion;
        while (true) {
            try {
                tipo = Integer.parseInt(JOptionPane.showInputDialog(
                        "¿Qué tipo de planeta deseas crear?\n1 = Rocoso\n2 = Gaseoso"));

                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico");
            }
        }
        //Asignación de valores al planeta rocoso
        if (tipo == 1) { // Rocoso
            String nombre = JOptionPane.showInputDialog("Nombre del planeta rocosa:");
            while (true) {
                //Manejo de excepciones
                try {
                    masa = Double.parseDouble(JOptionPane.showInputDialog("Masa (kg):"));
                    velOrb = Double.parseDouble(JOptionPane.showInputDialog("Velocidad orbital (m/s):"));
                    radio = Double.parseDouble(JOptionPane.showInputDialog("Radio del planeta (m):"));
                    distSol = Double.parseDouble(JOptionPane.showInputDialog("Distancia al Sol (km):"));
                    lunas = Integer.parseInt(JOptionPane.showInputDialog("Número de lunas:"));
                    size = Double.parseDouble(JOptionPane.showInputDialog("Tamaño (diámetro km):"));
                    break;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Ingrese un valor numérico");
                }
            }
            while (true) {
                try {
                    String strCorteza = "";
                    strCorteza = JOptionPane.showInputDialog("¿Tiene corteza sólida? (true/false)");
                    if (strCorteza.equals("true") || strCorteza.equals("false")) {
                        corteza = Boolean.parseBoolean(strCorteza);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor correcto(true/false)");
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print(e);
                }
            }

            // Crear planeta rocoso
            PlanetaRocoso roca = new PlanetaRocoso(nombre, masa, velOrb, true, 24,
                    radio, OrbitType.circular, distSol, lunas, size, corteza);
            planetas[0] = roca;

            // Crear planeta gaseoso de ejemplo
            PlanetaGaseoso gas = new PlanetaGaseoso("Júpiter", 1.898e27, 13070, true, 10,
                    69911000, OrbitType.elliptical, 778_500_000, 79, 139820, true, "Hidrógeno y Helio");
            planetas[1] = gas;

            //Ingreso de valores de planeta gaseosos
        } else { // Gaseoso
            String nombre = JOptionPane.showInputDialog("Nombre del planeta gaseoso:");
            //Manejo de excepciones
            while (true) {
                try {
                    masa = Double.parseDouble(JOptionPane.showInputDialog("Masa (kg):"));
                    velOrb = Double.parseDouble(JOptionPane.showInputDialog("Velocidad orbital (m/s):"));
                    radio = Double.parseDouble(JOptionPane.showInputDialog("Radio del planeta (m):"));
                    distSol = Double.parseDouble(JOptionPane.showInputDialog("Distancia al Sol (km):"));
                    lunas = Integer.parseInt(JOptionPane.showInputDialog("Número de lunas:"));
                    size = Double.parseDouble(JOptionPane.showInputDialog("Tamaño (diámetro km):"));
                    break;
                } catch (ArithmeticException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese valorse numericos!");
                }
            }

            while (true) {
                try {
                    String strAnillos = "";
                    strAnillos = JOptionPane.showInputDialog("¿Tiene corteza sólida? (true/false)");
                    if (strAnillos.equals("true") || strAnillos.equals("false")) {
                        anillos = Boolean.parseBoolean(strAnillos);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor correcto(true/false)");
                        throw new Exception();
                    }
                    break;
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
            String compAtmo = JOptionPane.showInputDialog("Composición atmosférica:");
            // Crear planeta gaseoso
            PlanetaGaseoso gas = new PlanetaGaseoso(nombre, masa, velOrb, true, 10,
                    radio, OrbitType.elliptical, distSol, lunas, size, anillos, compAtmo);
            planetas[0] = gas;

            // Crear planeta rocoso de ejemplo
            PlanetaRocoso roca = new PlanetaRocoso("Tierra", 5.972e24, 29783, true, 24,
                    6371000, OrbitType.circular, 149_600_000, 1, 12742, true);
            planetas[1] = roca;
        }

        //Manejo de expeciones
        while (true) {
            try {
                //Menú para las agrupaciones
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "Selecciona una opción:\n"
                        + "1 = Ver planetas rocosos\n"
                        + "2 = Ver planetas gaseosos\n"
                        + "3 = Comparar tamaño (mayor a menor)\n"
                        + "4 = Comparar distancia al Sol (mayor a menor)"
                ));
                break;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor correcto!!");

            }
        }
        switch (opcion) {
            case 1: // Rocosos
                for (Planeta p : planetas) {
                    if (p instanceof PlanetaRocoso) {
                        JOptionPane.showMessageDialog(null, p.toString(), "Planeta Rocoso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;

            case 2: // Gaseosos
                for (Planeta p : planetas) {
                    if (p instanceof PlanetaGaseoso) {
                        JOptionPane.showMessageDialog(null, p.toString(), "Planeta Gaseoso", JOptionPane.INFORMATION_MESSAGE);
                    }
                }
                break;

            case 3: // Comparar tamaño
                // Bubble sort por tamaño
                for (int i = 0; i < planetas.length - 1; i++) {
                    for (int j = 0; j < planetas.length - i - 1; j++) {
                        if (planetas[j].getSize() < planetas[j + 1].getSize()) {
                            Planeta temp = planetas[j];
                            planetas[j] = planetas[j + 1];
                            planetas[j + 1] = temp;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Se muestran las comparación de mayor a menor!!");
                for (Planeta p : planetas) {
                    JOptionPane.showMessageDialog(null, p);
                }
                break;

            case 4: // Comparar distancia al Sol
                // Bubble sort por distancia
                for (int i = 0; i < planetas.length - 1; i++) {
                    for (int j = 0; j < planetas.length - i - 1; j++) {
                        if (planetas[j].getDistancetoSun() < planetas[j + 1].getDistancetoSun()) {
                            Planeta temp = planetas[j];
                            planetas[j] = planetas[j + 1];
                            planetas[j + 1] = temp;
                        }
                    }
                }
                JOptionPane.showMessageDialog(null, "Se muestran las comparación de mayor a menor!!");
                for (Planeta p : planetas) {
                    JOptionPane.showMessageDialog(null, p);
                }
                break;

            default:
                JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
