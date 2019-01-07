
public class Enfermedad {

	int EnfermedadID;
	String Nombre_Enfermedad;
	
	public Enfermedad() {
	}
	
	public Enfermedad(int enfermedadID, String nombre_Enfermedad) {
		EnfermedadID = enfermedadID;
		Nombre_Enfermedad = nombre_Enfermedad;
	}

	public int getEnfermedadID() {
		return EnfermedadID;
	}

	public void setEnfermedadID(int enfermedadID) {
		EnfermedadID = enfermedadID;
	}

	public String getNombre_Enfermedad() {
		return Nombre_Enfermedad;
	}

	public void setNombre_Enfermedad(String nombre_Enfermedad) {
		Nombre_Enfermedad = nombre_Enfermedad;
	}

	@Override
	public String toString() {
		return "Enfermedad [EnfermedadID=" + EnfermedadID + ", Nombre_Enfermedad=" + Nombre_Enfermedad + "]";
	}
	
	
}
