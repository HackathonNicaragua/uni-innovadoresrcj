package uni.innovadores.uniservicesonline.models;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

public class Categorias {
	private String NombreCat;
	private int IdCat, estado;


	public Categorias() {
	}

	public Categorias(String NombreCat, int IdCat, int estado) {
		this.NombreCat = NombreCat;
		this.IdCat = IdCat;
		this.estado = estado;
	}


	//Metodos Get y Set
	public String getNombreCat() {
		return NombreCat;
	}

	public void setNombreCat(String NombreCat) {
		this.NombreCat = NombreCat;
	}

	public int getIdCat() {
		return IdCat;
	}

	public void setIdCat(int idServ) {
		this.IdCat = IdCat;
	}

	public int getEstado(){
		return estado;}

	public void setEstado(int estado){
		this.estado = estado;}

}
