package izvjestaji.aplikacija;

public class Model {

    String ime;
    String prebivaliste;

    public Model(String ime, String prebivaliste) {
        this.ime = ime;
        this.prebivaliste = prebivaliste;
    }

    public String getIme() {
        return ime;
    }

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