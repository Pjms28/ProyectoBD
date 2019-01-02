import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test2 {
	
	LicenciaBO libo = new LicenciaBO();
	Licencia lin = new Licencia();
	String mensaje = "";
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	Date today = new Date();
	@SuppressWarnings("null")
	
	public void Insertar() throws ParseException, SQLException {
		String date = "12/30/2018 00.00.00.0";
		String date2 = "10/23/2018 00.00.00.0";
		lin.setDescripcion("Hola soy vegetta");
		lin.setServicioID(1);
		lin.setFecha_inicio(date);
		lin.setFecha_fin(date2);
		mensaje=libo.agregarLicencia(lin);
		System.out.println(mensaje);
		
	}
	
	public void Eliminar() throws SQLException {
		mensaje = libo.eliminarLicencia(2);
	}
	
	public static void main(String[] args) throws ParseException, SQLException {
		Test2 t = new Test2();
		//t.Insertar();
		//t.Eliminar();
	}

}
