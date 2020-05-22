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
import GestionDatos.TiposDatos.Plato;

class TestAnalisisYEstadisticas {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	
	// Uriel Fernández Graña
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
		
		
		//Es el mismo porque en el anterior no puedo hacer el for de 9->10 mas de una vez, dado que eese dato no lo puedo cambiar
		
		@Test
		@DisplayName("PCB-02-C2")
		void PR02_CP02(){
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
		
		//El camino 3 y 4 pasa lo mismo, no puedo dar varias vueltas a los for
		
		
		
		@Test
		@DisplayName("PCB-02-C5")
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
		@DisplayName("PCB-02-C6")
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
		@Test
		@DisplayName("PCB-02-C7")
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
		
		//el caamino 8 ya se cumple en el primero
		
		@Test
		@DisplayName("PCB-02-C9")
		void PR02_CP09(){
			ArrayList<Plato> p1=new ArrayList<>();
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
		
		@Test
		@DisplayName("PCB-02-C10")
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

}
