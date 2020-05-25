package AnalisisYEstadisticas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.json.JSONException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import GestionDatos.Estadisticas.AnalisisYEstadisticasVerGestionDatosEstadisticas;
import GestionDatos.Facturas.AnalisisYEstadisticasVerGestionDatosFacturas;
import GestionDatos.Facturas.FacturasDAO;
import GestionDatos.TiposDatos.Estadistica;
import GestionDatos.TiposDatos.Plato;

class TestAnalisisYEstadisticas {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	
	// Uriel Fernandez Granha
	@Nested
	class TestsverHorasMasConcurridas{
		AnalisisYEstadisticasVerGestionDatosFacturas mockDatosFacturas ;
		AnalisisYEstadisticasVerGestionDatosEstadisticas mockDatosEstadisticas;
		
		@InjectMocks
		AnalisisYEstadisticas ae;

		
		@BeforeEach
		void setUp() throws Exception {
			this.ae = new AnalisisYEstadisticas();
			this.mockDatosFacturas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosFacturas.class);
			this.mockDatosEstadisticas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosEstadisticas.class);
			
			//Mock injection para el constructor de mi clase a probar
			MockitoAnnotations.initMocks(this);

		}

		@AfterEach
		void tearDown() throws Exception {
			this.ae = null;
		}
		
		@Test
		@DisplayName("PCB-04-C1")
		void PR05_CP001(){
			//Arrange
			HashMap<Date,Date> tiempos = new HashMap<>();

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertThrows(IllegalArgumentException.class, ()->{ae.verHorasMasConcurridas();},"No se ha avisado del error por el parámetro");
		}
		
		@Test
		@DisplayName("PCB-04-C2")
		void PR05_CP002(){
			//Arrange
			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date();
			HashMap<Integer, Double> x = null;
			
			//Act
			tiempos.put(fecha, fecha);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x, "No se han podido calcular las horas más concurridas");
		}
		
		@Test
		@DisplayName("PCB-04-C3")
		void PR05_CP003(){
			//Arrange
			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date();
			Date fecha2 = new Date(100000);
			HashMap<Integer, Double> x = null;
			
			//Act
			tiempos.put(fecha, fecha);
			tiempos.put(fecha2, fecha2);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x, "No se han podido calcular las horas más concurridas");
		}
		
		@Test
		@DisplayName("PCB-04-C4")
		void PR05_CP004(){
			//Arrange
			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date(1000);
			Date fechaAux = new Date(1000);
			HashMap<Integer, Double> x = null;
			
			//Act
			tiempos.put(fecha, fecha);
			tiempos.put(fechaAux, fechaAux);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x, "No se han podido calcular las horas más concurridas");
		}
		

	}
//--------------------------------------------------------------------------------------------------------------------------
	// Andre Camops Alvarez
	@Nested
	class TestsVerPuntuacionesPlatosDia{
		AnalisisYEstadisticasVerGestionDatosFacturas mockDatosFacturas ;
		AnalisisYEstadisticasVerGestionDatosEstadisticas mockDatosEstadisticas;
		
		@InjectMocks
		AnalisisYEstadisticas aest;

		
		@BeforeEach
		void setUp() throws Exception {
			aest = new AnalisisYEstadisticas();
			mockDatosFacturas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosFacturas.class);
			mockDatosEstadisticas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosEstadisticas.class);
			
			//Mock injection para el constructor de la clase a probar
			MockitoAnnotations.initMocks(this);

		}

		@AfterEach
		void tearDown() throws Exception {
			this.aest = null;
		}
		
		@Test
		@DisplayName("PCB-02-C1")
		void PR02_CP01(){
			ArrayList<Plato> p1=new ArrayList<>();
			ArrayList<Integer> v1 = new ArrayList<>();
			v1.add(1);
			HashMap<String, Double> puntuaciones=null;
			Date d= new Date();
			try {
			Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(d)).thenReturn(p1);
			Mockito.when(mockDatosFacturas.obtenerValesCanjeados(d)).thenReturn(v1);
			puntuaciones=this.aest.verPuntuacionesPlatosDia();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			assertNotNull(puntuaciones, "no se han obtenido las puntuaciones de los platos");
			
		}
		
		
		
		
		@Test
		@DisplayName("PCB-02-C2")
		void PR02_CP05(){
			Plato p=new Plato("primero", "patatas");
			ArrayList<Plato> p1=new ArrayList<>();
			p1.add(p);
			ArrayList<Integer> v1 = new ArrayList<>();
			v1.add(1);
			HashMap<String, Double> puntuaciones=null;
			Date d= new Date();
			try {
			Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(d)).thenReturn(p1);
			Mockito.when(mockDatosFacturas.obtenerValesCanjeados(d)).thenReturn(v1);
			Mockito.when(mockDatosEstadisticas.obtenerValoracion(2, "pato")).thenReturn(-1);
			puntuaciones=this.aest.verPuntuacionesPlatosDia();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			assertNotNull(puntuaciones, "no se han obtenido las puntuaciones de los platos");
			
		}
		
		@Test
		@DisplayName("PCB-02-C3")
		void PR02_CP06(){
			Plato p=new Plato("primero", "patatas");
			ArrayList<Plato> p1=new ArrayList<>();
			p1.add(p);
			ArrayList<Integer> v1 = new ArrayList<>();
			v1.add(1);
			HashMap<String, Double> puntuaciones=null;
			Date d= new Date();
			try {
			Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(d)).thenReturn(p1);
			Mockito.when(mockDatosFacturas.obtenerValesCanjeados(d)).thenReturn(v1);
			Mockito.when(mockDatosEstadisticas.obtenerValoracion(2, "pato")).thenReturn(1);
			puntuaciones=this.aest.verPuntuacionesPlatosDia();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			assertNotNull(puntuaciones, "no se han obtenido las puntuaciones de los platos");
			
		}
		
		
		//Este camino es intratable dado que para ello debería de haber 2 platos con el mismo nombre en el array nomPlatos(para el if) pero en el primer
		//if te impide que existan dos platos con el mismo nombre
		@Disabled("Este método tiene un camino imposible")
		@Test
		@DisplayName("PCB-02-C4")
		void PR02_CP07(){
			Plato p=new Plato("primero", "patatas");
			Plato p2=new Plato("primero", "patatas");
			ArrayList<Plato> p1=new ArrayList<>();
			p1.add(p);
			p1.add(p2);
			ArrayList<Integer> v1 = new ArrayList<>();
			v1.add(1);
			HashMap<String, Double> puntuaciones=null;
			Date d= new Date();
			try {
			Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(d)).thenReturn(p1);
			Mockito.when(mockDatosFacturas.obtenerValesCanjeados(d)).thenReturn(v1);
			Mockito.when(mockDatosEstadisticas.obtenerValoracion(2, "pato")).thenReturn(1);
			puntuaciones=this.aest.verPuntuacionesPlatosDia();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			assertNotNull(puntuaciones, "no se han obtenido las puntuaciones de los platos");
			
		}
		
		@Test
		@DisplayName("PCB-02-C5")
		void PR02_CP09(){
			ArrayList<Plato> p1=new ArrayList<>();
			ArrayList<Integer> v1 = new ArrayList<>();
			HashMap<String, Double> puntuaciones=null;
			Date d= new Date();
			try {
			Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(d)).thenReturn(p1);
			Mockito.when(mockDatosFacturas.obtenerValesCanjeados(d)).thenReturn(v1);
			
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			assertThrows(IllegalArgumentException.class, ()->{this.aest.verPuntuacionesPlatosDia();},"No se ha avisado del error por el parámetro");
			
		}
		
		@Test
		@DisplayName("PCB-02-C6")
		void PR02_CP10(){
			Plato p=new Plato("primero", "patatas");
			ArrayList<Plato> p1=new ArrayList<>();
			p1.add(p);
			p1.add(p);
			ArrayList<Integer> v1 = new ArrayList<>();
			HashMap<String, Double> puntuaciones=null;
			Date d= new Date();
			try {
			Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(d)).thenReturn(p1);
			Mockito.when(mockDatosFacturas.obtenerValesCanjeados(d)).thenReturn(v1);
			puntuaciones=this.aest.verPuntuacionesPlatosDia();
			
			}
			catch(Exception e) {
				e.printStackTrace();
				}
			assertNotNull(puntuaciones, "no se han obtenido las puntuaciones de los platos");
			
		}
		
		
		
		
	}
	//-----------------------------------------------------------------------------------------------
	//Damian Cruz Garcia
	@Nested
	class TestsVerPlatosMasComidos{
		
		AnalisisYEstadisticasVerGestionDatosFacturas mockDatosFacturas ;
		AnalisisYEstadisticasVerGestionDatosEstadisticas mockDatosEstadisticas;
		
		@InjectMocks
		AnalisisYEstadisticas aest;
		
		@BeforeEach
		void setUp() throws Exception {
			aest = new AnalisisYEstadisticas();
			mockDatosFacturas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosFacturas.class);
			mockDatosEstadisticas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosEstadisticas.class);
			
			//Mock injection para el constructor de la clase a probar
			MockitoAnnotations.initMocks(this);

		}
		

		@AfterEach
		void tearDown() throws Exception {
			this.aest = null;
		}
		
		@Test
		@DisplayName("PCB-03-C1")
		void PR03_CP01(){
			//1-3
			
			try {
				assertThrows(IllegalArgumentException.class, () -> {
					this.aest.verPlatosMasComidos(null);
				}, "Se esperaba una excepción IllegalArgumentException al valorar los platos y no se ha producido");
			}catch(Exception e) {
					e.printStackTrace();
			}
		}
		
		@Test
		@DisplayName("PCB-03-C2")
		void PR03_CP02(){
			//1-2-5
			Date fecha=new Date(2030,1,1);//fecha futura
			try {
				assertThrows(ExcepcionFechaAnalisis.class, () -> {
					this.aest.verPlatosMasComidos(fecha);
				}, "Se esperaba una excepción ExcepcionFechaAnalisis y no se ha producido");
			}catch(Exception e) {
					e.printStackTrace();
			}
			
		}
		@Test
		@DisplayName("PCB-03-C3")
		void PR03_CP03(){
			//1-2-4-6-9-13 
			Date fecha=new Date();
			HashMap<Plato,Integer> resultado=new HashMap<>();
			
			try {
				resultado=this.aest.verPlatosMasComidos(fecha);
			}catch(Exception e) {
					e.printStackTrace();
			}
			assertFalse(resultado.isEmpty(),"el resultado es vacio");
			
		}
		@Test
		@DisplayName("PCB-03-C4")//QUE PASE POR AMBOS FOR y 8
		void PR03_CP04(){
			//1-2-4-6-8-9-10-11-12-13 
			Date fecha=new Date();
			Plato plato=new Plato("primero","patatas");
			ArrayList<Plato> listaPlatos=new ArrayList<>();
			listaPlatos.add(plato);
			HashMap<Plato,Integer> resultado=new HashMap<>();
			
			try {
				Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(fecha)).thenReturn(listaPlatos);
				resultado=this.aest.verPlatosMasComidos(fecha);
			}catch(Exception e) {
					e.printStackTrace();
			}
			assertFalse(resultado.isEmpty(),"el resultado es vacio");
			
		}
		@Test
		@DisplayName("PCB-03-C5")////QUE PASE POR AMBOS FOR y 7 y 8
		void PR03_CP05(){
			//1-2-4-6-8-9-6-7-9-10-11-12-13 
			Date fecha=new Date();
			Plato plato=new Plato("primero","patatas");
			ArrayList<Plato> listaPlatos=new ArrayList<>();
			listaPlatos.add(plato);
			listaPlatos.add(plato);
			HashMap<Plato,Integer> resultado=new HashMap<>();
			
			try {
				Mockito.when(mockDatosFacturas.obtenerPlatosConsumidos(fecha)).thenReturn(listaPlatos);
				resultado=this.aest.verPlatosMasComidos(fecha);
			}catch(Exception e) {
					e.printStackTrace();
			}
			assertFalse(resultado.isEmpty(),"el resultado es vacio");
			
		}
		
		
	}//test ver platos mas comidos
	
	//-----------------------------------------------------------------------------------------------
	//Enrique Campos Duran
		@Nested
		class TestsverRankginPlatos{
			AnalisisYEstadisticasVerGestionDatosFacturas mockDatosFacturas ;
			AnalisisYEstadisticasVerGestionDatosEstadisticas mockDatosEstadisticas;
			
			@InjectMocks
			AnalisisYEstadisticas ae;

			
			@BeforeEach
			void setUp() throws Exception {
				this.ae = new AnalisisYEstadisticas();
				this.mockDatosFacturas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosFacturas.class);
				this.mockDatosEstadisticas = Mockito.mock(AnalisisYEstadisticasVerGestionDatosEstadisticas.class);
				
				//Mock injection para el constructor de mi clase a probar
				MockitoAnnotations.initMocks(this);

			}

			@AfterEach
			void tearDown() throws Exception {
				this.ae = null;
			}
			@Test
			@DisplayName("PCB-01-C1")
			void PR01_CP001(){
				//Arrange
				ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();

				try {
					Mockito.when(mockDatosEstadisticas.obtenerEstadisticas()).thenReturn(estadisticas);
				} catch (IOException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Assert
				assertThrows(IllegalArgumentException.class, ()->{ae.verRankginPlatos();},"No se ha avisado del error por el parametro");
			}
			//sin entrar a fors
			@Test
			@DisplayName("PCB-01-C2")
			void PR01_CP002(){
				//Arrange
				ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
				Estadistica es = new Estadistica(1,"macarrones",5);
				estadisticas.add(es);
				HashMap<String,Double> x = new HashMap<String,Double>();

				try {
					Mockito.when(mockDatosEstadisticas.obtenerEstadisticas()).thenReturn(estadisticas);
					x = this.ae.verRankginPlatos();
				} catch (IOException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Assert
				assertNotNull(x, "No se han podido calcular el ranking de platos");
			}
			
			//Para entrar en los fors
			
			
			@Test
			@DisplayName("PCB-01-C3")
			void PR01_CP003(){
				//Arrange
				ArrayList<Estadistica> estadisticas = new ArrayList<Estadistica>();
				Estadistica es = new Estadistica(1,"macarrones",5);
				Estadistica es1 = new Estadistica(1,"pollo",5);
				Estadistica es2 = new Estadistica(1,"patatas",5);
				Estadistica es3 = new Estadistica(1,"tortilla",5);
				Estadistica es4 = new Estadistica(1,"filete",5);
				Estadistica es5 = new Estadistica(1,"sopa",5);
				Estadistica es6 = new Estadistica(1,"lentejas",5);
				Estadistica es7 = new Estadistica(1,"ensalada",5);
				Estadistica es8 = new Estadistica(1,"sandwich",5);
				Estadistica es9 = new Estadistica(1,"bocadillo",5);
				Estadistica es10 = new Estadistica(1,"pescado",5);
				estadisticas.add(es);
				estadisticas.add(es1);
				estadisticas.add(es2);
				estadisticas.add(es3);
				estadisticas.add(es4);
				estadisticas.add(es5);
				estadisticas.add(es6);
				estadisticas.add(es7);
				estadisticas.add(es8);
				estadisticas.add(es9);
				estadisticas.add(es10);
				HashMap<String,Double> x = new HashMap<String,Double>();

				try {
					Mockito.when(mockDatosEstadisticas.obtenerEstadisticas()).thenReturn(estadisticas);
					x = this.ae.verRankginPlatos();
				} catch (IOException | JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//Assert
				assertNotNull(x, "No se han podido calcular el ranking de platos");
			}
			//Para entrar en el if de si hay mas de 10 cosas, el if de contains es intratable porque no puedo poner dos cosas con la misma key en un hashmap
		}
	
}
