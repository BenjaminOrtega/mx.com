package datos.mx.com;

import domain.mx.com.PersonaDTO;
import static datos.mx.com.Conexion.*;

import java.sql.*;
import java.util.*;

import datos.DAO.mx.com.PersonaDao;

public class PersonaDaoJDBC implements PersonaDao{
	
	private Connection conexionTransaccional = null;
	private static final String SQL_SELECT = "SELECT id_persona, nombre, apellido, email, telefono FROM persona";
	private static final String SQL_INSERT = "INSERT INTO persona (nombre, apellido,email, telefono) values (?, ?, ?, ?)";
	private static final String SQL_UPDATE = "UPDATE persona  set nombre = ?, apellido = ?, email = ?, telefono = ? WHERE id_persona = ?";
	private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona = ?";
	
	public PersonaDaoJDBC (Connection conexionTransaccional) {
		this.conexionTransaccional = conexionTransaccional;
	}
	
	public List<PersonaDTO> seleccionar() throws SQLException{
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		PersonaDTO persona = null;
		List<PersonaDTO> personas = new ArrayList<>();
		
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
			stmt = conn.prepareStatement(SQL_SELECT);
			rs = stmt.executeQuery();
			while(rs.next()) {
				
				int idPersona = rs.getInt("id_persona");
				String nombre = rs.getString("nombre");
				String apellido = rs.getString("apellido");
				String email = rs.getString("email");
				String telefono = rs.getString("telefono");
				
				persona = new PersonaDTO(idPersona,nombre,apellido,email,telefono);
				personas.add(persona);
				
			}
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					close(conn);
				}
				close(stmt);
				close(rs);
						
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
			
		}
		return personas;
	}//metodo seleccionar
	
	public Integer Insertar(PersonaDTO persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int personas = 0;
		
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
			stmt = conn.prepareStatement(SQL_INSERT);
			
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			personas = stmt.executeUpdate();
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					close(conn);
				}
				close(stmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace(System.out);
			}
		}
		
		return personas;
	}//metodo para insertar

	public Integer updatePerson(PersonaDTO persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int personas = 0;
		
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
			stmt = conn.prepareStatement(SQL_UPDATE);
			
			stmt.setString(1, persona.getNombre());
			stmt.setString(2, persona.getApellido());
			stmt.setString(3, persona.getEmail());
			stmt.setString(4, persona.getTelefono());
			
			stmt.setInt(5, persona.getIdPersona());
			
			personas = stmt.executeUpdate();
			
			
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					close(conn);
				}
				close(stmt);
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}		 
		return personas;
	}//metodo para actualizar una Persona
	
	public Integer personDelete(PersonaDTO persona) throws SQLException {
		Connection conn = null;
		PreparedStatement stmt = null;
		int personas = 0;
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : getConnection();
			stmt = conn.prepareStatement(SQL_DELETE);
			stmt.setInt(1, persona.getIdPersona());
			personas = stmt.executeUpdate();
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					close(conn);
				}
				close(stmt);
			} catch (SQLException e2) {
				e2.printStackTrace(System.out);
			}
		}
		
		
		return personas;
	}

	
}
