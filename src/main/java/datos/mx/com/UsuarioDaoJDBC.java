package datos.mx.com;

import java.sql.*;
import java.sql.SQLException;
import java.util.*;
import datos.DAO.mx.com.UsuarioDAO;
import domain.mx.com.UsuarioDTO;

public class UsuarioDaoJDBC implements UsuarioDAO{
	
	private Connection conexionTransaccional;
	private static final String SQL_INSERT = "INSERT INTO Login ( nombre_usuario, password) values (?,?)";
	private static final String SQL_SELECT_ALL = "SELECT id_usuario, nombre_usuario, password FROM Login";
	private static final String SQL_UPDATE = "UPDATE Login set nombre_usuario = ?, password = ? WHERE id_usuario = ?";
	private static final String SQL_DELETE = "DELETE FROM Login WHERE id_usuario = ?";
	
	public UsuarioDaoJDBC (Connection conexionTransaccional) {
		this.conexionTransaccional = conexionTransaccional;
	}

	@Override
	public List<UsuarioDTO> listar() throws SQLException {
		UsuarioDTO user = null;
		List<UsuarioDTO> users = new ArrayList<>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			pstmt = conn.prepareStatement(SQL_SELECT_ALL);
			rs = pstmt.executeQuery();
			while (rs.next()) {	
				user = new UsuarioDTO(
							rs.getInt("id_usuario"),
							rs.getString("nombre_usuario"),
							rs.getString("password")
						);
				users.add(user);
			}
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					Conexion.close(conn);
				}
				Conexion.close(rs);
				Conexion.close(pstmt);
			} catch (SQLException e) {		
				e.printStackTrace(System.out);
			}
		}
		return users;
	}

	@Override
	public Integer insert(UsuarioDTO usuario) throws SQLException {
		Connection conn = null;
		PreparedStatement pstmt = null;
		Integer personas = 0;
		
		try {
			conn =  this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			pstmt = conn.prepareStatement(SQL_INSERT);
			
			pstmt.setString(1, usuario.getNombreUsuario());
			pstmt.setString(2, usuario.getPassword());
			personas = pstmt.executeUpdate();
		} finally {
			try {
				Conexion.close(pstmt);
				if(this.conexionTransaccional == null) {
					Conexion.close(conn);
				}
				
			} catch (SQLException e2) {
				e2.printStackTrace(System.out);
			}
		}
		
		return personas;
	}

	@Override
	public Integer update(UsuarioDTO usuario) throws SQLException {
		int personas = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			pstmt = conn.prepareStatement(SQL_UPDATE);
			
			pstmt.setString(1, usuario.getNombreUsuario());
			pstmt.setString(2, usuario.getPassword());
			pstmt.setInt(3, usuario.getIdUsuario());
			
			personas = pstmt.executeUpdate();
			
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					Conexion.close(conn);
				}
				Conexion.close(pstmt);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return  personas;
	}

	@Override
	public Integer delete(UsuarioDTO usuario) throws SQLException {
		int usuars = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion.getConnection();
			pstmt = conn.prepareStatement(SQL_DELETE);
			pstmt.setInt(1, usuario.getIdUsuario());
			usuars = pstmt.executeUpdate();
		} finally {
			try {
				if(this.conexionTransaccional == null) {
					Conexion.close(conn);
				}
				Conexion.close(pstmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return usuars;
	}
	
}//clase
