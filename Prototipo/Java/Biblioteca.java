package co.edu.poli.ing.polibooking;

public class Biblioteca {
	
	private String code;
	private String cubicle;
	private String hourStart;
	private String hourEnd;
	
	public Biblioteca(String code, String cubicle, String hourStart, String hourEnd) {
		this.code = code;
		this.cubicle = cubicle;
		this.hourStart = hourStart;
		this.hourEnd = hourEnd;
	}

	public String getCode() {
		return code;
	}

	public String getCubicle() {
		return cubicle;
	}

	public String getHourStart() {
		return hourStart;
	}

	public String getHourEnd() {
		return hourEnd;
	}

}
