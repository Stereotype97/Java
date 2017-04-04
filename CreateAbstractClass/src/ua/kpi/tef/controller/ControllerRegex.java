package ua.kpi.tef.controller;

/**
 * Created by Димон on 01.04.2017.
 */
public interface ControllerRegex {
    String REGEX_ONLY_NUMBERS = "[0-9]+";
    String REGEX_ONLY_LETTERS = "[A-ZА-Я][a-zа-я]+";
    String REGEX_MOBILE_PHONE = "\\+\\d{2}\\(\\d{3}\\)\\d{3}-\\d{2}-\\d{2}";
    String REGEX_DATE = "\\d{1,2}\\.\\d{1,2}\\.?\\d{0,4}";
    String REGEX_MONEY_FORMAT = "[0-9]+[.,]?[0-9]{0,2}";
}
