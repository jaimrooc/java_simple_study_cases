import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

/**
 * 
 * @author Jaime Andres Rojas Ocampo
 *
 */
public class MensajeHilo extends Thread {

	private MulticastSocket socket;
	private InetAddress grupo;

	public MensajeHilo(MulticastSocket socket, InetAddress grupo) {
		this.socket = socket;
		this.grupo = grupo;
	}

	@Override
	public void run() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String msg = "";
		do {
			try {
				msg = in.readLine();
				byte[] m = msg.getBytes();
				DatagramPacket mensajeSalida = new DatagramPacket(m, m.length, this.grupo, Constantes.PORT);
				socket.send(mensajeSalida);
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		} while (true);
	}

}
