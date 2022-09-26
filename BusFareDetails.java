package com.testexamples.busfaredetails;

public class BusFareDetails {
 private int busId;
 private String busName;
 private int kiloMeters;

    public BusFareDetails(int busId, String busName, int kiloMeters) {
        this.busId = busId;
        this.busName = busName;
        this.kiloMeters = kiloMeters;
    }

    public int getBusId() {
        return busId;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public int getKiloMeters() {
        return kiloMeters;
    }

    public void setKiloMeters(int kiloMeters) {
        this.kiloMeters = kiloMeters;
    }

    public void setBusId(int busId) {
        this.busId = busId;
    }
}
