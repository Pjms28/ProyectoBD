import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class LicenciaR  {
	String mensaje = "";
	Licencia li = new Licencia();
	LicenciaBO Lbo = new LicenciaBO();
	@FXML private Label lb1;
	@FXML private Label lb2;
	@FXML private Label lb3;
	@FXML private Label lb4;
	@FXML private Label lb5;
	@FXML private DatePicker tffecha;
	@FXML private DatePicker tffecha2;
	@FXML private TextField tf1;
	@FXML public TableView<Licencia> tableview;
	@FXML private TableColumn<Licencia, Integer> tc1;
	@FXML private TableColumn<Licencia, String> tc2;
	@FXML private TableColumn<Licencia, String> tc3;
	@FXML private TableColumn<Licencia, String> tc4;
	@FXML private ComboBox<String> cbe;
	
	@FXML
	public void initialize(){
		tc1.setCellValueFactory(new PropertyValueFactory<Licencia, Integer>("LicenciaID"));
		tc2.setCellValueFactory(new PropertyValueFactory<Licencia, String>("Descripcion"));
		tc3.setCellValueFactory(new PropertyValueFactory<Licencia, String>("Fecha_inicio"));
		tc4.setCellValueFactory(new PropertyValueFactory<Licencia, String>("Fecha_fin"));
		Lbo.opciones(cbe);
		Lbo.mostrarLicencia(tableview);
		
	}
	
	@FXML
	public void Insertar(ActionEvent event) throws SQLException {
			li.setFecha_inicio(tffecha.getValue().toString());
			li.setFecha_fin(tffecha2.getValue().toString());
			li.setDescripcion(tf1.getText());
			li.setServicioID(Integer.valueOf(cbe.getValue()));
			mensaje = Lbo.agregarLicencia(li);
			System.out.println(mensaje);
			Lbo.mostrarLicencia(tableview);
	}
	
	@FXML
	public void Eliminar(ActionEvent event) throws SQLException {
		mensaje = Lbo.eliminarLicencia(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getLicenciaID());
		Lbo.mostrarLicencia(tableview);
		System.out.println(mensaje);
	}
	
	@FXML
	public void Modificar(ActionEvent event) throws SQLException, ParseException {
		li.setDescripcion(tf1.getText());
		li.setFecha_inicio(tffecha.getValue().toString());
		li.setFecha_fin(tffecha2.getValue().toString());
		li.setServicioID(Integer.valueOf(cbe.getValue()));
		li.setLicenciaID(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getLicenciaID());
		mensaje = Lbo.modificarLicencia(li);
		System.out.println(mensaje);
		Lbo.mostrarLicencia(tableview);
	}
	
	@FXML
	public void Limpiar(ActionEvent event) {
		 tffecha.setValue(null);;

		 tf1.clear();
		 tffecha.setValue(null);
		 tffecha2.setValue(null);
		 cbe.setValue(null);
		 tf1.setDisable(false);
		 tffecha.setDisable(false);
		 tffecha2.setDisable(false);
		 cbe.setDisable(false);

	}
	
	public void CambiarEscenaV(ActionEvent event) throws IOException{
		Parent VisitaView= FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		Scene VisitaEscena = new Scene (VisitaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(VisitaEscena);
		window.show();
		
			
		}
	
	public void Detalle() throws IOException{
		Stage stage = new Stage();
		FXMLLoader loader = new FXMLLoader();
		AnchorPane root = (AnchorPane)loader.load(getClass().getResource("LicenciaDetalle.fxml").openStream());
		DetalleLicencia dv = (DetalleLicencia)loader.getController();
		Lbo.detalle(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getLicenciaID(), dv.ta);
		Scene scene = new Scene(root);
		stage.setScene(scene);		
		stage.alwaysOnTopProperty();
		stage.initModality(Modality.APPLICATION_MODAL);
		stage.show();
		}

}
