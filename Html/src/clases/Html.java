package clases;

import java.io.PrintWriter;
import java.util.ArrayList;

public class Html extends tag{
	
	private ArrayList<tag> head;
	private ArrayList<tag> body;


	@Override
	public void print(String texto, PrintWriter print) {
		print.print("<!DOCTYPE html>");
		print.print("<html>");
		print.print("<head>");
		for (tag tag : head) {
			tag.print(texto, print);
			
		}
		
		print.print("</head>");
		
	}


	public ArrayList<tag> getHead() {
		return head;
	}


	public void setHead(ArrayList<tag> head) {
		this.head = head;
	}


	public ArrayList<tag> getBody() {
		return body;
	}


	public void setBody(ArrayList<tag> body) {
		this.body = body;
	}


	public Html(ArrayList<tag> head, ArrayList<tag> body) {
		super();
		this.head = head;
		this.body = body;
	}
	
	

}
