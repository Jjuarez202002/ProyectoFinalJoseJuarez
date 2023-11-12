
package proyectofinalr;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Factura {
    private ConexionDB conexionDB;

    public Factura() throws SQLException {
        conexionDB = new ConexionDB();
    }

    public void realizarVenta() {
        try (Scanner scanner = new Scanner(System.in)) {
            // Mostrar lista de juguetes disponibles
            System.out.println("Lista de juguetes disponibles:");
            conexionDB.consultarJuguete();

            System.out.print("Ingrese el ID del juguete que desea comprar: ");
            int idJuguete = scanner.nextInt();

            System.out.print("Cantidad a comprar: ");
            int cantidadCompra = scanner.nextInt();

            // Realizar la venta
            procesarVenta(idJuguete, cantidadCompra);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void procesarVenta(int idJuguete, int cantidadCompra) throws SQLException {
        try {
            // Consultar la cantidad disponible en el inventario
            int cantidadDisponible = obtenerCantidadDisponible(idJuguete);

            if (cantidadDisponible >= cantidadCompra) {
                // Consultar el precio unitario del juguete
                double precioUnitario = obtenerPrecioUnitario(idJuguete);

                // Realizar la actualización en la tabla inventario
                int resta = cantidadDisponible - cantidadCompra;
                actualizarInventario(idJuguete, resta);

                // Insertar en la tabla facturación
                String nombre = obtenerTipoJuguetePorId(idJuguete);
                double total = cantidadCompra * precioUnitario;
                insertarFacturacion(idJuguete, nombre, cantidadCompra, total);

                System.out.println("\nLa venta se pudo realizar con exito!!!!.\n");
            } else {
                System.out.println("\n¡ No hay unidades en el inventario !.\n");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}