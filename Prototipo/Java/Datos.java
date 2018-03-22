/**
 * @category Clase para crear un nuevo participante
 */
public class Datos{

	/**
	 * name : String Recibe el nombre del participante
	 * lastName : String Recibe el apellido del participante
	 * semester : int Recibe el semestre acutual
	 * registered : boolean True si está matriculado; False si no está matriculado
	 * workingDay : boolean True si es diuno; False si es nocturno
	 * rol : int 0 si es estudiante; 1 si es docente; 2 si es colaborador
	 * password : Se supone es la misma contraseña de moodle
	 */
	private String name;
	private String lastName;
	private int semester;
	private boolean registered;
	private boolean workingDay;
	private int rol; 
	private String password;
	/**
	 * @param name : Nombre del usuario
	 * @param lastName : Apellido del usuario
	 * @param semester : Numero de semestre actual(semester > 0)
	 * @param registered : Esta matriculado o no 
	 * @param workingDay : Jornada (True: dia, False, noche)
	 * @param rol : Rol dentro de la universidad (0 <= rol <= 2)
	 * @param password : Contraseña
	 */
	public Datos(String name, String lastName, int semester, boolean registered, boolean workingDay, int rol, String password) {
		this.name = name.toLowerCase();
		this.lastName = lastName.toLowerCase();
		if(semester < 0) this.semester = 0;
		else this.semester = semester;			
		this.registered = registered;
		this.workingDay = workingDay;
		if(rol >= 0 && rol <= 2) this.rol = rol;
		else this.rol = 0;
		this.password = decod(password);
	}

	public String getName() {
		return name;
	}

	public String getLastName() {
		return lastName;
	}

	public int getSemester() {
		return semester;
	}

	public boolean isRegistered() {
		return registered;
	}

	public boolean isWorkingDay() {
		return workingDay;
	}

	public int getRol() {
		return rol;
	}

	public String getPasswordd() {
		return password;
	}
	/**
	 * @category Decodifica la clave para mayor seguridad
	 * @param clave : ingresada por el usuario
	 * @return Clave decodificadad
	 */
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
}
