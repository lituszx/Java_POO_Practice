/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

/**
 *
 * @author Carles
 */
public class WoodFriend extends Cliente {
    private int codigoSocio;

    /**
     * Constructor de la clase WoodFriend.
     * @param nif El NIF del WoodFriend.
     * @param nombre El nombre del WoodFriend.
     * @param codigoSocio El código de socio asignado al WoodFriend.
     */
    public WoodFriend(String nif, String nombre, int codigoSocio) {
        super(nif, nombre);
        this.codigoSocio = codigoSocio;
    }

    /**
     * Método para obtener el código de socio del WoodFriend.
     * @return El código de socio del WoodFriend.
     */
    public int getCodigoSocio() {
        return codigoSocio;
    }
    
        /**
     * Método para definir el codigo de socio.
     * @param codigoSocio El numero de socio.
     */
    public void setCodigoSocio(int codigoSocio){
        this.codigoSocio = codigoSocio;
    }
    
}
