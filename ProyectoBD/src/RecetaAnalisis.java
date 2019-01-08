
public class RecetaAnalisis {
	
	private int RecetaanalisisID;
	private int RecetaID;
	private int AnalisisID;
	
	public RecetaAnalisis() {
		
	}
	
	public RecetaAnalisis(int recetaanalisisID, int recetaID, int analisisID) {
		RecetaanalisisID = recetaanalisisID;
		RecetaID = recetaID;
		AnalisisID = analisisID;
	}

	
	@Override
	public String toString() {
		return "RecetaAnalisis [RecetaanalisisID=" + RecetaanalisisID + ", RecetaID=" + RecetaID + ", AnalisisID="
				+ AnalisisID + "]";
	}
	
	public int getRecetaanalisisID() {
		return RecetaanalisisID;
	}
	public void setRecetaanalisisID(int recetaanalisisID) {
		RecetaanalisisID = recetaanalisisID;
	}
	public int getRecetaID() {
		return RecetaID;
	}
	public void setRecetaID(int recetaID) {
		RecetaID = recetaID;
	}
	public int getAnalisisID() {
		return AnalisisID;
	}
	public void setAnalisisID(int analisisID) {
		AnalisisID = analisisID;
	}


}
