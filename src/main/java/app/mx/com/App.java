package app.mx.com;

import java.sql.*;

import datos.mx.com.Conexion;
import datos.mx.com.PersonaDAO;
import domain.mx.com.Persona;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
    	Connection conexion = null;
    	
    	try {
			conexion = Conexion.getConnection();
			if(conexion.getAutoCommit()) {
				conexion.setAutoCommit(false);
			}//validaccion ara que el autocomit se desacctive
			PersonaDAO accionPrsonaDAO = new PersonaDAO(conexion);
			
			Persona persona1 = new Persona();
			persona1.setNombre("Staryuki");
			persona1.setApellido("Ni idea");
			persona1.setEmail("cabeson@gmail.com");
			persona1.setTelefono("564565656");
			
			accionPrsonaDAO.Insertar(persona1);
			
			Persona persona2 = new Persona(2,"Sashagrey",
											 "gamerPro",
											 "gamerpro@gmail.com",
											 "5678657845");
			
			accionPrsonaDAO.updatePerson(persona2);
			conexion.commit();//se ejecuta el commit para que las sentecnias que afectan la BD no sean procesadas cuando una de estas falle
			System.out.println("Se guardo el commit");
		} catch (SQLException e) {
			e.printStackTrace(System.out);
			System.out.println("Roollback iniciado");
			try {
				conexion.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace(System.out);
			}
		}
    	
    }
}
