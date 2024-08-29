/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carles
 */
public class Venta {
    private int numeroTicket;
    private Date fecha;
    private Cliente cliente;
    private List<LineaDetalle> lineasDetalle;

    /**
     * Constructor de la clase Venta.
     * @param numeroTicket El número del ticket de la venta.
     * @param fecha La fecha de la venta.
     * @param cliente El cliente asociado a la venta (puede ser null para clientes anónimos).
     */
    public Venta(int numeroTicket, Date fecha, Cliente cliente) {
        this.numeroTicket = numeroTicket;
        this.fecha = fecha;
        this.cliente = cliente;
        this.lineasDetalle = new ArrayList<>();
    }

    /**
     * Método para agregar una línea de detalle a la venta.
     * @param linea La línea de detalle a agregar.
     */
    public void agregarLineaDetalle(LineaDetalle linea) {
        lineasDetalle.add(linea);
    }

    /**
     * Método para calcular el total de la venta.
     * @return El total de la venta.
     */
    public double calcularTotal() {
        double total = 0;
        for (LineaDetalle linea : lineasDetalle) {
            total += linea.calcularSubtotal();
        }
        if (cliente instanceof ClienteProfesional) {
        ClienteProfesional clienteProfesional = (ClienteProfesional) cliente;
        total -= (total * clienteProfesional.getDescuento() / 100); //    
        }
        return total;
    }
    
     // Getters y setters
    public int getNumeroTicket() {
        return numeroTicket;
    }

    public void setNumeroTicket(int numeroTicket) {
        this.numeroTicket = numeroTicket;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<LineaDetalle> getLineasDetalle() {
        return lineasDetalle;
    }

    public void setLineasDetalle(List<LineaDetalle> lineasDetalle) {
        this.lineasDetalle = lineasDetalle;
    }
}
