package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.util.Objects;

public class Turismo {

	//Declaración de expresión regular para validar la marca del turismo.
	private final static String ER_MARCA = "^(Seat|Land Rover|KIA|Rolls-Royce|SsangYong)$";
	
	//Declaración de expresión regular para validar matrícula.
	private final static String ER_MATRICULA = "^[0-9]{1,4}(?!.*(LL|CH))[BCDFGHJKLMNPRSTVWXYZ]{3}";
			
	//Declaración de atributos
	private String marca;
	private String modelo;
	private int cilindrada;
	private String matricula;
	
	//Constructor con parámetros
	public Turismo(String marca, String modelo, int cilindrada, String matricula)
	{
		setMarca(marca);
		setModelo(modelo);
		setCilindrada(cilindrada);
		setMatricula(matricula);
		
	}
	
	//Constructor copia
	public Turismo (Turismo turismo)
	{
		if (turismo == null)
		{
			throw new NullPointerException("ERROR: No es posible copiar un turismo nulo.");
		}
		
		setMarca(turismo.getMarca());
		setModelo(turismo.getModelo());
		setCilindrada(turismo.getCilindrada());
		setMatricula(turismo.getMatricula());
	}
	
	//getters
	public String getMarca() {
		return marca;
	}
	public String getModelo() {
		return modelo;
	}
	public int getCilindrada() {
		return cilindrada;
	}
	public String getMatricula() {
		return matricula;
	}
	
	//Setter que valida marca solo si no es nulo y si cumple el patrón establecido como expresion regular
	private void setMarca(String marca) 
	{
		
		if (marca == null)
		{
			throw new NullPointerException("ERROR: La marca no puede ser nula.");
		}
		
		if (!marca.matches(ER_MARCA))
		{
			throw new IllegalArgumentException("ERROR: La marca no tiene un formato válido.");
		}
		this.marca = marca;
	}
	
	//setter para validar el modelo a ingresar. Valida solo si no está vacío. 
	private void setModelo(String modelo) 
	{
		if (modelo == null)
		{
			throw new NullPointerException("ERROR: El modelo no puede ser nulo.");
		}
		if (modelo.isEmpty())
		{
			throw new IllegalArgumentException("ERROR: El modelo no puede estar en blanco.");
		}
		
		this.modelo = modelo;
	}
	
	//Valida cilindrada si y solo si los valores estén entre 0 y 5000 ambos incluídos
	private void setCilindrada(int cilindrada) 
	{
		if (cilindrada<0 || cilindrada>5000)
		{
			throw new IllegalArgumentException("ERROR: La cilindrada no es correcta.");
		}
		this.cilindrada = cilindrada;
	}
	
	//valida Matricula si y solo si no es nula y si cumple el patrón establecido en la expresion regular
	private void setMatricula(String matricula) 
	{
		if (matricula == null)
		{
			throw new NullPointerException("ERROR: La matrícula no puede ser nula.");
		}
		if (!matricula.matches(ER_MATRICULA))
		{
			throw new IllegalArgumentException("ERROR: La matrícula no tiene un formato válido.");
		}
		this.matricula = matricula;
	}
	
	public Turismo getTurismoConMatricula(String matricula)
	{
		return new Turismo(marca, modelo, cilindrada, matricula);
	}

	@Override
	public int hashCode() {
		return Objects.hash(matricula);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turismo other = (Turismo) obj;
		return Objects.equals(matricula, other.matricula);
	}

	@Override
	public String toString() 
	{
		return String.format("%s %s (%sCV) - %s", marca, modelo, cilindrada, matricula, "disponible");
	}
	
	
	
	
	
	
	
	
}

