package be.ste.st.jsp.contact.testdao;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.CountryManager;

public class TestDAOSpring extends HttpServlet{

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DriverManagerDataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost/contacts", "postgres", "s6k6q36e"); 
		
		CountryManager manager = new CountryManager(dataSource);
		Country usa = manager.getCountryByAbbreviation("US");
		System.out.println(usa);
		resp.setContentType("text/plain");
		resp.getWriter().write("ok");
	}
		
	
	
	

}
