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
import uni.innovadores.uniservicesonline.models.Categorias;
import uni.innovadores.uniservicesonline.models.Servicios;

/**
 * Created by Javier Gutierrez on 25/11/2017.
 */

public class CategoriasAdapter extends BaseAdapter {
	private Activity activity;
	private LayoutInflater inflater;
	private List<Categorias> categoriasItems;

	public CategoriasAdapter(Activity activity, List<Categorias> categoriasItems) {
		this.activity = activity;
		this.categoriasItems = categoriasItems;
	}

	@Override
	public int getCount() {
		return categoriasItems.size();
	}

	@Override
	public Object getItem(int location) {
		return categoriasItems.get(location);
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
			convertView = inflater.inflate(R.layout.categorias_row, null);

		TextView IDCat = convertView.findViewById(R.id.tx_cat_id);
		TextView NamCat = convertView.findViewById(R.id.tv_name_cat);
		TextView DescCat = convertView.findViewById(R.id.tv_descr_cat);
		ImageView IMGServicio = convertView.findViewById(R.id.img_cat);

		try{

			Categorias cat = categoriasItems.get(position);

			//Picasso.with(convertView.getContext()).load(srv.getThumbnailUrl()).into(IMGServicio);

			IDCat.setText(String.valueOf(cat.getIdCat()));
			NamCat.setText(cat.getNombreCat());

			//img1.setText(srv.getThumbnailUrl());
			//img2.setText(srv.getThumbnailUrl2());
		}catch(Exception e){
			System.out.print(e+"!");
		}
		finally{

		}

		return convertView;
	}

}
