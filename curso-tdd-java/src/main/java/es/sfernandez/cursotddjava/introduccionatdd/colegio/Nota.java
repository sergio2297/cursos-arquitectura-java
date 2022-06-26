package es.sfernandez.cursotddjava.introduccionatdd.colegio;

import java.util.Objects;

public class Nota {

	//---- Constantes y Definiciones ----
	public enum Tipo {
		MUY_DEFICIENTE, INSUFICIENTE, BIEN, NOTABLE, SOBRESALIENTE
	}
	
	//---- Atributos ----
	private double nota;
	private String asignatura;
	
	//---- Constructor ----
	public Nota() {}
	
	public Nota(final int nota, final String asignatura) {
		this.nota = nota;
		this.asignatura = asignatura;
	}

	//---- Metodos ----
	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public boolean tieneMismaAsignatura(Nota otraNota) {
		return getAsignatura().equals(otraNota.getAsignatura());
	}

	@Override
	public int hashCode() {
		return Objects.hash(asignatura, nota);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Nota other = (Nota) obj;
		return Objects.equals(asignatura, other.asignatura)
				&& Double.doubleToLongBits(nota) == Double.doubleToLongBits(other.nota);
	}

	public boolean tieneMayorNota(Nota otraNota) {
		if(!tieneMismaAsignatura(otraNota)) {
			throw new RuntimeException("Error. No se puede comparar nota de dos asignaturas diferentes");
		}
		return getNota() > otraNota.getNota();
	}
	
	public Tipo getTipo() {
		if(getNota() < 0 || getNota() > 10) {
			throw new RuntimeException("La nota está fuera de rango");
		} else if(getNota() >= 0 && getNota() < 3) {
			return Tipo.MUY_DEFICIENTE;
		} else if(getNota() >= 3 && getNota() < 5) {
			return Tipo.INSUFICIENTE;
		} else if(getNota() >= 5 && getNota() < 7) {
			return Tipo.BIEN;
		} else if(getNota() >= 7 && getNota() < 9) {
			return Tipo.NOTABLE;
		} else {
			return Tipo.SOBRESALIENTE;
		}
	}
	
}
