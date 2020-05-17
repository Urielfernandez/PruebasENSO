package AnalisisYEstadisticas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

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
		private AnalisisYEstadisticas ae;
		
		@BeforeEach
		void setUp() throws Exception {
			this.ae = new AnalisisYEstadisticas();
		}

		@AfterEach
		void tearDown() throws Exception {
			this.ae = null;
		}
		
		@Test
		@DisplayName("PCB-04-C1")
		void PR05_CP001(){
			//Arrange
			FacturasDAO mockDatosFacturas = Mockito.mock(FacturasDAO.class);
			//Act
			FacturasDAO x = new FacturasDAO();
			//whenNew(FacturasDAO.class).thenReturn(null);
			//Assert
			
		}
		
		@Test
		@DisplayName("PCB-04-C2")
		void PR05_CP002(){
			//Arrange
			
			//Act
			
			//Assert
			
		}
		
		@Test
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
			
			//Assert
			
		}
		
		@Test
		@DisplayName("PCB-04-C5")
		void PR05_CP005(){
			//Arrange
			
			//Act
			
			//Assert
			
		}
		
		@Test
		@DisplayName("PCB-04-C6")
		void PR05_CP006(){
			//Arrange
			
			//Act
			
			//Assert
			
		}
		
		@Test
		@DisplayName("PCB-04-C7")
		void PR05_CP007(){
			//Arrange
			
			//Act
			
			//Assert
			
		}
		
		@Test
		@DisplayName("PCB-04-C8")
		void PR05_CP008(){
			//Arrange
			
			//Act
			
			//Assert
			
		}
	}

}
