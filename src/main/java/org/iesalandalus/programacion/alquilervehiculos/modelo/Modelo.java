package org.iesalandalus.programacion.alquilervehiculos.modelo;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Alquileres;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Clientes;
import org.iesalandalus.programacion.alquilervehiculos.modelo.negocio.Turismos;

public class Modelo 
{

	//declaramos las clases anteriores como atributes de clase de modelo (0,1)
	private Clientes clientes;
	private Turismos turismos;
	private Alquileres alquileres;
	
	//Constructor
	public Modelo()
	{
		comenzar();
	}
	
	//Método donde creamos las instancias de las clases negocio declaradas al comienzo
	public void comenzar()
	{
		clientes = new Clientes();
		turismos = new Turismos();
		alquileres = new Alquileres();
	}
	
	//método para terminar el programa que simplemente muestra un mensaje de salida
	public void terminar()
	{
		System.out.println("Modelo terminado");
	}
	
	//Método insertar un cliente
	public void insertar(Cliente cliente) throws OperationNotSupportedException
	{
		clientes.insertar(cliente);
	}
	
	//Método para insertar un Turismo
	public void insertar(Turismo turismo)throws OperationNotSupportedException
	{
		turismos.insertar(turismo);
	}
	
	//método para insertar Alquiler
	public void insertar(Alquiler alquiler) throws OperationNotSupportedException
	{
		//Declaraion de null
		if (alquiler == null)
		{
			throw new NullPointerException("ERROR: No se puede realizar un alquiler nulo.");
		}
		//Si el cliente no existe, no se puede insertar un alquiler
		if (buscar(alquiler.getCliente()) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe el cliente del alquiler.");
		}
		//Si el turismo no existe, no puede insertarse el alquiler
		if (buscar(alquiler.getTurismo()) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe el turismo del alquiler.");
		}
	}
	
	public Cliente buscar(Cliente cliente)
	{
		return clientes.buscar(cliente);
	}
	
	public Turismo buscar(Turismo turismo)
	{
		return turismos.buscar(turismo);
	}
	
	public Alquiler buscar(Alquiler alquiler)
	{
		return alquileres.buscar(alquiler);
	}
	
	public void modificar(Cliente cliente, String nombre, String telefono) throws OperationNotSupportedException
	{
		clientes.modificar(cliente, nombre, telefono);
	}
	
	public void devolver(Alquiler alquiler, LocalDate fechaDevolucion) throws OperationNotSupportedException
	{
		if (buscar(alquiler) == null)
		{
			throw new OperationNotSupportedException("ERROR: No existe el alquiler a devolver.");
		}
		alquileres.devolver(alquiler, fechaDevolucion);
	}
	
	public void borrar(Cliente cliente) throws OperationNotSupportedException
	{
		for(Alquiler a : alquileres.get())
		{
			
			if (a.getCliente().equals(cliente))
			{
			borrar(a);
			}
		}	
		clientes.borrar(cliente);
		
	}
	
	public void borrar(Turismo turismo) throws OperationNotSupportedException
	{
		for(Alquiler a: alquileres.get())
		{
			if(a.getTurismo().equals(turismo))
			{
				borrar(a);
			}
		}
		turismos.borrar(turismo);
	}
	
	public void borrar(Alquiler alquiler) throws OperationNotSupportedException
	{
		alquileres.borrar(alquiler);
	}
	
	//método get para obtener una nueva lista de clientes
	public List<Cliente> getClientes()
	{
		return new LinkedList<>(clientes.get());
	}
	
	//método get para obtener una nueva lista de turismos
	public List<Turismo> getTurismos()
	{
		return new LinkedList<>(turismos.get());
	}
	
	//método get para obtener una nueva lista de alquileres
	public List<Alquiler> getAlquileres()
	{
		return new LinkedList<>(alquileres.get());
	}
	
	//método get para obtener alquileres por cliente
	public List<Alquiler> getAlquileres(Cliente cliente)
	{
		List<Alquiler> alquileresCliente = new LinkedList<Alquiler>();
		for (Alquiler alquiler: alquileres.get())
		{
			if (alquiler.getCliente().equals(cliente))
			{
				alquileresCliente.add(alquiler);
			}
		}
		return alquileresCliente;
	}
	
	//método get para obtener alquileres por turismo
	public List<Alquiler> getAlquileres(Turismo turismo)
	{
		List<Alquiler> alquileresTurismo = new LinkedList<Alquiler>();
		for (Alquiler alquiler: alquileres.get())
		{
			if (alquiler.getTurismo().equals(turismo))
			{
				alquileresTurismo.add(alquiler);
			}
		}
		return alquileresTurismo;
	}
}
