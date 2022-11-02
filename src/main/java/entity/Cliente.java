package entity;

public class Cliente {

	private long codigoCliente;
	private long cedula;
	private String nombres;
	private String apellidos;
	private String direccionEntrega;
	private long telefono;

	public Cliente(long codigoCliente, long cedula, String nombres, String apellidos, String direccionEntrega, long telefono) {
		this.codigoCliente = codigoCliente;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.direccionEntrega = direccionEntrega;
		this.telefono = telefono;
	}

	Cliente() {

	}

	@Override
	public String toString() {
		return "Cliente [cedula=" + cedula + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccionEntrega="
				+ direccionEntrega + ", telefono=" + telefono + "]";
	}

	public long getCodigoCliente() {
		return codigoCliente;
	}

	public void setCodigoCliente(long codigoCliente) {
		this.codigoCliente = codigoCliente;
	}

	public long getCedula() {
		return cedula;
	}

	public void setCedula(long cedula) {
		this.cedula = cedula;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccionEntrega() {
		return direccionEntrega;
	}

	public void setDireccionEntrega(String direccionEntrega) {
		this.direccionEntrega = direccionEntrega;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

}
