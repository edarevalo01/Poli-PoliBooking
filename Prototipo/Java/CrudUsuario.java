package co.edu.poli.ing.polibooking;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.codec.digest.DigestUtils;

public class CrudUsuario{

	private Statement stm;

	public CrudUsuario() {}

	public void create(Usuario user) {
		conect("INSERT INTO `base_de_datos_polibooking`.`usuario` (`nombre`, `apellido`, `codigo`, `documento`, `clave`, `email`, `semestre`, `activo`, `jornada`, `rol`) "
				+ "VALUES ('"+user.getName()+"', '"+user.getLastName()+"', '"+user.getCode()+"', '"+user.getDocument()+"', '"+encrip(user.getPassword())+"', '"
				+user.getEmail()+"', '"+user.getSemester()+"', '"+user.getActive()+"', '"+user.getWorkingDay()+"', '"+user.getRol()+"');");
	}

	public void delete(String code) {
		conect("DELETE FROM `base_de_datos_polibooking`.`usuario` WHERE `codigo`='"+code.trim()+"';");
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
					String name = srt.getString(1);//Name
					String lastName = srt.getString(2);//Last Name
					String code = srt.getString(3);//Code
					String document = srt.getString(4);//Document
					String password = srt.getString(5);//Password
					String email = srt.getString(6);//E-Mail
					String semester = srt.getString(7);//Semester
					String active = srt.getString(8);//Active
					String workingDay = srt.getString(9);//WorkingDay
					String rol = srt.getString(10);//Rol
					System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", name, lastName, code, document, password, email, semester, active, workingDay, rol);
				}
			}
			else return;
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		finally {
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public Usuario retrieveUser(String code) {
		Usuario usuario = null;
		try (Connection conec = DriverManager.getConnection("jdbc:mysql://localhost/Base_de_datos_PoliBooking", "root", "A1023954647*");){
			Class.forName("com.mysql.jdbc.Driver");
			if(conec != null) {
				stm = conec.createStatement();
				ResultSet srt = stm.executeQuery("select * from Usuario WHERE `codigo`='"+code.trim()+"';");
				System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", "Name", "LastName", "Code", "Document", "Password", "E-mail", "Semester", "Active", "WorkingDay", "Rol");
				if(srt.next()) { 
					String name = srt.getString(1);//Name
					String lastName = srt.getString(2);//Last Name
					String codde = srt.getString(3);//Code
					String document = srt.getString(4);//Document
					String password = srt.getString(5);//Password
					String email = srt.getString(6);//E-Mail
					String semester = srt.getString(7);//Semester
					String active = srt.getString(8);//Active
					String workingDay = srt.getString(9);//WorkingDay
					String rol = srt.getString(10);//Rol
					System.out.printf("%-12s%-12s%-14s%-13s%-35s%-22s%-10s%-9s%-13s%-10s\n", name, lastName, codde, document, password, email, semester, active, workingDay, rol);
					usuario = new Usuario(name, lastName, codde, document, password, email, semester, active, workingDay, rol);
				}
				else {
					return usuario;
				}

			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return usuario;
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
			stm.close();
		}
		catch(Exception e) {
			e.printStackTrace();
			return;
		}
		finally {
			if(stm != null) {
				try {
					stm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private String encrip(String password) {
		return DigestUtils.md5Hex(password.trim());
	}

	public boolean login(String code, String password) {
		Usuario user = retrieveUser(code);
		return user != null && user.getPassword().equals(encrip(password));
	}
	

}
