
public class Receta {
	
	private int RecetaID;
	private int ServicioID;
	private String Descripcion;
	private String Fecha;
	private String Hora;
	
	public Receta(){
		
	}
	
	public Receta(int recetaID, int servicioID, String descripcion, String fecha, String hora) {
		RecetaID = recetaID;
		ServicioID = servicioID;
		Descripcion = descripcion;
		Fecha = fecha;
		Hora = hora;
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

	@Override
	public String toString() {
		return "Receta [RecetaID=" + RecetaID + ", ServicioID=" + ServicioID + ", Descripcion=" + Descripcion
				+ ", Fecha=" + Fecha + ", Hora=" + Hora + "]";
	}
	
	
	
}






