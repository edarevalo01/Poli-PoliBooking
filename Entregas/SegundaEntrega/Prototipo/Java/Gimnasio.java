package co.edu.poli.ing.polibooking;

public class Gimnasio {
	
	private String code;
	private String turn;
	private String hourStart;
	private String hourEnd;
	
	public Gimnasio(String code, String turn, String hourStart, String hourEnd) {
		this.code = code;
		this.turn = turn;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
	}

	public String getCode() {
		return code;
	}

	public String getTurn() {
		return turn;
	}

	public String getHourStart() {
		return hourStart;
	}

	public String getHourEnd() {
		return hourEnd;
	}

}
