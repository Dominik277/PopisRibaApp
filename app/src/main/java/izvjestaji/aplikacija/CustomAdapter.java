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

    private ArrayList<DataModel> dataSet = new ArrayList<>();
    private Context context;

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


    //ova metoda se poziva kada listItem treba biti napravljen
    //i kada listItem treba biti popunjen podacima
    //u ovoj metodi prvo je View "inflated" pomocu LayoutInflater.inflate()
    //bitno nam je prokuziti je li view koji zelimo "inflatati" novi ili recikliran
    //if(convertedView == null) onda view treba biti "inlatan"
    //
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        if (listItem == null){
            listItem = LayoutInflater.from(context).inflate(R.layout.my_list,parent,false);
        }

        DataModel currentData = dataSet.get(position);

        ImageView slika = listItem.findViewById(R.id.slika);
        slika.setImageResource(currentData.getSlika());

        TextView ime = listItem.findViewById(R.id.ime);
        ime.setText(currentData.getIme());

        TextView prebivaliste = listItem.findViewById(R.id.prebivaliste);
        prebivaliste.setText(currentData.getPrebivaliste());

        return listItem;

    }
}
