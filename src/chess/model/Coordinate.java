package chess.model;

public class Coordinate {
	private int X;
	private int Y;

	public Coordinate() {
		X = 0;
		Y = 0;
	}
	
	public Coordinate(Object x, Object y) {
		X = Integer.parseInt(String.valueOf(x));
		Y = Integer.parseInt(String.valueOf(y));
	}
	
	public Coordinate(int x, int y) {
		X = x;
		Y = y;
	}

	public void setX(int x) {
		X = x;
	}

	public int getX() {
		return X;
	}

	public void setY(int y) {
		Y = y;
	}

	public int getY() {
		return Y;
	}
}
