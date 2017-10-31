
import java.io.*;
import java.net.*;
import java.util.logging.*;

/**
 * 
 * @author Jaime Andres Rojas Ocampo
 *
 */
public class Servidor {

	public static void main(String args[]) throws IOException {
		ServerSocket ss;
		System.out.print("Inicializando servidor... ");
		try {
			ss = new ServerSocket(10578);
			System.out.println("\t[OK]");
			int idSession = 1;
			while (true) {
				Socket socket;
				socket = ss.accept();
				System.out.println("Nueva conexion entrante: " + socket);
				((ServidorHilo) new ServidorHilo(socket, idSession)).start();
				idSession++;
			}
		} catch (IOException ex) {
			Logger.getLogger(Servidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
