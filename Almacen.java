/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 * @author Carles
 * Clase que representa el almacén de una tienda de productos de madera.
 */
import java.util.ArrayList;
import java.util.List;

public class Almacen {

    private final List<Producto> productos;

    /**
     * Constructor de la clase Almacen.
     */
    public Almacen() {
        this.productos = new ArrayList<>();
    }

     /**
     * Método para agregar un producto al almacén.
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        productos.add(producto);
    }

    /**
     * Método para obtener todos los productos del almacén sin filtros.
     * @return Una lista de todos los productos del almacén.
     */
    public List<Producto> obtenerProductos() {
        return productos;
    }
}
