/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 * @author Carles
 * Clase abstracta que representa un producto de madera.
 */
public class Producto {

    private String codigo;
    private String descripcion;
    private Proveedor proveedor;
    private double precioVenta;
    private int stock;

     /**
     * Constructor de la clase Producto.
     * @param codigo El código del producto.
     * @param descripcion La descripción del producto.
     * @param proveedor El proveedor del producto.
     * @param precioVenta El precio de venta del producto.
     * @param stock El stock disponible del producto.
     */
    public Producto(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.proveedor = proveedor;
        this.precioVenta = precioVenta;
        this.stock = stock;
    }
    /**
     * Método para obtener el código del producto.
     * @return El código del producto.
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * Método para establecer el código del producto.
     * @param codigo El nuevo código del producto.
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * Método para obtener la descripción del producto.
     * @return La descripción del producto.
     */
    public String getDescripcion() {
        return descripcion;
    }
    /**
     * Método para establecer la descripción del producto.
     * @param descripcion La nueva descripción del producto.
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    /**
     * Método para obtener el proveedor del producto.
     * @return El proveedor del producto.
     */
    public Proveedor getProveedor() {
        return proveedor;
    }
    /**
     * Método para establecer el proveedor del producto.
     * @param proveedor El nuevo proveedor del producto.
     */
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
    /**
     * Método para obtener el precio de venta del producto.
     * @return El precio de venta del producto.
     */
    public double getPrecioVenta() {
        return precioVenta;
    }
    /**
     * Método para establecer el precio de venta del producto.
     * @param precioVenta El nuevo precio de venta del producto.
     */
    public void setPrecioVenta(double precioVenta) {
        this.precioVenta = precioVenta;
    }
    /**
     * Método para obtener el stock disponible del producto.
     * @return El stock disponible del producto.
     */
    public int getStock() {
        return stock;
    }
    /**
     * Método para establecer el stock disponible del producto.
     * @param stock El nuevo stock disponible del producto.
     */
    public void setStock(int stock) {
        this.stock = stock;
    }
    /**
     * Método para actualizar el stock.
     * @param cantidad numero de productos añadidos a los actuales.
     */
    public void actualizarStock(int cantidad) {
        this.stock += cantidad;
    }
}
