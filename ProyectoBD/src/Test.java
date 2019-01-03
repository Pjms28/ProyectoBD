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
		String date = "2018-01-2";
		vis.setFecha(date);
		vis.setDescripcion("Hola soy goku");
		vis.setHora("3:47");
		vis.setTipoVisita("CONSULTA");
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
	
	public void Modificar() throws SQLException {
		vis.setTipoVisita("Emergencia");
		String date = "1/JAN/2017";
		vis.setFecha(date);
		vis.setHora("3:48");
		vis.setDescripcion("Accidente");
		vis.setEnfermedad("Heridas graves");
		vis.setNumeroCamilla(8);
		vis.setServicioID(45);
		mensaje = vbo.modificarVisita(vis);
		System.out.println(mensaje);
		
	}
	
	public static void main(String[] args) throws ParseException, SQLException {
		Test t = new Test();
		//t.Insertar();
		//t.Eliminar();
		 t.Modificar();	
	}
}
