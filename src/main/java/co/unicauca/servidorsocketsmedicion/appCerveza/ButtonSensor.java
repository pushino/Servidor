package co.unicauca.servidorsocketsmedicion.appCerveza;

import com.mycompany.sistemaservidorclientecomun.Objeto;
import frameworkMedicion.core.Disparador;

/**
 *
 * @author juanc
 */
public class ButtonSensor extends frameworkMedicion.external.SensorActivo{
    
    CervezaActuador ca;
    boolean estado = false;
    
    public ButtonSensor() {
        ca = new CervezaActuador();
    } 
    
    public Objeto creaobj(){
        
        Objeto o = new Objeto();
        o.setListaProductosAceptables(ca.getListaProductosAceptables());
        o.setListaProductosDefectuosos( ca.getListaProductosDefectuosos());
        return o;
    }
    
    public ButtonSensor(Disparador d) {
        super(d);
    }
    
    public ButtonSensor(boolean e) {
        this.estado=e;
        ca = new CervezaActuador();
    }
    
    public void run(Objeto c){
        ca.addlist(c);
    }

    @Override
    public Object doMeasure() {
        return this.getDisparador();
    }
}
