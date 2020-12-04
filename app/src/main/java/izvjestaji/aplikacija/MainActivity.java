package izvjestaji.aplikacija;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collection;

public class MainActivity extends AppCompatActivity {

    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("Šaran");
        arrayList.add("Amur");
        arrayList.add("Som");
        arrayList.add("Štuka");
        arrayList.add("Smuđ");
        arrayList.add("Babuška");
        arrayList.add("Grgeč");
        arrayList.add("Deverika");
        arrayList.add("Tostolobik");
        arrayList.add("Klen");

        ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,arrayList);
        listView.setAdapter(arrayAdapter);

    }



}