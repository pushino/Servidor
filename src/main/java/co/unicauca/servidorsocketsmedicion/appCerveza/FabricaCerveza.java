
package co.unicauca.servidorsocketsmedicion.appCerveza;

import frameworkMedicion.core.ItemFabrica;
import frameworkMedicion.core.ItemMedicion;

/**
 *
 * @author juanc
 */
public class FabricaCerveza extends ItemFabrica{
    private CervezaMedible item;
    
    public FabricaCerveza(){
            super();
            item = new CervezaMedible();
    }
    
    @Override
    public ItemMedicion crearItem() {
        return item;
    }
    
}
