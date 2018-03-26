import java.util.*;
/**
 * @category Esta clase es una Base de datos provisional
 */
public class Base_de_Datos {
	/**
	 * El campo de dato -datos- representa cada uno de los miembros de la base de datos
	 * es un mapa que describe las siguientes caracteristicas
	 * Como Key contiene un tipo de dato String, el cuál será un número de 10 cifras (código estudiantil)
	 * Como Value contiene un arreglo de Strings los cules van a representar el nombre, apellido, semestre, matriculado, jornada
	 */
	private Map<String, Usuario> datos; 
	/**
	 * @category Se inicializa la base de datos con unos usuarios iniciales
	 */
	public Base_de_Datos() {
		datos = new TreeMap<>();
		datos.put("1520010900", new Usuario("user","0","0000000000","0000000000","123","user0@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010901", new Usuario("user","1","0000000001","0000000001","123","user1@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010902", new Usuario("user","2","0000000002","0000000002","123","user2@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010903", new Usuario("user","3","0000000003","0000000003","123","user3@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010904", new Usuario("user","4","0000000004","0000000004","123","user4@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010905", new Usuario("user","5","0000000005","0000000005","123","user5@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010906", new Usuario("user","6","0000000006","0000000006","123","user6@gmail.com","1","0","dia","estudiante"));
		datos.put("1520010907", new Usuario("user","7","0000000007","0000000007","123","user7@gmail.com","1","0","dia","estudiante"));
	}
	/**
	 * @category Verificar si el estudiante existe en la base de datos
	 * @param code : Codigo de estudiante
	 * @return Si el estudiante existe en la base de datos
	 */
	public boolean codeEx(String code) {
		return datos.containsKey(code);
	}
	/**
	 * @category Obtener los datos de un estudiante
	 * @param code : Codigo de estudiante
	 * @return Datos del estudiante
	 */
	public Usuario getDatos(String code) {
		return datos.get(code);
	}
	/**
	 * @category Agregar un nuevo estudiante
	 * @param cd : Codigo de estudiante
	 * @param dt : Datos a agregar
	 */
	public void addDatos(String cd, Usuario dt) {
		if(datos.containsKey(cd)) System.out.println("Ya existe el usuario con codigo " + cd + ".");
		else datos.put(cd, dt);
	}
    /**
     * @category Modificar un estudiante
     * @param cd : Codigo de estudiante
     * @param dt : Datos a modificar
      * @return Si fue posible su modificacion
     */
	public boolean modify(String cd, Usuario dt) {
		if(datos.containsKey(cd)) datos.put(cd, dt);
		else return false;
		return true;
	}
}