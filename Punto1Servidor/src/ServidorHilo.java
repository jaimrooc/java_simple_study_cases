
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 
 * @author Jaime Andres Rojas Ocampo
 *
 */
public class ServidorHilo extends Thread {

	private Socket socket;
	private DataOutputStream dos;
	private int idSession;
	private int iteraciones = 0;

	public ServidorHilo(Socket socket, int id) {
		this.socket = socket;
		this.idSession = id;
		try {
			dos = new DataOutputStream(socket.getOutputStream());
		} catch (IOException ex) {
			Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void desconnectar() {
		try {
			socket.close();
			System.out.println("Session: (" +this.idSession + ") ---> Finaliza session <---");
		} catch (IOException ex) {
			Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	@Override
	public void run() {
		do {
			try {
				
				String fechaServidor = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss.SSS").format(new Date());
				System.out.println("Session: (" +this.idSession + ") Servidor entrega la fecha: " + fechaServidor);

				dos.writeUTF(fechaServidor);
				iteraciones++;
				if (iteraciones > 3) {
					iteraciones = 0;
					break;
				}

			} catch (IOException ex) {
				Logger.getLogger(ServidorHilo.class.getName()).log(Level.SEVERE, null, ex);
			}
		} while (true);
		desconnectar();
	}
}
