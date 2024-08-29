/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 *
 * @author Carles
 * Clase que representa un proveedor de productos de madera.
 */
public class Proveedor {

    private String nif;
    private String nombre;

     /**
     * Constructor de la clase Proveedor.
     * @param nif El NIF del proveedor.
     * @param nombre El nombre del proveedor.
     */
    public Proveedor(String nif, String nombre) {
        this.nif = nif;
        this.nombre = nombre;
    }

     /**
     * Método para obtener el NIF del proveedor.
     * @return El NIF del proveedor.
     */
    public String getNif() {
        return nif;
    }
    /**
     * Método para establecer el NIF del proveedor.
     * @param nif El nuevo NIF del proveedor.
     */
    public void setNif(String nif) {
        this.nif = nif;
    }
    /**
     * Método para obtener el nombre del proveedor.
     * @return El nombre del proveedor.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método para establecer el nombre del proveedor.
     * @param nombre El nuevo nombre del proveedor.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
