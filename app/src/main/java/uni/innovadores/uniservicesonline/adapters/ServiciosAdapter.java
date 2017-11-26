package uni.innovadores.uniservicesonline.adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.List;

import uni.innovadores.uniservicesonline.R;
import uni.innovadores.uniservicesonline.models.Servicios;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

public class ServiciosAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Servicios> serviciosItems;

	public ServiciosAdapter(Activity activity, List<Servicios> serviciosItems) {
		this.activity = activity;
		this.serviciosItems = serviciosItems;
	}

	@Override
	public int getCount() {
		return serviciosItems.size();
	}

	@Override
	public Object getItem(int location) {
		return serviciosItems.get(location);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (inflater == null)
			inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if (convertView == null)
			convertView = inflater.inflate(R.layout.servicios_row, null);

		TextView NServicio = convertView.findViewById(R.id.tv_name_serv);
		TextView DServicio = convertView.findViewById(R.id.tv_descr_serv);
		TextView precioServicio = convertView.findViewById(R.id.tv_precio);
		RatingBar puntServicio = convertView.findViewById(R.id.rtb_punt);
		ImageView IMGServicio = convertView.findViewById(R.id.img_serv);

		try{

			Servicios srv = serviciosItems.get(position);

			//Picasso.with(convertView.getContext()).load(srv.getThumbnailUrl()).into(IMGServicio);

			NServicio.setText(srv.getNombreServ());
			DServicio.setText(srv.getDescrServ());
			String PreC = activity.getString(R.string.init_precio)+String.valueOf(srv.getPrecioServ());
			precioServicio.setText(PreC);
			puntServicio.setRating(Float.parseFloat(String.valueOf(srv.getPuntuacion())));

		}catch(Exception e){
			System.out.print(e+"!");
		}
		finally{

		}

		return convertView;
	}

}
