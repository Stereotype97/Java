package ua.kpi.tef;


import ua.kpi.tef.model.entity.Model;
import ua.kpi.tef.model.entity.Notebook;

import java.util.Scanner;
import java.util.regex.*;

//add package / model / entity
//logic in model, controller only
/**
 * Created by Dima Skorobogatskii on 13.03.2017.
 */
public class Controller {

    //Constants
    public static final String REGEX_NUMBERS_AND_LETTERS = "[A-Za-z0-9_]+";
    public static final String REGEX_ONLY_NUMBERS = "[0-9]+";
    public static final String REGEX_ONLY_LETTERS = "[A-ZА-Я][a-zа-я]+";
    public static final String REGEX_HOME_PHONE = ".?\\d{0,2}-?\\d{1,5}-\\d{4,8}";
    public static final String REGEX_MOBILE_PHONE = "\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";
    public static final String REGEX_MAIL =
            "([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}";
    public static final String REGEX_INDEX = "[A-Za-z]?-?\\d{3,6}";
    public static final String REGEX_DATE = "\\d{1,2}\\.\\d{1,2}\\.?\\d{0,4}";

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
            view.printMessage(wrongInput);
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
    private String checkByMixedPattern(){
        return checkBySpecifiedRegex(REGEX_NUMBERS_AND_LETTERS, view.WRONG_INPUT_ONLY_ENGLISH_AND_NUMBER);
    }
    private String readStringLineWithoutChecking() {
            return scanner.nextLine();
    }
    private String checkByRegexOnMobilePhone(){
        return checkBySpecifiedRegex(REGEX_MOBILE_PHONE, view.WRONG_INPUT_MOBILE_PHONE_NUMBER);
    }
    private String checkByRegexOnHomePhone(){
        return checkBySpecifiedRegex(REGEX_HOME_PHONE, view.WRONG_INPUT_MOBILE_PHONE_NUMBER);
    }
    private String checkByRegexOnEmail(){
        return checkBySpecifiedRegex(REGEX_MAIL, view.WRONG_INPUT_EMAIL);
    }
    private String checkByRegexOnDate(){
        return checkBySpecifiedRegex(REGEX_DATE, view.WRONG_INPUT_DATE);
    }

    private void processSurname(){
        view.printMessage(view.INPUT + "фамилию: ");
        notebook.setSurname(checkByLettersPattern());
    }
    private void processName(){
        view.printMessage(view.INPUT + "имя: ");
        notebook.setName(checkByLettersPattern());
    }
    private void processPatronymic(){
        view.printMessage(view.INPUT + "отчество: ");
        notebook.setPatronymic(checkByLettersPattern());
    }
    private void processNickname(){
        view.printMessage(view.INPUT + "никнейм: ");
        notebook.setNickname(checkByMixedPattern());
    }
    private void processDescription(){
        view.printMessage(view.INPUT + "свои комментарии: ");
        notebook.setDescription(readStringLineWithoutChecking());
        view.printMessage(notebook.getDescription());
    }
    private void processGroup(){
        view.printMessage(view.INPUT + "группу(категорию людей): ");
        notebook.setGroup(checkByLettersPattern());
    }
    private void processHomePhone(){
        view.printMessage(view.INPUT + "домашний телефон. " + view.EXAMPLE_HOME_PHONE);
        notebook.setHomePhone(checkByRegexOnHomePhone());
    }
    private void processMobilePhone(){
        view.printMessage(view.INPUT + "номер мобильного телефона. " + view.SСHEDULE_MOBILE_PHONE_NUMBER);
        notebook.setMobilePhone(checkByRegexOnMobilePhone());
    }
    private void processEmail(){
        view.printMessage(view.INPUT + "эл. почту: ");
        notebook.setEmail(checkByRegexOnEmail());
    }
    private void processSkypeLogin(){
        view.printMessage(view.INPUT + "логин в Skype: ");
        notebook.setSkypeLogin(checkByMixedPattern());
    }

    private String addrProcessIndex(){
        return checkBySpecifiedRegex(REGEX_INDEX, view.WRONG_INPUT_INDEX);
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
        view.printMessage(view.INPUT + "полный адрес:\n");
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
        view.printMessage(view.INPUT + "дату создания записи. " + view.SСHEDULE_DATE);
        notebook.setDateOfFirstRecord(checkByRegexOnDate());
    }
    private void processBirthday(){
        view.printMessage(view.INPUT + "дату рождения. " + view.SСHEDULE_DATE);
        notebook.setBirthday(checkByRegexOnDate());
    }

}
