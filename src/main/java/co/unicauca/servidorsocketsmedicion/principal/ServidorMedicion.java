/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package co.unicauca.servidorsocketsmedicion.principal;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author juanc
 */
public class ServidorMedicion {

    public static void main(String[] args) throws InterruptedException {
        
        ServerSocket servidor = null;
        Socket sc = null;
        DataInputStream in;
        DataOutputStream out;
        final int PUERTO = 5000;
        try {

            servidor = new ServerSocket(PUERTO);
            System.out.println("Servidor Iniciado");
            
            while(true){
                
                sc=servidor.accept();
                
                System.out.println("Cliente conectado");
                
                in = new DataInputStream(sc.getInputStream());
                out = new DataOutputStream(sc.getOutputStream());
                
                ServidorMedicionHilo hilo = new ServidorMedicionHilo(in, out);
                hilo.start();
                hilo.join();
                
                sc.close();
                System.out.println("Cliente desconectado");
                
            }
        } catch (IOException ex) {
            Logger.getLogger(ServidorMedicion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
}
