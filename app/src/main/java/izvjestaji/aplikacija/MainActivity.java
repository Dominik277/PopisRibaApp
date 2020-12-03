package izvjestaji.aplikacija;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    Context context;
    CardView cardView;
    ViewGroup.LayoutParams layoutParams;
    TextView textView;
    RelativeLayout relativeLayout;
    FloatingActionButton floatingActionButton;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        String [] fruits = new String[]{"Jabuka","Jagoda","Lubenica"};
        List<String> fruitsList = new ArrayList<String>(Arrays.asList(fruits));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,fruitsList);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fruitsList.add("Tresnja");
                fruitsList.add("Visnja");
                arrayAdapter.notifyDataSetChanged();
            }
        });
    }

    private void createCardViewProgrammatically() {

        cardView = new CardView(this);
        layoutParams = new RelativeLayout.LayoutParams
                (ViewGroup.LayoutParams.WRAP_CONTENT
                , ViewGroup.LayoutParams.WRAP_CONTENT);

        cardView.setLayoutParams(layoutParams);
        cardView.setRadius(15);
        cardView.setPadding(25,25,25,25);
        cardView.setCardBackgroundColor(Color.MAGENTA);
        cardView.setMaxCardElevation(30);
        cardView.setMaxCardElevation(6);

        textView = new TextView(this);
        textView.setLayoutParams(layoutParams);
        textView.setText("CardView Programmatically");
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP,25);
        textView.setTextColor(Color.WHITE);
        textView.setPadding(25,25,25,25);
        textView.setGravity(Gravity.CENTER);

        cardView.addView(textView);

        relativeLayout.addView(cardView);


    }

}