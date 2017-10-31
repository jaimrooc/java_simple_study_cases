package co.com.parcial1.piedrapapeltijera.servier;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Clase con la logia del servidor
 * 
 * @author Jaime Andres Rojas Ocampo
 * @author Laura Diez Castrillon
 */
public class Server {

	public static void main(String args[]) throws Exception {

		String respuetaParaCliente1 = "";
		String respuetaParaCliente2 = "";
		String inputCliente1;
		String inputCliente2;

		// Mensaje bienvenida
		System.out.println(Constantes.MENSAJE_BIENVENIDA);

		ServerSocket serverSocket = new ServerSocket(Constantes.PUERTO_POR_DEFECTO);

		while (!serverSocket.isClosed()) {

			// Valores Jugador 1 ---------------------------------------------
			Socket socketCliente1 = serverSocket.accept();
			if (socketCliente1.isConnected()) {
				System.out.println(Constantes.JUGADOR_UNO_CONECTADO_ESPERANDO_DOS);
			}
			DataOutputStream dataOutputStreamCliente1 = new DataOutputStream(socketCliente1.getOutputStream());
			BufferedReader bufferedReaderCliente1 = new BufferedReader(
					new InputStreamReader(socketCliente1.getInputStream()));

			// Valores Jugador 2 ---------------------------------------------
			Socket socketClient2 = serverSocket.accept();
			if (socketClient2.isConnected()) {
				System.out.println(Constantes.JUGADOR_DOS_INICIAR_JUEGO);
			}
			DataOutputStream dataOutputStreamCliente2 = new DataOutputStream(socketClient2.getOutputStream());
			BufferedReader bufferedReaderCliente2 = new BufferedReader(
					new InputStreamReader(socketClient2.getInputStream()));

			// Valores de respuesta
			inputCliente1 = bufferedReaderCliente1.readLine();
			inputCliente2 = bufferedReaderCliente2.readLine();

			if (inputCliente1.equals(inputCliente2)) {
				respuetaParaCliente1 = Constantes.EMPATE;
				respuetaParaCliente2 = Constantes.EMPATE;
				System.out.println(Constantes.EMPATE);
			} else if (inputCliente1.equals(Constantes.ROCA) && inputCliente2.equals(Constantes.TIJERA)) {
				respuetaParaCliente1 = Constantes.GANASTE;
				respuetaParaCliente2 = Constantes.PERDISTE;
				System.out.println("Jugador 1 GANASTE!!");

			} else if (inputCliente1.equals(Constantes.TIJERA) && inputCliente2.equals(Constantes.ROCA)) {
				respuetaParaCliente1 = Constantes.PERDISTE;
				respuetaParaCliente2 = Constantes.GANASTE;
				System.out.println("Jugador 2 GANASTE!!");
			} else if (inputCliente1.equals(Constantes.ROCA) && inputCliente2.equals(Constantes.PAPEL)) {
				respuetaParaCliente1 = Constantes.PERDISTE;
				respuetaParaCliente2 = Constantes.GANASTE;
				System.out.println("Jugador 2 GANASTE!!");
			} else if (inputCliente1.equals(Constantes.PAPEL) && inputCliente2.equals(Constantes.ROCA)) {
				respuetaParaCliente1 = Constantes.GANASTE;
				respuetaParaCliente2 = Constantes.PERDISTE;
				System.out.println("Jugador 1 GANASTE!!");
			} else if (inputCliente1.equals(Constantes.TIJERA) && inputCliente2.equals(Constantes.PAPEL)) {
				respuetaParaCliente1 = Constantes.GANASTE;
				respuetaParaCliente2 = Constantes.PERDISTE;
				System.out.println("Jugador 1 GANASTE!!");
			} else if (inputCliente1.equals(Constantes.PAPEL) && inputCliente2.equals(Constantes.TIJERA)) {
				respuetaParaCliente1 = Constantes.PERDISTE;
				respuetaParaCliente2 = Constantes.GANASTE;
				System.out.println("Jugador 2 GANASTE!!");
			}

			dataOutputStreamCliente1.writeBytes(respuetaParaCliente1.toUpperCase());
			dataOutputStreamCliente2.writeBytes(respuetaParaCliente2.toUpperCase());
			socketCliente1.close();
			socketClient2.close();

			System.out.println(Constantes.ESPERANDO_NUEVOS_JUGADORES);

		}
	}
}