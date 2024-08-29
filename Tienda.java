/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aa4_woodshops;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author Carles Clase que representa una tienda de productos de madera.
 */
public class Tienda {

    private Almacen almacen;
    private String nombre;
    private List<Venta> ventas;

    /**
     * Constructor de la clase Tienda.
     *
     * @param nombre El nombre de la tienda.
     */
    public Tienda(String nombre) {
        this.almacen = new Almacen();
        this.nombre = nombre;
        this.ventas = new ArrayList<>();
    }

    /**
     * Método para obtener el nombre de la tienda.
     *
     * @return El nombre de la tienda.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Método para establecer el nombre de la tienda.
     *
     * @param nombre El nuevo nombre de la tienda.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Método para agregar un producto al almacén de la tienda.
     *
     * @param producto El producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        almacen.agregarProducto(producto);
    }

    /**
     * Método para obtener todos los productos de la tienda sin filtros.
     *
     * @return Una lista de todos los productos de la tienda.
     */
    public List<Producto> obtenerProductos() {
        return almacen.obtenerProductos();
    }

    /**
     * Método para obtener todos los productos de la tienda con filtros para
     * diferenciar entre las subclases de producto.
     *
     * @param tipo de producto
     * @return Una lista de todos los productos de la tienda.
     */
    public List<Producto> listarProductosPorTipo(String tipo) {
        List<Producto> productosFiltrados = new ArrayList<>();
        List<Producto> productos = almacen.obtenerProductos();

        if (tipo.equalsIgnoreCase("tablero")) {
            for (Producto producto : productos) {
                if (producto instanceof Tablero) {
                    productosFiltrados.add(producto);
                }
            }
        } else if (tipo.equalsIgnoreCase("barniz")) {
            for (Producto producto : productos) {
                if (producto instanceof Barniz) {
                    productosFiltrados.add(producto);
                }
            }
        } else if (tipo.equalsIgnoreCase("articulo")) {
            for (Producto producto : productos) {
                if (producto instanceof Articulo) {
                    productosFiltrados.add(producto);
                }
            }
        } else {
            // Si no se especifica un tipo valido, se muestran todos los productos
            productosFiltrados = productos;
        }

        return productosFiltrados;
    }

    /**
     * Método para mostrar el stock de un producto concreto
     *
     * @param codigoProducto identificador del producto para filtrar
     */
    public void mostrarStockProducto(String codigoProducto) {
        List<Producto> productos = almacen.obtenerProductos();
        for (Producto producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigoProducto)) {
                System.out.println("Tienda: " + nombre + ", Stock: " + producto.getStock());
            }
        }
    }

    /**
     * Método para agregar un nuevo ticket de venta a la tienda.
     *
     * @param venta La venta a agregar.
     */
    public void agregarVenta(Venta venta) {
        ventas.add(venta);
    }

    /**
     * Método para obtener la lista de ventas de la tienda.
     *
     * @return La lista de ventas de la tienda.
     */
    public List<Venta> getVentas() {
        return ventas;
    }

    /**
     * Método para buscar un producto en el almacén de la tienda por su código.
     *
     * @param codigo El código del producto a buscar.
     * @return El producto encontrado, o null si no se encuentra.
     */
    public Producto buscarProductoPorCodigo(String codigo) {
        List<Producto> productos = almacen.obtenerProductos();
        for (Producto producto : productos) {
            if (producto.getCodigo().equalsIgnoreCase(codigo)) {
                return producto;
            }
        }
        return null; // Si no se encuentra el producto
    }

    /**
     * Método para generar un nuevo ticket de venta en la tienda.
     *
     * @param cliente El cliente asociado a la venta.
     * @param lineasDetalle Las líneas de detalle que componen la venta.
     */
    public void generarTicketVenta(Cliente cliente, List<LineaDetalle> lineasDetalle) {
        int numeroTicket = ventas.size() + 1; // Obtener el número de ticket como el tamaño de la lista de ventas más 1
        Date fecha = new Date(); // Obtener la fecha actual

        // Crear el ticket de venta
        Venta ticket = new Venta(numeroTicket, fecha, cliente);

        // Agregar las líneas de detalle al ticket de venta y actualizar el stock
        for (LineaDetalle linea : lineasDetalle) {
            Producto producto = linea.getProducto();
            int cantidad = linea.getCantidad();

            // Verificar si hay suficiente stock del producto
            if (producto.getStock() >= cantidad) {
                // Actualizar el stock del producto
                producto.actualizarStock(-cantidad);

                // Agregar la línea de detalle al ticket de venta
                ticket.agregarLineaDetalle(linea);
            } else {
                System.out.println("No hay suficiente stock del producto " + producto.getCodigo());
                return; // Si no hay suficiente stock, se cancela la venta
            }
        }

        // Agregar el ticket de venta a la lista de ventas de la tienda
        ventas.add(ticket);

        // Mostrar el ticket completo por pantalla
        System.out.println(ticket);
    }

    /**
     * Método para mostrar tickets entre fechas.
     *
     * @param fechaInicio fecha inicial.
     * @param fechaFin fecha final.
     */
    public void mostrarResumenTickets(Date fechaInicio, Date fechaFin) {
        System.out.println("Resumen de tickets en la tienda " + nombre + " entre " + fechaInicio + " y " + fechaFin + ":");

        for (Venta ticket : ventas) {
            Date fechaTicket = ticket.getFecha();
            if (fechaTicket.after(fechaInicio) && fechaTicket.before(fechaFin)) {
                int numeroTicket = ticket.getNumeroTicket();
                Cliente cliente = ticket.getCliente();
                double descuento = 0;

                // Si el cliente es registrado, obtener el descuento aplicado
                if (cliente != null && cliente instanceof ClienteProfesional) {
                    ClienteProfesional clienteProfesional = (ClienteProfesional) cliente;
                    descuento = clienteProfesional.getDescuento();
                }

                double total = ticket.calcularTotal();
                System.out.println("Número de ticket: " + numeroTicket);
                System.out.println("Fecha: " + fechaTicket);
                if (cliente != null) {
                    System.out.println("Cliente: " + cliente.getNombre());
                }
                if (descuento > 0) {
                    System.out.println("Descuento aplicado: " + descuento + "%");
                }
                System.out.println("Total del importe del ticket: " + total);
            }
        }
    }

    public double calcularTotalVentasEntreFechas(Date fechaInicio, Date fechaFin) {
        double totalVentas = 0.0;
        for (Venta venta : ventas) {
            if (venta.getFecha().after(fechaInicio) && venta.getFecha().before(fechaFin)) {
                totalVentas += venta.calcularTotal();
            }
        }
        return totalVentas;
    }
}
