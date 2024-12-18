package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/Controller","/main"})
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public controller() {
        super();
    
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getContextPath();
		System.out.println(action);
		
		switch(action) {
		case "/main":
			
		}
		
	}

}
