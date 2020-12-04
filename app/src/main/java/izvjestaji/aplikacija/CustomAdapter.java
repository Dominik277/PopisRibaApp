package izvjestaji.aplikacija;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context context;

    //static klasa ViewHolder koja zbog toga sto je static ne mogu se
    //od nje pravit objekti, nego se atributima pristupa ImeKlase.atribut
    //u ovoj klasi se nalaze atributi tipa TextView txtIme i txtPrebivaliste
    //te atribut slika tipa ImageView koji nam se nalaze u custom listViewu u XML-u
    private static class ViewHolder{
        TextView txtIme;
        TextView txtPrebivaliste;
        ImageView slika;
    }


    //ovo je custom konstruktor koji kao parametre prima context i data
    //ovaj konstruktor nam sluzi kako bi inicijalizirali objekt prilikom njegovog stvaranja
    //Context context -->
    //ArrayList<DataModel> data-->
    //super(context,R.layout.my_list,data) -->
    //this.dataSet = data -->
    //this.context = context -->
    public CustomAdapter(@NonNull Context context, ArrayList<DataModel> data) {
        super(context, R.layout.my_list,data);
        this.dataSet = data;
        this.context = context;
    }


    //metoda cije se tijelo izvrsava kada se klikne na neki item
    //prima paramterar v tipa View
    //View v -->
    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();
        Object object = getItem(position);
        DataModel dataModel = (DataModel) object;

        switch (v.getId()){
            case R.id.slika:
                Snackbar.make(v,"Release Date " +dataModel.getPrebivaliste()
                        ,Snackbar.LENGTH_LONG).setAction("No action",null).show();
                break;
        }
    }

    private int lastPosition = -1;

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get the data item for this position
        DataModel dataModel = getItem(position);
        //Check if an existing view is being reused,otherwise inflate the view
        ViewHolder viewHolder;

        final View result;

        if (convertView == null){
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.my_list,parent,false);
            viewHolder.txtIme = (TextView) convertView.findViewById(R.id.ime);
            viewHolder.txtPrebivaliste = (TextView)convertView.findViewById(R.id.prebivaliste);
            viewHolder.slika = (ImageView)convertView.findViewById(R.id.slika);

            result = convertView;
            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder)convertView.getTag();
            result = convertView;
        }

        viewHolder.txtIme.setText(dataModel.getIme());
        viewHolder.txtPrebivaliste.setText(dataModel.getPrebivaliste());
        return convertView;
    }
}
