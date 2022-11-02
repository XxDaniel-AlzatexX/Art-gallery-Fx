package proyectoFx.view;

import control.ControlGaleria;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class VentanaPrincipal extends Application {
    private final static String ICON_NAME = "team.png";
    private final static String MAIN_FXML_NAME = "interfaz proyecto final.fxml";
    private final static String STYLE_SHEET_NAME = "styles.css";
    private final static String WINDOW_NAME = "Galeria de Arte";

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource(MAIN_FXML_NAME));
        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource(STYLE_SHEET_NAME).toExternalForm());
        stage.getIcons().add(new Image(getClass().getResourceAsStream(ICON_NAME)));
        stage.setTitle(WINDOW_NAME);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        	public void handle(WindowEvent window) {
        		ControlGaleria control = ControlGaleria.getInstance();
        		control.persistirArchivoObrasEscultura();
        		control.persistirArchivoObrasInstalacion();
        		control.persistirArchivoObrasCuadro();
        		control.persistirArchivoClientes();
        		control.persistirArchivoArtistas();
        		control.persistirArchivoCompras();
        		control.persistirArchivoComprasCuadro();
        	}
        });
    }

    public static void main(String[] args) {
        launch();
    }

}