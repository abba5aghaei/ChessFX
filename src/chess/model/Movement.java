package chess.model;

public class Movement {
	private Coordinate current;
	private Coordinate previuos;
	private String piece;
	private String piece_name;
	private char type;
	private String event;
	private String query;
	
	public Movement(Coordinate c, Piece p, char t) {
		current = c;
		previuos = p.getLocation();
		piece = p.getBody().getId();
		type = t;
		piece_name = getPieceName(piece);
		event = piece_name+" از "+Location.getLocationName(previuos)+" به "+Location.getLocationName(current)+" حرکت کرد";
		query = "move "+piece+" from "+Location.getLocationName(previuos)+" to "+Location.getLocationName(current);
	}
	
	public Movement(Piece p, Coordinate c) {
		current = c;
		previuos = p.getLocation();
		type = 'k';
		piece = p.getBody().getId();
		piece_name = getPieceName(piece);
		event = piece_name+" از بین رفت";
		query = "deport "+piece_name;
	}
	public Movement() {
		
	}
	
	private String getPieceName(String p) {
		if(p.equals("bk")) {
			return "شاه سیاه";
		}
		else if(p.equals("bq")) {
			return "وزیر سیاه";
		}
		else if(p.equals("ble") || p.equals("bre")) {
			return "فیل سیاه";
		}
		else if(p.equals("blh") || p.equals("brh")) {
			return "اسب سیاه";
		}
		else if(p.equals("blc")| p.equals("brc")) {
			return "قلعه سیاه";
		}
		else if(p.equals("bs1") || p.equals("bs2") || p.equals("bs3") || p.equals("bs4")) {
			return "سرباز سیاه";
		}
		else if(p.equals("bs5") || p.equals("bs6") || p.equals("bs7") || p.equals("bs8")) {
			return "سرباز سیاه";
		}
		else if(p.equals("wk")) {
			return "شاه سفید";
		}
		else if(p.equals("wq")) {
			return "وزیر سفید";
		}
		else if(p.equals("wle") || p.equals("wre")) {
			return "فیل سفید";
		}
		else if(p.equals("wlh") || p.equals("wrh")) {
			return "اسب سفید";
		}
		else if(p.equals("wlc")| p.equals("wrc")) {
			return "قلعه سفید";
		}
		else if(p.equals("ws1") || p.equals("ws2") || p.equals("ws3") || p.equals("ws4")) {
			return "سرباز سفید";
		}
		else if(p.equals("ws5") || p.equals("ws6") || p.equals("ws7") || p.equals("ws8")) {
			return "سرباز سفید";
		}
		return "بی نام";
	}
	public Coordinate getCurrent() {
		return current;
	}
	public Coordinate getPreviuos() {
		return previuos;
	}
	public String getPiece() {
		return piece;
	}
	public char getType() {
		return type;
	}
	public String getEvent() {
		return event;
	}
	public void setCurrent(Coordinate c) {
		current = c;
	}
	public void setPreviuos(Coordinate p) {
		previuos = p;
	}
	public void setPiece(String p) {
		piece = p;
		piece_name = getPieceName(p);
	}
	public void setType(char t) {
		type = t;
	}
	public void setEvent(String e) {
		event = e;
	}

	public String getPieceName() {
		return piece_name;
	}
	
	public void setQuery(String q) {
		query = q;
	}
	
	public String getQuery() {
		return query;
	}
}
