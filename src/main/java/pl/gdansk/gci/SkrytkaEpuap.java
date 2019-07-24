package pl.gdansk.gci;

public class SkrytkaEpuap {

    private String nazwaPodmiotu;
    private String regon;
    private String adres;
    private String kodPocztowy;
    private String miasto;
    private String adresSkrytki;

    public SkrytkaEpuap() {
    }

    public SkrytkaEpuap(String nazwaPodmiotu, String regon, String adres, String kodPocztowy, String miasto, String adresSkrytki) {
        this.nazwaPodmiotu = nazwaPodmiotu;
        this.regon = regon;
        this.adres = adres;
        this.kodPocztowy = kodPocztowy;
        this.miasto = miasto;
        this.adresSkrytki = adresSkrytki;
    }

    public String getNazwaPodmiotu() {
        return nazwaPodmiotu;
    }

    public void setNazwaPodmiotu(String nazwaPodmiotu) {
        this.nazwaPodmiotu = nazwaPodmiotu;
    }

    public String getRegon() {
        return regon;
    }

    public void setRegon(String regon) {
        this.regon = regon;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
    }

    public String getKodPocztowy() {
        return kodPocztowy;
    }

    public void setKodPocztowy(String kodPocztowy) {
        this.kodPocztowy = kodPocztowy;
    }

    public String getMiasto() {
        return miasto;
    }

    public void setMiasto(String miasto) {
        this.miasto = miasto;
    }

    public String getAdresSkrytki() {
        return adresSkrytki;
    }

    public void setAdresSkrytki(String adresSkrytki) {
        this.adresSkrytki = adresSkrytki;
    }

    @Override
    public String toString() {
        return "SkrytkaEpuap{" +
                "nazwaPodmiotu='" + nazwaPodmiotu + '\'' +
                ", regon='" + regon + '\'' +
                ", adres='" + adres + '\'' +
                ", kodPocztowy='" + kodPocztowy + '\'' +
                ", miasto='" + miasto + '\'' +
                ", adresSkrytki='" + adresSkrytki + '\'' +
                '}';
    }
}
