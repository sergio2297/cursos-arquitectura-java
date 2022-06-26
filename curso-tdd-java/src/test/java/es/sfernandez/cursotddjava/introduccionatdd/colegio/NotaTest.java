package es.sfernandez.cursotddjava.introduccionatdd.colegio;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.sfernandez.cursotddjava.introduccionatdd.colegio.Nota.Tipo;

class NotaTest {

	//---- Atributos ----
	private Nota notaLengua8, notaLengua7, notaLengua6, notaMatematicas8, notaMatematicas7;
	
	//---- Configuración ----
	@BeforeEach
	public void setup() {
		notaLengua8 = new Nota(8, "Lengua");
		notaLengua7 = new Nota(7, "Lengua");
		notaLengua6 = new Nota(6, "Lengua");
		notaMatematicas8 = new Nota(8, "Matematicas");
		notaMatematicas7 = new Nota(7, "Matematicas");
	}
	
	//---- Tests ----
	@Test
	public void notasConMismaAsignaturaTest() {
		boolean esMisma = notaLengua8.tieneMismaAsignatura(notaLengua7);
		assertTrue(esMisma);
	}
	
	@Test
	public void notasConDistintasAsignaturasTest() {
		boolean esDiferente = notaLengua8.tieneMismaAsignatura(notaMatematicas8); 
		assertFalse(esDiferente);
	}
	
	@Test
	public void notasIgualesTest() {
		Nota nota = new Nota(8, "Lengua");
		boolean iguales = notaLengua8.equals(nota);
		assertTrue(iguales);
	}
	
	@Test
	public void notasDistintasTest() {
		boolean distintas = !notaLengua8.equals(notaMatematicas7);
		assertTrue(distintas);
	}
	
	@Test
	public void notaMayorQueOtraMismaAsignaturaConMenorNotaTest() {
		boolean esMayor = notaLengua8.tieneMayorNota(notaLengua7);
		assertTrue(esMayor);
	}
	
	@Test
	public void notaMayorQueOtraMismaAsignaturaConMismaNotaTest() {
		boolean esMayor = notaLengua8.tieneMayorNota(notaLengua8);
		assertFalse(esMayor);
	}
	
	@Test
	public void notaMayorQueOtraDistintaAsignaturaTest() {
		assertThrows(RuntimeException.class, () -> notaMatematicas7.tieneMayorNota(notaLengua7));
	}
	
	@Test
	public void notaEsTipoBienTest() {
		Tipo tipoNota = notaLengua6.getTipo();
		assertEquals(Tipo.BIEN, tipoNota);
	}
	
	@Test
	public void notaEsTipoNotableTest() {
		Tipo tipoNota = notaLengua8.getTipo();
		assertEquals(Tipo.NOTABLE, tipoNota);
	}
	
}
