package org.iesalandalus.programacion.alquilervehiculos.vista;

import java.util.Iterator;
import java.util.List;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Alquiler;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Cliente;
import org.iesalandalus.programacion.alquilervehiculos.modelo.dominio.Turismo;

public class Vista
{
	private Controlador controlador;
	
	public void setControlador(Controlador controlador)
	{
		if (controlador == null)
		{
			throw new NullPointerException("ERROR: El controlador no puede ser nulo");
		}
		this.controlador = controlador;
	}
	
	public void comenzar()
	{
		Consola.mostrarCabecera("Gestión de Alquileres");
	
		do 
		{
			Consola.elegirOpcion();
		}while(Consola.elegirOpcion() != Opcion.SALIR);
	}	
	
	public void terminar()
	{
		controlador.terminar();
	}
	
	private void ejecutar(Opcion opcion)
	{
		switch (opcion) {
        case SALIR:
            controlador.terminar();
            break;
        case INSERTAR_CLIENTE:
            controlador.insertar(cliente);
            break;
        case INSERTAR_TURISMO:
            controlador.borrar(turismo);
            break;
        case INSERTAR_ALQUILER:
            controlador.insertar();
            break;
        case BUSCAR_CLIENTE:
            controlador.buscar();
            break;
        case BUSCAR_TURISMO:
            controlador.buscar();
            break;
        case BUSCAR_ALQUILER:
            controlador.buscar();
            break;
        case MODIFICAR_CLIENTE:
            controlador.modificar();
            break;
        case DEVOLVER_ALQUILER:
            controlador.devolver();
            break;
        case BORRAR_CLIENTE:
            controlador.borrar();
            break;
        case BORRAR_TURISMO:
            controlador.borrar();
            break;
        case BORRAR_ALQUILER:
            controlador.borrar();
            break;
        case LISTAR_CLIENTES:
            controlador.getClientes();
            break;
        case LISTAR_TURISMOS:
            controlador.getTurismos();
            break;
        case LISTAR_ALQUILERES:
            controlador.getAlquileres();
            break;
        case LISTAR_ALQUILERES_CLIENTE:
            controlador.getAlquileres(null);
            break;
        case LISTAR_ALQUILERES_TURISMO:
            controlador.getAlquileres(null);
            break;
        default:
            System.out.println("Opción no válida");
            break;
            }
	}
	

	private void insertarCliente()
	{
		
	    Consola.mostrarCabecera("Insertar cliente\n");
	    try 
	    {
	    	controlador.insertar(Consola.leerCliente());
	    	System.out.println("Cliente insertado con éxito");
	    }
	    catch (NullPointerException | OperationNotSupportedException | IllegalArgumentException e)
	    {
	    	System.out.println(e.getMessage());
	    }
	}

	private void insertarTurismo()
	{
	    Consola.mostrarCabecera("Insertar turismo\n");
	    
	    try
	    {
	    	controlador.insertar(Consola.leerTurismo());
	    	System.out.println("Turismo insertado con éxito");
	    }
	    catch (NullPointerException | OperationNotSupportedException | IllegalArgumentException e)
	    {
	    	System.out.println(e.getMessage());
	    }

	}

	private void insertarAlquiler()
	{
		 Consola.mostrarCabecera("Insertar alquiler\n");
		    
		    try
		    {
		    	controlador.insertar(Consola.leerAlquiler());
		    	System.out.println("Alquiler insertado con éxito");
		    }
		    catch (NullPointerException | OperationNotSupportedException | IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void buscarCliente()
	{
		 Consola.mostrarCabecera("Buscar cliente\n");
		 Cliente cliente;
		    try
		    {
		    	cliente = controlador.buscar(Consola.leerClienteDni());
		    	String mensaje = (cliente != null) ? cliente.toString(): "El cliente indicado no se encuentra en el sistema";
		    }
		    catch (NullPointerException | IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void buscarTurismo()
	{
		 Consola.mostrarCabecera("Buscar turismo\n");
		 Turismo turismo;
		    try
		    {
		    	turismo = controlador.buscar(Consola.leerTurismoMatricula());
		    	String mensaje = (turismo != null) ? turismo.toString(): "El turismo indicado no se encuentra en el sistema";
		    }
		    catch (NullPointerException | IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }

	    
	}

	private void buscarAlquiler()
	{
		 Consola.mostrarCabecera("Buscar alquiler\n");
		 Alquiler alquiler;
		    try
		    {
		    	alquiler = controlador.buscar(Consola.leerAlquiler());
		    	String mensaje = (alquiler != null) ? alquiler.toString(): "El alquiler indicado no se encuentra en el sistema";
		    }
		    catch (NullPointerException | IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void modificarCliente()
	{
		 Consola.mostrarCabecera("Modificar cliente\n");
		 Cliente cliente;
		    try
		    {
		    	cliente = controlador.modificar(Consola.leerCliente());
		    	String mensaje = (cliente != null) ? cliente.toString(): "El cliente indicado no se encuentra en el sistema";
		    }
		    catch (NullPointerException | OperationNotSupportedException| IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void devolverAlquiler()
	{
		 Consola.mostrarCabecera("Devolver alquiler\n");
		 
		    try
		    {
		    	controlador.devolver(Consola.leerAlquiler(), Consola.leerFechaDevolucion());
		    	System.out.println("Fecha de devolución correcta");
		    }
		    catch (NullPointerException | OperationNotSupportedException| IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void borrarCliente()
	{
		 Consola.mostrarCabecera("Borrar cliente\n");
		 
		    try
		    {
		    	controlador.borrar(Consola.leerClienteDni());
		    	System.out.println("El cliente ha sido borrado con éxito");
		    	
		    }
		    catch (NullPointerException | OperationNotSupportedException| IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void borrarTurismo()
	{
		 Consola.mostrarCabecera("Borrar turismo\n");
		 
		    try
		    {
		    	controlador.borrar(Consola.leerTurismoMatricula());
		    	System.out.println("El turismo ha sido borrado con éxito");
		    	
		    }
		    catch (NullPointerException | OperationNotSupportedException| IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }
	}

	private void borrarAlquiler()
	{
		 Consola.mostrarCabecera("Borrar alquiler\n");
		 
		    try
		    {
		    	controlador.borrar(Consola.leerAlquiler());
		    	System.out.println("El cliente ha sido borrado con éxito");
		    	
		    }
		    catch (NullPointerException | OperationNotSupportedException| IllegalArgumentException e)
		    {
		    	System.out.println(e.getMessage());
		    }

	  
	}

	private void listarClientes()
	{
	    Consola.mostrarCabecera("Listado de clientes: ");
	    List<String> clientes = controlador.getClientes();

	    if (clientes.size() > 0)
	    {
	    	for(Iterator<String> it = clientes.iterator(); it.hasNext();)
	    	{
	    		String cliente = it.next();
	    		System.out.println(cliente);
	    	}
	    	
	    }
	    else
	    	System.out.println("ERROR: No hay clientes que listar. Por favor, inserte primero un cliente en el sistema.");
	}

	private void listarTurismo()
	{
		 Consola.mostrarCabecera("Listado de turismos: ");
		 List<String> turismos = controlador.getTurismos();

		 if (turismos.size() > 0)
		 {
		   	for(Iterator<String> it = turismos.iterator(); it.hasNext();)
	    	{
	    		String turismo = it.next();
	    		System.out.println(turismos);
		    }
		    	
		 }
		 else
			 System.out.println("ERROR: No hay turismos que listar. Por favor, inserte primero un turismo en el sistema.");
	}

	private void listarAlquileres()
	{
		 Consola.mostrarCabecera("Listado de alquileres: ");
		 List<String> alquileres = controlador.getAlquileres();

		 if (alquileres.size() > 0)
		 {
			 for(Iterator<String> it = alquileres.iterator(); it.hasNext();)
			 {
				 String alquiler = it.next();
				 System.out.println(alquiler);
			 }
		    	
		 }
		 else
			 System.out.println("ERROR: No hay alquileres que listar. Por favor, inserte primero un alquiler en el sistema.");
		
	}
	
	private void listarAlquileresCliente()
	{
		 Consola.mostrarCabecera("Listado de alquileres por cliente: ");
		 List<Alquiler> alquileresClientes = controlador.getAlquileres(Consola.leerClienteDni());

		 if (alquileresClientes.size() > 0)
		 {
			 for(Iterator<Alquiler> it = alquileresClientes.iterator(); it.hasNext();)
			 {
				 Alquiler alquiler = it.next();
				 System.out.println(alquiler);
			 }
		    	
		 }
		 else
			 System.out.println("ERROR: No hay alquileres para dicho cliente.");	
	}
	
	private void listarAlquileresTurismo()
	{
		 Consola.mostrarCabecera("Listado de alquileres por turismo: ");
		 List<Alquiler> alquileresTurismo = controlador.getAlquileres(Consola.leerTurismoMatricula());

		 if (alquileresTurismo.size() > 0)
		 {
			 for(Iterator<Alquiler> it = alquileresTurismo.iterator(); it.hasNext();)
			 {
				 Alquiler alquiler = it.next();
				 System.out.println(alquiler);
			 }
		    	
		 }
		 else
			 System.out.println("ERROR: No hay alquileres para dicho turismo.");	
	}

}
