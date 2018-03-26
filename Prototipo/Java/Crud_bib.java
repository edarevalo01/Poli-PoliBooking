import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;

public class Crud_bib {
	
	private Statement stm;
	
	public Crud_bib() {}
	
	public void create(Usuario user, String cubiculo) {
		conect("INSERT INTO `base_de_datos_polibooking`.`solicitudserviciobiblioteca` (`cod_usuario_bib`, `numero_cubiculo`, `hora_inicio`, `hora_final`)"
				+ " VALUES ('"+user.getCode()+"', '"+cubiculo+"', '"+horaIni()+"', '"+horaFin()+"');");
	}
	
	public void delete(Usuario user) {
		conect("DELETE FROM `base_de_datos_polibooking`.`solicitudserviciobiblioteca` WHERE `cod_usuario_bib`='"+user.getCode()+"';");
	}
	/**
	 * @see La hora se mantiene porque solo esta cambiando de cubiculo..
	 * @param user
	 * @param nuevoCub
	 */
	public void update(Usuario user, String nuevoCub) {
		conect("UPDATE `base_de_datos_polibooking`.`solicitudserviciobiblioteca` SET `numero_cubiculo`='"+nuevoCub+"' WHERE `cod_usuario_bib`='"+user.getCode()+"';");
	}
	
	public void retrieveTable() {
		try (Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/Base_de_datos_PoliBooking", "root", "A1023954647*");){
			Class.forName("com.mysql.jdbc.Driver");
			if(conec != null) {
				stm = conec.createStatement();
				ResultSet srt = stm.executeQuery("select * from solicitudserviciobiblioteca");
				System.out.printf("%-13s%-11s%-25s%-13s\n", "Code", "Cubiculo", "Start", "End");
				while(srt.next()) {
					String a = srt.getString(1);//Code
					String b = srt.getString(2);//Cub
					String c = srt.getString(3);//Start
					String d = srt.getString(4);//End
					System.out.printf("%-13s%-11s%-25s%-13s\n", a, b, c, d);
				}
			}
			else return;
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	public void retrieveUser(Usuario user) {
		try (Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/Base_de_datos_PoliBooking", "root", "A1023954647*");){
			Class.forName("com.mysql.jdbc.Driver");
			if(conec != null) {
				stm = conec.createStatement();
				ResultSet srt = stm.executeQuery("select * from solicitudserviciobiblioteca WHERE `cod_usuario_bib`='"+user.getCode()+"';");
				System.out.printf("%-13s%-11s%-25s%-13s\n", "Code", "Cubiculo", "Start", "End");
				while(srt.next()) {
					String a = srt.getString(1);//Code
					String b = srt.getString(2);//Cub
					String c = srt.getString(3);//Start
					String d = srt.getString(4);//End
					System.out.printf("%-13s%-11s%-25s%-13s\n", a, b, c, d);
				}
			}
			else {
				return;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	private void conect(String sentence) {
		try (Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/Base_de_datos_PoliBooking", "root", "A1023954647*");){
			Class.forName("com.mysql.jdbc.Driver");
			if(conec != null) {
				System.out.println(conec);
				stm = conec.createStatement();
				stm.executeUpdate(sentence);
			}
			else {
				System.err.println("No Connect");
				return;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
	}
	
	private String horaIni() {
		Date d = new Date();
		String comp = d.toString();
		String dia = comp.substring(8, 10);
		String mes = comp.substring(4,7).toLowerCase();
		String ano = comp.substring(24);
		String hora = comp.substring(11,13);
		String min = comp.substring(14,16);
		String sec = comp.substring(17, 19);
		return ano+"-"+len(mes(mes))+"-"+dia+" "+hora+":"+min+":"+sec;
	}
	
	private String horaFin() {
		Date d = new Date();
		String comp = d.toString();
		String dia = comp.substring(8, 10);
		String mes = comp.substring(4,7).toLowerCase();
		String ano = comp.substring(24);
		String hora = comp.substring(11,13);
		String min = comp.substring(14,16);
		String sec = comp.substring(17, 19);
		return ano+"-"+len(mes(mes))+"-"+dia+" "+horaMas(hora)+":"+min+":"+sec;
	}
	
	private String horaMas(String hora) {
		if(hora.equals("22")) return "00";
		else if(hora.equals("23"))return "01";
		else return String.valueOf(Integer.parseInt(hora)+2);
	}

	private String len(String any) {
		if(any.length()==1) return "0"+any;
		else return any;
	}
	
	private String mes(String mes) {
		switch (mes) {
		case "jan": return "01";
		case "feb": return "02";
		case "mar": return "03";
		case "apr": return "04";
		case "may": return "05";
		case "jun": return "06";			
		case "jul": return "07"; 
		case "aug": return "08"; 
		case "sep": return "09";
		case "oct": return "10";
		case "nov": return "11";
		case "dec": return "12";
		}
		return "";
	}

}
