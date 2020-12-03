package izvjestaji.aplikacija;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    String [] datum = {"21.1.","30.1","21.6","31.3"};
    String [] riba = {"Saran","Amur"};
    String [] kilaza = {"7,54","9,25","21,54","3,64"};
    String [] vrijeme = {"11:25","12:46","18:54","19:01"};
    String [] mamac = {"Boila","Kukuruz","Boila","Boila"};
    String [] izvjestaj = {"","","",""};

    String[] mainTitle = {"Title 1","Title 2","Title 3","Title 4"};
    String[] subTitle = {"SubTitle 1","SubTitle 2","SubTitle 3","SubTitle 4"};
    Integer [] imageView = {R.drawable.facebook,R.drawable.instagram,R.drawable.viber,R.drawable.wapp};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);

        MyListAdapter adapter = new MyListAdapter(this,datum,riba,kilaza,vrijeme,mamac,izvjestaj);
        listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position==0){
                    Toast.makeText(getApplicationContext(),"Place Your First Option Code", Toast.LENGTH_SHORT).show();
                }else if (position == 1){
                    Toast.makeText(getApplicationContext(),"Place Your Second Option Code",Toast.LENGTH_SHORT).show();
                }else if (position == 2){
                    Toast.makeText(getApplicationContext(),"Place Your Third Option Code",Toast.LENGTH_SHORT).show();
                }else if (position == 3){
                    Toast.makeText(getApplicationContext(),"Place Your Forth Option Code",Toast.LENGTH_SHORT).show();
                }else if (position == 4){
                    Toast.makeText(getApplicationContext(),"Place Your Fifth Option Code",Toast.LENGTH_SHORT).show();
                }
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