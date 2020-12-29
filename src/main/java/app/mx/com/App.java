package app.mx.com;

import java.sql.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        String  url = "jdbc:mysql://localhost:3306/Test?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
        try {
			Connection conexion = DriverManager.getConnection(url,"root","");
			Statement intriduccion = conexion.createStatement();
			String sql = "SELECT id_persona,nombre,apellido,email,telefono FROM Persona";
			ResultSet  resultado = intriduccion.executeQuery(sql);
			
			while (resultado.next()) {
				
				System.out.println("**************** " + resultado.getInt("id_persona"));
				System.out.println("Nombre: " + resultado.getString("nombre"));
				System.out.println("Apellido: " + resultado.getString("apellido"));
				System.out.println("Email: " + resultado.getString("email"));
				System.out.println("Telefono: " + resultado.getString("telefono"));
			}
			resultado.close();
			intriduccion.close();
			conexion.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
    }
}
