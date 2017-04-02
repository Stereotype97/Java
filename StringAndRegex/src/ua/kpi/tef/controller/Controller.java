package ua.kpi.tef.controller;


import ua.kpi.tef.View;
import ua.kpi.tef.model.entity.Model;
import ua.kpi.tef.model.entity.Notebook;

import java.util.Scanner;
import java.util.regex.*;

/**
 * Created by Dima Skorobogatskii on 13.03.2017.
 */
public class Controller {

    Model model;
    View view;
    Notebook notebook = new Notebook();

    Pattern pattern;
    Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view){
        this.model = model;
        this.view = view;
        }

    public void processUserRecord(){
        processSurname();
        processName();
        processPatronymic();
        processNickname();
        processDescription();
        processGroup();
        processHomePhone();
        processMobilePhone();
        processEmail();
        processSkypeLogin();
        processAddress();
        processDateOfFirstRecord();
        processBirthday();

        model.setNotebook(notebook);
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
        return checkBySpecifiedRegex(ControllerRegex.REGEX_ONLY_NUMBERS, view.WRONG_INPUT_ONLY_NUMBERS);
    }
    private String checkByLettersPattern(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_ONLY_LETTERS, view.WRONG_INPUT_ONLY_LETTERS);
    }
    private String checkByMixedPattern(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_NUMBERS_AND_LETTERS, view.WRONG_INPUT_ONLY_ENGLISH_AND_NUMBER);
    }
    private String readStringLineWithoutChecking() {
            return scanner.nextLine();
    }
    private String checkByRegexOnMobilePhone(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_MOBILE_PHONE, view.WRONG_INPUT_MOBILE_PHONE_NUMBER);
    }
    private String checkByRegexOnHomePhone(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_HOME_PHONE, view.WRONG_INPUT_MOBILE_PHONE_NUMBER);
    }
    private String checkByRegexOnEmail(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_MAIL, view.WRONG_INPUT_EMAIL);
    }
    private String checkByRegexOnDate(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_DATE, view.WRONG_INPUT_DATE);
    }

    private void processSurname(){
        view.printInputMessage("фамилию: ");
        notebook.setSurname(checkByLettersPattern());
    }
    private void processName(){
        view.printInputMessage("имя: ");
        notebook.setName(checkByLettersPattern());
    }
    private void processPatronymic(){
        view.printInputMessage("отчество: ");
        notebook.setPatronymic(checkByLettersPattern());
    }
    private void processNickname(){
        view.printInputMessage("никнейм: ");
        notebook.setNickname(checkByMixedPattern());
    }
    private void processDescription(){
        view.printInputMessage("свои комментарии: ");
        notebook.setDescription(readStringLineWithoutChecking());
        view.printMessage(notebook.getDescription());
    }
    private void processGroup(){
        view.printInputMessage("группу(категорию людей): ");
        notebook.setGroup(checkByLettersPattern());
    }
    private void processHomePhone(){
        view.printInputMessage("домашний телефон. " + view.EXAMPLE_HOME_PHONE + '\n');
        notebook.setHomePhone(checkByRegexOnHomePhone());
    }
    private void processMobilePhone(){
        view.printInputMessage("номер мобильного телефона. " + view.SСHEDULE_MOBILE_PHONE_NUMBER + '\n');
        notebook.setMobilePhone(checkByRegexOnMobilePhone());
    }
    private void processEmail(){
        view.printInputMessage("эл. почту: ");
        notebook.setEmail(checkByRegexOnEmail());
    }
    private void processSkypeLogin(){
        view.printInputMessage("логин в Skype: ");
        notebook.setSkypeLogin(checkByMixedPattern());
    }

    private String addrProcessIndex(){
        return checkBySpecifiedRegex(ControllerRegex.REGEX_INDEX, view.WRONG_INPUT_INDEX);
    }
    private String addrProcessCity(){
        return checkByLettersPattern();
    }
    private String addrProcessStreet(){
        return checkByLettersPattern();
    }
    private String addrProcessHouseNumber(){
       return checkByNumbersPattern();
    }
    private String addrProcessFlatNumber(){
        return checkByNumbersPattern();
    }
    private void processAddress(){
        view.printInputMessage("полный адрес:\n");
        view.printMessage("- индекс: ");
        notebook.getAddress().setIndex(addrProcessIndex());
        view.printMessage("- город: ");
        notebook.getAddress().setCity(addrProcessCity());
        view.printMessage("- улица: ");
        notebook.getAddress().setStreet(addrProcessStreet());
        view.printMessage("- номер дома: ");
        notebook.getAddress().setHouseNumber(addrProcessHouseNumber());
        view.printMessage("- номер квартиры: ");
        notebook.getAddress().setFlatNumber(addrProcessFlatNumber());
    }

    private void processDateOfFirstRecord(){
        view.printInputMessage("дату создания записи. " + view.SСHEDULE_DATE);
        notebook.setDateOfFirstRecord(checkByRegexOnDate());
    }
    private void processBirthday(){
        view.printInputMessage("дату рождения. " + view.SСHEDULE_DATE);
        notebook.setBirthday(checkByRegexOnDate());
    }

}
