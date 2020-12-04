package izvjestaji.aplikacija;

import android.content.Context;
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
            viewHolder
        }
    }
}
