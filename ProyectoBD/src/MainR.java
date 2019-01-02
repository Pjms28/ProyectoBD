import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class MainR {

	String mensaje = "";
	Visita vis = new Visita();
	VisitaBO Vbo = new VisitaBO();
	@FXML private RadioButton rb1;
	@FXML private RadioButton rb2;
	@FXML private Label lb1;
	@FXML private Label lb2;
	@FXML private Label lb3;
	@FXML private Label lb4;
	@FXML private Label lb5;
	@FXML private Label lb6;
	@FXML private Label lb7;
	@FXML private Label lb8;
	@FXML private Label lb9;
	@FXML private DatePicker tffecha;
	@FXML private TextField tfhora;
	@FXML private TextField tf1;
	@FXML private TextField tf2;
	@FXML private TextField tf3;
	@FXML private TextField tf4;
	@FXML private TextField tf5;
	@FXML private TextField tf9;
	@FXML private TableView<Visita> tableview;
	@FXML private TableColumn<Visita, Integer> tc1;
	@FXML private TableColumn<Visita, String> tc2;
	@FXML private TableColumn<Visita, String> tc3;
	@FXML private TableColumn<Visita, String> tc4;	
	
	
	@FXML
	public void initialize(){
		tc1.setCellValueFactory(new PropertyValueFactory<Visita, Integer>("Numero de visita"));
		tc2.setCellValueFactory(new PropertyValueFactory<Visita, String>("Fecha"));
		tc3.setCellValueFactory(new PropertyValueFactory<Visita, String>("Hora"));
		tc4.setCellValueFactory(new PropertyValueFactory<Visita, String>("Tipo visita"));
		Vbo.mostrarVisita(tableview);
	}
	
		
	
	
	public void radioSelect (ActionEvent event) {
		
		if(rb1.isSelected()) {
			lb8.setDisable(true);
			tf1.setDisable(true);
			lb4.setDisable(false);
			tf2.setDisable(false);
			lb6.setDisable(false);
			tf4.setDisable(false);
		}
		else if(rb2.isSelected()) {
			lb8.setDisable(false);
			tf1.setDisable(false);
			lb4.setDisable(true);
			tf2.setDisable(true);
			lb6.setDisable(true);
			tf4.setDisable(true);
		}
		

	}
	
	@FXML
	public void Insertar(ActionEvent event) throws SQLException {
		if(rb1.isSelected()) {
			vis.setTipoVisita(rb1.getText());
			vis.setTipoConsulta(tf2.getText());
			vis.setSintomas(tf4.getText());
			
		}
		else {
			vis.setTipoVisita(rb2.getText());
			vis.setNumeroCamilla(Integer.parseInt(tf1.getText()));
		}
		String date = "2-01-2018";
		vis.setFecha(tffecha.getValue().toString());
		System.out.println(vis.getFecha());
		vis.setHora(tfhora.getText());
		vis.setEnfermedad(tf3.getText());
		vis.setDescripcion(tf5.getText());
		vis.setAdmisionID(Integer.parseInt(tf9.getText()));
		mensaje = Vbo.agregarVisita(vis);
		System.out.println(mensaje);
		Vbo.mostrarVisita(tableview);
	}
	
	@FXML
	public void Eliminar(ActionEvent event) throws SQLException {
		Vbo.eliminarVisita(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getServicioID());
		Vbo.mostrarVisita(tableview);
	}
	
	@FXML
	public void Modificar(ActionEvent event) {
		
	}
	
	@FXML
	public void Limpiar(ActionEvent event) {
		 tffecha.setValue(null);;
		 tfhora.clear();
		 tf1.clear();
		 tf2.clear();
		 tf3.clear();
		 tf4.clear();
		 tf5.clear();
		 tf9.clear();
		 rb1.setSelected(false);
		 rb2.setSelected(false);;
	}
	
public void CambiarEscenaL(ActionEvent event) throws IOException{
	Parent LicenciaView= FXMLLoader.load(getClass().getClassLoader().getResource("Licencia.fxml"));
	Scene LicenciaEscena = new Scene (LicenciaView);
	Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
	
	window.setScene(LicenciaEscena);
	window.show();	
	}

public void CambiarEscenaR(ActionEvent event) throws IOException{
	Parent LicenciaView= FXMLLoader.load(getClass().getClassLoader().getResource("Receta.fxml"));
	Scene LicenciaEscena = new Scene (LicenciaView);
	Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
	
	window.setScene(LicenciaEscena);
	window.show();
	
		
	}

	

}
