/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.practicaevaluada_1;

/**
 *
 * @author zid
 */
public interface IPlaneta {
    //Nombre del planeta
    public abstract String getName();
    //Tamaño del planeta
    public abstract double getSize();
    //Distancia al sol
    public abstract double getDistancetoSun();
    //numero de lunas
    public abstract int getNumberofMoons();
    //Calculo de tiempo al sol en días terrestres
    public abstract double timeToSunCalculus();
}
