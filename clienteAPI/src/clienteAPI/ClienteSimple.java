package clienteAPI;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import java.util.Calendar;

import org.apache.hc.core5.net.URIBuilder;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ClienteSimple {

	public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {
		// HttpRequest --> Peticion
		// HttpResponse --> Respuesta
		
		/*
		 * https:// --> protocolo
		 * opendata.aemet.es --> host/servidor
		 * api/observación/.../estación/9491X --> recurso
		 */
		
		String apikey = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDAzNTFAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiI5NDE0ODRjYS1jZGIwLTQzMjQtYmVlZS02NmM5NGY4Y2NlYTIiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY0NDIyNjU3MCwidXNlcklkIjoiOTQxNDg0Y2EtY2RiMC00MzI0LWJlZWUtNjZjOTRmOGNjZWEyIiwicm9sZSI6IiJ9.3kb6i2rMWkKSBbEOX2pGUrla9jU9xoIi1yKoxJp4WoE";
		String idemaAlmudevar = "9491X";
		
		// Construir URI
		URI direccion = new URIBuilder()
				.setScheme("https") //protocolo
				.setHost("opendata.aemet.es") //servidor
				.setPath("/opendata/api/observacion/convencional/datos/estacion/"+ idemaAlmudevar)
				.addParameter("api_key", apikey) // ?api_key=eyJh...
				.build();
		
		// Construir petición
		HttpRequest peticion = HttpRequest.newBuilder()
								.uri(direccion)
							    .GET()
							    .timeout(Duration.ofSeconds(10))
							    .version(HttpClient.Version.HTTP_2) //Si no encuentra la 2 usará la 1
							    .build();
		
		// Construir cliente
		HttpClient cliente = HttpClient.newBuilder()
				.build();
		
		// Solicita la respuesta enviando la petición desde el cliente
		HttpResponse<String> respuesta = 
				cliente.send(peticion, BodyHandlers.ofString()); //Va a recibir un String
		
		System.out.println(respuesta.headers().toString());
		System.out.println(respuesta.body());
		
		// Extraer datos de la respuesta
		Gson gson = new Gson();
		RespuestaAemet respAemet = gson.fromJson(respuesta.body(), RespuestaAemet.class);
		System.out.println(respAemet.descripcion);
		System.out.println(respAemet.datos);
		
		// Extraer datos del json
		URI uriDatos = new URI(respAemet.datos.toString());
		
		HttpRequest peticionDatos = HttpRequest.newBuilder()
				.uri(uriDatos)
			    .GET()
			    .timeout(Duration.ofSeconds(10))
			    .version(HttpClient.Version.HTTP_2) //Si no encuentra la 2 usará la 1
			    .build();
		
		HttpResponse<String> respuestaDatos = 
				cliente.send(peticionDatos, BodyHandlers.ofString());
		
		//System.out.println(respuestaDatos.body());
		
		//DatosEstacion[] datosAlmudevar = gson.fromJson(respuestaDatos.body(), DatosEstacion[].class);
		//System.out.println(datosAlmudevar);
		
		System.out.println(respuestaDatos.body());
		Gson gson2 = new GsonBuilder()
				.setDateFormat("yyyy-MM-dd'T'hh:mm:ss")
				.create();
		DatosEstacion[] datosAlmudevar = 
				gson2.fromJson(respuestaDatos.body(), DatosEstacion[].class);
		for(DatosEstacion datosEstacion : datosAlmudevar) {
			System.out.println(datosEstacion);
		}
	}

}
