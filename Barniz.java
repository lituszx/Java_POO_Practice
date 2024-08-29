/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 * @author Carles
 * Clase que representa un barniz para productos de madera.
 */
public class Barniz extends Producto {

    private int mililitros;
    private ColorBarniz color;

     /**
     * Constructor de la clase Barniz.
     * @param codigo El código del barniz.
     * @param descripcion La descripción del barniz.
     * @param proveedor El proveedor del barniz.
     * @param precioVenta El precio de venta del barniz.
     * @param stock El stock disponible del barniz.
     * @param mililitros La cantidad de mililitros del barniz.
     * @param color El color del barniz.
     */
    public Barniz(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock,
            int mililitros, ColorBarniz color) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.mililitros = mililitros;
        this.color = color;
    }

     /**
     * Método para obtener la cantidad de mililitros del barniz.
     * @return La cantidad de mililitros del barniz.
     */
    public int getMililitros() {
        return mililitros;
    }
    /**
     * Método para establecer la cantidad de mililitros del barniz.
     * @param mililitros La nueva cantidad de mililitros del barniz.
     */
    public void setMililitros(int mililitros) {
        this.mililitros = mililitros;
    }
    /**
     * Método para obtener el color del barniz.
     * @return El color del barniz.
     */
    public ColorBarniz getColor() {
        return color;
    }
    /**
     * Método para establecer el color del barniz.
     * @param color El nuevo color del barniz.
     */
    public void setColor(ColorBarniz color) {
        this.color = color;
    }
}
