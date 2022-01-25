package httpConexion;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HttpsURLConnection;

public class DescargaWeb {

	public static void main(String[] args) throws IOException {
		
		String stringURL = "https://wikipedia.org";
		URL objetoURL = new URL(stringURL);//Lanza excepcion de url mal formada
		//URLConnection conexionURL = objetoURL.openConnection(); //Se abre la conexión. Lanza IOException. Se usa para http
		HttpsURLConnection conexionHttps = (HttpsURLConnection) objetoURL.openConnection(); //Usar para https
		BufferedInputStream lectorURL = new BufferedInputStream(objetoURL.openStream());
		
		System.out.println("El servidor devuelve: " + conexionHttps.getResponseCode());
		byte[] buffer = new byte[2048];
		int bytesLeidos = lectorURL.read(buffer);
		while(bytesLeidos != -1) { //Ha leido cosas
			System.out.println(new String(buffer));
			bytesLeidos = lectorURL.read(buffer);
		}
		
	}
	
}
