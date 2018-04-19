package co.edu.poli.ing.polibooking;

/**
 * @category Clase para crear un nuevo participante
 */
public class Usuario{

	private String name;
	private String lastName;
	private String code;
	private String document;
	private String password;
	private String email;
	private String semester;
	private String active;
	private String workingDay;
	private String rol;
	/**
	 * @param name : nombre
	 * @param lastName : apellido
	 * @param code : codigo de 10 digitos 
	 * @param document : documento de identidad 
	 * @param password : clave(toca encriptar)
	 * @param email : correo
	 * @param semester : semestre actual
	 * @param active : 0: si, 1: no (esto puede ser un checkbox)
	 * @param workingDay : 'dia', 'noche' (lista desplegable)
	 * @param rol : 'estudiante', 'docente', 'administrativo' ( lista desplegable)
	 */
	public Usuario(String name, String lastName, String code, String document, String password, String email, String semester, String active, String workingDay, String rol) {
		if(name.length() == 0 || lastName.length() == 0 || code.length() == 0 || document.length() == 0 || password.length() == 0 || email.length() == 0 || semester.length() == 0 ) {
			System.err.println("Ningun campo puede estar vacio");
			return;
		}
		else if(code.length()!=10) {
			System.err.println("El codigo tiene que ser de 10 digitos");
			return;
		}
		this.name = name;
		this.lastName = lastName;
		this.code = code;
		this.document = document;
		this.password = password;
		this.email = email;
		this.semester = semester;
		this.active = active;
		this.workingDay = workingDay;
		this.rol = rol;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public String getCode() {
		return code;
	}
	public String getDocument() {
		return document;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getSemester() {
		return semester;
	}
	public String getActive() {
		return active;
	}
	public String getWorkingDay() {
		return workingDay;
	}
	public String getRol() {
		return rol;
	}
}
