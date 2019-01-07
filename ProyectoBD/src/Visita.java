import java.sql.Date;

public class Visita {
	
	

	private long ServicioID;
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
	
	public Visita(long servicioID,String tipovisita,String Enfermedad) {
		this.ServicioID = servicioID;
		this.TipoVisita = tipovisita;
		this.Enfermedad = Enfermedad;
	}
	
	public long getServicioID() {
		return ServicioID;
	}

	public void setServicioID(long servicioID) {
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