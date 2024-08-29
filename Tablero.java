/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 *
 * @author Carles
 * Clase que representa un tablero de madera.
 */
public class Tablero extends Producto {

    private double altura;
    private double anchura;
    private TipoTablero tipo;

     /**
     * Constructor de la clase Tablero.
     * @param codigo El código del tablero.
     * @param descripcion La descripción del tablero.
     * @param proveedor El proveedor del tablero.
     * @param precioVenta El precio de venta del tablero.
     * @param stock El stock disponible del tablero.
     * @param altura La altura del tablero.
     * @param anchura La anchura del tablero.
     * @param tipo El tipo de tablero.
     */
    public Tablero(String codigo, String descripcion, Proveedor proveedor, double precioVenta, int stock,
            double altura, double anchura, TipoTablero tipo) {
        super(codigo, descripcion, proveedor, precioVenta, stock);
        this.altura = altura;
        this.anchura = anchura;
        this.tipo = tipo;
    }

    /**
     * Método para obtener la altura del tablero.
     * @return La altura del tablero.
     */
    public double getAltura() {
        return altura;
    }
    /**
     * Método para establecer la altura del tablero.
     * @param altura La nueva altura del tablero.
     */
    public void setAltura(double altura) {
        this.altura = altura;
    }
    /**
     * Método para obtener la anchura del tablero.
     * @return La anchura del tablero.
     */
    public double getAnchura() {
        return anchura;
    }
    /**
     * Método para establecer la anchura del tablero.
     * @param anchura La nueva anchura del tablero.
     */
    public void setAnchura(double anchura) {
        this.anchura = anchura;
    }
    /**
     * Método para obtener el tipo de tablero.
     * @return El tipo de tablero.
     */
    public TipoTablero getTipo() {
        return tipo;
    }
    /**
     * Método para establecer el tipo de tablero.
     * @param tipo El nuevo tipo de tablero.
     */
    public void setTipo(TipoTablero tipo) {
        this.tipo = tipo;
    }
}
