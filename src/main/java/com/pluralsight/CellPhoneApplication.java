package com.pluralsight;

import java.util.*;

public class CellPhoneApplication {
    static Scanner scanner =new Scanner(System.in);
    static String[] questionList={"What is the serial number?","What model is the phone?",
            "Who is the carrier?", "What is the phone number?", "Who is the owner of the phone?"};
    static List<CellPhone> cellPhoneList=new ArrayList<>();

    public static void main(String[] args) {
        setAllPhoneStats(1001010, "iPhone 15 Pro Max",
                "Verizon","(555) 123-4567","unKnown");
        startMenu();
    }

    public static void startMenu(){
        print("""
                enter (S)earch to get users cellphone data
                enter (E)nd to end program
                enter (A)dd to add new cellphone data
                """+String.format("%n"));
        print("Please enter your response here->: "+scanner.nextLine());
    }

    public static void print(String printString){
        System.out.print(printString);
    }
    public static void printPhoneStats(int cellPhoneIndex){
        for (int i = 0; i <= 4; i++) {
            print(questionList[i]+" "+cellPhoneList.get(cellPhoneIndex).getSinglePhoneStat(i)+String.format("%n"));
        }
    }
    public static void setAllPhoneStats(int SN, String md, String carr, String PN, String ON){
        CellPhone cellPhone = new CellPhone();
        cellPhone.setAllPhoneStats(SN, md, carr ,PN, ON);
        cellPhoneList.add(cellPhone);
        printPhoneStats(cellPhoneList.size()-1);
    }
}
