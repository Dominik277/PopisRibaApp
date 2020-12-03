package izvjestaji.aplikacija;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] datum;
    private final String[] riba;
    private final String[] kilaza;
    private final String[] vrijeme;
    private final String[] mamac;
    private final String[] izvjestaj;

    public MyListAdapter(Activity context, String[] datum, String[] riba, String[] kilaza, String[] vrijeme, String[] mamac, String[] izvjestaj) {
        super(context,R.layout.my_list,datum);
        this.context = context;
        this.datum = datum;
        this.riba = riba;
        this.kilaza = kilaza;
        this.vrijeme = vrijeme;
        this.mamac = mamac;
        this.izvjestaj = izvjestaj;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View objektListView = inflater.inflate(R.layout.my_list,null);

        TextView datum = objektListView.findViewById(R.id.datum);
        TextView subtitleText = objektListView.findViewById(R.id.subtitleText);
        ImageView imageView = objektListView.findViewById(R.id.imageView);

        titleText.setText(mainTitle[position]);
        subtitleText.setText(subTitle[position]);
        imageView.setImageResource(imgid[position]);

        return objektListView;
    }
}
