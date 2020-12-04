package izvjestaji.aplikacija;

import android.content.Context;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import androidx.annotation.NonNull;

public class CustomAdapter extends ArrayAdapter<DataModel> implements View.OnClickListener{

    private ArrayList<DataModel> dataSet;
    Context context;

    private static class ViewHolder{
        TextView txtIme;
        TextView txtPrebivaliste;
        ImageView slika;
    }

    public CustomAdapter(@NonNull Context context, ArrayList<DataModel> data) {
        super(context, R.layout.my_list,data);
        this.dataSet = data;
        this.context = context;
    }

    @Override
    public void onClick(View v) {

        int position = (Integer) v.getTag();

    }
}
