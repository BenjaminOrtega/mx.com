package app.mx.com;

import java.util.*;

import datos.mx.com.PersonaDAO;
import domain.mx.com.Persona;

public class TestManejoPersonas {

	public static void main(String[] args) {
		PersonaDAO personaDao = new PersonaDAO();
		List<Persona> personas= personaDao.seleccionar();
		
		personas.forEach(persona -> {
			System.out.println("Pesona = " + persona);
		});

	}

}