package ua.kpi.tef.controller;

import ua.kpi.tef.model.entity.*;
import ua.kpi.tef.model.entity.inheritors.Laptop;
import ua.kpi.tef.view.View;

import java.util.Locale;
import java.util.regex.*;
import java.util.Scanner;


public class Controller implements ControllerRegex{

    Model model;
    View view;

    Laptop laptop = new Laptop();

    Pattern pattern;
    Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
    }

    public void processUserRecord(){

        processLocale();

        processName();
        processFabricator();
        processAmount();
        processDateOfManufacture();
        processDateOfExpiration();
        processProvider();
        processNumberOfProvider();
        processNumberOfFabricator();
        processPrice();
        processScreenDiagonal();
        processOperatingSystem();

        model.setLaptop(laptop.clone());
    }


    private void processLocale(){
        System.out.println("Choose locale: en - 1  ru - 2");
        int choice = Integer.parseInt(checkByNumbersPattern());
        while( choice < 1 || choice  > 2) {
            view.printWrongMessage(view.WRONG_INPUT_ONLY_NUMBERS +
                    "Only 1 or 2");
            choice = Integer.parseInt(checkByNumbersPattern());
        }
        if (choice == 2) view.setBundle(new Locale("RU", "RU"));
        else view.setBundle(new Locale("EN", "US"));

    }

    /**This function check data getting from console while not get correctly string and return it*/
    private String checkBySpecifiedRegex(String patternString, String wrongInput){
        pattern = Pattern.compile(patternString);
        while(!scanner.hasNext(pattern)){
            view.printWrongMessage(wrongInput);
            scanner.next();
        }
        return scanner.next();
    }

    private String checkByNumbersPattern(){
        return checkBySpecifiedRegex(REGEX_ONLY_NUMBERS, view.WRONG_INPUT_ONLY_NUMBERS);
    }
    private String checkByLettersPattern(){
        return checkBySpecifiedRegex(REGEX_ONLY_LETTERS, view.WRONG_INPUT_ONLY_LETTERS);
    }
    private String checkByRegexOnMobilePhone(){
        return checkBySpecifiedRegex(REGEX_MOBILE_PHONE, view.WRONG_INPUT_MOBILE_PHONE_NUMBER);
    }
    private String checkByRegexOnDate(){
        return checkBySpecifiedRegex(REGEX_DATE, view.WRONG_INPUT_DATE);
    }
    private String checkByRegexOnMoneyFormat(){
        return checkBySpecifiedRegex(REGEX_MONEY_FORMAT, view.WRONG_INPUT_NOT_MONEY_FORMAT);
    }

    private void processName(){
        view.printInputMessage(view.INPUT_NAME);
        laptop.setName(checkByLettersPattern());
    }
    private void processFabricator(){
        view.printInputMessage(view.INPUT_FABRICATOR);
        laptop.setFabricator(checkByLettersPattern());
    }
    private void processAmount(){
        view.printInputMessage(view.INPUT_AMOUNT);
        laptop.setAmount(Integer.parseInt(checkByNumbersPattern()));
    }
    private void processDateOfManufacture(){
        view.printInputMessage(view.INPUT_DATE_MANUFACTURE);
        view.printMessage(view.SСHEDULE_DATE);
        laptop.setDateOfManufacture(checkByRegexOnDate());
    }
    private void processDateOfExpiration(){
        view.printInputMessage(view.INPUT_DATE_EXPIRATION);
        view.printMessage(view.SСHEDULE_DATE);
        laptop.setDateOfExpiration(checkByRegexOnDate());
    }
    private void processProvider(){
        view.printInputMessage(view.INPUT_PROVIDER);
        laptop.setProvider(checkByLettersPattern());

    }
    private void processNumberOfProvider(){
        view.printInputMessage(view.INPUT_NUMBER_PROVIDER);
        view.printMessage(view.SСHEDULE_MOBILE_PHONE_NUMBER);
        laptop.setNumberOfProvider(checkByRegexOnMobilePhone());
    }
    private void processNumberOfFabricator(){
        view.printInputMessage(view.INPUT_NUMBER_FABRICATOR);
        view.printMessage(view.SСHEDULE_MOBILE_PHONE_NUMBER);
        laptop.setNumberOfFabricator(checkByRegexOnMobilePhone());
    }
    private void processPrice(){
        view.printInputMessage(view.INPUT_PRICE);
        laptop.setPrice(Float.parseFloat(checkByRegexOnMoneyFormat()));
    }
    private void processScreenDiagonal() {
        view.printInputMessage(view.INPUT_SCREEN_DIAGONAL);
        laptop.setScreenDiagonal(Float.parseFloat(checkByRegexOnMoneyFormat()));
    }
    private void processOperatingSystem() {
        view.printInputMessage(view.INPUT_OPERATING_SYSTEM);
        laptop.setOperatingSystem(checkByLettersPattern());
    }

}
