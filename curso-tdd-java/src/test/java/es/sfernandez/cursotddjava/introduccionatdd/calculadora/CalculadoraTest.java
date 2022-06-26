package es.sfernandez.cursotddjava.introduccionatdd.calculadora;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * <p>Se definen varios test que prueban las distintas operaciones 
 * que ofrece la clase Calculadora. Para cada uno se ha usado una 
 * nomenclatura para nombrarlos diferente. También se han creado los 
 * test siguiendo los patrones AAA y GWT.</p>
 * @author Sergio
 *
 */
public class CalculadoraTest {

	@DisplayName("Sumar 2 + 2 debe dar 4")
	@Test
	public void sumarTest() {
		// Given
		Calculadora calculadora = new Calculadora();
		
		// When
		int suma = calculadora.sumar(2, 2);
		
		// Then
		assertEquals(4, suma);
	}
	
	@Test
	public void sumarCuatroMenosDosTest() {
		// Arrange
		Calculadora calculadora = new Calculadora();
		
		// Act
		int suma = calculadora.sumar(4, -2);
		
		// Assert
		assertEquals(2, suma);
	}
	
	@Test
	public void restarCuatroMenosUno() {
		Calculadora calculadora = new Calculadora();
		int resta = calculadora.restar(4, 1);
		assertEquals(3, resta);
	}
	
	@Test
	public void multiplicarTest() {
		Calculadora calculadora = new Calculadora();
		int multiplicacion = calculadora.multiplicar(5, 2);
		assertEquals(10, multiplicacion);
	}
}
