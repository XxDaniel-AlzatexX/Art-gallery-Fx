package control;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXB;

import entity.ArchivoArtista;
import entity.ArchivoCliente;
import entity.ArchivoCompra;
import entity.ArchivoCuadro;
import entity.ArchivoEscultura;
import entity.ArchivoInstalacion;
import entity.Artista;
import entity.Clasificacion;
import entity.Cliente;
import entity.Compra;
import entity.Cuadro;
import entity.Escultura;
import entity.Instalacion;
import entity.Material;
import entity.Obra;

public class ControlGaleria {

	private GestionObras gestionProductos = new GestionObras();
	private GestionCliente gestionCliente = new GestionCliente();
	private HashMap<Long, Artista> listaArtistas = new HashMap<Long, Artista>();
	private ArrayList<Obra> listaObras = new ArrayList<>();
	private HashMap<Long, Cliente> listaClientes = new HashMap<Long, Cliente>();
	private ArrayList<Compra> compras = new ArrayList<>();
	public static ControlGaleria control;

	private ControlGaleria(){
//		this.gestionProductos.crearListas(listaArtistas, listaObras);
		leerArchivoObrasEsculturas();
		leerArchivoObrasInstalacion();
		leerArchivoObrasCuadro();
		leerArchivoClientes();
		leerArchivoArtistas();
//		this.gestionCliente.crearClientes(listaClientes);
	}

	public static ControlGaleria getInstance() {
		if(control == null) {
			control = new ControlGaleria();
		}
		return control;
	}
	
	public ArrayList<Escultura> tomarEsculturas(){
		ArrayList<Escultura> esculturas = new ArrayList<Escultura>();
		for(Obra actual: this.listaObras) {
			if(actual instanceof Escultura) {
				esculturas.add((Escultura) actual);
			}
		}
		return esculturas;
	}
	
	public ArrayList<Instalacion> tomarInstalaciones(){
		ArrayList<Instalacion> instalaciones = new ArrayList<Instalacion>();
		for(Obra actual: this.listaObras) {
			if(actual instanceof Instalacion) {
				instalaciones.add((Instalacion) actual);
			}
		}
		return instalaciones;
	}
	
	public ArrayList<Cuadro> tomarCuadros(){
		ArrayList<Cuadro> cuadros = new ArrayList<Cuadro>();
		for(Obra actual: this.listaObras) {
			if(actual instanceof Cuadro) {
				cuadros.add((Cuadro) actual);
			}
		}
		return cuadros;
	}
	
	

	public boolean persistirArchivoObrasEscultura() {
		ArchivoEscultura esculturas = new ArchivoEscultura(tomarEsculturas());
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("obrasEsculturas.xml"))){
			JAXB.marshal(esculturas, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Escultura> leerArchivoObrasEsculturas() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("obrasEsculturas.xml"))){
			ArchivoEscultura esculturas = JAXB.unmarshal(input, ArchivoEscultura.class);
			ArrayList<Escultura> esc = esculturas.getEsculturas();
			for(Escultura actual: esc) {
				this.listaObras.add(actual);
			}
			return esc;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	public boolean persistirArchivoObrasInstalacion() {
		ArchivoInstalacion instalaciones = new ArchivoInstalacion(tomarInstalaciones());
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("obrasInstalaciones.xml"))){
			JAXB.marshal(instalaciones, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean leerArchivoObrasInstalacion() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("obrasInstalaciones.xml"))){
			ArchivoInstalacion instalaciones = JAXB.unmarshal(input, ArchivoInstalacion.class);
			ArrayList<Instalacion> ins = instalaciones.getInstalaciones();
			for(Instalacion actual: ins) {
				this.listaObras.add(actual);
			}
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean persistirArchivoObrasCuadro() {
		ArchivoCuadro cuadros = new ArchivoCuadro(tomarCuadros());
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("obrasCuadros.xml"))){
			JAXB.marshal(cuadros, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean leerArchivoObrasCuadro() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("obrasCuadros.xml"))){
			ArchivoCuadro cuadros = JAXB.unmarshal(input, ArchivoCuadro.class);
			ArrayList<Cuadro> cua = cuadros.getCuadros();
			for(Cuadro actual: cua) {
				this.listaObras.add(actual);
			}
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean persistirArchivoClientes() {
		ArchivoCliente clientes = new ArchivoCliente(this.listaClientes);
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("clientes.xml"))){
			JAXB.marshal(clientes, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean leerArchivoClientes() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("clientes.xml"))){
			ArchivoCliente clientes = JAXB.unmarshal(input, ArchivoCliente.class);
			this.listaClientes = clientes.getClientes();
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean persistirArchivoArtistas() {
		ArchivoArtista artistas = new ArchivoArtista(this.listaArtistas);
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("artistas.xml"))){
			JAXB.marshal(artistas, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean leerArchivoArtistas() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("artistas.xml"))){
			ArchivoArtista artistas = JAXB.unmarshal(input, ArchivoArtista.class);
			this.listaArtistas = artistas.getArtistas();
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean persistirArchivoCompras() {
		ArchivoCompra compras = new ArchivoCompra(this.compras);
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("compras.xml"))){
			JAXB.marshal(compras, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean leerArchivoCompras() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("compras.xml"))){
			ArchivoCompra compras = JAXB.unmarshal(input, ArchivoCompra.class);
			this.compras = compras.getCompras();
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public boolean persistirArchivoComprasCuadro() {
		ArchivoCompra compras = new ArchivoCompra(verComprasCuadro());
		try(BufferedWriter output = Files.newBufferedWriter(Paths.get("comprasCuadro.xml"))){
			JAXB.marshal(compras, output);
			return true;
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Compra> leerArchivoComprasCuadro() {
		try(BufferedReader input = Files.newBufferedReader(Paths.get("comprasCuadro.xml"))){
			ArchivoCompra compras = JAXB.unmarshal(input, ArchivoCompra.class);
			return compras.getCompras();
		}
		catch(IOException ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	
	
	public Obra buscarObraTitulo(String p_titulo){
		Obra encontrado = null;

		for(Obra actual : listaObras){
			if(actual.getTitulo().equals(p_titulo)){
				encontrado = actual;
			}
		}
		return encontrado;
	}

	public Obra buscarObraPid(long p_pid){
		Obra encontrado = null;

		for(Obra actual : listaObras){
			if(actual.getPid() == p_pid){
				encontrado = actual;
			}
		}
		return encontrado;
	}

	public ArrayList<Obra> buscarObraArtista(long p_codigoArtista){
		for(Map.Entry<Long, Artista> actual : this.listaArtistas.entrySet()){
			if(actual.getValue().getCodigoArtista() == p_codigoArtista){
				return actual.getValue().getObras();
			}
		}
		return null;
	}

	public ArrayList<Obra> buscarObraAnio(int anio){
		ArrayList<Obra> encontrados = new ArrayList<Obra>();
		for(Obra actual : listaObras){
			if(actual.getFecha().get(Calendar.YEAR)==anio){
				encontrados.add(actual);
			}
		}
		return encontrados;
	}

	public ArrayList<Compra> comprasExistentesAnioYMes(int anio, int mes){
		ArrayList<Compra> existentes = new ArrayList<Compra>();
		for(Compra actual : this.compras){
			if(clienteObraAsociadaCompra(actual.getCompraCliente(), actual.getCompraObra()) == true) {
				if (actual.getFechaRecibido().get(Calendar.YEAR) == anio && actual.getFechaRecibido().get(Calendar.MONTH) == mes)
					existentes.add(actual);
			}
		}
		return existentes;
	}

	public Compra buscarCompra (long numero) {
		Compra encontrado = null;
		for(Compra actual: this.compras) {
			if(actual.getNumeroPedido() == numero) {
				encontrado = actual;
			}
		}
		return encontrado;
	}

	public void insertarEscultura(long p_pid, String p_titulo, Calendar p_fecha, double p_precioRef, String p_dimensiones, Artista artista, Material material, double peso){
		Obra nueva = new Escultura(p_pid, p_titulo, p_fecha, p_precioRef, p_dimensiones, material, peso);
		if(artista != null) {
			nueva.agregarArtista(artista);
			artista.agregarObra(nueva);	
		}
		this.listaObras.add(nueva);
	}

	public void insertarInstalacion(long p_pid, String p_titulo, Calendar p_fecha, double p_precioRef, String p_dimensiones, Artista artista, String descripcion){
		Obra nueva = new Instalacion(p_pid, p_titulo, p_fecha, p_precioRef, p_dimensiones, descripcion);
		if(artista != null) {
			nueva.agregarArtista(artista);
			artista.agregarObra(nueva);			
		}

		this.listaObras.add(nueva);
	}

	public void insertarCuadro(long p_pid, String p_titulo, Calendar p_fecha, double p_precioRef, String p_dimensiones, Artista artista, String tema, String tecnica, Clasificacion clasificacion){
		Obra nueva = new Cuadro(p_pid, p_titulo, p_fecha, p_precioRef, p_dimensiones, tema, tecnica, clasificacion);
		if(artista != null) {
			nueva.agregarArtista(artista);
			artista.agregarObra(nueva);			
		}

		this.listaObras.add(nueva);
	}

	public boolean eliminarObra(long p_pid){
		Obra encontrado = buscarObraPid(p_pid);
		if(encontrado!=null&&obraAsociadaCompra(encontrado)==false){
			listaObras.remove(encontrado);
			return true;
		}
		return false;
	}

	public boolean eliminarCliente(long p_codigo){
		Cliente encontrado = buscarCliente(p_codigo);
		if(encontrado != null && clienteAsociadaCompra(encontrado) == false){
			listaClientes.remove(encontrado.getCedula());
			return true;
		}
		return false;
	}

	public boolean eliminarCompra (long numero) {
		Compra encontrado = buscarCompra(numero);
		if(encontrado != null) {
			compras.remove(encontrado);
			return true;
		}
		return false;
	}

	public boolean obraAsociadaCompra(Obra obra){

		for(Compra actual: this.compras) {
			if(actual.getCompraObra().equals(obra)) {
				return true;
			}
		}
		return false;
	}

	public boolean clienteAsociadaCompra(Cliente cliente){
		for(Compra actual : this.compras) {
			if(actual.getCompraCliente().equals(cliente)) {
				return true;
			}
		}
		return false;
	}

	public boolean clienteObraAsociadaCompra (Cliente cliente, Obra obra) {
		for(Compra actual: this.compras) {
			if(actual.getCompraCliente().equals(cliente) && actual.getCompraObra().equals(obra)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<Obra> obrasDisponibles(){
		ArrayList<Obra> disponible = new ArrayList<Obra>();
		for(Obra actual : this.listaObras){
			if(obraAsociadaCompra(actual) == false) {
				disponible.add(actual);
			}
		}
		return disponible;
	}

	public ArrayList<Compra> comprasExistentes(){
		ArrayList<Compra> existentes = new ArrayList<Compra>();
		for(Compra actual : this.compras){
			if(clienteObraAsociadaCompra(actual.getCompraCliente(), actual.getCompraObra()) == true) {
				existentes.add(actual);
			}
		}
		return existentes;
	}

	public void insertarCliente(long p_codigo, long p_cedula, String p_nombres, String p_apellidos, String p_direccion, long telefono){
		Cliente nuevo = new Cliente(p_codigo, p_cedula, p_nombres, p_apellidos, p_direccion, telefono);
		this.listaClientes.put(p_cedula, nuevo);
	}

	public Artista insertarArtista(long codigo, long p_cedula, String p_nombre, String p_apellido, Calendar p_fechaNaci, long p_telefono){
		Artista nuevo = new Artista(codigo, p_cedula, p_nombre, p_apellido, p_fechaNaci, p_telefono);
		this.listaArtistas.put(p_cedula, nuevo);
		return nuevo;
	}

	public Artista buscarArtista(long p_codigoArtista){
		Artista encontrado = null;

		for(Map.Entry<Long, Artista> actual : this.listaArtistas.entrySet()){
			if(actual.getValue().getCodigoArtista() == p_codigoArtista){
				encontrado = actual.getValue();
			}
		}
		return encontrado;
	}

	public Cliente buscarCliente(long p_codigoCliente){
		Cliente encontrado = null;

		for(Map.Entry<Long, Cliente> actual : this.listaClientes.entrySet()){
			if(actual.getValue().getCodigoCliente() == p_codigoCliente){
				encontrado = actual.getValue();
			}
		}
		return encontrado;
	}

	public boolean realizarCompraObra (int anio, int mes, int dia, String nombreRepartidor, long codCliente, long pidObra) {
		Obra buscada = buscarObraPid(pidObra);
		Cliente buscado = buscarCliente(codCliente);
		if (buscada != null && buscado != null) {
			if (clienteObraAsociadaCompra(buscado, buscada) == false) {
				Compra nuevo = new Compra(new GregorianCalendar(anio, mes, dia), false, nombreRepartidor, buscado, buscada);
				this.compras.add(nuevo);
				return true; 
			}
		}
		return false;
	}

	public boolean modificarEscultura (Obra obra, String titulo, long pid, double precio, Calendar fecha, String dimensiones, Material material, double peso) {
		obra.setPid(pid);
		obra.setTitulo(titulo);
		obra.setDimensiones(dimensiones);
		obra.setFecha(fecha);
		obra.setPrecioRef(precio);
		((Escultura) obra).setMaterial(material);
		((Escultura) obra).setPeso(peso);
		return true;
	}

	public boolean modificarInstalacion (Obra obra, String titulo, long pid, double precio, Calendar fecha, String dimensiones, String descripcion) {
		obra.setPid(pid);
		obra.setTitulo(titulo);
		obra.setDimensiones(dimensiones);
		obra.setFecha(fecha);
		obra.setPrecioRef(precio);
		((Instalacion) obra).setDescripcion(descripcion);
		return true;
	}

	public boolean modificarCuadro (Obra obra, String titulo, long pid, double precio, Calendar fecha, String dimensiones, String tema, String tecnica, Clasificacion clasificacion) {
			obra.setPid(pid);
			obra.setTitulo(titulo);
			obra.setDimensiones(dimensiones);
			obra.setFecha(fecha);
			obra.setPrecioRef(precio);
			((Cuadro) obra).setTema(tema);
			((Cuadro) obra).setTecnica(tecnica);
			((Cuadro) obra).setClasificacion(clasificacion);
			return true;
	}

	public boolean modificarCliente (Cliente cliente, long codigo, long cedula, String nombres, String apellidos, String direccion, long telefono) {
		cliente.setCodigoCliente(codigo);
		cliente.setCedula(cedula);
		cliente.setNombres(nombres);
		cliente.setApellidos(apellidos);
		cliente.setDireccionEntrega(direccion);
		cliente.setTelefono(telefono);
		return true;
	}

	public int verCantArtistasPorCompra(Artista a) {
		int cont = 0;
		for(Compra actualC : this.compras) {
			if(actualC.getCompraObra().getArtistas().contains(a)) {
				cont++;
			}	
		}
		return cont;
	}

	public ArrayList<Artista> artistasMasVendidos (){

		ArrayList<Artista> vendidos = new ArrayList<Artista>();
		for(Map.Entry<Long, Artista> actual: this.listaArtistas.entrySet()) {
			vendidos.add(actual.getValue());
		}

		for(int i = 0; i<vendidos.size() -1; i++) {
			for (int j = i + 1; j<vendidos.size(); j++) {
				if(verCantArtistasPorCompra(vendidos.get(i)) < verCantArtistasPorCompra(vendidos.get(j))) {
					Artista aux = vendidos.get(i);
					vendidos.set(i, vendidos.get(j));
					vendidos.set(j, aux);
				}
			}
		}
		return vendidos;
	}

	public ArrayList<Obra> verEsculturas(){
		ArrayList<Obra> esculturas = new ArrayList<Obra>();
		for(Obra actual: this.listaObras) {
			if(actual instanceof Escultura) {
				esculturas.add(actual);
			}
		}
		return esculturas;
	}

	public ArrayList<Compra> verComprasCuadro(){
		ArrayList<Compra> comprasCuadro = new ArrayList<Compra>();
		for(Compra actual: this.compras) {
			if(actual.getCompraObra() instanceof Cuadro) {
				comprasCuadro.add(actual);
			}
		}
		return comprasCuadro;
	}

	public double gananciaTotal() {
		double gananciaTotal = 0;
		for(Obra actual : this.listaObras) {
			if(obraAsociadaCompra(actual)) {
				gananciaTotal += actual.calcularPrecio();
			}
		}
		return gananciaTotal;
	}
	
	public ArrayList<Cliente> convertClients(){
		ArrayList<Cliente> clients = new ArrayList<Cliente>();
		for(Map.Entry<Long, Cliente> actual: this.listaClientes.entrySet()) {
			clients.add(actual.getValue());
		}
		return clients;
	}
	
	public ArrayList<Artista> convertArtists(){
		ArrayList<Artista> artists = new ArrayList<Artista>();
		for(Map.Entry<Long, Artista> actual: this.listaArtistas.entrySet()) {
			artists.add(actual.getValue());
		}
		return artists;
	}

	public GestionObras getGestionProductos() {
		return gestionProductos;
	}

	public GestionCliente getGestionCliente() {
		return gestionCliente;
	}

	public HashMap<Long, Artista> getListaArtistas() {
		return listaArtistas;
	}

	public ArrayList<Obra> getListaObras() {
		return listaObras;
	}

	public HashMap<Long, Cliente> getListaClientes() {
		return listaClientes;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}
}