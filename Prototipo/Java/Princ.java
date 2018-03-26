import java.io.*;

public class Princ {

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private static String code;
	private static Base_de_Datos db;
	private static Usuario user;
	private static Servicios s = new Servicios();

	public static void main(String[] args) throws Exception{
		db = new Base_de_Datos();
		while(true) {
			if(verificacion()) {
				loop: while(true) {					
					election();
					if(!out()) continue;
					else break loop;
				}
			}
		}
	}

	public static boolean verificacion() throws Exception {
		System.out.print("Digite su código estudiantil: ");
		code = in.readLine();
		while(code.length() != 10 || !db.codeEx(code)) {
			System.out.print("ERROR: Código no válido, digite de nuevo: ");
			code = in.readLine();
		}
		System.out.println("Usuario verificado, ingrese su contraseña (Intentos 3)");
		String pass = db.getDatos(code).getPassword();
		String password = in.readLine().trim();
		String temp = decod(password);
		int cont = 0;
		while(!temp.equals(pass)) {
			cont++;
			if(cont == 3)break;
			System.out.println("Contraseña erronea, intente de nuevo (Intentos " + (3-cont) + ")");
			password = in.readLine();
			temp = decod(password);
		}
		if(cont == 3) {
			System.out.println("Ha excedido el límite de intentos. Intente más tarde");
			return false;
		}
		user = db.getDatos(code);
		String name = user.getName().substring(0, 1).toUpperCase() + user.getName().substring(1);
		String last = user.getLastName().substring(0, 1).toUpperCase() + user.getLastName().substring(1);
		System.out.println("Bienvenido " + name + " " + last);
		return true;
	}

	private static String decod(String clave){
		char [] c = clave.toCharArray();
		int [] cAn = new int[c.length];//De char a int
		char [] nAc = new char [cAn.length];//De int a char
		for (int i = 0; i < c.length; i++) {
			cAn[i]=c[cAn.length-i-1]+2;
			nAc[i]=(char)cAn[i];
		}
		return new String(nAc);
	}

	public static void election() throws Exception {
		System.out.println("Digite el servicio a elegir \n1: Biblioteca, 2: Gimnasio, 3: Ninguno");
		String election = in.readLine().trim();
		if(election.equals("3")) return;
		while(!election.equals("1") && !election.equals("2")) {
			System.out.print("Eleccion no válida, digite de nuevo");
			election = in.readLine();
		}
		if(election.equals("1")) {
			System.out.println("1: Para 1 o 2 personas?.  2: Para más de 2 personas?.");
			String personas = in.readLine().trim();
			if(personas.equals("2")) election = "3";
		}
		s.solServ(Integer.parseInt(election), code);
		System.out.println(s.servSolicitado(code));
	}

	public static boolean out() throws Exception{
		System.out.print("Desea salir? 1:Si, 2:No ");
		String a = in.readLine().trim();
		while(!a.equals("1") && !a.equals("2")) {
			System.out.println("La opcion no existe, intente de nuevo");
			a = in.readLine().trim();
		}
		if(a.equals("1")) {
			return true;
		}
		else {
			return false;
		}
	}

	public static String getCode() {
		return code;
	}
}
