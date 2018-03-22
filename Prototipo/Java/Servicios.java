import java.util.*;

public class Servicios {

	private long [][] biblioteca; //Hay 15 cubículos cada índice de una fila+1 es un cubiculo
	private long [][] gimnasio; //Hay 8 cupos por hora cada índice de una fila+1 es un cupo
	private int indiceB;//Qué cubículo está en uso en la matriz
	private boolean cubiculosPequeLlena;
	private boolean cubiculosGrandLlena;
	private int cubGrandes; //hay 7 cubiculos 
	private int indiceG;
	private boolean gimLleno;
	private Map<String, Integer> solicitudB; //KEY: Code, VALUE: indice biblioteca
	private Map<String, Integer> solicitudG; //KEY: Code, VALUE: indice biblioteca
	private Base_de_Datos db;

	public Servicios() {
		biblioteca = new long[15][2]; //Para la columna 0 se asigna si esta o no usada (1: si esta usada) (0: si no esta), para la columna 1 es el tiempo transcurrido
		gimnasio = new long[8][2]; 
		cubGrandes = indiceB+7;
		indiceB = 0;
		indiceG = 0;
		cubiculosPequeLlena = false;
		cubiculosGrandLlena = false;
		gimLleno = false;
		solicitudB = new TreeMap<>();
		solicitudG = new TreeMap<>();
		db = new Base_de_Datos();
	}

	/**
	 * @param a:  numero de servicio 1: biblioteca, 2: gimnasio
	 * @param code: código de usuario
	 */
	public void solServ(int a, String code) { //Solicitar servicio
		if(servSolicitado(code).equals("No ha solicitado ningun servicio")) {
			if(a==1 && disponibilidad(a)) {//Servicio biblioteca
				if(indiceB < 7 && biblioteca[indiceB][0] == 0) {
					asignB(code);
				}
				else {
					if(indiceB >= 7) {
						System.out.println("No hay cubiculos pequeños disponibles");
						cubiculosPequeLlena = true;
					}
					else {
						indiceB++;
						asignB(code);
					}
				}
			}
			else if(a==2 && disponibilidad(a)) {
				if(indiceG < 7 && gimnasio[indiceG][0] == 0) {
					asignG(code);
				}
				else {
					if(indiceB == 7) {
						System.out.println("No hay cupos disponibles");
						gimLleno = true;
					}
					else {
						indiceG++;
						asignG(code);
					}
				}
			}
			else if(a==3 && disponibilidad(a)) {
				if(cubGrandes < 14 && biblioteca[cubGrandes][0] == 0) {
					asignBG(code);
				}
				else {
					if(cubGrandes == 14) {
						System.out.println("No hay cubiculos grandes disponibles");
						cubiculosGrandLlena = true;
					}
					else {
						cubGrandes++;
						asignBG(code);
					}
				}
			}
		}
		else {
			System.out.println("Ya solicitó un servicio.");
		}
	}

	public String servSolicitado(String code) {
		if(solicitudB.containsKey(code)) {
			int a = solicitudB.get(code);
			return "El usuario " + db.getDatos(code).getName() + " tiene en uso el cubiculo de biblioteca #" + String.valueOf(a+1) ;
		}
		if(solicitudG.containsKey(code)) {
			int a = solicitudG.get(code);
			return "El usuario " + db.getDatos(code).getName() + " tiene el turno de gimnasio #" + String.valueOf(a+1) ;
		}
		else return "No ha solicitado ningun servicio";
	}

	private void asignBG(String code) {
		biblioteca[cubGrandes][0] = 1;
		biblioteca[cubGrandes][1] = Long.parseLong(code);
		solicitudB.put(code, cubGrandes);
		cubGrandes++;
	}
	
	private void asignB(String code) {
		biblioteca[indiceB][0] = 1;
		biblioteca[indiceB][1] = Long.parseLong(code);
		solicitudB.put(code, indiceB);
		indiceB++;
	}

	private void asignG(String code) {
		gimnasio[indiceG][0] = 1;
		gimnasio[indiceG][1] = Long.parseLong(code);
		solicitudG.put(code, indiceG);
		indiceG++;
	}

	private boolean disponibilidad(int a) {
		if(a==1 && cubiculosPequeLlena) {
			System.out.println("Todo los cubículos pequeños están en uso.");
			return false;
		}
		else if(a==2 && gimLleno) {
			System.out.println("Los cupos del Gimnasio están llenos.");
			return false;
		}
		else if(a==3 && cubiculosGrandLlena) {
			System.out.println("Todos los cubiculos grandes estan en uso");
			return false;
		}
		else return true;
	}

	/*private void calcTime() {
		long timeS , timeE = 0;
		timeS = System.currentTimeMillis();
		for(;;) {
			timeE = System.currentTimeMillis();
			if((timeE - timeS)/1000 == 7200) {//Se demora 7200s que equivale a 2 horas
				break;
			}
		}
		System.out.println((timeE - timeS)/1000/60);
	}*/

}
