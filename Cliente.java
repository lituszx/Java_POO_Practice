/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 *
 * @author Carles
 */
public class Cliente {
    private String nif;
    private String nombre;
    
     /**
     * Constructor de la clase Cliente.
     * @param nif El NIF del cliente.
     * @param nombre El nombre del cliente.
     */
    public Cliente(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }
    
    /**
     * Método para obtener el NIF del cliente.
     * @return El NIF del cliente.
     */
    public String getNif() {
        return nif;
    }
    
    /**
     * Método para establecer el nif de cliente.
     * @param nif El nif del cliente.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }
    /**
     * Método para obtener el nombre del cliente.
     * @return El nombre del cliente.
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Método para establecer el nombre de cliente.
     * @param nombre El nombre del cliente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}