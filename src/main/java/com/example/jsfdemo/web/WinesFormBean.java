package com.example.jsfdemo.web;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import javax.faces.model.ListDataModel;
import javax.faces.validator.ValidatorException;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.jsfdemo.domain.Wines;
import com.example.jsfdemo.service.WinesManager;

@SessionScoped
@Named("winesBean")
public class WinesFormBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private Wines wine = new Wines();

	private ListDataModel<Wines> wines = new ListDataModel<Wines>();

	@Inject
	private WinesManager wm;

	public Wines getWine() {
		return wine;
	}

	public void setWine(Wines wine) {
		this.wine = wine;
	}

	public ListDataModel<Wines> getAllWines() {
		wines.setWrappedData(wm.getAllWines());
		return wines;
	}
	
	// Actions
	
	public String addWine() {
		wm.add(wine);
		return "showWines";
		//return null;
	}

	public String deleteWine() {
		Wines wineToDelete = wines.getRowData();
		wm.deleteWine(wineToDelete);
		return null;
	}
	
	public String editWine(){
		Wines wineToUpdate = wines.getRowData();
		wm.updateWine(wineToUpdate);
		
			return "showUpdate";
	}
	
	public String saveWine(){
		wm.updateWineFinish(wine);
			return "showWines";
	}

	// Validators

	// Business logic validation
	/*public void uniquePin(FacesContext context, UIComponent component,
			Object value) {

		String pin = (String) value;
		String origin = (String) value;

		for (Person person : pm.getAllPersons()) {
			if (person.getPin().equalsIgnoreCase(pin)) {
				FacesMessage message = new FacesMessage(
						"Person with this PIN already exists in database");
				message.setSeverity(FacesMessage.SEVERITY_ERROR);
				throw new ValidatorException(message);
			}
		}
	}
	*/

	// Multi field validation with <f:event>
	// Rule: first two digits of PIN must match last two digits of the year of
	// birth

	public void validatePinDob(ComponentSystemEvent event) {
		
		UIForm form = (UIForm) event.getComponent();
		UIInput origin_ = (UIInput) form.findComponent("origin_");
		UIInput region_ = (UIInput) form.findComponent("region_");


		if (origin_.getValue() == "Italy" && region_.getValue() != "Sicilia"){
			FacesContext context = FacesContext.getCurrentInstance();
			context.addMessage(form.getId(), new FacesMessage(
					"i'm so sorry"));
			context.renderResponse();
			}
		
	}
		
		
		/*if (pin.getValue() != null && dob.getValue() != null
				&& pin.getValue().toString().length() >= 2) {
			String twoDigitsOfPin = pin.getValue().toString().substring(0, 2);
			Calendar cal = Calendar.getInstance();
			cal.setTime(((Date) dob.getValue()));

			String lastDigitsOfDob = ((Integer) cal.get(Calendar.YEAR))
					.toString().substring(2);

			if (!twoDigitsOfPin.equals(lastDigitsOfDob)) {
				FacesContext context = FacesContext.getCurrentInstance();
				context.addMessage(form.getClientId(), new FacesMessage(
						"PIN doesn't match date of birth"));
				context.renderResponse();
			}
			*/
		
	
}

