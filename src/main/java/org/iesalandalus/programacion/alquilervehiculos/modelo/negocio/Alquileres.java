package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Alquileres 
{
	//Inicializacion de lista (0..*)
	private List<Alquiler> coleccionAlquileres;
	
	//constructor por defecto
	public Alquileres()
	{
		coleccionAlquileres = new LinkedList<>();
	}
	
	//Método get para devolver una nueva lista con los mismos elementos
	public List<Alquiler> get()
	{
		List<Alquiler> copiaAlquileres = new LinkedList<>();
		
		for (Alquiler alquiler: coleccionAlquileres)
		{
			copiaAlquileres.add(alquiler);
		}
		
		return copiaAlquileres;
	}
	//Método get que toma por parámetro un cliente y devuelve una lista de alquileres asociados a dicho cliente
	public List<Alquiler> get(Cliente cliente)
	{
		//inicializamos la lista
		List<Alquiler> alquilerCliente = new LinkedList<>();
		
		//ciclo for each para recorrer la lista de alquileres
		for (Alquiler alquiler: coleccionAlquileres)
		{
			//Condición que evalúa cada alquiler extrayendo la información del cliente
			//La compara con el cliente ingresado por parámetro.
			if (alquiler.getCliente().equals(cliente))
			{
				//Si el cliente es el mismo, agregamos a la nueva lista el alquiler
				alquilerCliente.add(alquiler);
			}
		}
		
		return alquilerCliente;
		
	}
	
	//Método get que toma por parámetro un turismo y devuelve una lista de alquileres asociados a dicho elemento
	public List<Alquiler> get(Turismo turismo)
	{
		//inicializamos la lista
		List<Alquiler> alquilerTurismo = new LinkedList<>();
		
		//ciclo for each para recorrer la lista de alquileres
		for(Alquiler alquiler: coleccionAlquileres)
		{
			//Condición que evalúa cada alquiler extrayendo la información del turismo y la compara 
			//con el turismo pasado por parámetro
			if (alquiler.getTurismo().equals(turismo))
			{
				//Si el turismo es el mismo que el ingresado por parámetro, lo agregamos a la nueva lista
				alquilerTurismo.add(alquiler);
			}
		}
		return alquilerTurismo;
	}
	
	public int getCantidad()
	{
		return coleccionAlquileres.size();
	}
	
	private void comprobarAlquiler(Cliente cliente, Turismo turismo, LocalDate fechaAlquiler) throws OperationNotSupportedException
	{
		for (Alquiler alquiler : coleccionAlquileres) 
		{
	        if (alquiler.getTurismo().equals(turismo) && alquiler.getFechaDevolucion() == null)
	        {
	            throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
	        }
	        
	        if (alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion() == null)
	        {
	            throw new OperationNotSupportedException("ERROR: El cliente tiene otro alquiler sin devolver.");
	        }
	        
	        if (alquiler.getTurismo().equals(turismo) && alquiler.getFechaDevolucion() != null &&
	                alquiler.getFechaDevolucion().isAfter(fechaAlquiler))
	        {
	            throw new OperationNotSupportedException("ERROR: El turismo está actualmente alquilado.");
	        }
	        
	        if (alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion() != null &&
	                alquiler.getFechaDevolucion().isAfter(fechaAlquiler))
	        {
	            throw new OperationNotSupportedException("ERROR: El cliente tiene un alquiler posterior.");
	        }
		}
	}
	
	//método para insertar un alquiler en la lista de alquileres siempre y cuando no sea nulo
	// y se compruebe que puede insertarse a través del método anterior compruebaAlquiler
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException
	{
		//comprobación de que no sea nulo
		if (alquiler == null)
		{
			throw new NullPointerException("ERROR: No se puede insertar un alquiler nulo.");
		}
		//Llamada al método para comprobar las condiciones para que pueda insertarse el alquiler en la lista 
		//de alquileres
		comprobarAlquiler(alquiler.getCliente(), alquiler.getTurismo(), alquiler.getFechaAlquiler());
		
		coleccionAlquileres.add(alquiler);
	}
	
	//método devolver que ingreasa por parámetro un cliente y una fecha de devolución
	public void devolver(Cliente cliente, LocalDate fechaDevolucion)
	{
		//for para recorrer la coleccionAlquileres
		for (Alquiler alquiler: coleccionAlquileres)
		{
			//si el alquiler es null, lanzamos la excepcion
			if (alquiler == null)
			{
				throw new NullPointerException("ERROR: No se puede devolver un alquiler nulo.");
			}
			//Si el alquiler recorrido contiene al mismo cliente y la fecha de devolución es null
			//llamamos al método devolver de la clase Alquiler
			if(alquiler.getCliente().equals(cliente) && alquiler.getFechaDevolucion() == null)
			{
				alquiler.devolver(fechaDevolucion);
				//una vez asignada la fecha devolución, rompemos el ciclo.
				break;
			}
		}
	}
	
	//Método para buscar un alquiler por parámetro y que buscará en la lista de coleccionAlquileres
	//el alquiler requerido
	public Alquiler buscar(Alquiler alquiler)
	{
		if (alquiler == null)
		{
			throw new NullPointerException("ERROR: No se puede buscar un alquiler nulo.");
		}
		for (Alquiler buscaAlquiler: coleccionAlquileres)
		{
			if (buscaAlquiler.equals(alquiler))
			{
				return buscaAlquiler;
			}
		}
		
		return null;
	}
	
	//método para borrar un alquiler de la coleccion solo si este no es nulo y existe. 
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException
	{
		if (alquiler == null)
		{
			throw new NullPointerException("ERROR: No se puede borrar un alquiler nulo.");
		}
		if (!coleccionAlquileres.contains(alquiler))
		{
			throw new OperationNotSupportedException("ERROR: No existe ningún alquiler igual.");
		}
		else
			coleccionAlquileres.remove(alquiler);
	}
	
	
	
}
