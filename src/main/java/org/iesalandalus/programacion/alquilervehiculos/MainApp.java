package org.iesalandalus.programacion.alquilervehiculos;

import org.iesalandalus.programacion.alquilervehiculos.controlador.Controlador;
import org.iesalandalus.programacion.alquilervehiculos.modelo.Modelo;
import org.iesalandalus.programacion.alquilervehiculos.vista.Vista;


/**
 * 
 * @author Pedro Patricio Cárdenas Figueroa
 * Github: https://github.com/ptrdck/AlquilerVehiculos.git
 * Tarea Online 7
 * Programación DAM 2022/23
 */
public class MainApp {

	public static void main(String[] args) {
		Modelo modelo = new Modelo();
		Vista vista = new Vista();
		Controlador controlador = new Controlador(modelo, vista);
		controlador.comenzar();
	}

}
