/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.servidorsocketsmedicion.appCerveza;

import frameworkMedicion.core.ItemMedicion;
import static java.lang.Math.pow;

/**
 *
 * @author juanc
 */
public class CervezaMedible extends ItemMedicion{

    public CervezaMedible() {
    }
    
    @Override
    public boolean Status(Cerveza c){
        double v= volumen(c);
        if(v >= 500 && v <= 600){
            return true;
        }else{
            return false;
        }
    }
    
    @Override
    public double volumen(Cerveza c){
        double v;
        double r = ((c.getDiametro())/2);
        v = (pow(r,2)*(c.getLargo())*(3.14));
        return v;
    }

   
}
