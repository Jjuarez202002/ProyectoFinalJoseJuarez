
package proyectofinalr;

import java.sql.SQLException;
import java.util.*;
public class ProyectoFinalR {
    public static void main(String[] args)throws SQLException {
        Scanner entrada = new Scanner(System.in);
        Juguete juguete= new Juguete();
        ConexionDB conexiondb= null;
        
        int opcion;
        System.out.println("Ingrese el la opcion que necesite");
        System.out.println("1.Consultar Juguete");
        System.out.println("2.Crear nuevo Juguete");
        System.out.println("3.Eliminar Juguete");
        System.out.println("0.Salir del Menu");
        opcion= entrada.nextInt();
        
        
        
        switch(opcion){
            case 1:
                juguete.consultarJuguete();
                break;
            case 2:
                juguete.nuevoJuguete();
                break;
            case 3:
                juguete.eliminarJuguete();
                break;  
        }
    }  
}
