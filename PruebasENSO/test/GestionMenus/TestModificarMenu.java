package GestionMenus;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import GestionDatos.Menus.ExcepcionFechaMenu;
import GestionDatos.TiposDatos.Plato;


/**
 * @author Enrique Campos Durán
 *
 */
class TestModificarMenu {
	//Fixtures
	private static GestionMenus gm;
	private ArrayList<Plato> primeros;
	private ArrayList<Plato> segundos;
	private ArrayList<Plato> postres;
	private Date fecha;
	private Date fechaNueva;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		gm = new GestionMenus();
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		gm = null;
	}

	@BeforeEach
	void setUp() throws Exception {
		primeros = new ArrayList<Plato>();
		segundos = new ArrayList<Plato>();
		postres = new ArrayList<Plato>();
	}

	@AfterEach
	void tearDown() throws Exception {
		primeros = null;
		segundos = null;
		postres= null;
	}

	@Test
	@DisplayName("P-05-C1")
	void PO4_C1() {
		//Arrange
		boolean fallo=false;
		
		
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();

		
		//Act
		try {
			gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);
		}catch(Exception e) {
			if(!(e instanceof ExcepcionFechaMenu)) {
				fallo=true;
			}
		}
		//Assert
		assertFalse(fallo,"Se ha producido una excepcion no esperada");
		
	}
	@Test
	@DisplayName("P-05-C2")
	void PO5_C2() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		primeros.add(p1);
		primeros.add(p2);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);;},"No se comprueban el numero de primeros");
		
	}
	@Test
	@DisplayName("P-05-C3")
	void PO5_C3() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		Plato p4 = new Plato("ensaladilla de pasta","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		primeros.add(p4);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);;},"No se comprueban el numero de primeros");
		
	}
	@Test
	@DisplayName("P-05-C4")
	void PO5_C4() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		primeros.add(p1);
		primeros.add(p1);
		primeros.add(p1);

		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);;},"No se comprueba si los primeros son iguales");
	}
	@Test
	@DisplayName("P-05-C5")
	void PO5_C5() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		primeros.add(p1);
		primeros.add(p2);

		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		primeros.add(s1);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueba si los primeros tienen otro tipo de plato");
		
	}
	@Test
	@DisplayName("P-05-C6")
	void PO5_C6() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");

		segundos.add(s1);
		segundos.add(s2);

		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueban el numero de segundos");
		
	}
	@Test
	@DisplayName("P-05-C7")
	void PO5_C7() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		Plato s4 = new Plato("albondigas","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		segundos.add(s4);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueban el numero de segundos");
		
	}
	@Test
	@DisplayName("P-05-C8")
	void PO5_C8() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		segundos.add(s1);
		segundos.add(s1);
		segundos.add(s1);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueban si los segundos son iguales");
		
	}
	@Test
	@DisplayName("P-05-C9")
	void PO5_C9() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(p1);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueba si los segundos tienen otro tipo de platos");
		
	}
	@Test
	@DisplayName("P-05-C10")
	void PO5_C10() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");

		
		postres.add(pp1);
		postres.add(pp2);

		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueban el numero de postres");
		
	}
	@Test
	@DisplayName("P-05-C11")
	void PO5_C11() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		Plato pp4 = new Plato("tarta de chocolate","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		postres.add(pp4);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueban el numero de postres");
		
	}
	@Test
	@DisplayName("P-05-C12")
	void PO5_C12() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		postres.add(pp1);
		postres.add(pp1);
		postres.add(pp1);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueba si los postres son iguales");
		
	}
	@Test
	@DisplayName("P-05-C13")
	void PO5_C13() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(s1);
		this.fecha = new Date();
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueba si los postres tienen otro tipo de platos");
		
	}
	@Test
	@DisplayName("P-05-C14")
	void PO5_C14() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fechaNueva = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueba si la fecha es nula");
		
	}
	@Test
	@DisplayName("P-05-C15")
	void PO5_C15() {
		//Arrange
		Plato p1 = new Plato("sopa","primero");
		Plato p2 = new Plato("ensaladilla rusa","primero");
		Plato p3 = new Plato("lentejas","primero");
		primeros.add(p1);
		primeros.add(p2);
		primeros.add(p3);
		
		Plato s1 = new Plato("pollo asado","segundo");
		Plato s2 = new Plato("macarrones con tomate","segundo");
		Plato s3 = new Plato("pescado","segundo");
		segundos.add(s1);
		segundos.add(s2);
		segundos.add(s3);
		
		
		
		Plato pp1 = new Plato("flan de cafe","postre");
		Plato pp2 = new Plato("tarta helada","postre");
		Plato pp3 = new Plato("tarta de queso","postre");
		
		postres.add(pp1);
		postres.add(pp2);
		postres.add(pp3);
		this.fecha = new Date();
		//Assert
		assertThrows(IllegalArgumentException.class,()->{gm.modificarMenu(fecha,primeros, segundos, postres,fechaNueva);},"No se comprueba si la fecha es nula");
		
	}

}
