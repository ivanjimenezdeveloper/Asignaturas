package clases;

import java.io.PrintWriter;

public class Header extends tag {



	@Override
	public void print(String texto, PrintWriter print) {
		
		
		print.print("<h1>"+texto+"</h1>");
	}
	
	

}
