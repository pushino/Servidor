/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package frameworkMedicion.external;

import frameworkMedicion.core.Disparador;

/**
 *
 * @author juanc
 */
public abstract class SensorActivo extends Sensor{
    private Disparador disparador;
    
    public SensorActivo(Disparador disparador) {
        this.disparador = disparador;
    }
    
    public void notifyDisparador(){
      
    }
    
    public Disparador getDisparador(){
        return disparador;
    }
}
