import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test3 {
	
	RecetaBO rbo = new RecetaBO();
	Receta rec= new Receta();
	String mensaje= "";
	SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd-MM-yyyy");
	Date today = new Date();
	
	public void Insertar() throws ParseException, SQLException {
		String date = "09/11/2018 00.00.00.0";
		rec.setServicioID(1);
		rec.setDescripcion("Hola soy gohan");
		rec.setFecha(date);
		rec.setHora("2:33");
		mensaje= rbo.agregarReceta(rec);
		System.out.println(mensaje);
		
	}
	
	public void Eliminar() throws SQLException {
		mensaje = rbo.eliminarReceta(2);
	}

	public static void main(String[] args) throws ParseException, SQLException {
		// TODO Auto-generated method stub
		
		Test3 t = new Test3();
		t.Insertar();
		//t.Eliminar();
	}


	}