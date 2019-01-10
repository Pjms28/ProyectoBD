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
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TipoRecetaR {
	String mensaje = "";
	Receta rec=new Receta();
	RecetaMedicina recm=new RecetaMedicina();
	RecetaAnalisis reca=new RecetaAnalisis();
	RecetaBO Rbo = new RecetaBO();
	@FXML private ComboBox<Integer> cbe3;
	@FXML private ComboBox<Integer> cbe4;
	@FXML private RadioButton rbr1;
	@FXML private RadioButton rbr2;
	@FXML private TextField tfr1;
	@FXML public TextField nReceta;
	@FXML private Label lbr1;
	@FXML private Label lbr2;
	@FXML private Label lbr3;
	@FXML private Label lbr4;
	@FXML private Label lbr5;
	@FXML private Label titulo;
	@FXML private TableView<RecetaAnalisis> tableview;
	@FXML private TableView<RecetaMedicina> tableview2;
	@FXML private TableColumn<RecetaAnalisis, Integer> tc1;
	@FXML private TableColumn<RecetaAnalisis, Integer> tc2;
	@FXML private TableColumn<RecetaAnalisis, Integer> tc3;
	@FXML private TableColumn<RecetaMedicina, Integer> tc4;
	@FXML private TableColumn<RecetaMedicina, Integer> tc5;
	@FXML private TableColumn<RecetaMedicina, Integer> tc6;
	
	@FXML
	public void initialize(){
		tc1.setCellValueFactory(new PropertyValueFactory<RecetaAnalisis, Integer>("RecetaanalisisID"));
		tc2.setCellValueFactory(new PropertyValueFactory<RecetaAnalisis, Integer>("RecetaID"));
		tc3.setCellValueFactory(new PropertyValueFactory<RecetaAnalisis, Integer>("AnalisisID"));
		Rbo.mostrarRecetaAnalisis(tableview);
		tc4.setCellValueFactory(new PropertyValueFactory<RecetaMedicina, Integer>("RecetamedicinaID"));
		tc5.setCellValueFactory(new PropertyValueFactory<RecetaMedicina, Integer>("RecetaID"));
		tc6.setCellValueFactory(new PropertyValueFactory<RecetaMedicina, Integer>("MedicinaID"));
		Rbo.mostrarRecetaMedicina(tableview2);
		//Rbo.opciones2(cbe2);
		Rbo.opciones3(cbe3);
		Rbo.opciones4(cbe4);
		nReceta.setDisable(true);
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
		if(rbr1.isSelected()) {
			recm.setRecetaID(Integer.valueOf(nReceta.getText()));
			recm.setMedicinaID(cbe3.getValue());
			recm.setDosis(tfr1.getText());
			mensaje = Rbo.agregarRecetaMedicina(recm);
			System.out.println(mensaje);
			Rbo.mostrarRecetaMedicina(tableview2);
		}else {
			reca.setRecetaID(Integer.valueOf(nReceta.getText()));
			reca.setAnalisisID(cbe4.getValue());
			mensaje = Rbo.agregarRecetaAnalisis(reca);
			System.out.println(mensaje);
			Rbo.mostrarRecetaAnalisis(tableview);
		}
		
	}
	
	
	@FXML
	public void Eliminar(ActionEvent event) throws SQLException {
		if(rbr1.isSelected()) {
			Rbo.eliminarRecetaMedicina(tableview2.getItems().get(tableview2.getSelectionModel().getSelectedIndex()).getRecetamedicinaID());
			Rbo.mostrarRecetaMedicina(tableview2);
			
		}else {
			Rbo.eliminarRecetaAnalisis(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getRecetaanalisisID());
			Rbo.mostrarRecetaAnalisis(tableview);
		}
	
	
	}
	
	@FXML
	public void Modificar(ActionEvent event) throws SQLException, ParseException {
		if(rbr1.isSelected()) {
			recm.setRecetaID(Integer.valueOf(nReceta.getText()));
			recm.setMedicinaID(cbe3.getValue());
			recm.setDosis(tfr1.getText());
			recm.setRecetamedicinaID(tableview2.getItems().get(tableview2.getSelectionModel().getSelectedIndex()).getRecetamedicinaID());
			Rbo.modificarRecetaMedicina(recm);
			Rbo.mostrarRecetaMedicina(tableview2);
			
		}else {
			reca.setRecetaID(Integer.valueOf(nReceta.getText()));
			reca.setAnalisisID(cbe4.getValue());
			reca.setRecetaanalisisID(tableview.getItems().get(tableview.getSelectionModel().getSelectedIndex()).getRecetaanalisisID());
			Rbo.modificarRecetaAnalisis(reca);
			Rbo.mostrarRecetaAnalisis(tableview);
		}
	}
	
	@FXML
	public void Limpiar(ActionEvent event) {
		tfr1.clear();
		tfr1.setDisable(false);
		cbe3.setValue(null);
		cbe4.setValue(null);
	}
	
	@FXML
	public void radioSelect (ActionEvent event) {
		if(rbr1.isSelected()) {
			lbr2.setDisable(false);
			tfr1.setDisable(false);
			lbr3.setDisable(false);
			lbr4.setDisable(false);
			cbe3.setDisable(false);
			lbr5.setDisable(true);
			cbe4.setDisable(true);
		}else {
			lbr2.setDisable(true);
			tfr1.setDisable(true);
			lbr3.setDisable(false);
			lbr4.setDisable(true);
			cbe3.setDisable(true);
			lbr5.setDisable(false);
			cbe4.setDisable(false);
		}
	}
	
	

}

