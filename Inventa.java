/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectofinalr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Inventa {
    private int idInventario;
    private int idJuguete;
    private int cantidad;
    private String clasiJuguete;

    public Inventa(int idInventario, int idJuguete, int cantidad, String clasiJuguete) {
        this.idInventario = idInventario;
        this.idJuguete = idJuguete;
        this.cantidad = cantidad;
        this.clasiJuguete = clasiJuguete;
    }

    public int getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(int idInventario) {
        this.idInventario = idInventario;
    }

    public int getIdJuguete() {
        return idJuguete;
    }

    public void setIdJuguete(int idJuguete) {
        this.idJuguete = idJuguete;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getClasiJuguete() {
        return clasiJuguete;
    }

    public void setClasiJuguete(String clasiJuguete) {
        this.clasiJuguete = clasiJuguete;
    }

    public void actualizarInventarioEnBaseDeDatos(Connection connection) {
        try {
            String sql = "UPDATE inventario SET cantidad = ? WHERE clasiJuguete = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, this.cantidad);
                statement.setString(2, this.clasiJuguete);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}