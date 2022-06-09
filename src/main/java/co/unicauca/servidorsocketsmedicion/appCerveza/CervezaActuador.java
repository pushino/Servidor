/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.servidorsocketsmedicion.appCerveza;

import com.mycompany.sistemaservidorclientecomun.Objeto;
import frameworkMedicion.external.Actuador;
import java.util.ArrayList;

/**
 *
 * @author juanc
 */
public class CervezaActuador extends Actuador{
    
    private ArrayList<Objeto> listaProductosAceptables= new ArrayList<>();
    private ArrayList<Objeto> listaProductosDefectuosos= new ArrayList<>();
   
    FabricaCerveza fc = new FabricaCerveza();

    public CervezaActuador() {
    }
            
    public void addlist(Objeto o){
        CervezaMedible cm = (CervezaMedible) fc.crearItem();
        if(cm.Status(new Cerveza(o.getReferencia(),o.getLargo(),o.getDiametro(),o.getPeso()))){
            listaProductosAceptables.add(o);
        }else{
            listaProductosDefectuosos.add(o);
        }
        
    }    

    public ArrayList<Objeto> getListaProductosAceptables() {
        return listaProductosAceptables;
    }

    public void setListaProductosAceptables(ArrayList<Objeto> listaProductosAceptables) {
        this.listaProductosAceptables = listaProductosAceptables;
    }

    public ArrayList<Objeto> getListaProductosDefectuosos() {
        return listaProductosDefectuosos;
    }

    public void setListaProductosDefectuosos(ArrayList<Objeto> listaProductosDefectuosos) {
        this.listaProductosDefectuosos = listaProductosDefectuosos;
    }

    @Override
    public boolean action(Objeto o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
   
    
}
