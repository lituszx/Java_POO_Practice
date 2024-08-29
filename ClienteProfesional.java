/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 *
 * @author Carles
 */
public class ClienteProfesional extends Cliente{
     private double descuento;

    /**
     * Constructor de la clase ClienteProfesional.
     * @param nif El NIF del cliente profesional.
     * @param nombre El nombre del cliente profesional.
     * @param descuento El descuento aplicado para el cliente profesional.
     */
    public ClienteProfesional(String nif, String nombre, double descuento) {
        super(nif, nombre);
        this.descuento = descuento;
    }

    /**
     * Método para obtener el descuento aplicado para el cliente profesional.
     * @return El descuento del cliente profesional.
     */
    public double getDescuento() {
        return descuento;
    }
    
    /**
     * Método para definir descuento del cliente profesional.
     * @param descuento El descuento del cliente profesional.
     */
    public void setDescuento(double descuento){
        this.descuento = descuento;
    }
}
