package com.example.jsfdemo.web;
import java.util.ArrayList;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

import com.example.jsfdemo.domain.Wines;


@FacesValidator("regionValidator")
public class StrainsValidator implements Validator {
	@Override
	public void validate(FacesContext context, UIComponent component, Object value)
				throws ValidatorException {
		
		
		
		Wines wine = new Wines();
	
		String region;
		
		region = wine.getRegion();
		

		
		if (region.isEmpty()){
			FacesMessage message = new FacesMessage();
			message.setDetail("Please select a region!");
			message.setSummary("Please select a region!");
			message.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(message);
		}
		
		
		/*if (origin.startsWith("pai") && !type.startsWith("red")){
				FacesMessage message = new FacesMessage();
				message.setDetail("This country does not have selected strain!");
				message.setSummary("This country does not have selected strain!");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
		}
		*/
	}
}