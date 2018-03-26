import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;

public class Crud_usuario{
	
	private Statement stm;
	
	public Crud_usuario() {}
	
	public void create(Usuario user) {
		conect("INSERT INTO `base_de_datos_polibooking`.`usuario` (`nombre`, `apellido`, `codigo`, `documento`, `clave`, `email`, `semestre`, `activo`, `jornada`, `rol`) "
						+ "VALUES ('"+user.getName()+"', '"+user.getLastName()+"', '"+user.getCode()+"', '"+user.getDocument()+"', '"+encrip(user.getPassword())+"', '"
				+user.getEmail()+"', '"+user.getSemester()+"', '"+user.getActive()+"', '"+user.getWorkingDay()+"', '"+user.getRol()+"');");
	}
	
	public void delete(Usuario user) {
		conect("DELETE FROM `base_de_datos_polibooking`.`usuario` WHERE `codigo`='"+user.getCode().trim()+"';");
	}
	
	public void update(Usuario user) {
		conect("UPDATE `base_de_datos_polibooking`.`usuario` SET `nombre`='"+user.getName()+"', `apellido`='"+user.getLastName()+"', `documento`='"
						+user.getDocument()+"', `clave`='"+encrip(user.getPassword())+"', `email`='"+user.getEmail()+"', `semestre`='"+user.getSemester()
						+"', `activo`='"+user.getActive()+"', `jornada`='"+user.getWorkingDay()+"', `rol`='"+user.getRol()+"' WHERE `codigo`='"+user.getCode()+"';");
	}
	
	public void retrieveTable() {
		try (Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/Base_de_datos_PoliBooking", "root", "A1023954647*");){
			Class.forName("com.mysql.jdbc.Driver");
			if(conec != null) {
				stm = conec.createStatement();
				ResultSet srt = stm.executeQuery("select * from Usuario");
				System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", "Name", "LastName", "Code", "Document", "Password", "E-mail", "Semester", "Active", "WorkingDay", "Rol");
				while(srt.next()) {
					String a = srt.getString(1);//Name
					String b = srt.getString(2);//Last Name
					String c = srt.getString(3);//Code
					String d = srt.getString(4);//Document
					String e = srt.getString(5);//Password
					String f = srt.getString(6);//E-Mail
					String g = srt.getString(7);//Semester
					String h = srt.getString(8);//Active
					String i = srt.getString(9);//WorkingDay
					String j = srt.getString(10);//Rol
					System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", a, b, c, d, e, f, g, h, i, j);
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
				ResultSet srt = stm.executeQuery("select * from Usuario WHERE `codigo`='"+user.getCode()+"';");
				System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", "Name", "LastName", "Code", "Document", "Password", "E-mail", "Semester", "Active", "WorkingDay", "Rol");
				while(srt.next()) {
					String a = srt.getString(1);//Name
					String b = srt.getString(2);//Last Name
					String c = srt.getString(3);//Code
					String d = srt.getString(4);//Document
					String e = srt.getString(5);//Password
					String f = srt.getString(6);//E-Mail
					String g = srt.getString(7);//Semester
					String h = srt.getString(8);//Active
					String i = srt.getString(9);//WorkingDay
					String j = srt.getString(10);//Rol
					System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", a, b, c, d, e, f, g, h, i, j);
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
	
	private String encrip(String password) {
		return DigestUtils.md5Hex(password.trim());
	}

}
