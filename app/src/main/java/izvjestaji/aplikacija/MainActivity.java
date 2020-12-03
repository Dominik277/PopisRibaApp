package izvjestaji.aplikacija;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button button;
    ListView listView;

    String[] mainTitle = {"Title 1","Title 2","Title 3","Title 4"};
    String[] subTitle = {"SubTitle 1","SubTitle 2","SubTitle 3","SubTitle 4"};
    Integer [] imageView = {R.drawable.facebook,R.drawable.instagram,R.drawable.viber,R.drawable.wapp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        listView = findViewById(R.id.listView);

        String [] fruits = new String[]{"Jabuka","Jagoda"};
        List<String> fruitsList = new ArrayList<String>(Arrays.asList(fruits));

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,fruitsList);
        listView.setAdapter(arrayAdapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //fruitsList.add("Tresnja");
                //fruitsList.add("Visnja");
                //arrayAdapter.notifyDataSetChanged();
                showAlertDialog();
            }
        });
    }

    public void showAlertDialog(){
        new AlertDialog.Builder(MainActivity.this)
                .setTitle("delete entry")
                .setMessage("Are you sure")
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton(android.R.string.no,null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

}