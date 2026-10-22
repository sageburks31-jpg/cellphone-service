package com.pluralsight;

public class CellPhone {
    private int serialNumber = 1000000;
    private String model = "";

    private String carrier = "";
    private String phoneNumber = "";
    private String owner = "";

    public void setAllPhoneStats(int SN, String MD, String CR, String PN, String ON){
        this.serialNumber=SN;
        this.model=MD;
        this.carrier=CR;
        this.phoneNumber=PN;
        this.owner=ON;
    }

    public void setSinglePhoneStat(int statKey, String setValue){
        switch (statKey) {
            case (0):
                this.serialNumber = Integer.parseInt(setValue);
                break;
            case (1):
                this.model = setValue;
                break;
            case (2):
                this.carrier = setValue;
                break;
            case (3):
                this.phoneNumber = setValue;
                break;
            case (4):
                this.owner = setValue;
                break;
        }
    }

    public String getSinglePhoneStat(int statKey){
        return switch (statKey) {
            case (0) -> "" + this.serialNumber;
            case (1) -> this.model;
            case (2) -> this.carrier;
            case (3) -> this.phoneNumber;
            case (4) -> this.owner;
            default -> "";
        };
    }

}
