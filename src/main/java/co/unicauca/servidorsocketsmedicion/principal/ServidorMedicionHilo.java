/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.unicauca.servidorsocketsmedicion.principal;
import co.unicauca.servidorsocketsmedicion.appCerveza.ButtonSensor;
import co.unicauca.servidorsocketsmedicion.appCerveza.Cerveza;
import co.unicauca.servidorsocketsmedicion.appCerveza.CervezaMedible;
import com.mycompany.sistemaservidorclientecomun.Objeto;
import com.google.gson.Gson;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author juanc
 */
public class ServidorMedicionHilo extends Thread{
    private DataInputStream in;
    private DataOutputStream out;

    public ServidorMedicionHilo(DataInputStream in, DataOutputStream out) {
        this.in = in;
        this.out = out;
    }
    
    
    @Override
    public void run(){
               
        
        try {
            
            ArrayList<Objeto> productosAceptados = new ArrayList<>();
            ArrayList<Objeto> productosDefectuosos = new ArrayList<>();
            
            String jsonCerveza=in.readUTF();
            System.out.println(jsonCerveza);
            
            Objeto jObjeto = new Gson().fromJson(jsonCerveza, Objeto.class);
           
            
            System.out.println("Referencia cerveza: "+jObjeto.getReferencia());
            System.out.println("Largo cerveza: "+jObjeto.getLargo());
            System.out.println("Diametro cerveza: "+jObjeto.getDiametro());
            System.out.println("Peso cerveza: "+jObjeto.getPeso());
           
            Gson gson= new Gson();
           
            Cerveza c = new Cerveza(jObjeto.getReferencia(),jObjeto.getLargo(),jObjeto.getDiametro(),jObjeto.getPeso());
//                //Aqui hace la medicion de calidad hacia el producto, eligiendo si se encuentra defectuosa o valida
//                
            CervezaMedible cm= new CervezaMedible();


            //Envia el objeto en forma json con la cerveza valida
            if(cm.Status(c)){

                productosAceptados.add(jObjeto);
                System.out.println("Cerveza valida");

                out.writeUTF("La cerveza cumple con el estandar");

                //Enviando json con proudcto aceptado para guardar en el otro lado

                int cervezaAceptada=1;

                //Enviamos cantidad de aceptados al cliente para poder iterar
                out.writeInt(cervezaAceptada);

                //Enviamos json con la cerveza aceptada
                out.writeUTF(jsonCerveza);


            }else{
                productosDefectuosos.add(jObjeto);
                System.out.println("Cerveza defectuosa");
                out.writeUTF("La cerveza no cumple con el estandar");

                int cervezaDefectuosa=2;
                //Enviamos tipo de cerveza a guardar
                out.writeInt(cervezaDefectuosa);

                //Enviamos json con la cerveza aceptada
                out.writeUTF(jsonCerveza);

            }
//            
            
        } catch (IOException ex) {
            Logger.getLogger(ServidorMedicionHilo.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
