package com.pluralsight;

import java.util.*;

public class CellPhoneApplication {
    static CellPhone cellPhone = new CellPhone();
    static String[] questionList={"What is the serial number?","What model is the phone?",
            "Who is the carrier?", "What is the phone number?", "Who is the owner of the phone?"};
    static List<CellPhone> cellPhoneList=new ArrayList<>();

    public static void main(String[] args) {
        cellPhone.setAllPhoneStats(1000010,"iPhone 15 Pro Max",
                "Verizon","(555) 123-4567","unKnown");
        printPhoneStats();
    }
    public static void print(String printString){
        System.out.print(printString);
    }
    public static void printPhoneStats(){
        for (int i = 0; i <= 4; i++) {
            print(questionList[i]+" "+cellPhone.getSinglePhoneStat(i)+String.format("%n"));
        }
    }
}
