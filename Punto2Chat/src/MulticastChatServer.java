
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;

/**
 * 
 * @author Jaime Andres Rojas Ocampo
 *
 */
public class MulticastChatServer {
	public static void main(String args[]) {

		try {
			InetAddress grupo = InetAddress.getByName(Constantes.IP_GROUP);
			MulticastSocket socket = new MulticastSocket(Constantes.PORT);

			socket.joinGroup(grupo);
			((MensajeHilo) new MensajeHilo(socket, grupo)).start();

			byte[] bufer = new byte[1000];
			String linea;

			while (true) {
				DatagramPacket mensajeEntrada = new DatagramPacket(bufer, bufer.length);
				socket.receive(mensajeEntrada);
				linea = new String(mensajeEntrada.getData(), 0, mensajeEntrada.getLength());
				System.out.println("Recibe :" + linea);
				if (linea.equals(Constantes.FINALIZAR_CHAT)) {
					break;
				}
			}

			socket.leaveGroup(grupo);
		} catch (SocketException e) {
			System.out.println("Socket:" + e.getMessage());
		} catch (IOException e) {
			System.out.println("IO:" + e.getMessage());
		}
	}
}
