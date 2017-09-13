package be.ste.st.jsp.contact.contacts;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import be.ste.st.jsp.contact.tools.DAOBuilder;
import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.ContactsManager;

public class ManagerContacts extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private final ContactsManager _manager = new DAOBuilder().contactsManagerBuilder();
	
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
		List<Contact> listeContacts = this._manager.getAllContacts();
		req.setAttribute("LISTE_CONTACTS", listeContacts);
		resp.setContentType("text/plain");
		req.getRequestDispatcher("/contact.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*System.out.println("controleur.doPost()");
		
		/*analyse de la validation de la requete */
		
		/*String addPays = req.getParameter("ADD_PAYS");
		String addAbb = req.getParameter("ADD_ABR");
		
		
		this._manager.createAndSaveCountry(addAbb, addPays);
		req.setAttribute("ADD_PAYS", addPays);
		req.setAttribute("ADD_ABR", addAbb);
		req.getRequestDispatcher("/addpays.jsp").forward(req, resp);*/

	}
}
