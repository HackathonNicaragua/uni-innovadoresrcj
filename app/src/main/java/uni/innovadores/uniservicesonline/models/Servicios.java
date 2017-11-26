package uni.innovadores.uniservicesonline.models;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

public class Servicios {
	private String NombreServ, DescrServ, CategoriaServ, IMG;
	private int idServ, estado;
	private double PrecioServ, Puntuacion;


	public Servicios() {
	}

	public Servicios(String NombreServ, String DescrServ, String IMG, String CategoriaServ, int idServ, int estado, double PrecioServ, double Puntuacion) {
		this.NombreServ = NombreServ;
		this.DescrServ = IMG;
		this.DescrServ = IMG;
		this.CategoriaServ = CategoriaServ;
		this.idServ = idServ;
		this.estado = estado;
		this.PrecioServ = PrecioServ;
		this.Puntuacion = Puntuacion;
	}


	//Metodos Get y Set
	public String getNombreServ() {
		return NombreServ;
	}

	public void setNombreServ(String NombreServ) {
		this.NombreServ = NombreServ;
	}

	public String getIMG() {
		return IMG;
	}

	public void setIMG(String IMG) {
		this.IMG = IMG;
	}

	public String getDescrServ() {
		return DescrServ;
	}

	public void setDescrServ(String DescrServ) {
		this.DescrServ = DescrServ;
	}

	public String getCategoriaServ() {
		return CategoriaServ;
	}

	public void setCategoriaServ(String CategoriaServ) {
		this.CategoriaServ = CategoriaServ;
	}


	public int getIdServ() {
		return idServ;
	}

	public void setIdServ(int idServ) {
		this.idServ = idServ;
	}

	public int getEstado(){
		return estado;}

	public void setEstado(int estado){
		this.estado = estado;}

	public double getPrecioServ(){
		return PrecioServ;}

	public void setPrecioServ(double PrecioServ){
		this.PrecioServ = PrecioServ;}

	public double getPuntuacion(){
		return Puntuacion;}

	public void setPuntuacion(double Puntuacion){
		this.Puntuacion = Puntuacion;}
}
