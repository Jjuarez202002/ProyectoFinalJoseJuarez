
package proyectofinalr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Juguete {
    private ConexionDB conexiondb;

    public Juguete() throws SQLException {
        conexiondb = new ConexionDB();
    }
    
     public void consultarJuguete(){
        try{
        String consultas = "SELECT * FROM juguete";
        ResultSet consulta = conexiondb.consultar(consultas);
        
        while (consulta.next()){
        int id = consulta.getInt("id");
        String nombre = consulta.getString("nombre");
        Double precio = consulta.getDouble("precio");
        String color = consulta.getString("color");
        String marca = consulta.getString("marca");
        int piezas = consulta.getInt("piezas");
        
        System.out.print("nombre: " + nombre + " - ");
        System.out.print(":precio " + precio + " - ");
        System.out.print("color: " + color + " - ");
        System.out.print("marca: " + marca + " - ");
        System.out.print("piezas: " + piezas + " - ");         
            }
    }catch (SQLException e){
        e.printStackTrace();
    } 
}
 public void nuevoJuguete() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Ingrese el nombre del Juguete:");
    String nombre = scanner.nextLine();
    System.out.println("Ingrese el precio del Juguete:");
    double precio = scanner.nextDouble();
    scanner.nextLine();  // Consumir el salto de línea pendiente después de nextDouble()
    System.out.println("Ingrese el color del Juguete");
    String color = scanner.nextLine();
    System.out.println("Ingrese la marca del Juguete");
    String marca = scanner.nextLine();
    System.out.println("Ingrese la cantidad de piezas");
    int piezas = scanner.nextInt();

    // Insertar el nuevo juguete en la tabla 'juguete'
    try {
        String sqlInsercionJuguete = "INSERT INTO juguete (nombre, precio, color, marca, piezas) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement statementJuguete = conexiondb.getConnection().prepareStatement(sqlInsercionJuguete, PreparedStatement.RETURN_GENERATED_KEYS);
        statementJuguete.setString(1, nombre);
        statementJuguete.setDouble(2, precio);
        statementJuguete.setString(3, color);
        statementJuguete.setString(4, marca);
        statementJuguete.setInt(5, piezas);
        statementJuguete.executeUpdate();

        // Obtener el ID del nuevo juguete automáticamente
        int idDelNuevoJuguete = -1;
        ResultSet generatedKeys = statementJuguete.getGeneratedKeys();
        if (generatedKeys.next()) {
            idDelNuevoJuguete = generatedKeys.getInt(1);
        }

        if (idDelNuevoJuguete != -1) {
            System.out.println("Nuevo juguete agregado con éxito. ID del Juguete: " + idDelNuevoJuguete);
        } else {
            System.out.println("Error al obtener el ID del nuevo juguete.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
 
    public void eliminarJuguete() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el ID del Juguete que desea eliminar: ");
        int idJuguete = scanner.nextInt();

        try {
            String sqlEliminarJuguete = "DELETE FROM juguete WHERE id = ?";
            try (PreparedStatement statementEliminarJuguete = conexiondb.getConnection().prepareStatement(sqlEliminarJuguete)) {
                statementEliminarJuguete.setInt(1, idJuguete);
                int filasAfectadas = statementEliminarJuguete.executeUpdate();

                if (filasAfectadas > 0) {
                    System.out.println("Eliminación del juguete realizada con éxito.");
                } else {
                    System.out.println("El juguete con ID " + idJuguete + " no existe en la tabla 'juguete'.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
     
   