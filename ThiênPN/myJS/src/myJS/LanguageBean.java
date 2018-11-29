package myJS;

import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class LanguageBean {
//	private static final long serialVersionUID = 1L;
//	private String locale;
//	private final static Locale LOCALE_VI = new Locale("vi", "VI");
//
//	private static Map<String, Object> countries;
//	static {
//		countries = new LinkedHashMap<String, Object>();
//		countries.put("English", Locale.ENGLISH);
//		countries.put("Vietnamese", LOCALE_VI);
//	}
//
//	public Map<String, Object> getCountries() {
//		return countries;
//	}
//
//	public String getLocale() {
//		return locale;
//	}
//
//	public void setLocale(String locale) {
//		this.locale = locale;
//	}
//
//	public void localeChanged(ValueChangeEvent e) {
//		String newLocaleValue = e.getNewValue().toString();
//		for (Map.Entry<String, Object> entry : countries.entrySet()) {
//			if (entry.getValue().toString().equals(newLocaleValue)) {
//				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale) entry.getValue());
//			}
//		}
//	}
	
	 private Locale locale;

	    @PostConstruct
	    public void init() {
	        locale = FacesContext.getCurrentInstance().getExternalContext().getRequestLocale();
	    }

	    public Locale getLocale() {
	        return locale;
	    }

	    public String getLanguage() {
	        return locale.getLanguage();
	    }

	    public void setLanguage(String language) {
	        locale = new Locale(language);
	        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
	    }
}
