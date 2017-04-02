package ua.kpi.tef.controller;

/**
 * Created by Димон on 02.04.2017.
 */
public interface ControllerRegex {

    String REGEX_NUMBERS_AND_LETTERS = "[A-Za-z0-9_]+";
    String REGEX_ONLY_NUMBERS = "[0-9]+";
    String REGEX_ONLY_LETTERS = "[A-ZА-Я][a-zа-я]+";
    String REGEX_HOME_PHONE = ".?\\d{0,2}-?\\d{1,5}-\\d{4,8}";
    String REGEX_MOBILE_PHONE = "\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";
    String REGEX_MAIL =
            "([a-z0-9_-]+\\.)*[a-z0-9_-]+@[a-z0-9_-]+(\\.[a-z0-9_-]+)*\\.[a-z]{2,6}";
    String REGEX_INDEX = "[A-Za-z]?-?\\d{3,6}";
    String REGEX_DATE = "\\d{1,2}\\.\\d{1,2}\\.?\\d{0,4}";

}
