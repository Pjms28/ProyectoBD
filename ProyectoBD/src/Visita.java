import java.sql.Date;

public class Visita {
	
	

	private int ServicioID;
	private int AdmisionID;
	private String Fecha;
	private String Descripcion;
	private String Hora;
	private String Enfermedad;
	private String TipoVisita;
	private String TipoConsulta;
	private String Sintomas;
	private int CitaID; 
	private int NumeroCamilla;
	
	public Visita() {
	}
	
	public Visita(int servicioID, int admisionID, String fecha, String descripcion, String hora, String enfermedad,
			String tipoVisita, String tipoConsulta, String sintomas, int citaID, int numeroCamilla) {
		
		ServicioID = servicioID;
		AdmisionID = admisionID;
		Fecha = fecha;
		Descripcion = descripcion;
		Hora = hora;
		Enfermedad = enfermedad;
		TipoVisita = tipoVisita;
		TipoConsulta = tipoConsulta;
		Sintomas = sintomas;
		CitaID = citaID;
		NumeroCamilla = numeroCamilla;
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

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
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
	
	public String getTipoConsulta() {
		return TipoConsulta;
	}

	public void setTipoConsulta(String tipoConsulta) {
		TipoConsulta = tipoConsulta;
	}

	public String getSintomas() {
		return Sintomas;
	}

	public void setSintomas(String sintomas) {
		Sintomas = sintomas;
	}

	public int getCitaID() {
		return CitaID;
	}

	public void setCitaID(int citaID) {
		CitaID = citaID;
	}

	public int getNumeroCamilla() {
		return NumeroCamilla;
	}

	public void setNumeroCamilla(int numeroCamilla) {
		NumeroCamilla = numeroCamilla;
	}

	@Override
	public String toString() {
		return "Visita [ServicioID=" + ServicioID + ", AdmisionID=" + AdmisionID + ", Fecha=" + Fecha + ", Descripcion="
				+ Descripcion + ", Hora=" + Hora + ", Enfermedad=" + Enfermedad + ", TipoVisita=" + TipoVisita
				+ ", TipoConsulta=" + TipoConsulta + ", Sintomas=" + Sintomas + ", CitaID=" + CitaID
				+ ", NumeroCamilla=" + NumeroCamilla + "]";
	}
	
	
	
}