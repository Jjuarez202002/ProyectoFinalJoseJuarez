
package proyectofinalr;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CONSULTA {
    private ConexionDB conexiondb;
    public  CONSULTA() throws SQLException{
            conexiondb = new ConexionDB();
    }
    public String consultaInventario(){
        String mensaje ="";
        try{
        String inv = "SELECT * FROM inventario";
        String jug = "SELECT * FROM juguete";
        ResultSet resultados = conexiondb.consultar(inv);
        ResultSet ju = conexiondb.consultar(jug);

        
        while (resultados.next()){
            int idJuguete = resultados.getInt("idJuguete");
            int cantidad = resultados.getInt("cantidad");
            String clasiJuguete = resultados.getString("clasiJuguete");            
            
            while (ju.next()){
            int idJugueteJug = ju.getInt("idJuguete");
            if (idJugueteJug == idJuguete) {
            String tipoJuguete = ju.getString("tipoJuguete");
                mensaje = "juguete: " + tipoJuguete + " - clasificacion: " 
                        + clasiJuguete + " - cantidad: " + cantidad;
                    System.out.print("juguete: " + tipoJuguete + " - ");
                    System.out.print("clasificacion: " + clasiJuguete + " - ");
                    System.out.println("cantidad: " + cantidad);
                    
                }
                       
            }
            ju.beforeFirst();
        }
    }catch (SQLException e){
        e.printStackTrace();
    } 
        return mensaje;
}
    public void consultarInventario(){
        try{
        String inv = "SELECT * FROM inventario";
        String jug = "SELECT * FROM juguete";
        ResultSet resultados = conexiondb.consultar(inv);
        ResultSet ju = conexiondb.consultar(jug);
        
        while (resultados.next()){
            int idJuguete = resultados.getInt("idJuguete");
            int cantidad = resultados.getInt("cantidad");
            String clasiJuguete = resultados.getString("clasiJuguete");            
            
            while (ju.next()){
            int idJugueteJug = ju.getInt("idJuguete");
            if (idJugueteJug == idJuguete) {
            String tipoJuguete = ju.getString("tipoJuguete");
                    System.out.print("juguete: " + tipoJuguete + " - ");
                    System.out.print("clasificacion: " + clasiJuguete + " - ");
                    System.out.println("cantidad: " + cantidad);
                }
                       
            }
            ju.beforeFirst();
                }
            }catch (SQLException e){
        e.printStackTrace();
                } 
        }
    
    public void consultarJuguete(){
        try{
        String jug = "SELECT * FROM juguete";
        ResultSet ju = conexiondb.consultar(jug);
        
        while (ju.next()){
        int idJuguete = ju.getInt("idJuguete");
        String tipoJuguete = ju.getString("tipoJuguete");
        String tamanio = ju.getString("tamanio");
        double precio = ju.getDouble("precio");
        
        System.out.print("id: " + idJuguete + " - ");
        System.out.print("Juguete: " + tipoJuguete + " - ");
        System.out.print("tamanio: " + tamanio + " - ");
        System.out.println("precio: " + precio);
                         
            }
    }catch (SQLException e){
        e.printStackTrace();
    } 
}
        
    public void consultarPedido(){
        try{
        String pedido = "SELECT * FROM pedido";
        ResultSet pedidos = conexiondb.consultar(pedido);
        
        while (pedidos.next()){
        int idPedido = pedidos.getInt("idPedido");
        String idInventario = pedidos.getString("idInventario");
        String cantidad = pedidos.getString("cantidad");
        double precio = pedidos.getDouble("precio");
        
        System.out.print("id: " + idPedido + " - ");
        System.out.print("Juguete: " + idInventario + " - ");
        System.out.print("tamanio: " + cantidad + " - ");
        System.out.println("precio: " + precio);
                         
            }
    }catch (SQLException e){
        e.printStackTrace();
    } 
}
            public String obtenerTipoJuguetePorId(int idJuguete) {
        try {
            String sql = "SELECT tipoJuguete FROM juguete WHERE idJuguete = " + idJuguete;
            ResultSet resultado = conexiondb.consultar(sql);

            if (resultado.next()) {
                String nombre = resultado.getString("tipoJuguete");
                return nombre;
            } else {
                System.out.println("El ID de " + idJuguete + " no existe en la base.");
                return "";
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return "";
        }
    }
            
    public int obtenerCantidadInventarioPorIdJuguete(int idJuguete) {
        try {
            String sql = "SELECT cantidad FROM inventario WHERE idJuguete = " + idJuguete;
            ResultSet resultado = conexiondb.consultar(sql);

            if (resultado.next()) {
                return resultado.getInt("cantidad");
            } else {
                System.out.println("El juguete con ID " + idJuguete + " no existe en el inventario.");
                return 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0; 
        }
    }
                
    public double obtenerPrecioJuguetePorId(int idJuguete) {
        try {
            String sql = "SELECT precio FROM juguete WHERE idJuguete = " + idJuguete;
            ResultSet resultado = conexiondb.consultar(sql);

            if (resultado.next()) {
                return resultado.getDouble("precio");
            } else {
                System.out.println("El juguete con ID " + idJuguete + " no existe.");
                return 0.0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return 0.0;
        }
    }       
}