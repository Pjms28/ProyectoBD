import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

	VisitaBO vbo = new VisitaBO();
	Visita vis = new Visita();
	String mensaje = "";
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	Date today = new Date();
	@SuppressWarnings("null")
	public void Insertar() throws ParseException {
		vis.setAdmisionID(1);
		String date = "1992-07-10";
		vis.setFecha(date);
		vis.setDescripcion("Hola soy goku");
		vis.setHora("3:47 PM");
		vis.setTipoVisita("Consulta");
		vis.setTipoConsulta("Analisis");
		vis.setEnfermedad("Virus");
		vis.setSintomas("Fiebre");
		vis.setCitaID((Integer) null);
		vis.setNumeroCamilla((Integer) null);
	}
	
	public static void main(String[] args) throws ParseException {
		Test t = new Test();
		t.Insertar();
	}
}
