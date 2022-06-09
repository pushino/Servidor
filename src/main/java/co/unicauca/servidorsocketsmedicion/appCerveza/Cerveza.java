/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package co.unicauca.servidorsocketsmedicion.appCerveza;

import frameworkMedicion.core.Item;


public class Cerveza extends Item{
    private int referencia;
    private double largo;
    private double diametro;
    private double peso;
    private String msj = "";

    public Cerveza() {
    }

    
    public Cerveza(int referencia, double largo, double diametro, double peso) {
        this.referencia = referencia;
        this.largo = largo;
        this.diametro = diametro;
        this.peso = peso;
    }

    public int getReferencia() {
        return referencia;
    }

    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public double getDiametro() {
        return diametro;
    }

    public void setDiametro(double diametro) {
        this.diametro = diametro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String getMsj() {
        return msj;
    }
    
    public void setMsj(String msj) {
        this.msj = msj;
    }
    
    @Override
    public String toString() {
        return "Cerveza{" + "referencia=" + referencia + ", largo=" + largo + ", diametro=" + diametro + ", peso=" + peso + '}';
    }
}