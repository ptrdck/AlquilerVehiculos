package org.iesalandalus.programacion.alquilervehiculos.modelo.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Alquiler {
	

	
	//Expresiones regulares y constantes
	
	final static DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private final static int PRECIO_DIA = 20;
	
	//Declaración de atributos
	
	private Cliente cliente;
	private Turismo turismo;
	
	private LocalDate fechaAlquiler;
	private LocalDate fechaDevolucion;
	
	//Constructor con parámetros
	public Alquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler)
	{
		setCliente(cliente);
		setTurismo(turismo);
		setFechaAlquiler(fechaAlquiler);
	}
	
	//Constructor copia
	public Alquiler(Alquiler alquiler)
	{
		if (alquiler == null)
		{
			throw new NullPointerException("ERROR: No es posible copiar un alquiler nulo.");
		}
		setCliente(alquiler.getCliente());
		setTurismo(alquiler.getTurismo());
		setFechaAlquiler(alquiler.getFechaAlquiler());
	}
	
	// getters
	public Cliente getCliente() {
		return cliente;
	}
	public Turismo getTurismo() {
		return turismo;
	}
	public LocalDate getFechaAlquiler() {
		return fechaAlquiler;
	}
	public LocalDate getFechaDevolucion() {
		return fechaDevolucion;
	}
	
	//Setters
	
	
	private void setCliente(Cliente cliente) 
	{
		if (cliente == null)
		{
			throw new NullPointerException("ERROR: El cliente no puede ser nulo.");
		}
		this.cliente = cliente;
	}
	
	private void setTurismo(Turismo turismo) 
	{
		if (turismo == null)
		{
			throw new NullPointerException("ERROR: El turismo no puede ser nulo.");
		}
		this.turismo = turismo;
	}
	
	//método set para evaluar que la fecha de alquiler no sea nula ni posterior a la fecha actual. 
	private void setFechaAlquiler(LocalDate fechaAlquiler)
	{
		if (fechaAlquiler == null)
		{
			throw new NullPointerException("ERROR: La fecha de alquiler no puede ser nula.");
		}
		if (fechaAlquiler.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("ERROR: La fecha de alquiler no puede ser futura.");
		}
		this.fechaAlquiler = fechaAlquiler;
	}
	
	//Este método comprueba que la devolución no sea nula, ni posterior a día de hoy, ni tampoco anterior o igual a la fecha de alquiler
	private void setFechaDevolucion(LocalDate fechaDevolucion)
	{
		if (fechaDevolucion == null)
		{
			throw new NullPointerException("ERROR: La fecha de devolución no puede ser nula.");
		}
		if (fechaDevolucion.isAfter(LocalDate.now()))
		{
			throw new IllegalArgumentException("ERROR: La fecha de devolución no puede ser futura.");
		}
		if (fechaDevolucion.isAfter(fechaAlquiler) || fechaDevolucion.isEqual(fechaAlquiler))
		{
			throw new IllegalArgumentException("ERROR: La fecha de devolución debe ser posterior a la fecha de alquiler.");
		}
		this.fechaDevolucion = fechaDevolucion;
	}
	
	//Método Devolver
	
	public void devolver(LocalDate fechaDevolucion)
	{
		if (fechaDevolucion != null)
		{
			throw new IllegalArgumentException("ERROR: La devolución ya estaba registrada.");
		}
		setFechaDevolucion(fechaDevolucion);
	}
	
	public int getPrecio()
	{
		//declaramos la variable local de tipo entero precio
		int precio;
		//Extraemos el factor cilindrada del atributo cilindrada de turismo y lo dividimos por 10
		int factorCilindrada = (int) (turismo.getCilindrada()/10);
		//Extraemos la cantidad de días entre fechas de alquiler y devolución y lo casteamos a un entero
		int numDias = (int) ChronoUnit.DAYS.between(fechaDevolucion, fechaAlquiler); 
		
		//establecemos el valor de precio con la fórmula establecida en la tarea.
		precio = (PRECIO_DIA + factorCilindrada)*numDias;
		
		//retornamos el valor de precio
		return precio;
	}

	// hashCode y equals que verifican que dos objetos son iguales si su cliente, turismo y fechaAlquier son los mismos
	@Override
	public int hashCode() {
		return Objects.hash(cliente, fechaAlquiler, turismo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alquiler other = (Alquiler) obj;
		return Objects.equals(cliente, other.cliente) && Objects.equals(fechaAlquiler, other.fechaAlquiler)
				&& Objects.equals(turismo, other.turismo);
	}

	@Override
	public String toString() {
		return String.format("%s <---> %s, %s - %s (%d€)", cliente, turismo, fechaAlquiler, fechaDevolucion);
	}
	
	
	
	

}
