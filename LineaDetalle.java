/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 *
 * @author Carles
 */
public class LineaDetalle {
    private Producto producto;
    private int cantidad;

    /**
     * Constructor de la clase LineaDetalle.
     * @param producto El producto de la línea de detalle.
     * @param cantidad La cantidad comprada del producto.
     */
    public LineaDetalle(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
    }

    /**
     * Método para calcular el subtotal de la línea de detalle.
     * @return El subtotal de la línea de detalle.
     */
    public double calcularSubtotal() {
        return producto.getPrecioVenta() * cantidad;
    }
    
    /**
     * Método para obtener el producto de la línea de detalle.
     * @return El producto de la línea de detalle.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Método para obtener la cantidad comprada del producto.
     * @return La cantidad comprada del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

}
