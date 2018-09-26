package chess.model;

import javafx.scene.control.Label;

public class Piece {
	protected boolean life;
	protected Label body;
	protected Coordinate location;

	public boolean haveLife() {
		return life;
	}

	public void setLife(boolean b) {
		life = b;
	}

	public Label getBody() {
		return body;
	}

	public void setBody(Label lbl) {
		body = lbl;
	}

	public Coordinate getLocation() {
		return location;
	}

	public void setLocation(Coordinate l) {
		location = l;
	}
}
