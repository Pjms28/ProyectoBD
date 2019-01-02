import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RecetaR {
	
	public void CambiarEscenaVi(ActionEvent event) throws IOException{
		Parent VisitaView= FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		Scene VisitaEscena = new Scene (VisitaView);
		Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow();
		
		window.setScene(VisitaEscena);
		window.show();
		
			
		}

}
