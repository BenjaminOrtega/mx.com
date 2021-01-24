package app.mx.com;

import java.sql.*;
import java.util.List;

import datos.DAO.mx.com.PersonaDao;
import datos.DAO.mx.com.UsuarioDAO;
import datos.mx.com.Conexion;
import datos.mx.com.PersonaDaoJDBC;
import datos.mx.com.UsuarioDaoJDBC;
import domain.mx.com.PersonaDTO;
import domain.mx.com.UsuarioDTO;

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
			PersonaDao personaDao = new PersonaDaoJDBC(conexion);
			UsuarioDAO usaurioDao = new UsuarioDaoJDBC(conexion);
			
			List<PersonaDTO> personas = personaDao.seleccionar();
			
			List<UsuarioDTO> usuarios = usaurioDao.listar(); 
			
			personas.forEach(persona -> {
				System.out.println(persona);
			});
			System.out.println("-----------------------------");
			usuarios.forEach(users-> {
				System.out.println(users);
			});
			
			
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
