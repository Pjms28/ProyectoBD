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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class RecetaR {
	
	String mensaje = "";
	Receta rec=new Receta();
	RecetaMedicina recm=new RecetaMedicina();
	RecetaAnalisis reca=new RecetaAnalisis();
	RecetaBO Rbo = new RecetaBO();
	@FXML private DatePicker tffecha;
	@FXML private TableView<Receta> tableview;
	@FXML private Label lbr1;
	@FXML private Label lbr2;
	@FXML private Label lbr3;
	@FXML private Label lbr4;
	@FXML private TextField tfr1;
	@FXML private TextField tfr2;
	@FXML private TextField tfr3;
	@FXML private RadioButton rbr1;
	@FXML private RadioButton rbr2;
	@FXML private TableColumn<Receta, Integer> tc1;
	@FXML private TableColumn<Receta, Integer> tc2;
	@FXML private TableColumn<Receta, String> tc3;
	@FXML private TableColumn<Receta, String> tc4;
	@FXML private TableColumn<Receta, String> tc5;
	@FXML private ComboBox<Integer> cbe;
	
	@FXML
	public void initialize(){
		tc1.setCellValueFactory(new PropertyValueFactory<Receta, Integer>("RecetaID"));
		tc2.setCellValueFactory(new PropertyValueFactory<Receta, Integer>("ServicioID"));
		tc3.setCellValueFactory(new PropertyValueFactory<Receta, String>("Descripcion"));
		tc4.setCellValueFactory(new PropertyValueFactory<Receta, String>("Fecha"));
		tc5.setCellValueFactory(new PropertyValueFactory<Receta, String>("Hora"));
		
		Rbo.mostrarReceta(tableview);
		Rbo.opciones1(cbe);
	}


	public void CambiarEscenaVi(ActionEvent event) throws IOException{
		Parent VisitaView= FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		Scene VisitaEscena = new Scene (VisitaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(VisitaEscena);
		window.show();
		
			
		}
	
	public void CambiarEscenaRetipo(ActionEvent event) throws IOException{
		Parent VisitaView= FXMLLoader.load(getClass().getClassLoader().getResource("TipoReceta.fxml"));
		Scene VisitaEscena = new Scene (VisitaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(VisitaEscena);
		window.show();
		}
	
	public void CambiarEscenaR(ActionEvent event) throws IOException{
		Parent LicenciaView= FXMLLoader.load(getClass().getClassLoader().getResource("Receta.fxml"));
		Scene LicenciaEscena = new Scene (LicenciaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(LicenciaEscena);
		window.show();
		
			
		}
	
	@FXML
	public void Insertar(ActionEvent event) throws SQLException, ParseException {
		rec.setDescripcion(tfr2.getText());
		rec.setFecha(tffecha.getValue().toString());
		rec.setHora(tfr1.getText());
		rec.setServicioID(cbe.getValue());
		mensaje = Rbo.agregarReceta(rec);
		System.out.println(mensaje);
		Rbo.mostrarReceta(tableview);
	}
	
	@FXML
	public void Eliminar(ActionEvent event) throws SQLException {
		Rbo.eliminarReceta(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getRecetaID());
		Rbo.mostrarReceta(tableview);
	}
	
	@FXML
	public void Modificar(ActionEvent event) throws SQLException, ParseException {
		rec.setDescripcion(tfr2.getText());
		rec.setFecha(tffecha.getValue().toString());
		rec.setHora(tfr1.getText());
		rec.setServicioID(cbe.getValue());
		rec.setRecetaID(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getRecetaID());
		mensaje = Rbo.modificarReceta(rec);
		Rbo.mostrarReceta(tableview);
	}
	
	@FXML
	public void Limpiar(ActionEvent event) {
		 tffecha.setValue(null);;

		 tfr1.clear();
		 tfr2.clear();
		 cbe.setValue(null);;
		 tfr1.setDisable(false);
		 tfr2.setDisable(false);
		 cbe.setDisable(false);

	}
	
//	public void radioSelect (ActionEvent event) {
//		if(rbr1.isSelected()) {
//			lbr5.setDisable(true);
//			tfr1.setDisable(true);
			

//		}
	//	else if(rbr2.isSelected()) {
		//	lbr5.setDisable(false);
			//tfr1.setDisable(false);
		//}
		

//	}
	
	

}
