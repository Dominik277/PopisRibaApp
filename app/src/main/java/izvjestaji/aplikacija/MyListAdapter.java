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
    private final String[] mainTitle;
    private final String[] subTitle;
    private final Integer[] imgid;


    public MyListAdapter(Activity context, String[] mainTitle, String[] subTitle, Integer[] imgid) {
        super(context,R.layout.my_list,mainTitle);

        this.context = context;
        this.mainTitle = mainTitle;
        this.subTitle = subTitle;
        this.imgid=imgid;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View view, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.my_list,null);

        TextView titleText = rowView.findViewById(R.id.titleText);
        TextView subtitleText = rowView.findViewById(R.id.subtitleText);
        ImageView imageView = rowView.findViewById(R.id.imageView);

        titleText.setText(mainTitle[position]);
        subtitleText.setText(subTitle[position]);
        imageView.setImageResource(imgid[position]);

        return rowView;
    }
}
