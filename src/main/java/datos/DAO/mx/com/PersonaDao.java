package datos.DAO.mx.com;

import java.sql.SQLException;
import java.util.List;

import domain.mx.com.PersonaDTO;

public interface PersonaDao {
	
	public List<PersonaDTO> seleccionar() throws SQLException;
	
	public Integer Insertar(PersonaDTO persona) throws SQLException;
	
	public Integer updatePerson(PersonaDTO persona) throws SQLException;
	
	public Integer personDelete(PersonaDTO persona) throws SQLException;
}
