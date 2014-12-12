package card_games;
import villa7.Print;

import java.util.*;

public class Bjp {
	public static Scanner s = new Scanner(System.in);
	public static Print p = new Print();
	public int total = 0;
	public String action = "",
				   name = "";
	public boolean isWinner = false,
					isFirstTurn = true,
					isAI = false;
	public Bjp() {
		super(); //not really needed but whatever
	}
	public Bjp(String name) {
		this.name = name;
		p.nl("Player \"" + name + "\" created.");
	}
	public Bjp(String name, boolean isAI) {
		this.name = name;
		this.isAI = isAI;
		p.nl("Player \"" + name + "\" created.");
	}
	public String getName() {
		return name;
	}
	public String getAction() {
		return s.next();
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public void addTotal(int total) {
		this.total += total;
	}
	public boolean isFirstTurn() {
		return isFirstTurn;
	}
	public void setFirstTurn(boolean isFirstTurn) {
		this.isFirstTurn = isFirstTurn;
	}
	public boolean isWinner() {
		return isWinner;
	}
	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
	public boolean isAI() {
		return isAI;
	}
	public void setAI(boolean isAI) {
		this.isAI = isAI;
	}

}
