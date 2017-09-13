package be.ste.st.jsp.contact.tools;

import javax.servlet.http.HttpServlet;
import javax.sql.DataSource;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import be.steformations.pc.java_data.contacts.spring_jdbc.managers.ContactsManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.CountryManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.TagManager;

public class DAOBuilder extends HttpServlet {
	private static final long serialVersionUID = 1L;
	final DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost/contacts", "postgres", "s6k6q36e");
	final CountryManager _pays = new CountryManager(this.dataSource);
	final TagManager _tag = new TagManager(this.dataSource);
	
	
	public CountryManager CountryManagerBuilder() {
		return this._pays;
		
	}
	public TagManager TagManagerBuilder() {
		return this._tag;
		
	}
	public ContactsManager contactsManagerBuilder() {
		return new ContactsManager(dataSource, this._pays, this._tag);
	}


}
