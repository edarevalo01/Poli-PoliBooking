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
	private Map<String, Datos> datos; 
	/**
	 * @category Se inicializa la base de datos con unos usuarios iniciales
	 */
	public Base_de_Datos() {
		datos = new TreeMap<>();
		datos.put("1520010900", new Datos("user", "01", 6, true, false, 0, "543"));
		datos.put("1520010901", new Datos("user", "02", 6, true, true, 0, "543"));
		datos.put("1520010902", new Datos("user", "03", 5, true, false, 0, "543"));
		datos.put("1520010903", new Datos("user", "04", 7, true, false, 0, "543"));
		datos.put("1520010904", new Datos("user", "05", 5, true, false, 0, "543"));
		datos.put("1520010905", new Datos("user", "06", 5, true, false, 0, "543"));
		datos.put("1520010906", new Datos("user", "07", 1, true, true, 2, "543"));
		datos.put("1520010907", new Datos("user", "08", 0, true, true, 1, "543"));
		datos.put("1520010908", new Datos("user", "09", 1, true, true, 1, "543"));
		datos.put("1520010909", new Datos("user", "10", 1, true, true, 1, "543"));
		datos.put("1520010910", new Datos("user", "11", 1, true, true, 1, "543"));
		datos.put("1520010911", new Datos("user", "12", 1, true, true, 1, "543"));
		datos.put("1520010912", new Datos("user", "13", 1, true, true, 1, "543"));
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
	public Datos getDatos(String code) {
		return datos.get(code);
	}
	/**
	 * @category Agregar un nuevo estudiante
	 * @param cd : Codigo de estudiante
	 * @param dt : Datos a agregar
	 */
	public void addDatos(String cd, Datos dt) {
		if(datos.containsKey(cd)) System.out.println("Ya existe el usuario con codigo " + cd + ".");
		else datos.put(cd, dt);
	}
    /**
     * @category Modificar un estudiante
     * @param cd : Codigo de estudiante
     * @param dt : Datos a modificar
      * @return Si fue posible su modificacion
     */
	public boolean modify(String cd, Datos dt) {
		if(datos.containsKey(cd)) datos.put(cd, dt);
		else return false;
		return true;
	}
}