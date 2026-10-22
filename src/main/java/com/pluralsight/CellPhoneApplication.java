package com.pluralsight;

import java.util.*;

public class CellPhoneApplication {

    static Scanner scanner = new Scanner(System.in);

    static String[] questionList={"What is the serial number?", "What model is the phone?",
            "Who is the carrier?", "What is the phone number?", "Who is the owner of the phone?"};
    static String[] phoneStatList={"serial number", "phone model", "carrier", "phone number", "phone holder"};

    static List<CellPhone> cellPhoneList=new ArrayList<>();

    public static void main(String[] args) {
        setAllPhoneStats(1001010, "iPhone 15 Pro Max",
                "Verizon", "(555) 123-4567", "unKnown");
        startMenu();
    }

    public static void startMenu(){
        print("""
                
                *==== Main Phone Menu ====*
                
                enter (S)earch to get users cellphone data.
                enter (E)nd to end program.
                enter (A)dd to add new cellphone data.
                enter (D)ial to call a registered phone number
                
                Please enter your response here->:""" + " ");

        String stringInput = scanner.nextLine().toLowerCase();

        switch (stringInput) {
            case ("s"), ("search") -> searchPhoneMenu();
            case ("e"), ("end") -> print("program has ended");
            case ("a"), ("add") -> addPhoneMenu();
            case ("d"), ("dial") -> {}
            default -> {
                print(String.format("Please enter a valid Input %n"));
                startMenu();
            }
        }
    }

    private static void dialPhoneMenu(){

    }

    public static void searchPhoneMenu(){
        print("""
                
                *==== Search Phone Menu ====*
                
                enter (SN) to search for serial number.
                enter (MD) to search for phone model.
                enter (CR) to search for carrier.
                enter (PN) to search for phone number.
                enter (ON) to search for name of phone holder.
                enter (R)eturn to return to main menu.
                
                Please enter your response here->:"""+" ");

        String stringInput = scanner.nextLine().toLowerCase();

        switch (stringInput){
            case ("r"), ("return") -> startMenu();
            case ("sn"), ("serial number") -> phoneSearcher(0);
            case ("md"), ("phone model") -> phoneSearcher(1);
            case ("cr"), ("carrier") -> phoneSearcher(2);
            case ("pn"), ("phone number") -> phoneSearcher(3);
            case ("on"), ("phone holder") -> phoneSearcher(4);
            default -> {
                print(String.format("Please enter a valid Input %n"));
                searchPhoneMenu();
            }
        }
    }

    public static void phoneSearcher(int statKey){
        print("please enter " + phoneStatList[statKey] + " here ->: ");

        boolean foundPhone = false;
        String enteredPhoneStat = scanner.nextLine().trim();
        int forloopindex=0;

        for (CellPhone cellPhone: cellPhoneList){
            if (cellPhone.getSinglePhoneStat(statKey).equals(enteredPhoneStat)){
                print(String.format("""
                
                *==== Found %ss Phone ====*
                
                """,cellPhone.getSinglePhoneStat(forloopindex)));
                printPhoneStats(forloopindex);
                foundPhone=true;
                break;
            }
            forloopindex++;
        }
        if (!foundPhone){
            print(" *==== Phone Not Found ====* ");
        }
        searcherRequestMenu();
    }

    public static void searcherRequestMenu(){
        print("""
                
                *==== Phone Searcher Menu ====*
                
                enter (S)earch to search for another cellphone.
                enter (E)nd to end program.
                enter (R)eturn to return to main menu.
                
                Please enter your response here->:"""+" ");

        String stringInput = scanner.nextLine().toLowerCase();

        switch (stringInput) {
            case ("s"), ("search") -> searchPhoneMenu();
            case ("e"), ("end") -> print("program has ended");
            case ("r"), ("add") -> startMenu();
            default -> {
                print(String.format("Please enter a valid Input %n"));
                searcherRequestMenu();
            }
        }
    }

    public static void addPhoneMenu(){
        boolean hasCansel = false;
        CellPhone cellPhone = new CellPhone();
        print("""
                
                *==== Add Phone Menu ====*
                
                enter (C)ancel to cancel and return to Main Menu.
                """);

        for (int i = 0; i <= 4; i++) {
            print(questionList[i] + String.format("%n | enter here ->: "));
            String answerInput = scanner.nextLine();
            String answerCheckString = answerInput.toLowerCase();

            if (answerCheckString.equals("c") || answerCheckString.equals("cancel")){
                hasCansel = true;
                break;
            } else {cellPhone.setSinglePhoneStat(i, answerInput);}
        }
        if (!hasCansel) {
            cellPhoneList.add(cellPhone);
            printPhoneStats(cellPhoneList.size() - 1);
            startMenu();
        } else {startMenu();}
    }

    public static void print(String printString){
        System.out.print(printString);
    }

    public static void printPhoneStats(int cellPhoneIndex){
        for (int i = 0; i <= 4; i++) {
            print(questionList[i] + " " + cellPhoneList.get(cellPhoneIndex).getSinglePhoneStat(i) + String.format("%n"));
        }
    }

    public static void setAllPhoneStats(int SN, String md, String CR, String PN, String ON){
        CellPhone cellPhone = new CellPhone();
        cellPhone.setAllPhoneStats(SN, md, CR ,PN, ON);
        cellPhoneList.add(cellPhone);
        printPhoneStats(cellPhoneList.size() - 1);
    }
}
