package uni.innovadores.uniservicesonline.models;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

public class Categorias {
	private String NombreCat, DesCat;
	private int IdCat, estado;


	public Categorias() {
	}

	public Categorias(String NombreCat, String DesCat, int IdCat, int estado) {
		this.NombreCat = NombreCat;
		this.DesCat = DesCat;
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

	public String getDesCat() {
		return DesCat;
	}

	public void setDesCat(String DesCat) {
		this.DesCat = DesCat;
	}

	public int getIdCat() {
		return IdCat;
	}

	public void setIdCat(int IdCat) {
		this.IdCat = IdCat;
	}

	public int getEstado(){
		return estado;}

	public void setEstado(int estado){
		this.estado = estado;}

}
