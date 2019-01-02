import java.sql.SQLException;
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
	public void Insertar() throws ParseException, SQLException {
		vis.setAdmisionID(1);
		String date = "2/01/2018";
		vis.setFecha(date);
		vis.setDescripcion("Hola soy goku");
		vis.setHora("3:47");
		vis.setTipoVisita("Consulta");
		vis.setTipoConsulta("Analisis");
		vis.setEnfermedad("Virus");
		vis.setSintomas("Tiene la Fiebre Alta");
		mensaje = vbo.agregarVisita(vis);
		System.out.println(mensaje);
		//vis.setCitaID((Integer) null);
		//vis.setNumeroCamilla((Integer) null);
	}
	
	public void Eliminar() throws SQLException {
		mensaje = vbo.eliminarVisita(2);
	}
	
	public static void main(String[] args) throws ParseException, SQLException {
		Test t = new Test();
		t.Insertar();
		//t.Eliminar();

	}
}
