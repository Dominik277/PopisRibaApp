package izvjestaji.aplikacija;

//klasa tipa DataModel koja u sebi sadrzava instance variables
//parametrzirani konstruktor i gettere i setter
public class DataModel {

    //atribut modela nazvan ime
    private String ime;
    //atribut modela nazvan prebivaliste
    private String prebivaliste;

    //custom constructor sa atributima s kojima cemo
    //inicijalizirati objekte
    //this.ime i this.prebivaliste -> atributi klase
    //ime i prebivaliste -> parametri konstruktora
    //kada pravimo objekt napisemo njegov tip i referencu po kojoj cemo ga pozivati
    //new DataModel(...) ovaj dio onogućuje stvaranje objekta u memoriji i inicijalizira
    //objekt s argumentima koje unesemo u zagrade konstruktora
    public DataModel(String ime, String prebivaliste) {
        this.ime = ime;
        this.prebivaliste = prebivaliste;
    }


    //posto su nam atributi tipa private ne mozemo im pristupiti izvan klase
    //bolji nacin je pristupanje varijablama pomocu getter metoda jer im korisnik
    //ne moze promjeniti vrijednost ako im pristupa izvan klase
    //stoga zovemo metodu getIme (imeObjekta.getIme()) i ona nam vraca vrijednost
    //imena koji je spremljen u objektu
    public String getIme() {
        return ime;
    }

    //posto su nam atributi klase privatni ne mozemo im pristupiti izvan njihove klase
    //stoga pravimo set metodu ako zelimo promjeniti atribut klase tako sto pozovemo metodu
    //i unesemo argument u zagradu kako bi promjenili vrijednost atributa
    //this.ime -> atribut klase,  ime -> argument koji unesemo u zagradu
    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrebivaliste() {
        return prebivaliste;
    }

    public void setPrebivaliste(String prebivaliste) {
        this.prebivaliste = prebivaliste;
    }
}
