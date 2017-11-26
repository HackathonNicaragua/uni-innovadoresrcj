package uni.innovadores.uniservicesonline.adapters;

/**
 * Created by javier on 02-03-17.
 */

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import uni.innovadores.uniservicesonline.R;
import uni.innovadores.uniservicesonline.models.Notify;

import java.util.List;

public class CustomListNotifyAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Notify> notifyItems;


    public CustomListNotifyAdapter(Activity activity, List<Notify> notifyItems) {
        this.activity = activity;
        this.notifyItems = notifyItems;
    }

    @Override
    public int getCount() {
        return notifyItems.size();
    }

    @Override
    public Object getItem(int location) {
        return notifyItems.get(location);
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
            convertView = inflater.inflate(R.layout.list_row_notify, null);


        TextView Titulo = convertView.findViewById(R.id.txtn_titulo);
        TextView Cuerpo = convertView.findViewById(R.id.txtn_texto);



        Notify ntfy = notifyItems.get(position);


        // Titulo
        Titulo.setText(ntfy.getTitulo());


        // Cuerpo
        Cuerpo.setText(ntfy.getTexto());

        return convertView;
    }

}