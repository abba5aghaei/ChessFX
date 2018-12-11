package chess.view;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import chess.GamePlay;
import chess.Main;
import chess.Transfer;
import chess.model.Coordinate;
import chess.model.Location;
import chess.model.Movement;
import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Cursor;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Font;
import javafx.stage.WindowEvent;

public class Controller {

	private Main main;
	public static int count;
	private char move_type;
	private int s = 0, bs = 0;
	private int m = 0, bm = 0;
	private int ws = 0, wbs = 0;
	private int wm = 0, wbm = 0;
	public static Timers bt, wt;
	private ServerSocket server_socket;
	private Socket socket;
	private DataInputStream in;
	private DataOutputStream out;
	private boolean network = false;
	@FXML
	private Label bs1;
	@FXML
	private Label bs2;
	@FXML
	private Label bs3;
	@FXML
	private Label bs4;
	@FXML
	private Label bs5;
	@FXML
	private Label bs6;
	@FXML
	private Label bs7;
	@FXML
	private Label bs8;
	@FXML
	private Label ws1;
	@FXML
	private Label ws2;
	@FXML
	private Label ws3;
	@FXML
	private Label ws4;
	@FXML
	private Label ws5;
	@FXML
	private Label ws6;
	@FXML
	private Label ws7;
	@FXML
	private Label ws8;
	@FXML
	private Label blc;
	@FXML
	private Label brc;
	@FXML
	private Label blh;
	@FXML
	private Label brh;
	@FXML
	private Label ble;
	@FXML
	private Label bre;
	@FXML
	private Label bq;
	@FXML
	private Label bk;
	@FXML
	private Label wlc;
	@FXML
	private Label wrc;
	@FXML
	private Label wlh;
	@FXML
	private Label wrh;
	@FXML
	private Label wle;
	@FXML
	private Label wre;
	@FXML
	private Label wq;
	@FXML
	private Label wk;
	@FXML
	private Label pen;
	@FXML
	private MenuItem normal;
	@FXML
	private MenuItem wood;
	@FXML
	private Button dark_button;
	@FXML
	private Button light_button;
	@FXML
	private TextArea chat;
	@FXML
	private TextField pm;
	@FXML
	private ListView<String> sena;
	@FXML
	private MenuItem undoer;
	@FXML
	private MenuItem redoer;
	@FXML
	private CheckMenuItem musicer;
	@FXML
	private CheckMenuItem reverse_check;
	@FXML
	private Label waiter_label;
	@FXML
	private ProgressIndicator waiter;
	@FXML
	private Label black_timer;
	@FXML
	private Label white_timer;
	@FXML
	private Label toaster;

	public void initialize() {
		Font.loadFont(Controller.class.getResource("resources/fonts/BNazanin.ttf").toExternalForm(), 10);
		Font.loadFont(Controller.class.getResource("resources/fonts/UrdType.ttf").toExternalForm(), 10);
		GamePlay.black_player.getKing().setBody(bk);
		GamePlay.black_player.getQueen().setBody(bq);
		GamePlay.black_player.getElephent('l').setBody(ble);
		GamePlay.black_player.getElephent('r').setBody(bre);
		GamePlay.black_player.getHorse('l').setBody(blh);
		GamePlay.black_player.getHorse('r').setBody(brh);
		GamePlay.black_player.getCastle('l').setBody(blc);
		GamePlay.black_player.getCastle('r').setBody(brc);
		GamePlay.black_player.getSolider(0).setBody(bs1);
		GamePlay.black_player.getSolider(1).setBody(bs2);
		GamePlay.black_player.getSolider(2).setBody(bs3);
		GamePlay.black_player.getSolider(3).setBody(bs4);
		GamePlay.black_player.getSolider(4).setBody(bs5);
		GamePlay.black_player.getSolider(5).setBody(bs6);
		GamePlay.black_player.getSolider(6).setBody(bs7);
		GamePlay.black_player.getSolider(7).setBody(bs8);
		GamePlay.white_player.getKing().setBody(wk);
		GamePlay.white_player.getQueen().setBody(wq);
		GamePlay.white_player.getElephent('l').setBody(wle);
		GamePlay.white_player.getElephent('r').setBody(wre);
		GamePlay.white_player.getHorse('l').setBody(wlh);
		GamePlay.white_player.getHorse('r').setBody(wrh);
		GamePlay.white_player.getCastle('l').setBody(wlc);
		GamePlay.white_player.getCastle('r').setBody(wrc);
		GamePlay.white_player.getSolider(0).setBody(ws1);
		GamePlay.white_player.getSolider(1).setBody(ws2);
		GamePlay.white_player.getSolider(2).setBody(ws3);
		GamePlay.white_player.getSolider(3).setBody(ws4);
		GamePlay.white_player.getSolider(4).setBody(ws5);
		GamePlay.white_player.getSolider(5).setBody(ws6);
		GamePlay.white_player.getSolider(6).setBody(ws7);
		GamePlay.white_player.getSolider(7).setBody(ws8);
		GamePlay.setSena(sena, black_timer, white_timer);
		GamePlay.onStock();
		pm.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent ke) {
				if (ke.getCode().equals(KeyCode.ENTER))
					sendHandller();
			}
		});
		count = 0;
		playAnimation();
	}

	private void playAnimation() {
		FadeTransition ft = new FadeTransition();
		ft.setNode(pen);
		ft.setFromValue(0);
		ft.setToValue(100);
		ft.setCycleCount(20);
		ft.play();
	}

	public void setMain(Main m) {
		main = m;
		main.getStage().addEventHandler(WindowEvent.WINDOW_CLOSE_REQUEST, new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent we) {
				try {
					if (socket.isConnected())
						socket.close();
					if (!server_socket.isClosed())
						server_socket.close();
					if (in != null)
						in.close();
					if (out != null)
						out.close();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		});
	}

	public void setNormalStyle() {
		main.getRoot().getStylesheets().clear();
		main.getRoot().getStylesheets().add(getClass().getResource("style-normal.css").toExternalForm());
		wood.setDisable(false);
		normal.setDisable(true);
	}

	public void setWoodStyle() {
		main.getRoot().getStylesheets().clear();
		main.getRoot().getStylesheets().add(getClass().getResource("style-wood.css").toExternalForm());
		normal.setDisable(false);
		wood.setDisable(true);
	}

	public void exit() {
		System.exit(0);
	}

	public void buttonLighter() {
		dark_button.setVisible(false);
		light_button.setVisible(true);
	}

	public void buttonDarker() {
		dark_button.setVisible(true);
		light_button.setVisible(false);
	}

	public void musicHandler() {
		if (musicer.isSelected()) {
			main.getPlayer().play();
		} else {
			main.getPlayer().stop();
		}
	}

	public void newGame() {
		main.showStart();
	}

	public void setScreen() {
		main.getStage().setFullScreen(true);
	}

	public void pickup(MouseEvent me) {
		Label l = (Label) me.getSource();
		l.setCursor(Cursor.CLOSED_HAND);
	}

	public void move(MouseEvent me) {
		Label l = (Label) me.getSource();
		if (GamePlay.isTurn(l.getId().charAt(0))) {
			l.setLayoutX(me.getScreenX() - 40);
			l.setLayoutY(me.getScreenY() - 40);
		}
	}

	public void release(MouseEvent me) {
		Label l = (Label) me.getSource();
		if (GamePlay.isTurn(l.getId().charAt(0))) {
			Coordinate next = Location.getLocation((int) me.getScreenX(), (int) me.getScreenY());
			if (GamePlay.isSelfLocation(l.getId().charAt(0), next))
				next = null;
			if (next != null) {
				GamePlay.changeTurn();
				undoer.setDisable(false);
				l.setLayoutX(next.getX());
				l.setLayoutY(next.getY());
				if (GamePlay.isEnemyLocation(l.getId().charAt(0), next))
					move_type = 'a';
				else
					move_type = 'm';
				if (l.equals(bk)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getKing(), move_type));
					GamePlay.black_player.getKing().setLocation(next);
				} else if (l.equals(bq)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getQueen(), move_type));
					GamePlay.black_player.getQueen().setLocation(next);
				} else if (l.equals(ble)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getElephent('l'), move_type));
					GamePlay.black_player.getElephent('l').setLocation(next);
				} else if (l.equals(bre)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getElephent('r'), move_type));
					GamePlay.black_player.getElephent('r').setLocation(next);
				} else if (l.equals(blh)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getHorse('l'), move_type));
					GamePlay.black_player.getHorse('l').setLocation(next);
				} else if (l.equals(brh)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getHorse('r'), move_type));
					GamePlay.black_player.getHorse('r').setLocation(next);
				} else if (l.equals(blc)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getCastle('l'), move_type));
					GamePlay.black_player.getCastle('l').setLocation(next);
				} else if (l.equals(brc)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getCastle('r'), move_type));
					GamePlay.black_player.getCastle('r').setLocation(next);
				} else if (l.equals(bs1)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(0), move_type));
					GamePlay.black_player.getSolider(0).setLocation(next);
				} else if (l.equals(bs2)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(1), move_type));
					GamePlay.black_player.getSolider(1).setLocation(next);
				} else if (l.equals(bs3)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(2), move_type));
					GamePlay.black_player.getSolider(2).setLocation(next);
				} else if (l.equals(bs4)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(3), move_type));
					GamePlay.black_player.getSolider(3).setLocation(next);
				} else if (l.equals(bs5)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(4), move_type));
					GamePlay.black_player.getSolider(4).setLocation(next);
				} else if (l.equals(bs6)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(5), move_type));
					GamePlay.black_player.getSolider(5).setLocation(next);
				} else if (l.equals(bs7)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(6), move_type));
					GamePlay.black_player.getSolider(6).setLocation(next);
				} else if (l.equals(bs8)) {
					GamePlay.moves.add(new Movement(next, GamePlay.black_player.getSolider(7), move_type));
					GamePlay.black_player.getSolider(7).setLocation(next);
				} else if (l.equals(wk)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getKing(), move_type));
					GamePlay.white_player.getKing().setLocation(next);
				} else if (l.equals(wq)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getQueen(), move_type));
					GamePlay.white_player.getQueen().setLocation(next);
				} else if (l.equals(wle)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getElephent('l'), move_type));
					GamePlay.white_player.getElephent('l').setLocation(next);
				} else if (l.equals(wre)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getElephent('r'), move_type));
					GamePlay.white_player.getElephent('r').setLocation(next);
				} else if (l.equals(wlh)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getHorse('l'), move_type));
					GamePlay.white_player.getHorse('l').setLocation(next);
				} else if (l.equals(wrh)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getHorse('r'), move_type));
					GamePlay.white_player.getHorse('r').setLocation(next);
				} else if (l.equals(wlc)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getCastle('l'), move_type));
					GamePlay.white_player.getCastle('l').setLocation(next);
				} else if (l.equals(wrc)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getCastle('r'), move_type));
					GamePlay.white_player.getCastle('r').setLocation(next);
				} else if (l.equals(ws1)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(0), move_type));
					GamePlay.white_player.getSolider(0).setLocation(next);
				} else if (l.equals(ws2)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(1), move_type));
					GamePlay.white_player.getSolider(1).setLocation(next);
				} else if (l.equals(ws3)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(2), move_type));
					GamePlay.white_player.getSolider(2).setLocation(next);
				} else if (l.equals(ws4)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(3), move_type));
					GamePlay.white_player.getSolider(3).setLocation(next);
				} else if (l.equals(ws5)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(4), move_type));
					GamePlay.white_player.getSolider(4).setLocation(next);
				} else if (l.equals(ws6)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(5), move_type));
					GamePlay.white_player.getSolider(5).setLocation(next);
				} else if (l.equals(ws7)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(6), move_type));
					GamePlay.white_player.getSolider(6).setLocation(next);
				} else if (l.equals(ws8)) {
					GamePlay.moves.add(new Movement(next, GamePlay.white_player.getSolider(7), move_type));
					GamePlay.white_player.getSolider(7).setLocation(next);
				}
				if (GamePlay.moves.get(count).getPreviuos().equals(GamePlay.moves.get(count).getCurrent())) {
					GamePlay.moves.remove(count);
				} else {
					if (network)
						sendQuery();
					sena.getItems().add(GamePlay.moves.get(count).getEvent());
					count++;
				}
			} else {
				if (l.equals(bk)) {
					bk.setLayoutX(GamePlay.black_player.getKing().getLocation().getX());
					bk.setLayoutY(GamePlay.black_player.getKing().getLocation().getY());
				} else if (l.equals(bq)) {
					bq.setLayoutX(GamePlay.black_player.getQueen().getLocation().getX());
					bq.setLayoutY(GamePlay.black_player.getQueen().getLocation().getY());
				} else if (l.equals(ble)) {
					ble.setLayoutX(GamePlay.black_player.getElephent('l').getLocation().getX());
					ble.setLayoutY(GamePlay.black_player.getElephent('l').getLocation().getY());
				} else if (l.equals(bre)) {
					bre.setLayoutX(GamePlay.black_player.getElephent('r').getLocation().getX());
					bre.setLayoutY(GamePlay.black_player.getElephent('r').getLocation().getY());
				} else if (l.equals(blh)) {
					blh.setLayoutX(GamePlay.black_player.getHorse('l').getLocation().getX());
					blh.setLayoutY(GamePlay.black_player.getHorse('l').getLocation().getY());
				} else if (l.equals(brh)) {
					brh.setLayoutX(GamePlay.black_player.getHorse('r').getLocation().getX());
					brh.setLayoutY(GamePlay.black_player.getHorse('r').getLocation().getY());
				} else if (l.equals(blc)) {
					blc.setLayoutX(GamePlay.black_player.getCastle('l').getLocation().getX());
					blc.setLayoutY(GamePlay.black_player.getCastle('l').getLocation().getY());
				} else if (l.equals(brc)) {
					brc.setLayoutX(GamePlay.black_player.getCastle('r').getLocation().getX());
					brc.setLayoutY(GamePlay.black_player.getCastle('r').getLocation().getY());
				} else if (l.equals(bs1)) {
					bs1.setLayoutX(GamePlay.black_player.getSolider(0).getLocation().getX());
					bs1.setLayoutY(GamePlay.black_player.getSolider(0).getLocation().getY());
				} else if (l.equals(bs2)) {
					bs2.setLayoutX(GamePlay.black_player.getSolider(1).getLocation().getX());
					bs2.setLayoutY(GamePlay.black_player.getSolider(1).getLocation().getY());
				} else if (l.equals(bs3)) {
					bs3.setLayoutX(GamePlay.black_player.getSolider(2).getLocation().getX());
					bs3.setLayoutY(GamePlay.black_player.getSolider(2).getLocation().getY());
				} else if (l.equals(bs4)) {
					bs4.setLayoutX(GamePlay.black_player.getSolider(3).getLocation().getX());
					bs4.setLayoutY(GamePlay.black_player.getSolider(3).getLocation().getY());
				} else if (l.equals(bs5)) {
					bs5.setLayoutX(GamePlay.black_player.getSolider(4).getLocation().getX());
					bs5.setLayoutY(GamePlay.black_player.getSolider(4).getLocation().getY());
				} else if (l.equals(bs6)) {
					bs6.setLayoutX(GamePlay.black_player.getSolider(5).getLocation().getX());
					bs6.setLayoutY(GamePlay.black_player.getSolider(5).getLocation().getY());
				} else if (l.equals(bs7)) {
					bs7.setLayoutX(GamePlay.black_player.getSolider(6).getLocation().getX());
					bs7.setLayoutY(GamePlay.black_player.getSolider(6).getLocation().getY());
				} else if (l.equals(bs8)) {
					bs8.setLayoutX(GamePlay.black_player.getSolider(7).getLocation().getX());
					bs8.setLayoutY(GamePlay.black_player.getSolider(7).getLocation().getY());
				} else if (l.equals(wk)) {
					wk.setLayoutX(GamePlay.white_player.getKing().getLocation().getX());
					wk.setLayoutY(GamePlay.white_player.getKing().getLocation().getY());
				} else if (l.equals(wq)) {
					wq.setLayoutX(GamePlay.white_player.getQueen().getLocation().getX());
					wq.setLayoutY(GamePlay.white_player.getQueen().getLocation().getY());
				} else if (l.equals(wle)) {
					wle.setLayoutX(GamePlay.white_player.getElephent('l').getLocation().getX());
					wle.setLayoutY(GamePlay.white_player.getElephent('l').getLocation().getY());
				} else if (l.equals(wre)) {
					wre.setLayoutX(GamePlay.white_player.getElephent('r').getLocation().getX());
					wre.setLayoutY(GamePlay.white_player.getElephent('r').getLocation().getY());
				} else if (l.equals(wlh)) {
					wlh.setLayoutX(GamePlay.white_player.getHorse('l').getLocation().getX());
					wlh.setLayoutY(GamePlay.white_player.getHorse('l').getLocation().getY());
				} else if (l.equals(wrh)) {
					wrh.setLayoutX(GamePlay.white_player.getHorse('r').getLocation().getX());
					wrh.setLayoutY(GamePlay.white_player.getHorse('r').getLocation().getY());
				} else if (l.equals(wlc)) {
					wlc.setLayoutX(GamePlay.white_player.getCastle('l').getLocation().getX());
					wlc.setLayoutY(GamePlay.white_player.getCastle('l').getLocation().getY());
				} else if (l.equals(wrc)) {
					wrc.setLayoutX(GamePlay.white_player.getCastle('r').getLocation().getX());
					wrc.setLayoutY(GamePlay.white_player.getCastle('r').getLocation().getY());
				} else if (l.equals(ws1)) {
					ws1.setLayoutX(GamePlay.white_player.getSolider(0).getLocation().getX());
					ws1.setLayoutY(GamePlay.white_player.getSolider(0).getLocation().getY());
				} else if (l.equals(ws2)) {
					ws2.setLayoutX(GamePlay.white_player.getSolider(1).getLocation().getX());
					ws2.setLayoutY(GamePlay.white_player.getSolider(1).getLocation().getY());
				} else if (l.equals(ws3)) {
					ws3.setLayoutX(GamePlay.white_player.getSolider(2).getLocation().getX());
					ws3.setLayoutY(GamePlay.white_player.getSolider(2).getLocation().getY());
				} else if (l.equals(ws4)) {
					ws4.setLayoutX(GamePlay.white_player.getSolider(3).getLocation().getX());
					ws4.setLayoutY(GamePlay.white_player.getSolider(3).getLocation().getY());
				} else if (l.equals(ws5)) {
					ws5.setLayoutX(GamePlay.white_player.getSolider(4).getLocation().getX());
					ws5.setLayoutY(GamePlay.white_player.getSolider(4).getLocation().getY());
				} else if (l.equals(ws6)) {
					ws6.setLayoutX(GamePlay.white_player.getSolider(5).getLocation().getX());
					ws6.setLayoutY(GamePlay.white_player.getSolider(5).getLocation().getY());
				} else if (l.equals(ws7)) {
					ws7.setLayoutX(GamePlay.white_player.getSolider(6).getLocation().getX());
					ws7.setLayoutY(GamePlay.white_player.getSolider(6).getLocation().getY());
				} else if (l.equals(ws8)) {
					ws8.setLayoutX(GamePlay.white_player.getSolider(7).getLocation().getX());
					ws8.setLayoutY(GamePlay.white_player.getSolider(7).getLocation().getY());
				}
			}
		}
		l.setCursor(Cursor.OPEN_HAND);
		main.playTap();
	}

	private void sendQuery() {
		try {
			out.writeUTF(GamePlay.moves.get(count).getQuery());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void undo() {
		String query = "move ";
		query += GamePlay.moves.get(count - 1).getPiece();
		query += " from ";
		query += Location.getLocationName(GamePlay.moves.get(count - 1).getCurrent());
		query += " to ";
		query += Location.getLocationName(GamePlay.moves.get(count - 1).getPreviuos());
		GamePlay.executeQuery(query);
	}

	public void redo() {

	}

	public void startAsClient(String ip, String port) {
		network = true;
		Thread client = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					socket = new Socket(ip, Integer.parseInt(port));
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					GamePlay.onBord();
					chat.setDisable(false);
					pm.setDisable(false);
					dark_button.setDisable(false);
					light_button.setDisable(false);
					String receive = "";
					while (true) {
						receive = in.readUTF();
						if (receive.startsWith("move"))
							GamePlay.executeQuery(receive);
						else
							chat.appendText("- " + receive + "\n");
					}
				} catch (Exception ex) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("خطا");
							alert.setHeaderText("خطای کلاینت");
							alert.setContentText(ex.getLocalizedMessage());
							alert.initOwner(main.getStage());
							alert.show();
						}
					});
				}
			}
		});
		client.start();
	}

	public void startAsServer(String port) {
		network = true;
		Thread server = new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					server_socket = new ServerSocket(Integer.parseInt(port));
					waiter.setVisible(true);
					waiter_label.setVisible(true);
					socket = server_socket.accept();
					waiter.setVisible(false);
					waiter_label.setVisible(false);
					GamePlay.onBord();
					chat.setDisable(false);
					pm.setDisable(false);
					dark_button.setDisable(false);
					light_button.setDisable(false);
					in = new DataInputStream(socket.getInputStream());
					out = new DataOutputStream(socket.getOutputStream());
					String receive = "";
					while (true) {
						receive = in.readUTF();
						if (receive.startsWith("move"))
							GamePlay.executeQuery(receive);
						else
							chat.appendText("- " + receive + "\n");
					}
				} catch (Exception ex) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							Alert alert = new Alert(AlertType.ERROR);
							alert.setTitle("خطا");
							alert.setHeaderText("خطای سرور");
							alert.setContentText(ex.getLocalizedMessage());
							alert.initOwner(main.getStage());
							alert.show();
						}
					});
				}
			}
		});
		server.start();
	}

	public void sendHandller() {
		chat.appendText("+ " + pm.getText() + "\n");
		try {
			out.writeUTF(pm.getText());
		} catch (IOException e) {
			e.printStackTrace();
		}
		pm.setText(null);
	}

	public void startCpuGame() {

	}

	public void startLocalGame() {
		if (bt != null)
			pickupGame();
		GamePlay.onBord();
		startTimers();
		wt.start();
		bt.start();
		bt.suspend();
		reverse_check.setDisable(true);
		black_timer.setDisable(true);
		white_timer.setDisable(false);
	}

	public void pickupGame() {
		reverse_check.setDisable(false);
		GamePlay.onStock();
		GamePlay.moves.clear();
		sena.getItems().clear();
		count = 0;
		try {
			if (bt != null) {
				if(GamePlay.black_player.getTurn())
					GamePlay.changeTurn();
				bt.stop();
				wt.stop();
				bt = null;
				wt = null;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			s = 0;
			bs = 0;
			m = 0;
			bm = 0;
			ws = 0;
			wbs = 0;
			wm = 0;
			wbm = 0;
			black_timer.setText("  " + bm + "" + m + "" + ":" + bs + "" + s);
			white_timer.setText("  " + wbm + "" + wm + "" + ":" + wbs + "" + ws);
		}
	}

	public void startTimers() {
		bt = new Timers(1);
		wt = new Timers(2);
	}

	public class Timers extends Thread {
		private int player;

		public Timers(int i) {
			player = i;
		}

		@Override
		public void run() {
			while (true) {
				increaseTimer(player);
				try {
					sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public void increaseTimer(int player) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if (player == 1) {
					s++;
					if (s > 9) {
						s = 0;
						bs++;
						if (bs > 5) {
							bs = 0;
							m++;
							if (m > 9) {
								m = 0;
								bm++;
							}
						}
					}
					black_timer.setText("  " + bm + "" + m + "" + ":" + bs + "" + s);
				} else {
					ws++;
					if (ws > 9) {
						ws = 0;
						wbs++;
						if (wbs > 5) {
							wbs = 0;
							wm++;
							if (wm > 9) {
								wm = 0;
								wbm++;
							}
						}
					}
					white_timer.setText("  " + wbm + "" + wm + "" + ":" + wbs + "" + ws);
				}
			}
		});
	}

	public void reverseHandler() {
		if (reverse_check.isSelected())
			GamePlay.reverse = true;
		else
			GamePlay.reverse = false;
		GamePlay.onStock();
	}

	public void save() {
		GamePlay.saveGame();
	}

	public void load() {
		startLocalGame();
		GamePlay.loadGame();
	}

	public void help() {
		//GamePlay.aboutGame();
		Transfer transfer = new Transfer(wq, Location.D8);
		transfer.setSpeed(2);
		transfer.playTransfer();
	}

	public void about() {
		GamePlay.showAbout();
	}

	public void toast(String msg) {
		toaster.setText(msg);
		FadeTransition ft = new FadeTransition();
		ft.setNode(toaster);
		ft.setFromValue(100);
		ft.setToValue(0);
		ft.setCycleCount(10);
		ft.play();
	}
}