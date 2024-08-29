/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aa4_woodshops;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/**
 * @author Carles Julia Enrich Clase principal que contiene el punto de entrada
 * del programa WoodShops.
 */
public class AA4_WoodShops {

    /**
     * Punto de entrada principal del programa. Permite al usuario interactuar
     * con el sistema WoodShops a través de un menú.
     *
     * @param args Los argumentos de la línea de comandos (no se utilizan en
     * este programa).
     */
    private static List<ClienteProfesional> clientesPro = new ArrayList<>();
    private static List<WoodFriend> clientesWF = new ArrayList<>();

    public static void main(String[] args) {
        // TODO code application logic here
        List<Tienda> tiendas = new ArrayList<>();
        Tienda tienda1 = new Tienda("Tienda 1");
        Tienda tienda2 = new Tienda("Tienda 2");
        tiendas.add(tienda1);
        tiendas.add(tienda2);

        cargarDatosIniciales(tiendas);

        try (Scanner scanner = new Scanner(System.in)) {
            int opcion;
            do {
                System.out.println("===== MENU =====");
                System.out.println("1. Anadir producto nuevo.");
                System.out.println("2. Listar productos.");
                System.out.println("3. Mostrar stock de un producto.");
                System.out.println("4. Agregar nuevos clientes a WoodShops.");
                System.out.println("5. Mostrar todos los clientes.");
                System.out.println("6. Agregar ticket de venta.");
                System.out.println("7. Mostrar listado de tickets entre fechas.");
                System.out.println("8. Mostrar resumen de ventas de tiendas entre fechas.");
                System.out.println("9. Salir.");
                System.out.print("Ingrese su opcion: ");
                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer del scanner

                switch (opcion) {
                    case 1:
                        agregarNuevoProducto(scanner, tiendas);
                        break;
                    case 2:
                        listarProductos(scanner, tiendas);
                        break;
                    case 3:
                        mostrarStockProducto(scanner, tiendas);
                        break;
                    case 4:
                        agregarNuevoCliente(scanner);
                        break;
                    case 5:
                        mostrarClientes(clientesPro, clientesWF);
                        break;
                    case 6:
                        agregarTicketVenta(scanner, tiendas, clientesPro, clientesWF);
                        break;
                    case 7:
                        mostrarResumenTicketsEntreFechas(scanner, tiendas);
                        break;
                    case 8:
                        mostrarResumenVentasEntreFechas(scanner, tiendas);
                        break;
                    case 9:
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, ingrese una opcion valida.");
                        break;
                }
            } while (opcion != 9);
        }
    }

    /**
     * Carga datos iniciales en las tiendas proporcionadas. Estos datos incluyen
     * proveedores y algunos productos predefinidos.
     *
     * @param tiendas La lista de tiendas en las que se cargarán los datos.
     */
    private static void cargarDatosIniciales(List<Tienda> tiendas) {
        // Crear algunos clientes profesionales
        ClienteProfesional clientePro1 = new ClienteProfesional("12345678X", "Cliente Profesional 1", 10);
        ClienteProfesional clientePro2 = new ClienteProfesional("87654321Y", "Cliente Profesional 2", 15);

        // Agregar clientes profesionales a la lista
        clientesPro.add(clientePro1);
        clientesPro.add(clientePro2);

        // Crear algunos WoodFriends
        WoodFriend clienteWF1 = new WoodFriend("00012345W", "WoodFriend 1", 1001);
        WoodFriend clienteWF2 = new WoodFriend("00054321W", "WoodFriend 2", 1002);

        // Agregar WoodFriends a la lista
        clientesWF.add(clienteWF1);
        clientesWF.add(clienteWF2);
        for (Tienda tienda : tiendas) {
            // Código de carga de datos iniciales para cada tienda
            // Crear proveedores
            Proveedor proveedor1 = new Proveedor("12345678A", "Proveedor 1");
            Proveedor proveedor2 = new Proveedor("87654321B", "Proveedor 2");

            // Crear productos
            Producto tablero1 = new Tablero("T001", "Tablero de Aglomerado", proveedor1, 10.0, 100, 120.0, 80.0, TipoTablero.AGLOMERADO);
            Producto barniz1 = new Barniz("B001", "Barniz Incoloro", proveedor2, 5.0, 50, 250, ColorBarniz.INCOLORO);
            Producto articulo1 = new Articulo("A001", "Mesa de Madera", proveedor1, 50.0, 20, TipoArticulo.MESA);

            // Agregar productos a la tienda
            tienda.agregarProducto(tablero1);
            tienda.agregarProducto(barniz1);
            tienda.agregarProducto(articulo1);

            // Generar un ejemplo de ticket de venta
            // Se asume que el primer cliente profesional y WoodFriend son los compradores
            List<LineaDetalle> lineasDetalle = new ArrayList<>();
            lineasDetalle.add(new LineaDetalle(tablero1, 2)); // 2 tableros
            lineasDetalle.add(new LineaDetalle(barniz1, 1)); // 1 barniz
            Venta ticketVenta = new Venta(tienda.getVentas().size() + 1, new Date(), clientePro1); // Ticket de venta para el cliente profesional 1
            for (LineaDetalle linea : lineasDetalle) {
                Producto producto = linea.getProducto();
                int cantidad = linea.getCantidad();
                producto.actualizarStock(-cantidad); // Actualizar el stock del producto
                ticketVenta.agregarLineaDetalle(linea); // Agregar la línea de detalle al ticket de venta
            }
            tienda.agregarVenta(ticketVenta);
        }
    }

    /**
     * Permite al usuario agregar un nuevo producto a una tienda seleccionada.
     * Solicita al usuario los detalles del producto y lo agrega a la tienda
     * correspondiente.
     *
     * @param scanner El objeto Scanner para la entrada del usuario.
     * @param tiendas La lista de tiendas disponibles en el sistema.
     */
    private static void agregarNuevoProducto(Scanner scanner, List<Tienda> tiendas) {
        System.out.println("Seleccione la tienda para agregar el producto, indique solo el numero:");
        for (int i = 0; i < tiendas.size(); i++) {
            System.out.println((i + 1) + ". Tienda " + (i + 1));
        }
        int opcionTienda = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Tienda tiendaSeleccionada = tiendas.get(opcionTienda - 1);

        System.out.println("Ingrese los detalles del nuevo producto:");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();
        System.out.print("Descripción: ");
        String descripcion = scanner.nextLine();
        System.out.print("Proveedor (NIF): ");
        String nifProveedor = scanner.nextLine();
        System.out.print("Precio de venta: ");
        double precioVenta = scanner.nextDouble();
        System.out.print("Stock: ");
        int stock = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        // Dependiendo del tipo de producto
        Producto nuevoProducto = null;
        System.out.println("Seleccione el tipo de producto (tablero, barniz, articulo): ");
        String tipoProducto = scanner.nextLine();
        switch (tipoProducto.toLowerCase()) {
            case "tablero":
                System.out.print("Altura: ");
                double altura = scanner.nextDouble();
                System.out.print("Anchura: ");
                double anchura = scanner.nextDouble();
                System.out.print("Tipo de tablero: ");
                String tipoTablero = scanner.next();
                nuevoProducto = new Tablero(codigo, descripcion, new Proveedor(nifProveedor, ""), precioVenta, stock, altura, anchura, TipoTablero.valueOf(tipoTablero.toUpperCase()));
                break;
            case "barniz":
                System.out.print("Mililitros: ");
                int mililitros = scanner.nextInt();
                System.out.print("Color: ");
                String color = scanner.next();
                nuevoProducto = new Barniz(codigo, descripcion, new Proveedor(nifProveedor, ""), precioVenta, stock, mililitros, ColorBarniz.valueOf(color.toUpperCase()));
                break;
            case "articulo":
                System.out.print("Tipo de artículo: ");
                String tipoArticulo = scanner.next();
                nuevoProducto = new Articulo(codigo, descripcion, new Proveedor(nifProveedor, ""), precioVenta, stock, TipoArticulo.valueOf(tipoArticulo.toUpperCase()));
                break;
            default:
                System.out.println("Tipo de producto no válido.");
                return;
        }

        // Agregar el nuevo producto a la tienda seleccionada
        tiendaSeleccionada.agregarProducto(nuevoProducto);
        System.out.println("Producto agregado con éxito a la tienda " + tiendaSeleccionada);
    }

    /**
     * Permite al usuario listar los productos de todas las tiendas o filtrarlos
     * por tipo. Solicita al usuario si desea filtrar por tipo y muestra los
     * productos correspondientes.
     *
     * @param scanner El objeto Scanner para la entrada del usuario.
     * @param tiendas La lista de tiendas disponibles en el sistema.
     */
    private static void listarProductos(Scanner scanner, List<Tienda> tiendas) {
        System.out.println("¿Desea filtrar por tipo? (S/N)");
        String respuesta = scanner.nextLine();
        if (respuesta.equalsIgnoreCase("S")) {
            System.out.println("Ingrese el tipo de producto (tablero, barniz, articulo): ");
            String tipo = scanner.nextLine();
            for (Tienda tienda : tiendas) {
                System.out.println("Productos de tipo " + tipo + " en " + tienda.getNombre());
                for (Producto producto : tienda.listarProductosPorTipo(tipo)) {
                    System.out.println("Codigos de los productos: " + producto.getCodigo());
                }
            }
        } else {
            System.out.println("Listado de todos los productos:");
            for (Tienda tienda : tiendas) {
                System.out.println("Productos en " + tienda.getNombre());
                for (Producto producto : tienda.obtenerProductos()) {
                    System.out.println(producto.getCodigo() + " " + producto.getDescripcion());
                }
            }
        }
    }

    /**
     * Permite al usuario mostrar el stock de un producto en todas las tiendas.
     * Solicita al usuario el código del producto y muestra su stock en cada
     * tienda.
     *
     * @param scanner El objeto Scanner para la entrada del usuario.
     * @param tiendas La lista de tiendas disponibles en el sistema.
     */
    private static void mostrarStockProducto(Scanner scanner, List<Tienda> tiendas) {
        System.out.println("Ingrese el código del producto: ");
        String codigo = scanner.nextLine();
        for (Tienda tienda : tiendas) {
            System.out.println("Stock del producto " + codigo + " en " + tienda.getNombre());
            tienda.mostrarStockProducto(codigo);
        }
    }

    /**
     * Método para agregar un nuevo cliente a la lista de clientes de la
     * empresa.
     *
     * @param scanner El objeto Scanner para la entrada del usuario.
     */
    private static void agregarNuevoCliente(Scanner scanner) {
        System.out.println("Ingrese los detalles del nuevo cliente:");
        System.out.print("Nif: ");
        String nif = scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Tipo de cliente (profesional, woodfriend): ");
        String tipoCliente = scanner.nextLine();

        switch (tipoCliente.toLowerCase()) {
            case "profesional":
                System.out.print("Descuento (%): ");
                int descuento = scanner.nextInt();
                ClienteProfesional nuevoClienteP = new ClienteProfesional(nif, nombre, descuento);
                clientesPro.add(nuevoClienteP);
                break;
            case "woodfriend":
                System.out.print("Codigo Socio: ");
                int codigoSocio = scanner.nextInt();
                WoodFriend nuevoClienteW = new WoodFriend(nif, nombre, codigoSocio);
                clientesWF.add(nuevoClienteW);
                break;
            default:
                System.out.println("Tipo de cliente no válido.");
                break;
        }
        System.out.println("Cliente agregado con exito:");

    }

    /**
     * Método para mostrar clientes de la empresa.
     *
     * @param clientesPro Lista clientes profesionales.
     * @param clientesWF Lista clientes WoodFriends.
     */
    private static void mostrarClientes(List<ClienteProfesional> clientesPro, List<WoodFriend> clientesWF) {
        System.out.println("=== Clientes Profesionales ===");
        if (clientesPro.isEmpty()) {
            System.out.println("No hay clientes profesionales registrados.");
        } else {
            for (ClienteProfesional cliente : clientesPro) {
                System.out.print("Nif: " + cliente.getNif() + " Nombre: " + cliente.getNombre() + " Descuento: " + cliente.getDescuento() + "\n");
            }
        }

        System.out.println("\n=== WoodFriends ===");
        if (clientesWF.isEmpty()) {
            System.out.println("No hay WoodFriends registrados.");
        } else {
            for (WoodFriend cliente : clientesWF) {
                System.out.print("Nif: " + cliente.getNif() + " Nombre: " + cliente.getNombre() + " Num. Socio: " + cliente.getCodigoSocio() + "\n");
            }
        }
    }

    /**
     * Método para buscar cliente por nif.
     *
     * @param nif NIF del cliente a buscar
     * @param clientesPro Lista clientes profesionales.
     * @param clientesWF Lista clientes WoodFriends.
     */
    // Función para buscar un cliente por su NIF en las listas de clientes profesionales y WoodFriends
    private static Cliente buscarClientePorNif(String nif, List<ClienteProfesional> clientesPro, List<WoodFriend> clientesWF) {
        // Buscar en la lista de clientes profesionales
        for (ClienteProfesional cliente : clientesPro) {
            if (cliente.getNif().equalsIgnoreCase(nif)) {
                return cliente;
            }
        }

        // Buscar en la lista de WoodFriends
        for (WoodFriend cliente : clientesWF) {
            if (cliente.getNif().equalsIgnoreCase(nif)) {
                return cliente;
            }
        }

        // Si no se encuentra el cliente, devolver null
        return null;
    }

    /**
     * Método para generar un nuevo ticket de venta en la tienda seleccionada.
     *
     * @param scanner El objeto Scanner para la entrada del usuario.
     * @param tiendas La lista de tiendas disponibles en el sistema.
     * @param clientesPro La lista de clientes profesionales.
     * @param clientesWF La lista de WoodFriends.
     */
    private static void agregarTicketVenta(Scanner scanner, List<Tienda> tiendas, List<ClienteProfesional> clientesPro, List<WoodFriend> clientesWF) {
        System.out.println("Seleccione la tienda para generar el ticket de venta, indique solo el número:");
        for (int i = 0; i < tiendas.size(); i++) {
            System.out.println((i + 1) + ". " + tiendas.get(i).getNombre());
        }
        int opcionTienda = scanner.nextInt();
        scanner.nextLine(); // Limpiar el buffer del scanner

        Tienda tiendaSeleccionada = tiendas.get(opcionTienda - 1);

        System.out.println("Ingrese el NIF del cliente (si no tiene, ingrese 'null'): ");
        String nifCliente = scanner.nextLine();

        // Buscar el cliente por su NIF
        Cliente cliente = buscarClientePorNif(nifCliente, clientesPro, clientesWF);

        // Mostrar los productos disponibles en la tienda
        System.out.println("Productos disponibles en " + tiendaSeleccionada.getNombre() + ":");
        for (Producto producto : tiendaSeleccionada.obtenerProductos()) {
            System.out.println(producto.getCodigo() + " - " + producto.getDescripcion());
        }

        // Solicitar la selección de productos y cantidades
        System.out.println("Ingrese los detalles del ticket de venta (código del producto y cantidad), separados por espacio (Ejemplo: A001 2).");
        System.out.println("Ingrese 'fin' para terminar la selección.");

        List<LineaDetalle> lineasDetalle = new ArrayList<>();

        while (true) {
            String entrada = scanner.nextLine();
            if (entrada.equalsIgnoreCase("fin")) {
                break;
            }

            String[] partes = entrada.split(" ");
            if (partes.length != 2) {
                System.out.println("Formato incorrecto. Ingrese el código del producto y la cantidad, separados por espacio.");
                continue;
            }

            String codigoProducto = partes[0];
            int cantidad;
            try {
                cantidad = Integer.parseInt(partes[1]);
            } catch (NumberFormatException e) {
                System.out.println("Cantidad no válida. Ingrese un número entero.");
                continue;
            }

            // Buscar el producto por su código
            Producto producto = tiendaSeleccionada.buscarProductoPorCodigo(codigoProducto);
            if (producto == null) {
                System.out.println("Producto no encontrado.");
                continue;
            }

            // Verificar si hay suficiente stock del producto
            if (producto.getStock() < cantidad) {
                System.out.println("No hay suficiente stock del producto " + codigoProducto);
                continue;
            }

            // Crear la línea de detalle y agregarla a la lista
            LineaDetalle linea = new LineaDetalle(producto, cantidad);
            lineasDetalle.add(linea);
        }

        // Generar el ticket de venta
        tiendaSeleccionada.generarTicketVenta(cliente, lineasDetalle);
    }

    /**
     * Método para mostrar un resumen de tickets de todas las tiendas entre dos
     * fechas especificadas.
     *
     * @param tiendas La lista de tiendas disponibles en el sistema.
     * @param fechaInicio La fecha de inicio del período para el resumen.
     * @param fechaFin La fecha de fin del período para el resumen.
     */
    private static void mostrarResumenTickets(List<Tienda> tiendas, Date fechaInicio, Date fechaFin) {
        System.out.println("Resumen de tickets entre " + fechaInicio + " y " + fechaFin + ":");

        // Iterar sobre todas las tiendas
        for (Tienda tienda : tiendas) {
            // Mostrar resumen de tickets para cada tienda
            tienda.mostrarResumenTickets(fechaInicio, fechaFin);
        }
    }

    /**
     * Método para mostrar un resumen de tickets de todas las tiendas entre dos
     * fechas especificadas.
     *
     * @param scanner El objeto Scanner para la entrada del usuario.
     * @param tiendas La lista de tiendas disponibles en el sistema.
     */
    private static void mostrarResumenTicketsEntreFechas(Scanner scanner, List<Tienda> tiendas) {
        System.out.println("=== Resumen de tickets entre dos fechas ===");
        System.out.println("Ingrese la fecha de inicio (formato: dd/MM/yyyy):");
        String fechaInicioStr = scanner.nextLine();
        System.out.println("Ingrese la fecha de fin (formato: dd/MM/yyyy):");
        String fechaFinStr = scanner.nextLine();

        // Parsear las fechas
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio;
        Date fechaFin;
        try {
            fechaInicio = dateFormat.parse(fechaInicioStr);
            fechaFin = dateFormat.parse(fechaFinStr);
        } catch (ParseException e) {
            System.out.println("Error al parsear las fechas.");
            return;
        }

        // Mostrar resumen de tickets entre las fechas especificadas
        mostrarResumenTickets(tiendas, fechaInicio, fechaFin);
    }

    private static void mostrarResumenVentasEntreFechas(Scanner scanner, List<Tienda> tiendas) {
        System.out.println("Ingrese la fecha de inicio (formato: dd/MM/yyyy):");
        String fechaInicioStr = scanner.nextLine();
        System.out.println("Ingrese la fecha de fin (formato: dd/MM/yyyy):");
        String fechaFinStr = scanner.nextLine();

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaInicio;
        Date fechaFin;
        try {
            fechaInicio = dateFormat.parse(fechaInicioStr);
            fechaFin = dateFormat.parse(fechaFinStr);
        } catch (ParseException e) {
            System.out.println("Error al parsear las fechas.");
            return;
        }

        System.out.println("Resumen de ventas entre " + fechaInicioStr + " y " + fechaFinStr + ":");
        for (Tienda tienda : tiendas) {
            double totalVentas = tienda.calcularTotalVentasEntreFechas(fechaInicio, fechaFin);
            System.out.println("Tienda: " + tienda.getNombre() + ", Total de ventas: " + totalVentas);
        }
    }
}
