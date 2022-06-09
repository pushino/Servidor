/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frameworkMedicion.core;

import co.unicauca.servidorsocketsmedicion.appCerveza.Cerveza;

/**
 *
 * @author juanc
 */
public abstract class ItemMedicion {
     
    public abstract boolean Status(Cerveza c);
    
    public abstract double volumen(Cerveza c);
}
