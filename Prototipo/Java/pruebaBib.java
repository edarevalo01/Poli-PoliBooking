
public class pruebaBib {

	public static void main(String[] args) {
		String turn = "4";
		String name = "usuario".toLowerCase();
		String lastName = turn.toLowerCase();
		String code = "000000000"+turn;
		String document = "000000000"+turn;
		String password = "124";
		String email = "usuario"+turn+"@gmail.com".toLowerCase();
		String semester = "1";
		String active = "0";
		String workingDay = "dia".toLowerCase(); 
		String rol = "EsTudIANTE".toLowerCase();
		
		Usuario user = new Usuario(name, lastName, code, document, password, email, semester, active, workingDay, rol);
		
		Crud_bib c = new Crud_bib();
		c.create(user, String.valueOf(Integer.parseInt(turn)+1));
//		c.delete(user);
//		c.update(user, "2");
		c.retrieveTable();
//		c.retrieveUser(user);

	}

}
