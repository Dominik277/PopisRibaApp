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

        //napravili smo varijablu listView tipa ListView koja je u sebe pohranila
        //XML vrijednost koju smo nazvali listView te smo je nasli pomocu metode
        //findViewById kojoj smo kao parametar dali id od listView-a
        ListView listView = findViewById(R.id.listView);

        //napravili smo objekt tipa ArrayList u memoriji pomoću dijela new ArrayList<>();
        //referenca koja pokazuje na taj objekt te ćemo tom objektu pristupati preko nje
        //se zove dataModels
        //ArrayList je klasa od koje se moze napraviti objekt u koji se pohranjuje lista
        //podataka određenog tipa, u ovom slučaju tipa <DataModel>
        //ArrayList je zapravo array u koji mozemo spremati mnogo podataka istog
        //jedina razlika je sto u ArrayListu mozemo nadodavati elemente, u array ne mozemo
        ArrayList<DataModel> dataModels = new ArrayList<>();


        //dataModels je referenca na objekt tipa ArrayList
        //pomocu metode add dodajemo u dataModels objekt vrijednosti koje navodimo kao argumente
        //add metoda u parametrima prima konstruktor klase DataModel koji inicijalizira objekt
        //onim vrijednostima koje se nalaze u zagradama kao parametri
        //posto smo u DataModel klasi napravili custom konstruktor
        //DataModel(String ime,String prebivaliste) onda te vrijednosti u zagradi unosimo
        //kako bi inicijalizirali pojedine objekte koji se spremaju u obliku dataModels objekta
        dataModels.add(new DataModel ("Šaran","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Amur","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Som","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Babuska","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Grgec","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Štuka","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Smuđ","Ribnjaci,rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Zubatac","More,oceani",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Klen","Rijeke",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Srdela","More",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Skuša","More",R.drawable.ic_launcher_background));
        dataModels.add(new DataModel("Lubin","More",R.drawable.ic_launcher_background));


        //customAdapter je referenca koja pokazuje na objekt u memoriji tipa CustomAdapter
        //napravili smo klasu CustomAdapter te smo sada iz te klase napravili objekt i odredili
        //da ce se tom objektu pristupati preko imena customAdapter
        //posto smo u CustomAdapter klasi napravili custom konstruktor onda ne postoji default konstruktor
        //nego samo taj custom, te onda njega moramo dozvati prilikom inicijalizacije objekta
        //ovaj objekt smo inicijalizirali sa getApplicationContext i dataModels
        //dataModels --> objekt tipa ArrayList u koje su spremljeni svi objekti tipa DataModel
        //               te su ti objekti inicijalizirani pomocu custom konstruktora
        // ??? getApplicationContext() --> ova metoda vraca context cijele aplikacije
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),dataModels);


        //listView nam je ono sto smo kreirali u activity_main.xml koji popunjava cijeli screen
        //setAdapter metoda postavalja adapter na taj listView i kao parametrar prima
        //određeni adapter kojem smo mi naveli koje vrijednosti da salje u listView i na koji
        //nacin da ih prikazuje
        //listView mozemo zamisliti kao manekenku u izlogu kojoj je zadatak samo da stoji
        //adapter mozemo zamisliti kao nekog menađera koji vodi brigu o tom sto ce
        //manekenka(listView) imati obuceno,kako ce biti obuceno,kako ce stajati itd,itd...
        listView.setAdapter(customAdapter);


        //listView objektu dajemo mogucnost sto da radi kada se na njega klikne
        //pomocu metode setOnItemClickListener koji primaa kao parametar new AdaptarView.OnItemClickListener()
        //ova metoda u svom tijelu ima onItemClick metodu pomocu koje određujemo sta ce se desiti
        //kada kliknemo na određeni item,u nasem slucaju listView
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //onItemClik metoda koja se izvrsava kada se klikne na neki item
            //AdapterView parent -->
            //View view -->
            //int position -->
            //long id -->
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DataModel dataModel = dataModels.get(position);

                //Snackbar je mala poruka na dnu screen-a koja ce se prikazati kada kliknemo
                //na neki od item u listView-u
                //view -->
                //dataModel.getIme() -->
                //dataModel.getPrebivaliste() -->
                //Snackbar.LENGHT_LONG -->
                //setAction -->
                //show -->
                Snackbar.make(view,dataModel.getIme() + "\n" + dataModel.getPrebivaliste(),Snackbar.LENGTH_LONG)
                        .setAction("No Action",null)
                        .show();
            }
        });
    }
}