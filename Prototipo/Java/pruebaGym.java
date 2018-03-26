
public class pruebaGym {

	static Crud_gym c = new Crud_gym();

	public static void main(String[] args) {
		String turn = "1";
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


		c.create(user);
//		c.delete(user);
//		c.update(user, "2");
		c.retrieveTable();
//		c.retrieveUser(user);


	}

}
