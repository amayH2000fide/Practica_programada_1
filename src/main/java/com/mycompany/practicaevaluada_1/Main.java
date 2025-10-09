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
        Planeta[] planetas = new Planeta[10];
        int tipo;
        int cantidadPlanetas = 2;
        int currentOption;
        boolean createMenu = false;
        
        //planetas default para las listas
        PlanetaRocoso tierra = new PlanetaRocoso( "Earth", 5.972e24, 29780, true, 1, 6371000,OrbitType.circular,149600000,1,12742,true);
        PlanetaGaseoso jupiter = new PlanetaGaseoso("Jupiter",1.898e27,13070,true,0.41, 69911000, OrbitType.circular, 778500000, 95, 
                139820, true, "Hydrogen, Helium");
        planetas[0] = tierra;
        planetas[1] = jupiter;
        
        //menu de creacion de planetas
        while(!createMenu){
            
            if (cantidadPlanetas >= planetas.length) {
                JOptionPane.showMessageDialog(null, "Se alcanzó la cantidad máxima de planetas.");
                createMenu = true;
            }
            
            currentOption = Start();
            
            tipo = currentOption;   
            
            if(tipo == -1) return; 
            
            planetas [cantidadPlanetas - 1] = CreacionMenu(tipo);
            
            cantidadPlanetas++;
            
            currentOption = JOptionPane.showConfirmDialog( null,"¿Desea crear otro planeta?","Confirmación", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (currentOption == JOptionPane.YES_OPTION) {
                JOptionPane.showMessageDialog(null, "Creando otro planeta...");
            } else {
                JOptionPane.showMessageDialog(null, "Proceso finalizado.");
                createMenu = true;
            }
        }
        
        MainMenu(planetas);
    }
    
    
    public static int Start() {
        int result = 0;
        boolean valid = false;
        while (!valid) {
            try {
                String input = JOptionPane.showInputDialog(
                    "¿Qué tipo de planeta deseas crear?\n1 = Rocoso\n2 = Gaseoso");
                
                if (input == null) return -1;

                result = Integer.parseInt(input);

                if (result == 1 || result == 2) {
                    valid = true;
                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese 1 o 2 únicamente.");
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor numérico válido.");
            }
        }   
        
        return result;
    }
    
    public static Planeta CreacionMenu (int typo){
        
        String nombre;
        double masa = 0;
        double velOrb = 0;
        double radio = 0;
        double distSol = 0;
        int lunas = 0;
        double size = 0;
        double rotacion = 0;
        boolean corteza = false;
        boolean anillos = false;
        String compAtmo = "";
        boolean isValid = false;
        
        if(typo == 1){
            nombre = JOptionPane.showInputDialog("Nombre del planeta rocoso:");
        } else {
            nombre = JOptionPane.showInputDialog("Nombre del planeta gaseoso:");
        }
        
        while(!isValid){
            try {
                String input;
                input = JOptionPane.showInputDialog("Masa (kg):");
                if (input == null) return null;
                masa = Double.parseDouble(input);

                input = JOptionPane.showInputDialog("Velocidad orbital (m/s):");
                if (input == null) return null;
                velOrb = Double.parseDouble(input);

                input = JOptionPane.showInputDialog("Radio del planeta (m):");
                if (input == null) return null;
                radio = Double.parseDouble(input);

                input = JOptionPane.showInputDialog("Distancia al Sol (km):");
                if (input == null) return null;
                distSol = Double.parseDouble(input);

                input = JOptionPane.showInputDialog("Número de lunas:");
                if (input == null) return null;
                lunas = Integer.parseInt(input);

                input = JOptionPane.showInputDialog("Tamaño (diámetro km):");
                if (input == null) return null;
                size = Double.parseDouble(input);

                input = JOptionPane.showInputDialog("¿Cuántas veces rota el planeta en 24 horas?");
                if (input == null) return null;
                rotacion = Double.parseDouble(input);

                isValid = true;
                
            } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor numérico");
            }
        }
        
        isValid = false;
        
        while (!isValid) {
            try {
                if (typo == 1) {
                    String input = JOptionPane.showInputDialog("¿Tiene corteza sólida? (true/false)");
                    if (input == null) return null;
                    if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                        corteza = Boolean.parseBoolean(input);
                        isValid = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor correcto (true/false).");
                    }
                } else { // Gaseoso
                    String input = JOptionPane.showInputDialog("¿Tiene anillos? (true/false)");
                    if (input == null) return null;
                    if (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false")) {
                        anillos = Boolean.parseBoolean(input);
                    } else {
                        JOptionPane.showMessageDialog(null, "Ingrese un valor correcto (true/false).");
                        continue;
                    }

                    input = JOptionPane.showInputDialog("Composición atmosférica:");
                    if (input == null) return null;
                    compAtmo = input;

                    isValid = true;
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrió un error. Intente de nuevo.");
            }
        }
       
        if(typo == 1){
            PlanetaRocoso roca = new PlanetaRocoso(nombre, masa, velOrb, true, rotacion,
            radio, OrbitType.circular, distSol, lunas, size, corteza);
            return roca;
        } else {
            PlanetaGaseoso gas = new PlanetaGaseoso(nombre, masa, velOrb, true, rotacion,
            radio, OrbitType.elliptical, distSol, lunas, size, anillos, compAtmo);
            return gas;
        }
    }
  
    public static void MainMenu(Planeta[] planetas) {
    boolean stop = false;
    int opcion = 0;
    String selection;

        while (!stop) {
            try {
                selection = JOptionPane.showInputDialog(null,
                        "Selecciona una opción:\n"
                        + "1 = Ver planetas rocosos\n"
                        + "2 = Ver planetas gaseosos\n"
                        + "3 = Comparar tamaño (mayor a menor)\n"
                        + "4 = Comparar distancia al Sol (mayor a menor)\n"
                        + "5 = Salir del menú"
                );

                if (selection == null) {
                    stop = true;
                    continue;
                }

                opcion = Integer.parseInt(selection);

                switch (opcion) {
                    case 1:
                        for (Planeta p : planetas) {
                            if (p instanceof PlanetaRocoso) {
                                JOptionPane.showMessageDialog(null, p.toString(), "Planeta Rocoso", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        break;
                    case 2:
                        for (Planeta p : planetas) {
                            if (p instanceof PlanetaGaseoso) {
                                JOptionPane.showMessageDialog(null, p.toString(), "Planeta Gaseoso", JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                        break;
                    case 3: // Comparar tamaño
                        for (int i = 0; i < planetas.length - 1; i++) {
                            for (int j = 0; j < planetas.length - i - 1; j++) {
                                if (planetas[j] == null || planetas[j + 1] == null) continue;
                                if (planetas[j].getSize() < planetas[j + 1].getSize()) {
                                    Planeta temp = planetas[j];
                                    planetas[j] = planetas[j + 1];
                                    planetas[j + 1] = temp;
                                }
                            }
                        }
                        String msgSize = "";
                        for (Planeta p : planetas) {
                            if (p != null) msgSize += p.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, msgSize, "Planetas por tamaño", JOptionPane.INFORMATION_MESSAGE);
                        break;

                    case 4: // Comparar distancia al Sol
                        for (int i = 0; i < planetas.length - 1; i++) {
                            for (int j = 0; j < planetas.length - i - 1; j++) {
                                if (planetas[j] == null || planetas[j + 1] == null) continue;
                                if (planetas[j].getDistancetoSun() < planetas[j + 1].getDistancetoSun()) {
                                    Planeta temp = planetas[j];
                                    planetas[j] = planetas[j + 1];
                                    planetas[j + 1] = temp;
                                }
                            }
                        }
                        String msgDist = "";
                        for (Planeta p : planetas) {
                            if (p != null) msgDist += p.toString() + "\n";
                        }
                        JOptionPane.showMessageDialog(null, msgDist, "Planetas por distancia al Sol", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case 5:
                        stop = true;
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Opción inválida", "Error", JOptionPane.ERROR_MESSAGE);
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Ingrese un valor correcto!!");
            }
        }
    }
}
