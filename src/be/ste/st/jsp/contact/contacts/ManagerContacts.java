package be.ste.st.jsp.contact.contacts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.javafx.collections.MappingChange.Map;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import be.ste.st.jsp.contact.tools.DAOBuilder;
import be.steformations.java_data.contacts.interfaces.beans.Contact;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.ContactsManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.CountryManager;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.TagManager;

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
		CountryManager mpays = new DAOBuilder().CountryManagerBuilder();
		TagManager mtags = new DAOBuilder().TagManagerBuilder();
		List<Country> listePays = mpays.getAllCountries();
		List<Tag> allListeTag = mtags.getAllTags();
		String _id = req.getParameter("ID");
		String delete = req.getParameter("DELETE");
		boolean del = false;
		Contact contact = null;
		Country pays = null;
		boolean boolTag = false;
		String listedTag = req.getParameter("UTAG");
		int id =-1;
		if(delete !=null) {
			del = Boolean.parseBoolean(delete);
		}
		if (listedTag != null) {
			boolTag = Boolean.parseBoolean(listedTag);
		}
		List<List<Tag>> mapTag;
		mapTag = new ArrayList<List<Tag>>();

			for(int i = 0; i< listeContacts.size(); i++) {
				mapTag.add(this._manager.getTagsByContact(listeContacts.get(i).getId()));
			}
			System.out.println(listeContacts.size());
		if(_id!=null) {
			id=Integer.parseInt(_id);
			contact = this._manager.getContactById(id);
			pays =contact.getCountry();
			System.out.println("ID "+ id);
			System.out.println("DEL "+ del);
			System.out.println("CONTACT "+ contact);
		}
		if(id> 0 && del) {
			this._manager.removeContact(id);
			listeContacts = this._manager.getAllContacts();
		}

		List<Tag> listeTags = this._manager.getTagsByContact(id);
		
		req.setAttribute("LIST_BY_USER_ALL", mapTag.toArray());
		req.setAttribute("CONTACT", contact);
		req.setAttribute("PAYS", pays);
		req.setAttribute("LISTE_CONTACTS", listeContacts);
		req.setAttribute("LISTE_PAYS", listePays);
		req.setAttribute("LISTE_TAG", listeTags);
		req.setAttribute("ALL_TAG", allListeTag);
		req.setAttribute("ID", id);
		resp.setContentType("text/plain");
		req.getRequestDispatcher("/contact.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		TagManager tag = new DAOBuilder().TagManagerBuilder();
		
		
		
		String boxPays  = req.getParameter("BOX_PAYS");
		String nom = req.getParameter("NOM");
		String prenom = req.getParameter("PRENOM");
		String email = req.getParameter("EMAIL"); 
		List<String> tagss = new ArrayList<>(Arrays.asList(req.getParameterValues("BOX_TAG")));
		
		if(boxPays.equalsIgnoreCase("none")) {
			boxPays = null;
		}
		
		if(!nom.isEmpty() && !prenom.isEmpty() && !email.isEmpty() && !boxPays.isEmpty()) {
			this._manager.createAndSaveContact(nom, prenom, email, boxPays, tagss);
		}
		req.setAttribute("NOM", nom);
		req.setAttribute("PRENOM", prenom);
		req.setAttribute("EMAIL", email);
		req.setAttribute("PAYS", boxPays);
		req.setAttribute("BOX_TAG", tagss);
		req.getRequestDispatcher("/contact.jsp").forward(req, resp);
		

	}
}
