
public class pruebaUser {

	public static void main(String[] args) throws Exception {
		String turn = "5";
		String name = "usuario".toLowerCase();
		String lastName = turn.toLowerCase();
		String code = "000000000"+turn;//En la interfaz recibe un numero y lo transforma a string, para evitar recibir letras
		String document = "000000000"+turn;//En la interfaz recibe un numero y lo transforma a string, para evitar recibir letras
		String password = "124";
		String email = "usuario"+turn+"@gmail.com".toLowerCase();
		String semester = "1";//En la interfaz recibe un numero y lo transforma a string, para evitar recibir letras
		String active = "0";//En la interfaz esto es un checkbox
		String workingDay = "dia".toLowerCase(); //Esto es una lista desplegable
		String rol = "EsTudIANTE".toLowerCase(); //Esto es una lista desplegable
		
		Usuario user = new Usuario(name, lastName, code, document, password, email, semester, active, workingDay, rol);
		
		Crud_usuario c = new Crud_usuario();
		c.create(user);
//		c.delete(user);
//		c.update(user);
		c.retrieveTable();
//		c.retrieveUser(user);
	}

}
