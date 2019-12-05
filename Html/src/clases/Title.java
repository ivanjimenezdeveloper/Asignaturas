package clases;

import java.io.PrintWriter;

public class Title extends tag {
	private String texto;

	@Override
	public void print(String texto, PrintWriter print) {
		print.print("<title>");
		print.print(texto);
		print.print("</title>");
	}

	public void print(PrintWriter print) {
		print.print("<title>");
		print.print(this.texto);
		print.print("</title>");
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

}
