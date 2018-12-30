import java.sql.Date;

public class Visita {
	
	

	private int ServicioID;
	private int AdmisionID;
	private Date Fecha;
	private String Descripcion;
	private String Hora;
	private String Enfermedad;
	private String TipoVisita;
	
	public Visita() {
	}
	
	public Visita(int servicioID, int admisionID, Date fecha, String descripcion, String hora, String enfermedad,
			String tipoVisita) {
		
		ServicioID = servicioID;
		AdmisionID = admisionID;
		Fecha = fecha;
		Descripcion = descripcion;
		Hora = hora;
		Enfermedad = enfermedad;
		TipoVisita = tipoVisita;
	}
	
	public int getServicioID() {
		return ServicioID;
	}

	public void setServicioID(int servicioID) {
		ServicioID = servicioID;
	}

	public int getAdmisionID() {
		return AdmisionID;
	}

	public void setAdmisionID(int admisionID) {
		AdmisionID = admisionID;
	}

	public Date getFecha() {
		return Fecha;
	}

	public void setFecha(Date fecha) {
		Fecha = fecha;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}

	public String getEnfermedad() {
		return Enfermedad;
	}

	public void setEnfermedad(String enfermedad) {
		Enfermedad = enfermedad;
	}

	public String getTipoVisita() {
		return TipoVisita;
	}

	public void setTipoVisita(String tipoVisita) {
		TipoVisita = tipoVisita;
	}

	@Override
	public String toString() {
		return "Visita [ServicioID=" + ServicioID + ", AdmisionID=" + AdmisionID + ", Fecha=" + Fecha + ", Descripcion="
				+ Descripcion + ", Hora=" + Hora + ", Enfermedad=" + Enfermedad + ", TipoVisita=" + TipoVisita + "]";
	}
	
	
	
}
