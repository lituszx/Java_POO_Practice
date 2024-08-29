/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 * @author Carles
 * Clase que representa un artículo de madera.
 */
public class Articulo extends Producto {

    private TipoArticulo tipoArticulo;

     /**
     * Constructor de la clase Articulo.
     * @param codigo El código del artículo.
     * @param descripcion La descripción del artículo.
     * @param proveedor El proveedor del artículo.
     * @param precioVenta El precio de venta del artículo.
     * @param stock El stock disponible del artículo.
     * @param tipoArticulo El tipo de artículo.
     */
    public Articulo(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock,
            TipoArticulo tipoArticulo) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.tipoArticulo = tipoArticulo;
    }

    /**
     * Método para obtener el tipo de artículo.
     * @return El tipo de artículo.
     */
    public TipoArticulo getArticulo() {
        return tipoArticulo;
    }
    /**
     * Método para establecer el tipo de artículo.
     * @param tipoArticulo El nuevo tipo de artículo.
     */
    public void setArticulo(TipoArticulo tipoArticulo) {
        this.tipoArticulo = tipoArticulo;
    }
}
