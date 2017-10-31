package co.com.parcial1.piedrapapeltijera.servier;

/**
 * Clase que almacena las constantes para el Servidor
 * 
 * @author Jaime Andres Rojas Ocampo
 * @author Laura Diez Castrillon
 */
public class Constantes {
	public static final Integer PUERTO_POR_DEFECTO = 1337;
	public static final String MENSAJE_BIENVENIDA = "Se inicializara la partida en el puerto " + PUERTO_POR_DEFECTO;
	// Mensajes usuario
	public static final String JUGADOR_UNO_CONECTADO_ESPERANDO_DOS = "\nJugador 1 conectado, a espera del segundo jugador";
	public static final String JUGADOR_DOS_INICIAR_JUEGO = "\nJugador 2 conectado, QUE INICIE EL JUEGO!!!";
	
	public static final String EMPATE = "Empate";
	public static final String GANASTE = "GANASTE!!";
	public static final String PERDISTE = "Perdiste :(";
	
	public static final String ESPERANDO_NUEVOS_JUGADORES = "\nEspera nuevos jugadores...\n";
	
	// Reglas de juego
	public static final String ROCA = "R";
	public static final String PAPEL = "P";
	public static final String TIJERA = "T";
}
