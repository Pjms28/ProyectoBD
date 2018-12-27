import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class MainR {
	@FXML private RadioButton rb1;
	@FXML private RadioButton rb2;
	@FXML private Label lb1;
	@FXML private TextField tf1;
	
	public void radioSelect (ActionEvent event) {
		if(rb1.isSelected()) {
			lb1.setDisable(true);
			tf1.setDisable(true);
		}
		if(rb2.isSelected()) {
			lb1.setDisable(false);
			tf1.setDisable(false);
		}

	}

}
