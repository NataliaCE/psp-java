package sockets03;

import java.util.ArrayList;

public class ColaMensajes {

	ArrayList<Mensaje> colaMensajes;

	public ColaMensajes() {
		colaMensajes = new ArrayList<Mensaje>();
	}
	
	/*
	 * Se hacen dos bloques sincronizados para evitar que intente hacer dos cosas a la vez
	 */
	public synchronized void anyadirMensaje(String mensaje, String origen) {
		colaMensajes.add(new Mensaje(mensaje, origen));
	}
	
	public synchronized Mensaje obtenerMensaje() {
		Mensaje m =  colaMensajes.get(0);
		colaMensajes.remove(0);
		return m;
	}
}
