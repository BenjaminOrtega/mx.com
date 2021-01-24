package domain.mx.com;

public class UsuarioDTO {
	private Integer idUsuario;
	private String nombreUsuario;
	private String password;
	
	public UsuarioDTO () {
		
	}
	
	public UsuarioDTO (Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	public UsuarioDTO (Integer idUsuario, String nombreUsuario, String password) {
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.password = password;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [idUsuario=" + idUsuario + ", nombreUsuario=" + nombreUsuario + ", password=" + password + "]";
	}
	
}
