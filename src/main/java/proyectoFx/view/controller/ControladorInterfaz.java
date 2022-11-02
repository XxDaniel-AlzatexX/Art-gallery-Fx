package proyectoFx.view.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import control.ControlGaleria;
import entity.Artista;
import entity.Clasificacion;
import entity.Cliente;
import entity.Compra;
import entity.Cuadro;
import entity.Escultura;
import entity.Material;
import entity.Obra;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import proyectoFx.utils.AlertUtils;
import proyectoFx.utils.ClienteYaExisteException;

public class ControladorInterfaz {

	private ControlGaleria controlador = ControlGaleria.getInstance();

	private final ObservableList<Obra> obras = FXCollections.observableArrayList();

	private final ObservableList<Compra> compras = FXCollections.observableArrayList();

	private final ObservableList<Cliente> clientes = FXCollections.observableArrayList();

	private final ObservableList<Artista> artistas = FXCollections.observableArrayList();
	
	private final ObservableList<Escultura> esculturas = FXCollections.observableArrayList();
	
	private final ObservableList<Compra> comprasDeCuadro = FXCollections.observableArrayList();

	@FXML
	private ImageView fondoObras;

	@FXML
	private ChoiceBox<String> busquedaO;

	@FXML
	private MenuItem mItemTitulo;

	@FXML
	private MenuItem mItemArtista;

	@FXML
	private MenuItem mItemAnio;

	@FXML
	private TextField busquedaObrasTexto;

	@FXML
	private Button busquedaObras;
	
	@FXML
    private TableColumn<Compra, Long> tableNumeroR1;
	
	@FXML
	private Pane paneInsertarObra;

	@FXML
	private TextField pidEscultura;

	@FXML
	private TextField tituloEscultura;

	@FXML
	private TextField precioEscultura;

	@FXML
	private TextField dimensionesEscultura;

	@FXML
	private TextField nombreMaterialEscultura;

	@FXML
	private DatePicker fechaEscultura;

	@FXML
	private TextField descripcionMaterialEscultura;

	@FXML
	private TextField pesoEscultura;

	@FXML
	private Button insertarEscultura;

	@FXML
	private TextField pidInstalacion;

	@FXML
	private TextField tituloInstalacion;

	@FXML
	private TextField precioInstalacion;

	@FXML
	private TextField dimensionesInstalacion;

	@FXML
	private TextField descripcionInstalacion;

	@FXML
	private DatePicker fechaInstalacion;

	@FXML
	private Button insertarInstalacion;

	@FXML
	private TextField pidCuadro;

	@FXML
	private TextField tituloCuadro;

	@FXML
	private TextField precioCuadro;

	@FXML
	private TextField dimensionesCuadro;

	@FXML
	private TextField temaCuadro;

	@FXML
	private DatePicker fechaCuadro;

	@FXML
	private TextField tecnicaCuadro;

	@FXML
	private Button insertarCuadro;

	@FXML
	private Label pidObra;

	@FXML
	private Label tituloObra;

	@FXML
	private Label fechaObra;

	@FXML
	private Label precioObra;

	@FXML
	private Label dimensionesObra;

	@FXML
	private Button modificarInstalacion;

	@FXML
	private Button modificarCuadro;

	@FXML
	private Button eliminarObra;

	@FXML
	private TableView<Obra> tableObras;

	@FXML
	private TableColumn<Obra, Long> tablePid;

	@FXML
	private TableColumn<Obra, String> tableTitulo;

	@FXML
	private TableColumn<Obra, Double> tablePrecio;

	@FXML
	private ImageView fondoArtistas;

	@FXML
	private Label codigoArtista;

	@FXML
	private Label cedulaArtista;

	@FXML
	private Label nombreArtista;

	@FXML
	private Label apellidosArtista;

	@FXML
	private Label fechaArtista;

	@FXML
	private Label telefonoArtista;

	@FXML
	private TableView<Artista> tableArtista;

	@FXML
	private TableColumn<Artista, Long> tableCodigoA;

	@FXML
	private TableColumn<Artista, Long> tableCedulaA;

	@FXML
	private TableColumn<Artista, String> tableNombresA;

	@FXML
	private TableColumn<Artista, String> tableApellidosA;

	@FXML
	private TableColumn<Artista, Calendar> tableFechaA;

	@FXML
	private ImageView fondoClientes;

	@FXML
	private TextField busquedaClientes;

	@FXML
	private Button busquedaClientesBoton;

	@FXML
	private TextField nombresCliente;

	@FXML
	private Label lCodigoCliente;

	@FXML
	private Label lCedulaCliente;

	@FXML
	private Label lNombresCliente;

	@FXML
	private Label lApellidosCliente;

	@FXML
	private Label lDireccionCliente;

	@FXML
	private Button modificarCliente;

	@FXML
	private Button eliminarCliente;

	@FXML
	private Label lTelefonoCliente;

	@FXML
	private TextField codigoCliente;

	@FXML
	private TextField cedulaCliente;

	@FXML
	private TextField apellidosCliente;

	@FXML
	private TextField direccionCliente;

	@FXML
	private TextField telefonoCliente;

	@FXML
	private Button insertarCliente;

	@FXML
	private TableView<Cliente> tableCliente;

	@FXML
	private TableColumn<Cliente, Long> tableCodigoC;

	@FXML
	private TableColumn<Cliente, Long> tableCedulaC;

	@FXML
	private TableColumn<Cliente, String> tableNombresC;

	@FXML
	private TableColumn<Cliente, String> tableApellidosC;

	@FXML
	private Button modificarEscultura;

	@FXML
	private ImageView fondoCompras;

	@FXML
	private Button busquedaCompraB;

	@FXML
	private TextField codigoClienteCompra;

	@FXML
	private DatePicker fechaCompra;

	@FXML
	private Label numeroPedido;

	@FXML
	private Label lfechaCompra;

	@FXML
	private Label lNombreRepartidor;

	@FXML
	private Label clienteCompra;

	@FXML
	private Label obraCompra;

	@FXML
	private Button eliminarCompra;

	@FXML
	private TextField nombreRepartidorCompra;

	@FXML
	private TextField pidObraCompra;

	@FXML
	private Button insertarCompra;

	@FXML
	private TextField busquedaCompra;

	@FXML
	private Label totalGanancias;

	@FXML
	private TableView<Compra> tableCompra;

	@FXML
	private TableColumn<Compra, Long> tableNumero;

	@FXML
	private TableColumn<Compra, Calendar> tableFecha;

	@FXML
	private TableColumn<Compra, Cliente> tableClienteCompra;

	@FXML
	private TableColumn<Compra, Obra> tableObraCompra;

	@FXML
	private ImageView fondoCompras1;

	@FXML
	private Button busquedaCompraB1;

	@FXML
	private Button verEsculturas;

	@FXML
	private Button comprasCuadro;

	@FXML
	private TableView<Compra> tableReporte;

	@FXML
	private TableColumn<Compra, Long> tableNumeroR;

	@FXML
	private TableColumn<Compra, Calendar> tableFechaR;

	@FXML
	private TableColumn<Compra, Cliente> tableClienteCompraR;

	@FXML
	private TableColumn<Compra, Obra> tableObraCompraR;

	@FXML
	private TableView<Escultura> tableVerEsculturas;

	@FXML
	private TableColumn<Escultura, String> tableTituloE;

	@FXML
	private TableColumn<Escultura, Double> tablePrecioE;

	@FXML
	private TableColumn<Escultura, Double> tablePesoE;

	@FXML
	private TableView<Compra> tableComprasCuadro;

	@FXML
	private TableColumn<Compra, Cliente> tableClienteR;

	@FXML
	private TextField mesCompra;

	@FXML
	private TableColumn<Compra, Cuadro> tableObraR;

	@FXML
	private ChoiceBox<Clasificacion> clasificacionCuadro;


	@FXML
	private TextField anioCompra;


	@FXML
	void buscarCliente(ActionEvent event) {
		if(busquedaClientes.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de busqueda");
			alert.setContentText("Se tiene que ingresar un dato correcto");
			alert.showAndWait();
		} else {
			long codigoBuscar = Long.parseLong(busquedaClientes.getText());
			Cliente clienteBuscado = controlador.buscarCliente(codigoBuscar);
			mostrarClientes(clienteBuscado);	
		}
	}

	@FXML
	void buscarCompra(ActionEvent event) {
		if(busquedaCompra.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de busqueda");
			alert.setContentText("Se tiene que ingresar un dato correcto");
			alert.showAndWait();
		} else {
			long numeroBuscar = Long.parseLong(busquedaCompra.getText());
			Compra compraBuscada = controlador.buscarCompra(numeroBuscar);
			mostrarCompras(compraBuscada);
		}
	}

	@FXML
	void buscarCompraR(ActionEvent event) {
		tableReporte.getItems().clear();
		compras.clear();
		if(anioCompra.getText().equals("") || mesCompra.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de busqueda");
			alert.setContentText("Se tiene que ingresar un dato correcto");
			alert.showAndWait();
		} else {
			int anio = Integer.parseInt(anioCompra.getText());
			int mes = Integer.parseInt(mesCompra.getText());
			ArrayList<Compra> comprasAnioMes = controlador.comprasExistentesAnioYMes(anio, mes);
			compras.addAll(comprasAnioMes);
			tableReporte.getItems().addAll(compras);
			
			anioCompra.setText("");
			mesCompra.setText("");
		}
	}

	@FXML
	void buscarObra(ActionEvent event) {
		String metodosBuscar = busquedaO.getValue();
		if(metodosBuscar.equals("Titulo")) {
			if(busquedaObrasTexto.getText().equals("")) {
				Alert alert = new Alert (AlertType.INFORMATION);
				alert.setTitle("Información");
				alert.setHeaderText("Error en la entrada de busqueda");
				alert.setContentText("Se tiene que ingresar un dato correcto");
				alert.showAndWait();
			} else {
				String tituloBuscar = busquedaObrasTexto.getText();
				Obra obraBuscada = controlador.buscarObraTitulo(tituloBuscar);
				mostrarObras(obraBuscada);	
				
				busquedaObrasTexto.setText("");
			}
		} else if(metodosBuscar.equals("Año")) {
			tableObras.getItems().clear();
			obras.clear();
			if(busquedaObrasTexto.getText().equals("") ) {
				Alert alert = new Alert (AlertType.INFORMATION);
				alert.setTitle("Información");
				alert.setHeaderText("Error en la entrada de busqueda");
				alert.setContentText("Se tiene que ingresar un dato correcto");
				alert.showAndWait();
			} else {
				int anio = Integer.parseInt(busquedaObrasTexto.getText());
				ArrayList<Obra> obrasAnio = controlador.buscarObraAnio(anio);
				obras.setAll(obrasAnio);
				tableObras.getItems().setAll(obras);
				
				busquedaObrasTexto.setText("");
			}
		} else {
			tableObras.getItems().clear();
			obras.clear();
			if(busquedaObrasTexto.getText().equals("") ) {
				Alert alert = new Alert (AlertType.INFORMATION);
				alert.setTitle("Información");
				alert.setHeaderText("Error en la entrada de busqueda");
				alert.setContentText("Se tiene que ingresar un dato correcto");
				alert.showAndWait();
			} else {
				long codigoArtista = Long.parseLong(busquedaObrasTexto.getText());
				ArrayList<Obra> obrasArtista = controlador.buscarObraArtista(codigoArtista);
				obras.setAll(obrasArtista);
				tableObras.getItems().setAll(obras);
				
				busquedaObrasTexto.setText("");
			}
		}
	}

	@FXML
	void comprasCuadro(ActionEvent event) {
		comprasDeCuadro.clear();
		comprasDeCuadro.addAll(controlador.verComprasCuadro());
		tableComprasCuadro.setItems(comprasDeCuadro);
	}

	@FXML
	void eliminarCliente(ActionEvent event) {
		Long codigoABorrar = tableCliente.getSelectionModel().getSelectedItem().getCodigoCliente();
		Optional<ButtonType> opcion = AlertUtils.alertConfirmation("Borrar un cliente", "", String.format("Esta seguro que quiere borrar el cliente", codigoABorrar));
		if(opcion.get().equals(ButtonType.OK)){
			this.controlador.eliminarCliente(codigoABorrar);
			clientes.setAll(controlador.convertClients());
		}else {
			System.out.println("No se pudo eliminar el cliente");
		}
	}

	@FXML
	void eliminarCompra(ActionEvent event) {
		Long numeroABorrar = tableCompra.getSelectionModel().getSelectedItem().getNumeroPedido();
		Optional<ButtonType> opcion = AlertUtils.alertConfirmation("Borrar una compra", "", String.format("Esta seguro que quiere borrar la compra", numeroABorrar));
		if(opcion.get().equals(ButtonType.OK)){
			this.controlador.eliminarCompra(numeroABorrar);
			compras.setAll(controlador.getCompras());
		}else {
			System.out.println("No se pudo eliminar la compra");
		}
	}

	@FXML
	void eliminarObra(ActionEvent event) {
		Long pidABorrar = tableObras.getSelectionModel().getSelectedItem().getPid();
		Optional<ButtonType> opcion = AlertUtils.alertConfirmation("Borrar una obra", "", String.format("Esta seguro que quiere borrar la obra", pidABorrar));
		if(opcion.get().equals(ButtonType.OK)){
			this.controlador.eliminarObra(pidABorrar);
			obras.setAll(controlador.getListaObras());
		}else {
			System.out.println("No se pudo eliminar la obra");
		}
	}

	@FXML
	void insertarCliente(ActionEvent event) {
		if(codigoCliente.getText().equals("") || cedulaCliente.getText().equals("") || 
				nombresCliente.getText().equals("") || apellidosCliente.getText().equals("") ||
				direccionCliente.getText().equals("") || telefonoCliente.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de datos");
			alert.setContentText("Los elementos: codigo, cedula, nombres, apellido, direccion y telefono"
					+ "son obligatorias");
			alert.showAndWait();
		} else {
			long codigo = Long.parseLong(codigoCliente.getText());
			long cedula = Long.parseLong(cedulaCliente.getText());
			String nombres = nombresCliente.getText();
			String apellidos = apellidosCliente.getText();
			String direccion = direccionCliente.getText();
			long telefono = Long.parseLong(telefonoCliente.getText());

			controlador.insertarCliente(codigo, cedula, nombres, apellidos, direccion, telefono);
			clientes.setAll(controlador.convertClients());

			codigoCliente.setText("");
			cedulaCliente.setText("");
			nombresCliente.setText("");
			apellidosCliente.setText("");
			direccionCliente.setText("");
			telefonoCliente.setText("");
		}
	}

	@FXML
	void insertarCompra(ActionEvent event) {
		if(fechaCompra.getValue().equals("") || nombreRepartidorCompra.getText().equals("") || 
				codigoClienteCompra.getText().equals("") || pidObraCompra.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de datos");
			alert.setContentText("Todos los campos de texto deben ser llenados");
			alert.showAndWait();
		} else {
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaCompra.getValue().getYear(), fechaCompra.getValue().getMonthValue() -1,
					fechaCompra.getValue().getDayOfMonth());
			String nombreRepartidor = nombreRepartidorCompra.getText();
			long codigoCliente = Long.parseLong(codigoClienteCompra.getText());
			long pidObra = Long.parseLong(pidObraCompra.getText());

			controlador.realizarCompraObra(fecha.get(Calendar.YEAR), 
					fecha.get(Calendar.MONTH), fecha.get(Calendar.DAY_OF_MONTH), 
					nombreRepartidor, codigoCliente, pidObra);
			compras.setAll(controlador.getCompras());

			fechaCompra.setValue(null);
			nombreRepartidorCompra.setText("");
			codigoClienteCompra.setText("");
			pidObraCompra.setText("");
		}
	}

	@FXML
	void insertarCuadro(ActionEvent event) {
		if(pidCuadro.getText().equals("") || tituloCuadro.getText().equals("") || 
				fechaCuadro.getValue().equals("") || precioCuadro.getText().equals("") ||
				dimensionesCuadro.getText().equals("") || temaCuadro.getText().equals("")
				|| tecnicaCuadro.getText().equals("") || clasificacionCuadro.getValue().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de datos");
			alert.setContentText("Todos los campos de texto deben ser llenados");
			alert.showAndWait();
		} else {
			long pid = Long.parseLong(pidCuadro.getText());
			String titulo = tituloCuadro.getText();
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaCuadro.getValue().getYear(), fechaCuadro.getValue().getMonthValue() -1,
					fechaCuadro.getValue().getDayOfMonth());
			double precio = Double.parseDouble(precioCuadro.getText());
			String dimensiones = dimensionesCuadro.getText();
			String temaC = temaCuadro.getText();
			String tecnicaC = tecnicaCuadro.getText();
			Clasificacion clasificacion  = (Clasificacion) clasificacionCuadro.getValue();

			controlador.insertarCuadro(pid, titulo, fecha, precio, dimensiones, null, temaC, tecnicaC, clasificacion);
			obras.setAll(controlador.getListaObras());
			pidCuadro.setText("");
			tituloCuadro.setText("");
			fechaCuadro.setValue(null);
			precioCuadro.setText("");
			dimensionesCuadro.setText("");
			temaCuadro.setText("");
			tecnicaCuadro.setText("");
			clasificacionCuadro.setValue(null);
		}
	}

	@FXML
	void insertarEscultura(ActionEvent event) {
		if(pidEscultura.getText().equals("") || tituloEscultura.getText().equals("") || 
				fechaEscultura.getValue().equals("") || precioEscultura.getText().equals("") ||
				dimensionesEscultura.getText().equals("") || nombreMaterialEscultura.getText().equals("")
				|| descripcionMaterialEscultura.getText().equals("") || pesoEscultura.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de datos");
			alert.setContentText("Todos los campos de texto deben ser llenados");
			alert.showAndWait();
		} else {
			long pid = Long.parseLong(pidEscultura.getText());
			String titulo = tituloEscultura.getText();
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaEscultura.getValue().getYear(), fechaEscultura.getValue().getMonthValue() -1,
					fechaEscultura.getValue().getDayOfMonth());
			double precio = Double.parseDouble(precioEscultura.getText());
			String dimensiones = dimensionesEscultura.getText();
			String nombreM = nombreMaterialEscultura.getText();
			String descripcionM = descripcionMaterialEscultura.getText();
			double peso = Double.parseDouble(pesoEscultura.getText());

			controlador.insertarEscultura(pid, titulo, fecha, precio, dimensiones, null, 
					new Material(nombreM, descripcionM), peso);
			obras.setAll(controlador.getListaObras());
			pidEscultura.setText("");
			tituloEscultura.setText("");
			fechaEscultura.setValue(null);
			precioEscultura.setText("");
			dimensionesEscultura.setText("");
			nombreMaterialEscultura.setText("");
			descripcionMaterialEscultura.setText("");
			pesoEscultura.setText("");
		}
	}

	@FXML
	void insertarInstalacion(ActionEvent event) {
		if(pidInstalacion.getText().equals("") || tituloInstalacion.getText().equals("") || 
				fechaInstalacion.getValue().equals("") || precioInstalacion.getText().equals("") ||
				dimensionesInstalacion.getText().equals("") || descripcionInstalacion.getText().equals("")) {
			Alert alert = new Alert (AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error en la entrada de datos");
			alert.setContentText("Todos los campos de texto deben ser llenados");
			alert.showAndWait();
		} else {
			long pid = Long.parseLong(pidInstalacion.getText());
			String titulo = tituloInstalacion.getText();
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaInstalacion.getValue().getYear(), fechaInstalacion.getValue().getMonthValue() -1,
					fechaInstalacion.getValue().getDayOfMonth());
			double precio = Double.parseDouble(precioInstalacion.getText());
			String dimensiones = dimensionesInstalacion.getText();
			String descripcionI = descripcionInstalacion.getText();

			controlador.insertarInstalacion(pid, titulo, fecha, precio, dimensiones, null, descripcionI);
			obras.setAll(controlador.getListaObras());

			pidInstalacion.setText("");
			tituloInstalacion.setText("");
			fechaInstalacion.setValue(null);
			precioInstalacion.setText("");
			dimensionesInstalacion.setText("");
			descripcionInstalacion.setText("");

		}
	}

	@FXML
	void modificarCliente(ActionEvent event) {
		int selectedIndex = tableCliente.getSelectionModel().selectedIndexProperty().get();
		if(selectedIndex == -1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error al seleccionar el cliente");
			alert.setContentText("Para modificar usted debe seleccionar un cliente de la lista");
			alert.showAndWait();
		} else {
			Cliente cliente = tableCliente.getSelectionModel().getSelectedItem();
			long codigo = Long.parseLong(codigoCliente.getText());
			long cedula = Long.parseLong(cedulaCliente.getText());
			String nombres = nombresCliente.getText();
			String apellidos = apellidosCliente.getText();
			String direccion = direccionCliente.getText();
			long telefono = Long.parseLong(telefonoCliente.getText());

			controlador.modificarCliente(cliente, codigo, cedula, nombres, apellidos, direccion, telefono);
			clientes.setAll(controlador.convertClients());

			codigoCliente.setText("");
			cedulaCliente.setText("");
			nombresCliente.setText("");
			apellidosCliente.setText("");
			direccionCliente.setText("");
			telefonoCliente.setText("");
		}
	}

	@FXML
	void modificarCuadro(ActionEvent event) {
		int selectedIndex = tableObras.getSelectionModel().selectedIndexProperty().get();
		if(selectedIndex == -1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error al seleccionar la obra");
			alert.setContentText("Para modificar usted debe seleccionar una obra de la lista");
			alert.showAndWait();
		} else {
			Obra obra = tableObras.getSelectionModel().getSelectedItem();
			long pid = Long.parseLong(pidCuadro.getText());
			String titulo = tituloCuadro.getText();
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaCuadro.getValue().getYear(), fechaCuadro.getValue().getMonthValue() -1,
					fechaCuadro.getValue().getDayOfMonth());
			double precio = Double.parseDouble(precioCuadro.getText());
			String dimensiones = dimensionesCuadro.getText();
			String temaC = temaCuadro.getText();
			String tecnicaC = tecnicaCuadro.getText();
			Clasificacion clasificacion  = (Clasificacion) clasificacionCuadro.getValue();
			controlador.modificarCuadro(obra, titulo, pid, precio, fecha, dimensiones, temaC, tecnicaC, clasificacion);
			obras.setAll(controlador.getListaObras());

			pidCuadro.setText("");
			tituloCuadro.setText("");
			fechaCuadro.setValue(null);
			precioCuadro.setText("");
			dimensionesCuadro.setText("");
			temaCuadro.setText("");
			tecnicaCuadro.setText("");
			clasificacionCuadro.setValue(null);

		}
	}

	@FXML
	void modificarEscultura(ActionEvent event) {
		int selectedIndex = tableObras.getSelectionModel().selectedIndexProperty().get();
		if(selectedIndex == -1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error al seleccionar la obra");
			alert.setContentText("Para modificar usted debe seleccionar una obra de la lista");
			alert.showAndWait();
		} else {
			Obra obra = tableObras.getSelectionModel().getSelectedItem();
			long pid = Long.parseLong(pidEscultura.getText());
			String titulo = tituloEscultura.getText();
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaEscultura.getValue().getYear(), fechaEscultura.getValue().getMonthValue() -1,
					fechaEscultura.getValue().getDayOfMonth());
			double precio = Double.parseDouble(precioEscultura.getText());
			String dimensiones = dimensionesEscultura.getText();
			String nombreM = nombreMaterialEscultura.getText();
			String descripcionM = descripcionMaterialEscultura.getText();
			double peso = Double.parseDouble(pesoEscultura.getText());
			controlador.modificarEscultura(obra, titulo, pid, precio, fecha, dimensiones, 
					new Material(nombreM, descripcionM), peso);
			obras.setAll(controlador.getListaObras());

			pidEscultura.setText("");
			tituloEscultura.setText("");
			fechaEscultura.setValue(null);
			precioEscultura.setText("");
			dimensionesEscultura.setText("");
			nombreMaterialEscultura.setText("");
			descripcionMaterialEscultura.setText("");
			pesoEscultura.setText("");
		}
	}

	@FXML
	void modificarInstalacion(ActionEvent event) {
		int selectedIndex = tableObras.getSelectionModel().selectedIndexProperty().get();
		if(selectedIndex == -1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Información");
			alert.setHeaderText("Error al seleccionar la obra");
			alert.setContentText("Para modificar usted debe seleccionar una obra de la lista");
			alert.showAndWait();
		} else {
			Obra obra = tableObras.getSelectionModel().getSelectedItem();
			long pid = Long.parseLong(pidInstalacion.getText());
			String titulo = tituloInstalacion.getText();
			Calendar fecha = Calendar.getInstance();
			fecha.set(fechaInstalacion.getValue().getYear(), fechaInstalacion.getValue().getMonthValue() -1,
					fechaInstalacion.getValue().getDayOfMonth());
			double precio = Double.parseDouble(precioInstalacion.getText());
			String dimensiones = dimensionesInstalacion.getText();
			String descripcionI = descripcionInstalacion.getText();

			controlador.modificarInstalacion(obra, titulo, pid, precio, fecha, dimensiones, descripcionI);
			obras.setAll(controlador.getListaObras());

			pidInstalacion.setText("");
			tituloInstalacion.setText("");
			fechaInstalacion.setValue(null);
			precioInstalacion.setText("");
			dimensionesInstalacion.setText("");
			descripcionInstalacion.setText("");
		}
	}

	@FXML
	void verEsculturas(ActionEvent event) {
		esculturas.clear();
		esculturas.setAll(controlador.tomarEsculturas());
		tableVerEsculturas.setItems(esculturas);
	}

	@FXML
	public void initialize() {

		clasificacionCuadro.getItems().add(Clasificacion.OBRA_MAESTRA);
		clasificacionCuadro.getItems().add(Clasificacion.OBRA_REPRESENTATIVA);

		busquedaO.getItems().add("Titulo");
		busquedaO.getItems().add("Año");
		busquedaO.getItems().add("Artista");

		configureTableObra();
		configureTableCliente();
		configureTableCompra();
		configureTableArtista();
		configureTableReporte();
		configureTableReporteEsculturas();
		configureTableComprasCuadro();

		obras.setAll(controlador.getListaObras());
		tableObras.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarObras(newValue));
		tableObras.setItems(obras);

		clientes.setAll(controlador.convertClients());
		tableCliente.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarClientes(newValue));
		tableCliente.setItems(clientes);

		compras.setAll(controlador.getCompras());
		tableCompra.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarCompras(newValue));
		tableCompra.setItems(compras);
		tableReporte.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarCompras(newValue));
		tableReporte.setItems(compras);

		artistas.setAll(controlador.convertArtists());
		tableArtista.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> mostrarArtistas(newValue));
		tableArtista.setItems(artistas);
	}

	private void mostrarObras(Obra obra) {

		if(obra != null) {
			pidObra.setText(String.valueOf(obra.getPid()));
			tituloObra.setText(String.valueOf(obra.getTitulo()));
			fechaObra.setText(obra.getFecha().getTime().toString());
			precioObra.setText(String.valueOf(obra.getPrecioRef()));
			dimensionesObra.setText(obra.getDimensiones());
		} else {
			pidObra.setText("");
			tituloObra.setText("");
			fechaObra.setText("");
			precioObra.setText("");
			dimensionesObra.setText("");			
		}

	}

	private void mostrarClientes(Cliente cliente) {
		if(cliente != null) {
			lCodigoCliente.setText(String.valueOf(cliente.getCodigoCliente()));
			lCedulaCliente.setText(String.valueOf(cliente.getCedula()));
			lNombresCliente.setText(String.valueOf(cliente.getNombres()));
			lApellidosCliente.setText(String.valueOf(cliente.getApellidos()));
			lDireccionCliente.setText(String.valueOf(cliente.getDireccionEntrega()));
			lTelefonoCliente.setText(String.valueOf(cliente.getTelefono()));
		} else {
			lCodigoCliente.setText("");
			lCedulaCliente.setText("");
			lNombresCliente.setText("");
			lApellidosCliente.setText("");
			lDireccionCliente.setText("");
			lTelefonoCliente.setText("");
		}
	}

	private void mostrarCompras(Compra compra) {
		if(compra != null) {
			numeroPedido.setText(String.valueOf(compra.getNumeroPedido()));
			lfechaCompra.setText(String.valueOf(compra.getFechaRecibido()));
			lNombreRepartidor.setText(String.valueOf(compra.getNombreRepartidor()));
			clienteCompra.setText(String.valueOf(compra.getCompraCliente().getCodigoCliente()));
			obraCompra.setText(String.valueOf(compra.getCompraObra().getPid()));
		} else {
			numeroPedido.setText("");
			lfechaCompra.setText("");
			lNombreRepartidor.setText("");
			clienteCompra.setText("");
			obraCompra.setText("");
		}
	}

	private void mostrarArtistas(Artista artista) {
		if(artista != null) {
			codigoArtista.setText(String.valueOf(artista.getCodigoArtista()));
			cedulaArtista.setText(String.valueOf(artista.getCedula()));
			nombreArtista.setText(String.valueOf(artista.getNombres()));
			apellidosArtista.setText(String.valueOf(artista.getApellidos()));
			fechaArtista.setText(String.valueOf(artista.getFechaDeNacimiento()));
			telefonoArtista.setText(String.valueOf(artista.getTelefono()));
		} else {
			codigoArtista.setText("");
			cedulaArtista.setText("");
			nombreArtista.setText("");
			apellidosArtista.setText("");
			fechaArtista.setText("");
			telefonoArtista.setText("");
		}
	}

	private void configureTableObra() {
		PropertyValueFactory<Obra, Long> idProperty = new PropertyValueFactory<Obra, Long>("pid");
		tablePid.setCellValueFactory(idProperty);

		PropertyValueFactory<Obra, String> tituloProperty = new PropertyValueFactory<Obra, String>("titulo");
		tableTitulo.setCellValueFactory(tituloProperty);    	

		PropertyValueFactory<Obra, Double> precioProperty = new PropertyValueFactory<Obra, Double>("precioRef");
		tablePrecio.setCellValueFactory(precioProperty);
	}

	private void configureTableCliente() {
		PropertyValueFactory<Cliente, Long> codigoProperty = new PropertyValueFactory<Cliente, Long>("codigoCliente");
		tableCodigoC.setCellValueFactory(codigoProperty);

		PropertyValueFactory<Cliente, Long> cedulaProperty = new PropertyValueFactory<Cliente, Long>("cedula");
		tableCedulaC.setCellValueFactory(cedulaProperty);

		PropertyValueFactory<Cliente, String> nombresProperty = new PropertyValueFactory<Cliente, String>("nombres");
		tableNombresC.setCellValueFactory(nombresProperty);

		PropertyValueFactory<Cliente, String> apellidosProperty = new PropertyValueFactory<Cliente, String>("apellidos");
		tableApellidosC.setCellValueFactory(apellidosProperty);
	}

	private void configureTableArtista() {
		PropertyValueFactory<Artista, Long> codigoProperty = new PropertyValueFactory<Artista, Long>("codigoArtista");
		tableCodigoA.setCellValueFactory(codigoProperty);

		PropertyValueFactory<Artista, Long> cedulaProperty = new PropertyValueFactory<Artista, Long>("cedula");
		tableCedulaA.setCellValueFactory(cedulaProperty);

		PropertyValueFactory<Artista, String> nombresProperty = new PropertyValueFactory<Artista, String>("nombres");
		tableNombresA.setCellValueFactory(nombresProperty);

		PropertyValueFactory<Artista, String> apellidosProperty = new PropertyValueFactory<Artista, String>("apellidos");
		tableApellidosA.setCellValueFactory(apellidosProperty);

		PropertyValueFactory<Artista, Calendar> fechaProperty = new PropertyValueFactory<Artista, Calendar>("fechaDeNacimiento");
		tableFechaA.setCellValueFactory(fechaProperty);
	}

	private void configureTableCompra() {
		PropertyValueFactory<Compra, Long> numeroProperty = new PropertyValueFactory<Compra, Long>("numeroPedido");
		tableNumero.setCellValueFactory(numeroProperty);

		PropertyValueFactory<Compra, Calendar> fechaProperty = new PropertyValueFactory<Compra, Calendar>("fechaRecibido");
		tableFecha.setCellValueFactory(fechaProperty);

		PropertyValueFactory<Compra, Cliente> clienteProperty = new PropertyValueFactory<Compra, Cliente>("compraCliente");
		tableClienteCompra.setCellValueFactory(clienteProperty);

		PropertyValueFactory<Compra, Obra> obraProperty = new PropertyValueFactory<Compra, Obra>("compraObra");
		tableObraCompra.setCellValueFactory(obraProperty);
	}

	private void configureTableReporte(){
		PropertyValueFactory<Compra, Long> numeroProperty = new PropertyValueFactory<Compra, Long>("numeroPedido");
		tableNumeroR.setCellValueFactory(numeroProperty);

		PropertyValueFactory<Compra, Calendar> fechaProperty = new PropertyValueFactory<Compra, Calendar>("fechaRecibido");
		tableFechaR.setCellValueFactory(fechaProperty);

		PropertyValueFactory<Compra, Cliente> clienteProperty = new PropertyValueFactory<Compra, Cliente>("compraCliente");
		tableClienteCompraR.setCellValueFactory(clienteProperty);

		PropertyValueFactory<Compra, Obra> obraProperty = new PropertyValueFactory<Compra, Obra>("compraObra");
		tableObraCompraR.setCellValueFactory(obraProperty);
	}
	
	private void configureTableComprasCuadro(){
		PropertyValueFactory<Compra, Long> numeroProperty = new PropertyValueFactory<Compra, Long>("numeroPedido");
		tableNumeroR1.setCellValueFactory(numeroProperty);

		PropertyValueFactory<Compra, Cliente> clienteProperty = new PropertyValueFactory<Compra, Cliente>("compraCliente");
		tableClienteR.setCellValueFactory(clienteProperty);

		PropertyValueFactory<Compra, Cuadro> obraProperty = new PropertyValueFactory<Compra, Cuadro>("compraObra");
		tableObraR.setCellValueFactory(obraProperty);
	}
	
	private void configureTableReporteEsculturas(){
		PropertyValueFactory<Escultura, String> tituloProperty = new PropertyValueFactory<Escultura, String>("titulo");
		tableTituloE.setCellValueFactory(tituloProperty);

		PropertyValueFactory<Escultura, Double> precioProperty = new PropertyValueFactory<Escultura, Double>("precioRef");
		tablePrecioE.setCellValueFactory(precioProperty);

		PropertyValueFactory<Escultura, Double> pesoProperty = new PropertyValueFactory<Escultura, Double>("peso");
		tablePesoE.setCellValueFactory(pesoProperty);
	}
}