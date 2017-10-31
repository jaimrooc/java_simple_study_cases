
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jaime Andres Rojas Ocampo
 *
 */
class Consumidor extends Thread {

	protected Socket sk;
	protected DataOutputStream dos;
	protected DataInputStream dis;
	private int id;

	public Consumidor(int id) {
		this.id = id;
	}

	@Override
	public void run() {
		try {

			sk = new Socket("localhost", 10578);
			System.out.println("Cliente creado");
			do {
				try {
					Date fechaInicial = new Date();

					dos = new DataOutputStream(sk.getOutputStream());
					dis = new DataInputStream(sk.getInputStream());
					System.out.println("Session: (" +id + ") Se solicita conexion al servidor");
					String respuesta = "N/A";
					respuesta = dis.readUTF();
					Date fechaDeServidor = null;
					try {
						fechaDeServidor = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS").parse(respuesta);
					} catch (ParseException e) {
						e.printStackTrace();
					}
					System.out.println("Session: (" +id + ") Servidor devuelve fecha: " + respuesta);
					System.out.println(
							"La diferecia entre las fecha es: " + diferenciaEnMS(fechaInicial, fechaDeServidor));
				} catch (Exception e) {
					System.out.println("Se finaliza la busqueda por cierre de servidor");break;
				}
			} while (true);
		} catch (IOException ex) {
			Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public static int diferenciaEnMS(Date fechaMayor, Date fechaMenor) {
		long direfenciaEnMS = (fechaMayor.getTime() - fechaMenor.getTime()) / (1000 * 60 * 60);
		return (int) direfenciaEnMS;
	}
}

public class Cliente {

	public static void main(String[] args) {
		ArrayList<Thread> clients = new ArrayList<Thread>();
		for (int i = 1; i < 3; i++) {
			clients.add(new Consumidor(i));
		}
		for (Thread thread : clients) {
			thread.start();
		}
	}
}
