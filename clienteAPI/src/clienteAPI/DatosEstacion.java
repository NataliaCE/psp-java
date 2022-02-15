package clienteAPI;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DatosEstacion {

	public String idema;
	public float lon;
	private Date fint;
	public float prec;
	public float alt;
	public float vmax;
	public float vv;
	public float dv;
	public float lat;
	public float dmax;
	public String ubi;
	public float hr;
	public float tamin;
	public float ta;
	public float tamax;
	@Override
	public String toString() {
		return "DatosEstacion [idema=" + idema + ", lon=" + lon + ", fint=" + fint + ", prec=" + prec + ", alt=" + alt
				+ ", vmax=" + vmax + ", vv=" + vv + ", dv=" + dv + ", lat=" + lat + ", dmax=" + dmax + ", ubi=" + ubi
				+ ", hr=" + hr + ", tamin=" + tamin + ", ta=" + ta + ", tamax=" + tamax + "]";
	}
	
	
	
}
