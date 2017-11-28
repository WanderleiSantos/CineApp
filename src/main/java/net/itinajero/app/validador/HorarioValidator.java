package net.itinajero.app.validador;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import net.itinajero.app.model.Horario;

public class HorarioValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Horario.class.equals(arg0);
	}
	
	@Override
	public void validate(Object arg0, Errors errors) {		
		Horario horario = (Horario) arg0;
		try{
			LocalTime.parse(horario.getHora());			
		}catch(DateTimeParseException ex){
			System.out.println("Error: " + ex.getMessage());
			errors.rejectValue("hora", "horario.hora", "La hora ingresada es incorrecta.");
		}
	}

}
