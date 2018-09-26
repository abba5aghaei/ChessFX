package chess;

import chess.model.Coordinate;
import javafx.application.Platform;
import javafx.scene.Node;

public class Transfer {
	private Node node;
	private Coordinate destation;
	private int speed;
	private boolean runing;

	public Transfer() {
		node = null;
		destation = null;
		speed = 1;
		runing = false;
	}

	public Transfer(Node n) {
		node = n;
		destation = null;
		speed = 1;
		runing = false;
	}

	public Transfer(Node n, Coordinate d) {
		node = n;
		destation = d;
		speed = 1;
		runing = false;
	}

	public void setNode(Node n) {
		node = n;
	}

	public void setDestation(Coordinate d) {
		destation = d;
	}

	public void setSpeed(int s) {
		speed = s;
	}

	public Node getNode() {
		return node;
	}

	public Coordinate getDestation() {
		return destation;
	}

	public int getSpeed() {
		return speed;
	}
	
	public boolean isRuning() {
		return runing;
	}

	public void playTransfer() {
		Thread player = new Thread(new Runnable() {
			double x = node.getLayoutX();
			double y = node.getLayoutY();
			@Override
			public void run() {
				runing = true;
				try {
					double ex = x - destation.getX();
					double ey = y - destation.getY();
					for (int i = 0; i < 300; i++) {
						Platform.runLater(new Runnable() {
							@Override
							public void run() {
								x -= ex / 300;
								y -= ey / 300;
								node.setLayoutX(x);
								node.setLayoutY(y);
							}
						});
						Thread.sleep(speed);
					}
				} catch (Exception e) {}
				runing = false;
			}
		});
		player.start();
	}
}
