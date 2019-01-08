
public class RecetaMedicina {

	private int RecetamedicinaID;
	private int RecetaID;
	private int MedicinaID;
	private String Dosis;
	
	public RecetaMedicina(){
		
	}
	
	public RecetaMedicina(int recetamedicinaID, int recetaID, int medicinaID, String dosis) {
		RecetamedicinaID = recetamedicinaID;
		RecetaID = recetaID;
		MedicinaID = medicinaID;
		Dosis = dosis;
	}
	
	public int getRecetamedicinaID() {
		return RecetamedicinaID;
	}
	public void setRecetamedicinaID(int recetamedicinaID) {
		RecetamedicinaID = recetamedicinaID;
	}
	public int getRecetaID() {
		return RecetaID;
	}
	public void setRecetaID(int recetaID) {
		RecetaID = recetaID;
	}
	public int getMedicinaID() {
		return MedicinaID;
	}
	public void setMedicinaID(int medicinaID) {
		MedicinaID = medicinaID;
	}
	public String getDosis() {
		return Dosis;
	}
	public void setDosis(String dosis) {
		Dosis = dosis;
	}
	
	@Override
	public String toString() {
		return "RecetaMedicina [RecetamedicinaID=" + RecetamedicinaID + ", RecetaID=" + RecetaID + ", MedicinaID="
				+ MedicinaID + ", Dosis=" + Dosis + "]";
	}

	

}
