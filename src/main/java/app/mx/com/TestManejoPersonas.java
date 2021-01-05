package app.mx.com;

import java.util.*;

import datos.mx.com.PersonaDAO;
import domain.mx.com.Persona;

public class TestManejoPersonas {

	public static void main(String[] args) {
		PersonaDAO personaDao = new PersonaDAO();
		List<Persona> personas= personaDao.seleccionar();
		
		/* insertar
		Persona peronaInsert = new Persona();
		peronaInsert.setNombre("Sandra");
		peronaInsert.setApellido("Carbajal");
		peronaInsert.setEmail("SandyCa@gmail.com");
		peronaInsert.setTelefono("5581309416");
		
		System.out.println("Se registro " + personaDao.Insertar(peronaInsert) + " persona(s)");
		*/
		
		/*Actualizar
		Persona personUpdate = new Persona(3,"Sandy","de Cortés","sandydecortes@gmail.com","5581309416");
		System.out.println("se actualizarona a " + personaDao.updatePerson(personUpdate));
		*/
		/*Eliminar
		Persona personaDelete = new Persona(2);
		System.out.println("Se elimino a " + personaDao.personDelete(personaDelete));
		*/
		personas.forEach(persona -> {
			System.out.println("Pesona = " + persona);
		});

	}

}
