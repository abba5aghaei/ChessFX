package chess.model;

public class Player {
	private String name;
	private boolean turn;
	private King king;
	private Queen queen;
	private Elephent left_elephent, right_elephent;
	private Horse left_horse, right_horse;
	private Castle left_castle, right_castle;
	private Solider[] soliders;
	public Player(String n) {
		name = n;
		turn = true;
		king = new King();
		queen = new Queen();
		left_elephent = new Elephent();
		right_elephent = new Elephent();
		left_horse = new Horse();
		right_horse = new Horse();
		left_castle = new Castle();
		right_castle = new Castle();
		soliders = new Solider[8];
		for(int i=0 ; i<8 ; i++)
			soliders[i] = new Solider();
	}
	public void setName(String n) {
		name = n;
	}
	public String getName() {
		return name;
	}
	public void setTurn(boolean b) {
		turn = b;
	}
	public boolean getTurn() {
		return turn;
	}
	public King getKing() {
		return king;
	}
	public Queen getQueen() {
		return queen;
	}
	public Elephent getElephent(char o) {
		if(o=='l')
			return left_elephent;
		else
			return right_elephent;
	}
	public Horse getHorse(char o) {
		if(o=='l')
			return left_horse;
		else
			return right_horse;
	}
	public Castle getCastle(char o) {
		if(o=='l')
			return left_castle;
		else
			return right_castle;
	}
	public Solider getSolider(int i) {
		return soliders[i];
	}
}
