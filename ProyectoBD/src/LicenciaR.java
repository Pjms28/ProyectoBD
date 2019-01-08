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
	@FXML private TableColumn<Licencia, Long> tc1;
	@FXML private TableColumn<Licencia, String> tc2;
	@FXML private TableColumn<Licencia, String> tc3;
	@FXML private TableColumn<Licencia, String> tc4;
	@FXML private ComboBox<Integer> cbe;
	
	@FXML
	public void initialize(){
		tc1.setCellValueFactory(new PropertyValueFactory<Licencia, Long>("Licencia"));
		tc2.setCellValueFactory(new PropertyValueFactory<Licencia, String>("Descripcion"));
		tc3.setCellValueFactory(new PropertyValueFactory<Licencia, String>("Fecha inicio"));
		tc4.setCellValueFactory(new PropertyValueFactory<Licencia, String>("Fecha fin"));
		Lbo.mostrarLicencia(tableview);
		
	}
	
	@FXML
	public void Insertar(ActionEvent event) throws SQLException {
			li.setFecha_inicio(tffecha.getValue().toString());
			li.setFecha_fin(tffecha2.getValue().toString());
			li.setDescripcion(tf1.getText());
			li.setServicioID(cbe.getValue());
			mensaje = Lbo.agregarLicencia(li);
			System.out.println(mensaje);
			Lbo.mostrarLicencia(tableview);
	}
	
	@FXML
	public void Eliminar(ActionEvent event) throws SQLException {
		Lbo.eliminarLicencia(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getLicenciaID());
		Lbo.mostrarLicencia(tableview);
	}
	
	@FXML
	public void Modificar(ActionEvent event) throws SQLException, ParseException {
		li.setDescripcion(tf1.getText());
		li.setFecha_inicio(tffecha.getValue().toString());
		li.setFecha_fin(tffecha2.getValue().toString());
		li.setServicioID(cbe.getValue());
		li.setLicenciaID(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getLicenciaID());
		mensaje = Lbo.modificarLicencia(li);
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

}
