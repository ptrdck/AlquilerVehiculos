package org.iesalandalus.programacion.alquilervehiculos.vista;

public enum Opcion 
{
	SALIR("Salir")
	{
		public void ejecutar()
		{
			vista.salir();
		}
	}
	,
	
	INSERTAR_CLIENTE("Insertar cliente")
	{
		public void ejecutar()
		{
			vista.insertarCliente();
		}
	}
	,
	
	INSERTAR_TURISMO("Insertar turismo")
	{
		public void ejecutar()
		{
			vista.insertarTurismo();
		}
	}
	,
	
	INSERTAR_ALQUILER("Insertar alquiler")
	{
		public void ejecutar()
		{
			vista.insertarAlquiler();
		}
	}
	,
	
	BUSCAR_CLIENTE("Buscar cliente")
	{
		public void ejecutar()
		{
			vista.buscarCliente();
		}
	}
	,
	
	BUSCAR_TURISMO("Buscar turismo")
	{
		public void ejecutar()
		{
			vista.buscarTurismo();
		}
	}
	,
	
	BUSCAR_ALQUILER("Buscar alquiler")
	{
		public void ejecutar()
		{
			vista.buscarAlquiler();
		}
	}
	,
	
	MODIFICAR_CLIENTE("Modificar cliente")
	{
		public void ejecutar()
		{
			vista.modificarCliente();
		}
	}
	,
	
	DEVOLVER_ALQUILER("Devolver alquiler")
	{
		public void ejecutar()
		{
			vista.devolverAlquiler();
		}
	}
	,
	
	BORRAR_CLIENTE("Borrar cliente")
	{
		public void ejecutar()
		{
			vista.borrarCliente();
		}
	}
	,
	
	BORRAR_TURISMO("Borrar turismo")
	{
		public void ejecutar()
		{
			vista.borrarTurismo();
		}
	}
	,
	
	BORRAR_ALQUILER("Borrar alquiler")
	{
		public void ejecutar()
		{
			vista.borrarAlquiler();
		}
	}
	,
	
	LISTAR_CLIENTES("Listar clientes")
	{
		public void ejecutar()
		{
			vista.listarClientes();
		}
	}
	,
	
	LISTAR_TURISMOS("Listar turismos")
	{
		public void ejecutar()
		{
			vista.listarTurismo();
		}
	}
	,
	
	LISTAR_ALQUILERES("Listar alquileres")
	{
		public void ejecutar()
		{
			vista.listarAlquileres();
		}
	}
	,
	
	LISTAR_ALQUILERES_CLIENTE("Listar alquileres cliente")
	{
		public void ejecutar()
		{
			vista.listarAlquileresCliente();
		}
	}
	,
	
	LISTAR_ALQUILERES_TURISMO("Listar alquileres turismo")
	{
		public void ejecutar()
		{
			vista.listarAlquileresTurismo();
		}
	}
	;
	
	private String texto;
	
	private Opcion(String texto)
	{
		this.texto = texto;
	}
	
	private boolean esOrdinalValido(int ordinal)
	{
		return (ordinal >=0 && ordinal <= values().length-1);
	}
	
	public Opcion get(int ordinal)
	{
		if (!esOrdinalValido(ordinal))
		{
			throw new IllegalArgumentException("Ordinal de la opción no válido");
		}
		return values()[ordinal];
	}
	
	public String toString()
	{
		return String.format("%d.- %s", ordinal(), texto);
	}
}
