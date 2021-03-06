/**
 * 
 */
package GestionPagosYCalificaciones;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.ParseException;

import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import GestionDatos.TiposDatos.Factura;

/**
 * @author Uriel Fernandez Granha
 *
 */
class TestGestionPagosYCualificaciones {
	private static GestionPagosYCalificaciones pc;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		//Genermos la estancia de la clase, para que todos los m�todos de prueba puedan hacer uso de ella
		pc = new GestionPagosYCalificaciones();
	}
	
	///// Caso de prueba v�lido
	@Test
	@DisplayName("P-01-C01")
	void PR01_CP001() {
		//Arrange
		int idMenu = 0;
		String primero = "macarrones con salsa de tomate ";
		String segundo = "merluza a la plancha";
		String postre = "pera ";
		String bebida = "agua ";
		Factura factura = null;
		//Act
		try {
			factura = pc.simularComida(idMenu, primero, segundo, postre, bebida);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Assert
		assertEquals(factura.getIdBandeja(), idMenu, "Los ids de la factura e introducidos no coinciden");
		assertEquals(factura.getPrimero(), primero, "El primero de la factura e introducidos no coinciden");
		assertEquals(factura.getSegundo(), segundo, "El segundo de la factura e introducidos no coinciden");
		assertEquals(factura.getPostre(), postre, "El postre de la factura e introducidos no coinciden");
		assertEquals(factura.getBebida(), bebida, "La bebida de la factura e introducidos no coinciden");
	}
	
	@Nested
	class CPNoValidos{
		//El id del men� no es v�lido
		@Test
		@DisplayName("P-01-C02")
		void PR01_CP002() {
			//Arrange
			int idMenu = 50;
			String primero = "macarrones con salsa de tomate";
			String segundo = "merluza a la plancha";
			String postre = "pera";
			String bebida = "agua";
			//Act
			
			//Assert
			assertThrows(IllegalArgumentException.class ,()->{pc.simularComida(idMenu, primero, segundo, postre, bebida);}, "El idMen� no se ha podido utilizar");
		}
		
		//El primer plato no es v�lido
		@Test
		@DisplayName("P-01-C03")
		void PR01_CP003() {
			//Arrange
			int idMenu = 0;
			String primero = "Jam�n asado";
			String segundo = "merluza a la plancha";
			String postre = "pera ";
			String bebida = "agua ";
			//Act
			
			//Assert
			assertThrows(IllegalArgumentException.class ,()->{pc.simularComida(idMenu, primero, segundo, postre, bebida);}, "El 'primero' no se ha podido utilizar");
		}
		
		//El segundo plato no es v�lido
		@Test
		@DisplayName("P-01-C04")
		void PR01_CP004() {
			//Arrange
			int idMenu = 0;
			String primero = "macarrones con salsa de tomate";
			String segundo = "kanelettus ";
			String postre = "pera";
			String bebida = "agua";
			//Act
			
			//Assert
			assertThrows(IllegalArgumentException.class ,()->{pc.simularComida(idMenu, primero, segundo, postre, bebida);}, "El 'segundo' no se ha podido utilizar");
		}
		
		//El postre no es v�lido
		@Test
		@DisplayName("P-01-C05")
		void PR01_CP005() {
			//Arrange
			int idMenu = 0;
			String primero = "macarrones con salsa de tomate";
			String segundo = "merluza a la plancha";
			String postre = "Roscas de at�n";
			String bebida = "agua";
			//Act
			
			//Assert
			assertThrows(IllegalArgumentException.class ,()->{pc.simularComida(idMenu, primero, segundo, postre, bebida);}, "El 'postre' no se ha podido utilizar");
		}
		
		//La bebida no es v�lida
		@Test
		@DisplayName("P-01-C06")
		void PR01_CP006() {
			//Arrange
			int idMenu = 0;
			String primero = "macarrones con salsa de tomate";
			String segundo = "merluza a la plancha";
			String postre = "pera ";
			String bebida = "Agua de grifo ";
			//Act
			
			//Assert
			assertThrows(IllegalArgumentException.class ,()->{pc.simularComida(idMenu, primero, segundo, postre, bebida);}, "La 'bebida' no se ha podido utilizar");
		}
		
	}

}
