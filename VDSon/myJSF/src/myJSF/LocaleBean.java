package myJSF;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LocaleBean {
	private Locale locale;

	public Locale getLocale() {
		return locale;
	}

	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	@PostConstruct
	public void init() {
		locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	}

	public String getLanguage() {
		return locale.getLanguage();
	}

	public void setLanguage(String Language) {
		locale = new Locale(Language);
		FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	}
}
