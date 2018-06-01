package com.keonsinkryte.ecosistemas.free;

public class Sal {
    private String valHum, valTemp, valMov, valMic, valLuz;
    private String id;

    public Sal() {}

    public Sal(String valHum, String valTemp, String valMov, String valMic, String valLuz, String id) {
        this.valHum = valHum;
        this.valTemp = valTemp;
        this.valMov = valMov;
        this.valMic = valMic;
        this.valLuz = valLuz;
        this.id = id;
    }

    public String getValHum() {
        return valHum;
    }

    public void setValHum(String valHum) {
        this.valHum = valHum;
    }

    public String getValTemp() {
        return valTemp;
    }

    public void setValTemp(String valTemp) {
        this.valTemp = valTemp;
    }

    public String getValMov() {
        return valMov;
    }

    public void setValMov(String valMov) {
        this.valMov = valMov;
    }

    public String getValMic() {
        return valMic;
    }

    public void setValMic(String valMic) {
        this.valMic = valMic;
    }

    public String getValLuz() {
        return valLuz;
    }

    public void setValLuz(String valLuz) {
        this.valLuz = valLuz;
    }

}
