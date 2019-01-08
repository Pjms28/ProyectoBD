
public class Licencia {

	private int LicenciaID;
	private String Descripcion;
	private int ServicioID;
	private String Fecha_inicio;
	private String Fecha_fin;
	
	public Licencia() {
		
	}
	

	public Licencia(int licenciaID, String descripcion, String fecha_inicio, String fecha_fin) {
		LicenciaID = licenciaID;
		Descripcion = descripcion;
		Fecha_inicio= fecha_inicio;
		Fecha_fin= fecha_fin;
	}
	
	public int getLicenciaID() {
		return LicenciaID;
	}


	public void setLicenciaID(int licenciaID) {
		LicenciaID = licenciaID;
	}


	public String getDescripcion() {
		return Descripcion;
	}


	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}


	public int getServicioID() {
		return ServicioID;
	}


	public void setServicioID(int servicioID) {
		ServicioID = servicioID;
	}


	public String getFecha_inicio() {
		return Fecha_inicio;
	}


	public void setFecha_inicio(String fecha_inicio) {
		Fecha_inicio = fecha_inicio;
	}


	public String getFecha_fin() {
		return Fecha_fin;
	}


	public void setFecha_fin(String fecha_fin) {
		Fecha_fin = fecha_fin;
	}
	
	@Override
	public String toString() {
		return "Licencia [LicenciaID=" + LicenciaID + ", Descripcion=" + Descripcion + ", ServicioID=" + ServicioID
				+ ", Fecha_inicio=" + Fecha_inicio + ", Fecha_fin=" + Fecha_fin + "]";
	}

	
	

}
