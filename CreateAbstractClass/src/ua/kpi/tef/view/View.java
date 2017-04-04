package ua.kpi.tef.view;

import ua.kpi.tef.*;
import ua.kpi.tef.controller.Utilities;

import javax.rmi.CORBA.Util;
import java.io.UnsupportedEncodingException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.Locale;

/**
 * Created by Димон on 20.03.2017.
 */
public class View {

    public static final String NAME_OF_BUNDLE_MESSAGES = "messages";
    //Resource bundle
    ResourceBundle bundle = ResourceBundle.getBundle(NAME_OF_BUNDLE_MESSAGES, new Locale("EN", "US"));

    public void setBundle(Locale locale){
        bundle = ResourceBundle.getBundle(NAME_OF_BUNDLE_MESSAGES, locale);
    }


    //Text constants
    public static final String WRONG_INPUT = "wrong.input";
    public static final String WRONG_INPUT_ONLY_NUMBERS =  "wrong.input.only.numbers";
    public static final String WRONG_INPUT_ONLY_LETTERS = "wrong.input.only.letters";
    public static final String WRONG_INPUT_DATE = "wrong.input.date";
    public static final String WRONG_INPUT_MOBILE_PHONE_NUMBER = "wrong.input.mobile.phone.number";
    public static final String WRONG_INPUT_NOT_MONEY_FORMAT = "wrong.input.not.money.format";

    public static final String INPUT = "input";
    public static final String SСHEDULE_DATE = "schedule.date";
    public static final String SСHEDULE_MOBILE_PHONE_NUMBER = "schedule.mobile.phone.number";

    public static final String INPUT_NAME = "input.product.name";
    public static final String INPUT_FABRICATOR = "input.fabricator";
    public static final String INPUT_AMOUNT = "input.amount";
    public static final String INPUT_DATE_MANUFACTURE = "input.date.manufacture";
    public static final String INPUT_DATE_EXPIRATION = "input.date.expiration";
    public static final String INPUT_PROVIDER = "input.provider";
    public static final String INPUT_NUMBER_PROVIDER = "input.number.provider";
    public static final String INPUT_NUMBER_FABRICATOR = "input.number.fabricator";
    public static final String INPUT_PRICE = "input.price";
    public static final String INPUT_SCREEN_DIAGONAL = "input.screen.diagonal";
    public static final String INPUT_OPERATING_SYSTEM = "input.operating.system";

    public void printMessage(String message){
        try {
            System.out.println(
                    Utilities.convertFrom866To1251(bundle.getString(message)));
        }catch(UnsupportedEncodingException e){
            System.out.println("Error convert");
        }
    }

    public void printWrongMessage(String message){
            try {
                System.out.println(
                        Utilities.convertFrom866To1251(bundle.getString(WRONG_INPUT)) +
                                Utilities.convertFrom866To1251(bundle.getString(message)));
            }catch(UnsupportedEncodingException e){
                System.out.println("Error convert");
            }

    }
    public void printInputMessage(String message){
            try {
                System.out.print(Utilities.convertFrom866To1251(bundle.getString(INPUT)) +
                        Utilities.convertFrom866To1251(bundle.getString(message)));
            }catch(UnsupportedEncodingException e){
                System.out.println("Error convert");
            }


    }
}
