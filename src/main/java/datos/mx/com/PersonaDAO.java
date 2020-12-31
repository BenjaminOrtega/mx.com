package datos.mx.com;

import domain.mx.com.Persona;
import static datos.mx.com.Conexion.*;

import java.sql.*;
import java.util.*;

public class PersonaDAO {
	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM Test.Persona";
	private static final String SQL_INSERT = "INSERT INTO Persona (nombre, apellido,email, telefono) values (?, ?, ?, ?)";
	public List<Persona> seleccionar(){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		Persona persona = null;
		List<Persona> personas = new ArrayList<>();
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				
				persona = new Persona(idPersona,nombre,apellido,email,telefono);
				personas.add(persona);
				
			}
		} catch (SQLException e) {
			e.printStackTrace(System.out);
		}finally {
			try {
				close(conn);
				close(stmt);
				close(rs);
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		return personas;
	}//metodo seleccionar
	
	public int Insertar(Persona persona) {
		Connection conn = null;
		PreparedStatement stmt = null;
		int personas = 0;
		
		try {
			conn = getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			personas = stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace(System.out);
		}
		finally {
			try {
				close(conn);
				close(stmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}
		
		return personas;
	}//metodo para insertar

}
