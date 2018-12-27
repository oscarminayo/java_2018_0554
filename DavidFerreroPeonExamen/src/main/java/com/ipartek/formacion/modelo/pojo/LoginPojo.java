package com.ipartek.formacion.modelo.pojo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import com.ipartek.formacion.modelo.pojo.PojoException;

public class LoginPojo {

	public static final String REGEX_EMAIL = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
	public static final String REGEX_PASSWORD = "(?=^.{6,}$)(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&amp;*()_+}{&quot;:;'?/&gt;.&lt;,])(?!.*\\s).*$";


	@NotEmpty // para validar 
	@Email // para validar
	private String email;
	
	@NotNull
	@Size(min=5, max=50)
	private String password;
	
	
	public LoginPojo() throws PojoException {
		super();
	
		this.email = "";
		this.password = "";
	}

	public LoginPojo( String email, String password) throws PojoException {
		this();
		
		setEmail(email);
		setPassword(password);
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) throws PojoException {

		if (email == null || email.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_EMAIL_VACIO);
		}

		if (!email.matches(REGEX_EMAIL)) {
			throw new PojoException(PojoException.EXCEPTION_EMAIL_NO_VALIDO);
		}

		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) throws PojoException {

		if (password == null || password.trim().length() == 0) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_VACIO);
		}

		if (!password.matches(REGEX_PASSWORD)) {
			throw new PojoException(PojoException.EXCEPTION_PASSWORD_NO_VALIDO);
		}

		this.password = password;
	}

	@Override
	public String toString() {
		return "Usuario [ email=" + email + ", password=" + password + "]";
	}
}
