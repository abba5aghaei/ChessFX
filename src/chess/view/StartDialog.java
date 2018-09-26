package chess.view;

import chess.Main;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class StartDialog {
	
	private Main main;
	@FXML
	private Label port_label;
	@FXML
	private Label ip_label;
	@FXML
	private ComboBox<String> list;
	@FXML
	private ToggleButton network;
	@FXML
	private TextField PORT;
	@FXML
	private TextField IP;
	@FXML
	private RadioButton server_radio;
	@FXML
	private RadioButton client_radio;
	
	public void initialize() {
		ToggleGroup group = new ToggleGroup();
		server_radio.setToggleGroup(group);
		client_radio.setToggleGroup(group);
		//list.getItems().addAll("یک نفره", "دو نفره");
		list.getItems().add("دو نفره");
		list.getSelectionModel().select(0);
		network.setDisable(true);
	}
	
	public void setMain(Main m) {
		main = m;
	}
	
	public void listHandller() {
//		if(list.getSelectionModel().getSelectedIndex() == 0) {
//			network.setSelected(false);
//			network.setDisable(true);
//		}
//		else {
//			network.setDisable(false);
//		}
//		networkHandller();
	}
	
	public void networkHandller() {
//		if(network.isSelected()) {
//			port_label.setDisable(false);
//			ip_label.setDisable(false);
//			PORT.setDisable(false);
//			IP.setDisable(false);
//			server_radio.setDisable(false);
//			client_radio.setDisable(false);
//		}
//		else {
//			port_label.setDisable(true);
//			ip_label.setDisable(true);
//			PORT.setDisable(true);
//			IP.setDisable(true);
//			server_radio.setDisable(true);
//			client_radio.setDisable(true);
//		}
	}

	public void cancel() {
		main.getStartStage().close();
	}
	
	public void startGame() {
		main.getStartStage().close();
		switch(list.getSelectionModel().getSelectedIndex()) {
			case 1: {
				main.getHome().startCpuGame();
				break;
			}
			case 0: {
				if(network.isSelected())
					if(server_radio.isSelected())
						main.getHome().startAsServer(PORT.getText());
					else
						main.getHome().startAsClient(IP.getText(), PORT.getText());
				else 
					main.getHome().startLocalGame();
			}
		}
	}
}
