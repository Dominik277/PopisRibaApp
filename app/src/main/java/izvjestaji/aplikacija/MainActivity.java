package izvjestaji.aplikacija;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);
        ArrayList<DataModel> dataModels = new ArrayList<>();

        dataModels.add(new DataModel ("Šaran","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Amur","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Som","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Babuska","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Grgec","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Štuka","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Smuđ","Ribnjaci,rijeke"));
        dataModels.add(new DataModel("Zubatac","More,oceani"));
        dataModels.add(new DataModel("Klen","Rijeke"));
        dataModels.add(new DataModel("Srdela","More"));
        dataModels.add(new DataModel("Skuša","More"));
        dataModels.add(new DataModel("Lubin","More"));

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),dataModels);
        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataModel dataModel = dataModels.get(position);
                Snackbar.make(view,dataModel.getIme() + "\n" + dataModel.getPrebivaliste(),Snackbar.LENGTH_LONG)
                        .setAction("No Action",null)
                        .show();
            }
        });
    }
}