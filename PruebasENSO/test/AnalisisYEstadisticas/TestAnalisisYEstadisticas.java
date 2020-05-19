package AnalisisYEstadisticas;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
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

class TestAnalisisYEstadisticas {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	

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

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date();
			tiempos.put(fecha, fecha);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap<Integer, Double> x = null;
			try {
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x,"No se han obtenido horas más concurridas");
		}
		
		@Test
		@DisplayName("PCB-04-C2")
		void PR05_CP002(){
			//Arrange

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date();
			tiempos.put(fecha, fecha);
			tiempos.put(fecha, fecha);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap<Integer, Double> x = null;
			try {
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x,"No se han obtenido horas más concurridas");
		}
		
		@Test
		@Disabled("El caso asociado a esta prueba contiene un camino intratable")
		@DisplayName("PCB-04-C3")
		void PR05_CP003(){
			//Arrange
			
			//Act
			
			//Assert
			
		}
		
		@Test
		@DisplayName("PCB-04-C4")
		void PR05_CP004(){
			//Arrange

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date();
			Date fecha2 = new Date(1000000);
			tiempos.put(fecha, fecha);
			tiempos.put(fecha2,fecha2);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap<Integer, Double> x = null;
			try {
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x,"No se han obtenido horas más concurridas");
		}
		
		@Test
		@DisplayName("PCB-04-C5")
		void PR05_CP005(){
			//Arrange

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			//Assert
			assertThrows(IllegalArgumentException.class, ()->{this.ae.verHorasMasConcurridas();}, "No se lanza la excepción esperada ante una lista vacía");
		}
		
		@Test
		@DisplayName("PCB-04-C6")
		@Disabled("El camino asociado a 8 -> 10 es instratable")
		void PR05_CP006(){
			//Arrange

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date(0);
			tiempos.put(fecha, fecha);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap<Integer, Double> x = null;
			try {
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x,"No se han obtenido horas más concurridas");
		}
		
		@Test
		@DisplayName("PCB-04-C7")
		void PR05_CP007(){
			//Arrange

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date(3000000);
			Date fecha2 = new Date(1000000);
			tiempos.put(fecha, fecha);
			tiempos.put(fecha2,fecha2);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap<Integer, Double> x = null;
			try {
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x,"No se han obtenido horas más concurridas");
		}
		
		@Test
		@DisplayName("PCB-04-C8")
		void PR05_CP008(){
			//Arrange

			//Act

			HashMap<Date,Date> tiempos = new HashMap<>();
			Date fecha = new Date();
			tiempos.put(fecha, fecha);
			tiempos.put(fecha, fecha);

			try {
				Mockito.when(mockDatosFacturas.obtenerParesFechas()).thenReturn(tiempos);
				
			} catch (IOException | JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			HashMap<Integer, Double> x = null;
			try {
				x = this.ae.verHorasMasConcurridas();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//Assert
			assertNotNull(x,"No se han obtenido horas más concurridas");
	}
	}

}
