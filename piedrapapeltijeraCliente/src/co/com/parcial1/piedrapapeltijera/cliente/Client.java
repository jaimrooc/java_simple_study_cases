package co.com.parcial1.piedrapapeltijera.cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * Clase con la logia del jugador
 * 
 * @author Jaime Andres Rojas Ocampo
 * @author Laura Diez Castrillon
 */
class Client {

	public static void main(String args[]) throws Exception {

		String entradaDeDato = "";
		String respuestaServidor;

		BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
		Socket clientSocket = new Socket(Constantes.HOST_POR_DEFECTO, Constantes.PUERTO_POR_DEFECTO);
		DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
		BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

		System.out.println(Constantes.INGRESANDO);
		do {
			System.out.println(Constantes.REGLAS_DE_JUEGO);
			entradaDeDato = inFromUser.readLine();

		} while (!entradaDeDato.equals(Constantes.ROCA) && !entradaDeDato.equals(Constantes.PAPEL)
				&& !entradaDeDato.equals(Constantes.TIJERA));

		// Envia al servidor
		outToServer.writeBytes(entradaDeDato + "\n");
		System.out.println(entradaDeDato + Constantes.MENSAJE_ENVIO);

		// Obtiene respuesta
		respuestaServidor = inFromServer.readLine();

		// Muestra respuesta
		System.out.println(respuestaServidor);

		// Fin conexion
		clientSocket.close();

	}
}
