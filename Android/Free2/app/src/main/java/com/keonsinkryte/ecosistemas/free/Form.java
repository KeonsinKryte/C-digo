package com.keonsinkryte.ecosistemas.free;

public class Form {
    String horaIn, horaOut, soft, user;
    boolean comp, sillaOcupada;
    int numSilla;

    public Form (){}

    public Form (String horaIn, String horaOut, boolean comp, String soft, int numSilla, boolean sillaOcupada, String user){
        this.horaIn = horaIn;
        this.horaOut = horaOut;
        this.comp = comp;
        this.soft = soft;
        this.numSilla = numSilla;
        this.sillaOcupada = sillaOcupada;
        this.user = user;
    }

    public String getHoraIn() {
        return horaIn;
    }

    public void setHoraIn(String horaIn) {
        this.horaIn = horaIn;
    }

    public String getHoraOut() {
        return horaOut;
    }

    public void setHoraOut(String horaOut) {
        this.horaOut = horaOut;
    }

    public String getSoft() {
        return soft;
    }

    public void setSoft(String soft) {
        this.soft = soft;
    }

    public boolean isComp() {
        return comp;
    }

    public void setComp(boolean comp) {
        this.comp = comp;
    }

    public boolean isSillaOcupada() {
        return sillaOcupada;
    }
    public void setSillaOcupada(boolean sillaOcupada) {
        this.sillaOcupada = sillaOcupada;
    }

    public int getNumSilla() {
        return numSilla;
    }

    public void setNumSilla(int numSilla) {
        this.numSilla = numSilla;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
