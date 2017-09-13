package be.ste.st.jsp.contact.contacts;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import be.ste.st.jsp.contact.tools.DAOBuilder;
import be.steformations.java_data.contacts.interfaces.beans.Country;
import be.steformations.java_data.contacts.interfaces.beans.Tag;
import be.steformations.pc.java_data.contacts.spring_jdbc.managers.TagManager;

public class ManagerTag extends HttpServlet {
	private final TagManager _manager = new DAOBuilder().TagManagerBuilder();
	
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
		List<Tag> listeTags = this._manager.getAllTags();
		req.setAttribute("LISTE_TAG", listeTags);
		resp.setContentType("text/plain");
		req.getRequestDispatcher("/tags.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*analyse de la validation de la requete */
		String addTag = req.getParameter("ADD_TAG");
		this._manager.createAndSaveTag(addTag);
		req.setAttribute("ADD_TAG", addTag);
		req.getRequestDispatcher("/addtag.jsp").forward(req, resp);

	}

}
