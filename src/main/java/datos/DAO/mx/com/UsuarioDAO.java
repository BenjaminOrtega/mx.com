package datos.DAO.mx.com;
import java.sql.SQLException;
import java.util.List;

import domain.mx.com.UsuarioDTO;


public interface UsuarioDAO {
	public List<UsuarioDTO> listar()throws SQLException;
	public Integer insert(UsuarioDTO usuario) throws SQLException;
	public Integer update(UsuarioDTO usuario) throws SQLException;
	public Integer delete(UsuarioDTO usuario) throws SQLException;
}
