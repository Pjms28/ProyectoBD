import java.sql.Connection;
import java.sql.PreparedStatement;

public class VisitaDAO {
	
	private String mensaje = "";
	
	public String agregarVisita(Connection conn, Visita vis) {
		PreparedStatement pst = null;
		String slq = "INSERT INTO VISITA (SERVICIOID, ADMISIONID, FECHA, DESCRIPCION, HORA, ENFERMEDAD, TIPOVISITA, TIPOCONSULTA, SINTOMAS, CITAID, NUMEROCAMILLA) "
				+ "VALUES()";
		return mensaje;
	}
	
	public String modificarVisita(Connection conn, Visita vis) {
		return mensaje;
	}
	
	public String eliminarVisita(Connection conn, int id) {
		return mensaje;
	}
	
	public void mostrarVisita() {
	}
}
