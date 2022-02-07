package clienteAPI;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpRequest;

public class ClienteSimple {

	public static void main(String[] args) throws URISyntaxException {
		// HttpRequest --> Peticion
		// HttpResponse --> Respuesta
		
		String apikey = "?api_key=eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiIyMDAzNTFAaWVzc2llcnJhZGVndWFyYS5jb20iLCJqdGkiOiI5NDE0ODRjYS1jZGIwLTQzMjQtYmVlZS02NmM5NGY4Y2NlYTIiLCJpc3MiOiJBRU1FVCIsImlhdCI6MTY0NDIyNjU3MCwidXNlcklkIjoiOTQxNDg0Y2EtY2RiMC00MzI0LWJlZWUtNjZjOTRmOGNjZWEyIiwicm9sZSI6IiJ9.3kb6i2rMWkKSBbEOX2pGUrla9jU9xoIi1yKoxJp4WoE";
		String idemaAlmudevar = "9491X";
		String servidor = "https://opendata.aemet.es/opendata";
		String cadenaPeticion = "GET /api/observacion/convencional/datos/estacion/";
		HttpRequest peticion = HttpRequest.newBuilder()
								.uri(new URI(servidor + cadenaPeticion + idemaAlmudevar + apikey))
							    .GET()
							    .build();
		
		
	}

}
