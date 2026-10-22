package com.pluralsight;

import java.util.*;

public class CellPhoneApplication {

    static Scanner scanner = new Scanner(System.in);

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
                
                *==== Main Phone Menu ====*
                
                enter (S)earch to get users cellphone data
                enter (E)nd to end program
                enter (A)dd to add new cellphone data
                
                Please enter your response here->:"""+" ");
        String stringInput=scanner.nextLine().toLowerCase();
        switch (stringInput){
            case ("s"),("search")->{searchPhoneMenu();}
            case ("end"), ("e") -> {print("program has ended");}
            case ("a"),("add") -> {}
            default -> {
                print(String.format("Please enter a valid Input %n"));
                startMenu();
            }
        }
    }

    public static void searchPhoneMenu(){
        print("""
                
                *==== Search Phone Menu ====*
                
                enter (SN) to search for serial number
                enter (MD) to search for phone model
                enter (CR) to search for carrier
                enter (PN) to search for phone number
                enter (ON) to search for name of phone holder
                enter (R)eturn to return to main menu
                
                Please enter your response here->:"""+" ");
        String stringInput=scanner.nextLine().toLowerCase();
        switch (stringInput){
            case ("r"), ("return") -> {startMenu();}
            case ("sn") -> {}
            case ("md") -> {}
            case ("cr") -> {}
            case ("pn") -> {}
            case ("on") -> {}
            default -> {
                print(String.format("Please enter a valid Input %n"));
                searchPhoneMenu();
            }
        }
    }

    public static void addPhoneMenu(){

    }

    public static void print(String printString){
        System.out.print(printString);
    }
    public static void printPhoneStats(int cellPhoneIndex){
        for (int i = 0; i <= 4; i++) {
            print(questionList[i]+" "+cellPhoneList.get(cellPhoneIndex).getSinglePhoneStat(i)+String.format("%n"));
        }
    }
    public static void setAllPhoneStats(int SN, String md, String CR, String PN, String ON){
        CellPhone cellPhone = new CellPhone();
        cellPhone.setAllPhoneStats(SN, md, CR ,PN, ON);
        cellPhoneList.add(cellPhone);
        printPhoneStats(cellPhoneList.size()-1);
    }
}
