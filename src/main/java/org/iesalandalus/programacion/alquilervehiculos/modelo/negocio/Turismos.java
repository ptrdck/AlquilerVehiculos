package org.iesalandalus.programacion.alquilervehiculos.modelo.negocio;

import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Turismos 
{
	//inicialización de lista (0..*)
	private List<Turismo> coleccionTurismos;
	
	//Constructor por defecto, crea lista
	public Turismos()
	{
		coleccionTurismos = new LinkedList<>();
	}
	
	//método get para una nueva lista con los mismos elementos
	public List<Turismo> get()
	{
		//Iniciamos una nueva lista para dejar la copia
		List<Turismo> copiaTurismos = new LinkedList<>();
		
		//For each para recorrer toda la lista de turismos
		for (Turismo turismo: coleccionTurismos)
		{
			//copiamos cada turismo en la nueva lista
			copiaTurismos.add(turismo);
		}
		return copiaTurismos;
		
	}
	
	//Método para extraer la cantidad de turismos en la lista coleccionTurismos
	public int getCantidad()
	{
		return coleccionTurismos.size();
	}
	
	//método para insertar un turismo si y solo si este existe y no es nulo
	public void insertar(Turismo turismo) throws OperationNotSupportedException
	{
		if (turismo == null)
		{
			throw new NullPointerException("ERROR: No se puede insertar un turismo nulo.");
		}
		else if (buscar(turismo) == null)
		{
			coleccionTurismos.add(new Turismo(turismo));
		}
		else
		{
			throw new OperationNotSupportedException("ERROR: Ya existe un turismo con esa matrícula.");
		}
	}
	
	//Método para buscar un turismo si y solo este existe y no es nulo
	public Turismo buscar(Turismo turismo)
	{
		if (turismo == null)
		{
			throw new NullPointerException("ERROR: No se puede buscar un turismo nulo.");
		}
		else if (coleccionTurismos.contains(turismo))
		{
			return new Turismo(turismo);
		}
		else
			return null;
	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException
	{
		if (turismo == null)
		{
			throw new NullPointerException("ERROR: No se puede borrar un turismo nulo.");
		}
		else if (coleccionTurismos.contains(turismo))
		{
			coleccionTurismos.remove(turismo);
		}
		else
			throw new OperationNotSupportedException("ERROR: No existe ningún turismo con esa matrícula.");
	}

}
