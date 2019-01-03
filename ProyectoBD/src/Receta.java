
public class Receta {
	
	private int RecetaID;
	private int ServicioID;
	private String Descripcion;
	private String Fecha;
	private String Hora;
	private String TipoReceta;
	private String Dosis;
	

	public Receta(){
		
	}
	
	public Receta(int recetaID, int servicioID, String descripcion, String fecha, String hora, String tipoReceta,
			String dosis) {
		RecetaID = recetaID;
		ServicioID = servicioID;
		Descripcion = descripcion;
		Fecha = fecha;
		Hora = hora;
		TipoReceta = tipoReceta;
		Dosis = dosis;
	}

	public int getRecetaID() {
		return RecetaID;
	}

	public void setRecetaID(int recetaID) {
		RecetaID = recetaID;
	}

	public int getServicioID() {
		return ServicioID;
	}

	public void setServicioID(int servicioID) {
		ServicioID = servicioID;
	}

	public String getDescripcion() {
		return Descripcion;
	}

	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getFecha() {
		return Fecha;
	}

	public void setFecha(String fecha) {
		Fecha = fecha;
	}

	public String getHora() {
		return Hora;
	}

	public void setHora(String hora) {
		Hora = hora;
	}
	
	public String getDosis() {
		return Dosis;
	}

	public void setDosis(String dosis) {
		Dosis = dosis;
	}
	
	public String getTipoReceta() {
		return TipoReceta;
	}

	public void setTipoReceta(String tipoReceta) {
		TipoReceta = tipoReceta;
	}
	
	@Override
	public String toString() {
		return "Receta [RecetaID=" + RecetaID + ", ServicioID=" + ServicioID + ", Descripcion=" + Descripcion
				+ ", Fecha=" + Fecha + ", Hora=" + Hora + ", TipoReceta=" + TipoReceta + ", Dosis=" + Dosis + "]";
	}


	
	
}