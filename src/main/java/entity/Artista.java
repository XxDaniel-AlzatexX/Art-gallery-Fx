package entity;

import java.util.ArrayList;
import java.util.Calendar;

public class Artista {

	private long codigoArtista;
	private long cedula;
	private String nombres;
	private String apellidos;
	private Calendar fechaDeNacimiento;
	private long telefono;
	private ArrayList<Obra> obras = new ArrayList<>();

	public Artista(long codigoArtista, long cedula, String nombres, String apellidos, Calendar fechaDeNacimiento, long telefono) {
		this.codigoArtista = codigoArtista;
		this.cedula = cedula;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.telefono = telefono;
	}

	public Artista(long p_cedula, String p_nombre, String p_apellido, Calendar p_fechaNaci, long p_telefono) {
		this.cedula = p_cedula;
		this.nombres = p_nombre;
		this.apellidos = p_apellido;
		this.fechaDeNacimiento = p_fechaNaci;
		this.telefono = p_telefono;
	}
	public Artista() {
		
	}

	public long getCodigoArtista() {
		return codigoArtista;
	}

	public void setCodigoArtista(long codigoArtista) {
		this.codigoArtista = codigoArtista;
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

	public Calendar getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}

	public void setFechaDeNacimiento(Calendar fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public ArrayList<Obra> getObras() {
		return obras;
	}

	public void agregarObra(Obra obra){
		this.obras.add(obra);
	}

}
