package com.grupa251.tema;

public class User {
    private String Nume;
    private String Prenume;
    private long ID;
    private String Parola;
    private UserType tip;

    public User() {
        Nume = "";
        Prenume = "";
        Parola = "";
    }

    public User(String nume, String prenume, long ID, String parola, UserType tip) {
        Nume = nume;
        Prenume = prenume;
        this.ID = ID;
        Parola = parola;
        this.tip = tip;
    }

    public String getNume() {
        return Nume;
    }

    public String getPrenume() {
        return Prenume;
    }

    public long getID() {
        return ID;
    }

    public String getParola() {
        return Parola;
    }

    public UserType getTip() {
        return tip;
    }

    public void setNume(String nume) {
        Nume = nume;
    }

    public void setPrenume(String prenume) {
        Prenume = prenume;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public void setParola(String parola) {
        Parola = parola;
    }

    public void setTip(UserType tip) {
        this.tip = tip;
    }

    @Override
    public String toString() {
        return Nume + " " + Prenume + " " + ID
                + " " + Parola + " " + tip;
    }
}
