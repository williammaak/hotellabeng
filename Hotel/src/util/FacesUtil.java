package util;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

public class FacesUtil {
	public static void addMessageInfo(String message){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesMessage);
	}
	
	public static void addMessageError(String message){
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message);
		
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, facesMessage);
	}
}
