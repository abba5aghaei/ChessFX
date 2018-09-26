/**INOG
 * @author abba5aghaei
 */

package chess;

import chess.view.Controller;
import chess.view.StartDialog;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.fxml.FXMLLoader;

public class Main extends Application {
	private Stage stage;
	private Stage start_stage;
	private AnchorPane root;
	private Controller home;
	private Media tap;
	private MediaPlayer tapPlayer;
	private MediaPlayer mediaPlayer;

	@Override
	public void start(Stage primaryStage) {
		stage = primaryStage;
		GamePlay chess = new GamePlay();
		chess.setMain(this);
		playMusic();
		showHome();
		stage.addEventHandler(KeyEvent.ANY, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if (event.getCode().equals(KeyCode.ESCAPE)) {
					if (!stage.isFullScreen())
						stage.setIconified(true);
					else
						stage.setFullScreen(true);
				}
			}
		});
		tap = new Media(Main.class.getResource("musics/tap.wav").toExternalForm());
	}

	private void showHome() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/Home.fxml"));
			root = (AnchorPane) loader.load();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			home = loader.getController();
			home.setMain(this);
			stage.setResizable(false);
			stage.setTitle("شطرنج");
			stage.setFullScreenExitHint("");
			stage.getIcons().addAll(new Image("file:resources/images/icon.png"));
			stage.setFullScreen(true);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void showStart() {
		try {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("view/Start.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Scene scene = new Scene(page);
			start_stage = new Stage();
			start_stage.setScene(scene);
			StartDialog satrt = loader.getController();
			satrt.setMain(this);
			start_stage.initOwner(stage);
			start_stage.setResizable(false);
			start_stage.setTitle("بازی جدید");
			start_stage.getIcons().addAll(new Image("file:resources/images/icon.png"));
			start_stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	public void playMusic() {
		Media music = new Media(Main.class.getResource("musics/WinterIsHere.mp3").toExternalForm());
		mediaPlayer = new MediaPlayer(music);
		mediaPlayer.play();
	}

	public MediaPlayer getPlayer() {
		return mediaPlayer;
	}

	public AnchorPane getRoot() {
		return root;
	}

	public Stage getStartStage() {
		return start_stage;
	}

	public Stage getStage() {
		return stage;
	}

	public Controller getHome() {
		return home;
	}
	
	public void playTap() {
		tapPlayer = new MediaPlayer(tap);
		tapPlayer.play();
	}
}
