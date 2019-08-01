package pl.gdansk.gci;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class SkrytkaEpuap {

    private String nazwaPodmiotu;
    private String regon;
    private String adres;
    private String kodPocztowy;
    private String miasto;
    private String adresSkrytki;
    private List<String> listOfSkrytkiEpuap = new ArrayList<>();

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

    public List<String> getListOfSkrytkiEpuap() {
        return listOfSkrytkiEpuap;
    }

    public void setListOfSkrytkiEpuap(BufferedInputStream in) {
        Stream<String> lines = new BufferedReader(new InputStreamReader(in)).lines();

        lines
                .distinct()
               //.limit(100)
                .map(this::clearLine)
                .filter(str -> !str.equals("NAZWA,REGON,ADRES,KOD_POCZTOWY,MIEJSCOWOSC,URI"))
                .forEach(listOfSkrytkiEpuap::add);
    }


    private String clearLine(String str) {

        String result = str.replace("\"", "").trim();
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SkrytkaEpuap that = (SkrytkaEpuap) o;
        return Objects.equals(nazwaPodmiotu, that.nazwaPodmiotu) &&
                Objects.equals(regon, that.regon) &&
                Objects.equals(adres, that.adres) &&
                Objects.equals(kodPocztowy, that.kodPocztowy) &&
                Objects.equals(miasto, that.miasto) &&
                Objects.equals(adresSkrytki, that.adresSkrytki);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nazwaPodmiotu, regon, adres, kodPocztowy, miasto, adresSkrytki);
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
