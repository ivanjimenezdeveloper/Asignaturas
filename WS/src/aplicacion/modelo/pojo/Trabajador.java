package aplicacion.modelo.pojo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Trabajador {

		private String nombre;
		
		private String apellidos;
		
		private Integer edad;
		
		private List<String> habilidades;

		public Trabajador() {
			habilidades = new ArrayList<String>();
		}
		
		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellidos() {
			return apellidos;
		}

		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}

		public Integer getEdad() {
			return edad;
		}

		public void setEdad(Integer edad) {
			this.edad = edad;
		}

		public List<String> getHabilidades() {
			return habilidades;
		}

		public void setHabilidades(List<String> habilidades) {
			this.habilidades = habilidades;
		}
		
		public void addHabilidad(String habilidad) {
			this.habilidades.add(habilidad);
		}
}
