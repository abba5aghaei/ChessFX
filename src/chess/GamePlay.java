package chess;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import chess.model.Coordinate;
import chess.model.Location;
import chess.model.Movement;
import chess.model.Piece;
import chess.model.Player;
import chess.view.Controller;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.FileChooser;

public class GamePlay {
	public static Player black_player;
	public static Player white_player;
	public static List<Movement> moves;
	public static boolean reverse = false;
	private static int up_index;
	private static int down_index;
	private static int d;
	private static ListView<String> senario;
	private static Label black_timer;
	private static Label white_timer;
	private static Main main;
	private static Transfer transfer;
	private static Piece[] pieces;

	public GamePlay() {
		moves = new ArrayList<Movement>();
		black_player = new Player("Blcak");
		white_player = new Player("White");
		black_player.setTurn(false);
		transfer = new Transfer();
		pieces = new Piece[] { black_player.getKing(), black_player.getQueen(), black_player.getElephent('l'),
				black_player.getElephent('r'), black_player.getHorse('l'), black_player.getHorse('r'),
				black_player.getCastle('l'), black_player.getCastle('r'), black_player.getSolider(0),
				black_player.getSolider(1), black_player.getSolider(2), black_player.getSolider(3),
				black_player.getSolider(4), black_player.getSolider(5), black_player.getSolider(6),
				black_player.getSolider(7), white_player.getKing(), white_player.getQueen(),
				white_player.getElephent('l'), white_player.getElephent('r'), white_player.getHorse('l'),
				white_player.getHorse('r'), white_player.getCastle('l'), white_player.getCastle('r'),
				white_player.getSolider(0), white_player.getSolider(1), white_player.getSolider(2),
				white_player.getSolider(3), white_player.getSolider(4), white_player.getSolider(5),
				white_player.getSolider(6), white_player.getSolider(7) };
		up_index = 16;
		down_index = 0;
	}

	public void setMain(Main m) {
		main = m;
	}

	public static void saveGame() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("abs files (*.abs)", "*.abs");
		fileChooser.getExtensionFilters().add(extFilter);
		File output = fileChooser.showSaveDialog(main.getStage());
		if (output != null) {
			try {
				PrintWriter writer = new PrintWriter(output);
				for (Movement m : moves) {
					writer.println(m.getQuery());
				}
				writer.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		main.getHome().toast("بازی ذخیره شد");
	}

	public static void loadGame() {
		FileChooser fileChooser = new FileChooser();
		FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("abs files (*.abs)", "*.abs");
		fileChooser.getExtensionFilters().add(extFilter);
		File input = fileChooser.showOpenDialog(main.getStage());
		if (input != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(input));
				String query;
				while ((query = reader.readLine()) != null) {
					executeQuery(query);
				}
				reader.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		main.getHome().toast("بارگذاری با موفقیت پایان یافت");
	}

	public static void runSenario() {
		senario.getItems().clear();
		Controller.count = 0;
		Thread runner = new Thread(new Runnable() {
			@Override
			public void run() {
				for (Movement m : moves) {
					Platform.runLater(new Runnable() {
						@Override
						public void run() {
							if (m.getQuery() != null)
								if (m.getQuery().startsWith("move"))
									runMove(m);
						}
					});
					try {
						Thread.sleep(300);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		runner.start();
	}

	public static void aboutGame() {

	}

	public static void showAbout() {

	}

	public static void executeQuery(String query) {
		try {
			query = query.trim();
			int i = 0;
			int j = query.indexOf(" ", i);
			String command = query.substring(i, j);
			if (command.equals("move")) {
				while (query.charAt(j) == ' ')
					j++;
				i = j;
				j = query.indexOf(" ", i);
				String p = query.substring(i, j);
				while (query.charAt(j) == ' ')
					j++;
				j += 4;
				while (query.charAt(j) == ' ')
					j++;
				i = j;
				j = query.indexOf(" ", i);
				String L1 = query.substring(i, j);
				while (query.charAt(j) == ' ')
					j++;
				j += 2;
				while (query.charAt(j) == ' ')
					j++;
				i = j;
				j = query.length();
				String L2 = query.substring(i, j);
				Movement move = new Movement();
				move.setCurrent(Location.getLocationByName(L2));
				move.setPreviuos(Location.getLocationByName(L1));
				move.setPiece(p);
				move.setType('k');
				move.setEvent(move.getPieceName() + " از " + L1 + " به " + L2 + " حرکت کرد");
				move.setQuery(query);
				moves.add(move);
				runMove(move);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void runMove(Movement move) {
		changeTurn();
		isEnemyLocation(move.getPiece().charAt(0), move.getCurrent());
		if (move.getPiece().equals("bk")) {
			black_player.getKing().setLocation(move.getCurrent());
			black_player.getKing().getBody().setLayoutX(move.getCurrent().getX());
			black_player.getKing().getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bq")) {
			black_player.getQueen().setLocation(move.getCurrent());
			black_player.getQueen().getBody().setLayoutX(move.getCurrent().getX());
			black_player.getQueen().getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ble")) {
			black_player.getElephent('l').setLocation(move.getCurrent());
			black_player.getElephent('l').getBody().setLayoutX(move.getCurrent().getX());
			black_player.getElephent('l').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bre")) {
			black_player.getElephent('r').setLocation(move.getCurrent());
			black_player.getElephent('r').getBody().setLayoutX(move.getCurrent().getX());
			black_player.getElephent('r').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("blh")) {
			black_player.getHorse('l').setLocation(move.getCurrent());
			black_player.getHorse('l').getBody().setLayoutX(move.getCurrent().getX());
			black_player.getHorse('l').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("brh")) {
			black_player.getHorse('r').setLocation(move.getCurrent());
			black_player.getHorse('r').getBody().setLayoutX(move.getCurrent().getX());
			black_player.getHorse('r').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("blc")) {
			black_player.getCastle('l').setLocation(move.getCurrent());
			black_player.getCastle('l').getBody().setLayoutX(move.getCurrent().getX());
			black_player.getCastle('l').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("brc")) {
			black_player.getCastle('r').setLocation(move.getCurrent());
			black_player.getCastle('r').getBody().setLayoutX(move.getCurrent().getX());
			black_player.getCastle('r').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs1")) {
			black_player.getSolider(0).setLocation(move.getCurrent());
			black_player.getSolider(0).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(0).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs2")) {
			black_player.getSolider(1).setLocation(move.getCurrent());
			black_player.getSolider(1).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(1).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs3")) {
			black_player.getSolider(2).setLocation(move.getCurrent());
			black_player.getSolider(2).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(2).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs4")) {
			black_player.getSolider(3).setLocation(move.getCurrent());
			black_player.getSolider(3).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(3).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs5")) {
			black_player.getSolider(4).setLocation(move.getCurrent());
			black_player.getSolider(4).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(4).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs6")) {
			black_player.getSolider(5).setLocation(move.getCurrent());
			black_player.getSolider(5).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(5).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs7")) {
			black_player.getSolider(6).setLocation(move.getCurrent());
			black_player.getSolider(6).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(6).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("bs8")) {
			black_player.getSolider(7).setLocation(move.getCurrent());
			black_player.getSolider(7).getBody().setLayoutX(move.getCurrent().getX());
			black_player.getSolider(7).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wk")) {
			white_player.getKing().setLocation(move.getCurrent());
			white_player.getKing().getBody().setLayoutX(move.getCurrent().getX());
			white_player.getKing().getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wq")) {
			white_player.getQueen().setLocation(move.getCurrent());
			white_player.getQueen().getBody().setLayoutX(move.getCurrent().getX());
			white_player.getQueen().getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wle")) {
			white_player.getElephent('l').setLocation(move.getCurrent());
			white_player.getElephent('l').getBody().setLayoutX(move.getCurrent().getX());
			white_player.getElephent('l').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wre")) {
			white_player.getElephent('r').setLocation(move.getCurrent());
			white_player.getElephent('r').getBody().setLayoutX(move.getCurrent().getX());
			white_player.getElephent('r').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wlh")) {
			white_player.getHorse('l').setLocation(move.getCurrent());
			white_player.getHorse('l').getBody().setLayoutX(move.getCurrent().getX());
			white_player.getHorse('l').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wrh")) {
			white_player.getHorse('r').setLocation(move.getCurrent());
			white_player.getHorse('r').getBody().setLayoutX(move.getCurrent().getX());
			white_player.getHorse('r').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wlc")) {
			white_player.getCastle('l').setLocation(move.getCurrent());
			white_player.getCastle('l').getBody().setLayoutX(move.getCurrent().getX());
			white_player.getCastle('l').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("wrc")) {
			white_player.getCastle('r').setLocation(move.getCurrent());
			white_player.getCastle('r').getBody().setLayoutX(move.getCurrent().getX());
			white_player.getCastle('r').getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws1")) {
			white_player.getSolider(0).setLocation(move.getCurrent());
			white_player.getSolider(0).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(0).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws2")) {
			white_player.getSolider(1).setLocation(move.getCurrent());
			white_player.getSolider(1).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(1).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws3")) {
			white_player.getSolider(2).setLocation(move.getCurrent());
			white_player.getSolider(2).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(2).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws4")) {
			white_player.getSolider(3).setLocation(move.getCurrent());
			white_player.getSolider(3).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(3).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws5")) {
			white_player.getSolider(4).setLocation(move.getCurrent());
			white_player.getSolider(4).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(4).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws6")) {
			white_player.getSolider(5).setLocation(move.getCurrent());
			white_player.getSolider(5).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(5).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws7")) {
			white_player.getSolider(6).setLocation(move.getCurrent());
			white_player.getSolider(6).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(6).getBody().setLayoutY(move.getCurrent().getY());
		} else if (move.getPiece().equals("ws8")) {
			white_player.getSolider(7).setLocation(move.getCurrent());
			white_player.getSolider(7).getBody().setLayoutX(move.getCurrent().getX());
			white_player.getSolider(7).getBody().setLayoutY(move.getCurrent().getY());
		}
		senario.getItems().add(moves.get(Controller.count).getEvent());
		Controller.count++;
	}

	public static void setSena(ListView<String> s, Label b, Label w) {
		senario = s;
		black_timer = b;
		white_timer = w;
	}

	public static void changeTurn() {
		if (black_player.getTurn()) {
			black_player.setTurn(false);
			white_player.setTurn(true);
			Controller.bt.suspend();
			Controller.wt.resume();
			black_timer.setDisable(true);
			white_timer.setDisable(false);
		} else {
			black_player.setTurn(true);
			white_player.setTurn(false);
			Controller.bt.resume();
			Controller.wt.suspend();
			black_timer.setDisable(false);
			white_timer.setDisable(true);
		}
	}

	public static boolean isSelfLocation(char p, Coordinate l) {
		if (p == 'b') {
			if (black_player.getKing().getLocation().equals(l))
				return true;
			if (black_player.getQueen().getLocation().equals(l))
				return true;
			if (black_player.getElephent('l').getLocation().equals(l))
				return true;
			if (black_player.getElephent('r').getLocation().equals(l))
				return true;
			if (black_player.getHorse('l').getLocation().equals(l))
				return true;
			if (black_player.getHorse('r').getLocation().equals(l))
				return true;
			if (black_player.getCastle('l').getLocation().equals(l))
				return true;
			if (black_player.getCastle('r').getLocation().equals(l))
				return true;
			if (black_player.getSolider(0).getLocation().equals(l))
				return true;
			if (black_player.getSolider(1).getLocation().equals(l))
				return true;
			if (black_player.getSolider(2).getLocation().equals(l))
				return true;
			if (black_player.getSolider(3).getLocation().equals(l))
				return true;
			if (black_player.getSolider(4).getLocation().equals(l))
				return true;
			if (black_player.getSolider(5).getLocation().equals(l))
				return true;
			if (black_player.getSolider(6).getLocation().equals(l))
				return true;
			if (black_player.getSolider(7).getLocation().equals(l))
				return true;
			return false;
		} else {
			if (white_player.getKing().getLocation().equals(l))
				return true;
			if (white_player.getQueen().getLocation().equals(l))
				return true;
			if (white_player.getElephent('l').getLocation().equals(l))
				return true;
			if (white_player.getElephent('r').getLocation().equals(l))
				return true;
			if (white_player.getHorse('l').getLocation().equals(l))
				return true;
			if (white_player.getHorse('r').getLocation().equals(l))
				return true;
			if (white_player.getCastle('l').getLocation().equals(l))
				return true;
			if (white_player.getCastle('r').getLocation().equals(l))
				return true;
			if (white_player.getSolider(0).getLocation().equals(l))
				return true;
			if (white_player.getSolider(1).getLocation().equals(l))
				return true;
			if (white_player.getSolider(2).getLocation().equals(l))
				return true;
			if (white_player.getSolider(3).getLocation().equals(l))
				return true;
			if (white_player.getSolider(4).getLocation().equals(l))
				return true;
			if (white_player.getSolider(5).getLocation().equals(l))
				return true;
			if (white_player.getSolider(6).getLocation().equals(l))
				return true;
			if (white_player.getSolider(7).getLocation().equals(l))
				return true;
			return false;
		}
	}

	public static boolean isEnemyLocation(char p, Coordinate l) {
		if (p == 'w') {
			if (black_player.getKing().getLocation().equals(l)) {
				deport(black_player.getKing(), p);
				return true;
			} else if (black_player.getQueen().getLocation().equals(l)) {
				deport(black_player.getQueen(), p);
				return true;
			} else if (black_player.getElephent('l').getLocation().equals(l)) {
				deport(black_player.getElephent('l'), p);
				return true;
			} else if (black_player.getElephent('r').getLocation().equals(l)) {
				deport(black_player.getElephent('r'), p);
				return true;
			} else if (black_player.getHorse('l').getLocation().equals(l)) {
				deport(black_player.getHorse('l'), p);
				return true;
			} else if (black_player.getHorse('r').getLocation().equals(l)) {
				deport(black_player.getHorse('r'), p);
				return true;
			} else if (black_player.getCastle('l').getLocation().equals(l)) {
				deport(black_player.getCastle('l'), p);
				return true;
			} else if (black_player.getCastle('r').getLocation().equals(l)) {
				deport(black_player.getCastle('r'), p);
				return true;
			} else if (black_player.getSolider(0).getLocation().equals(l)) {
				deport(black_player.getSolider(0), p);
				return true;
			} else if (black_player.getSolider(1).getLocation().equals(l)) {
				deport(black_player.getSolider(1), p);
				return true;
			} else if (black_player.getSolider(2).getLocation().equals(l)) {
				deport(black_player.getSolider(2), p);
				return true;
			} else if (black_player.getSolider(3).getLocation().equals(l)) {
				deport(black_player.getSolider(3), p);
				return true;
			} else if (black_player.getSolider(4).getLocation().equals(l)) {
				deport(black_player.getSolider(4), p);
				return true;
			} else if (black_player.getSolider(5).getLocation().equals(l)) {
				deport(black_player.getSolider(5), p);
				return true;
			} else if (black_player.getSolider(6).getLocation().equals(l)) {
				deport(black_player.getSolider(6), p);
				return true;
			} else if (black_player.getSolider(7).getLocation().equals(l)) {
				deport(black_player.getSolider(7), p);
				return true;
			} else
				return false;
		} else {
			if (white_player.getKing().getLocation().equals(l)) {
				deport(white_player.getKing(), p);
				return true;
			} else if (white_player.getQueen().getLocation().equals(l)) {
				deport(white_player.getQueen(), p);
				return true;
			} else if (white_player.getElephent('l').getLocation().equals(l)) {
				deport(white_player.getElephent('l'), p);
				return true;
			} else if (white_player.getElephent('r').getLocation().equals(l)) {
				deport(white_player.getElephent('r'), p);
				return true;
			} else if (white_player.getHorse('l').getLocation().equals(l)) {
				deport(white_player.getHorse('l'), p);
				return true;
			} else if (white_player.getHorse('r').getLocation().equals(l)) {
				deport(white_player.getHorse('r'), p);
				return true;
			} else if (white_player.getCastle('l').getLocation().equals(l)) {
				deport(white_player.getCastle('l'), p);
				return true;
			} else if (white_player.getCastle('r').getLocation().equals(l)) {
				deport(white_player.getCastle('r'), p);
				return true;
			} else if (white_player.getSolider(0).getLocation().equals(l)) {
				deport(white_player.getSolider(0), p);
				return true;
			} else if (white_player.getSolider(1).getLocation().equals(l)) {
				deport(white_player.getSolider(1), p);
				return true;
			} else if (white_player.getSolider(2).getLocation().equals(l)) {
				deport(white_player.getSolider(2), p);
				return true;
			} else if (white_player.getSolider(3).getLocation().equals(l)) {
				deport(white_player.getSolider(3), p);
				return true;
			} else if (white_player.getSolider(4).getLocation().equals(l)) {
				deport(white_player.getSolider(4), p);
				return true;
			} else if (white_player.getSolider(5).getLocation().equals(l)) {
				deport(white_player.getSolider(5), p);
				return true;
			} else if (white_player.getSolider(6).getLocation().equals(l)) {
				deport(white_player.getSolider(6), p);
				return true;
			} else if (white_player.getSolider(7).getLocation().equals(l)) {
				deport(white_player.getSolider(7), p);
				return true;
			} else
				return false;
		}
	}

	private static void deport(Piece p, char c) {
		if (!reverse)
			d = 16;
		else
			d = 0;
		if (c == 'w') {
			moves.add(new Movement(p, Location.stoke[up_index - d]));
			senario.getItems().add(moves.get(Controller.count).getEvent());
			Controller.count++;
			p.setLocation(Location.stoke[up_index - d]);
			p.getBody().setLayoutX(Location.stoke[up_index - d].getX());
			p.getBody().setLayoutY(Location.stoke[up_index - d].getY());
			p.getBody().setDisable(true);
			p.setLife(false);
			up_index++;
		} else {
			moves.add(new Movement(p, Location.stoke[down_index + d]));
			senario.getItems().add(moves.get(Controller.count).getEvent());
			Controller.count++;
			p.setLocation(Location.stoke[down_index + d]);
			p.getBody().setLayoutX(Location.stoke[down_index + d].getX());
			p.getBody().setLayoutY(Location.stoke[down_index + d].getY());
			p.getBody().setDisable(true);
			p.setLife(false);
			down_index++;
		}
	}

	public static boolean isTurn(char p) {
		if (p == 'b')
			return black_player.getTurn();
		else
			return white_player.getTurn();
	}

	public static void onStock() {
		if (reverse)
			d = 0;
		else
			d = 16;

		for (int i = 0; i < 16; i++) {
			pieces[i + d].getBody().setLayoutX(Location.stoke[i].getX());
			pieces[i + d].getBody().setLayoutY(Location.stoke[i].getY());
			pieces[i + d].setLocation(Location.stoke[i]);
		}

		for (int i = 16; i < 32; i++) {
			pieces[i - d].getBody().setLayoutX(Location.stoke[i].getX());
			pieces[i - d].getBody().setLayoutY(Location.stoke[i].getY());
			pieces[i - d].setLocation(Location.stoke[i]);
		}

		for (Piece p : pieces)
			p.getBody().setDisable(true);
	}

	public static void onBord() {
		if (reverse)
			d = 16;
		else
			d = 0;
		Thread onborder = new Thread(new Runnable() {
			@Override
			public void run() {
				for (int i = 0; i < 16; i++) {
					transfer.setNode(pieces[i + d].getBody());
					transfer.setDestation(Location.locations[i]);
					transfer.playTransfer();
					try {
						Thread.sleep(800);
						while(transfer.isRuning());
					} catch (InterruptedException e) {}
					pieces[i + d].setLocation(Location.locations[i]);
				}
				for (int i = 16; i < 32; i++) {
					transfer.setNode(pieces[i - d].getBody());
					transfer.setDestation(Location.locations[i]);
					transfer.playTransfer();
					try {
						Thread.sleep(800);
						while(transfer.isRuning());
					} catch (InterruptedException e) {}
					pieces[i - d].setLocation(Location.locations[i]);
				}
			}
		});
		onborder.start();
		for (Piece p : pieces)
			p.getBody().setDisable(false);
		up_index = 16;
		down_index = 0;
	}
}