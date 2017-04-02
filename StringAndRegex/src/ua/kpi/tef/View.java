package ua.kpi.tef;

/**
 * Created by Dima Skorobogatskii on 13.03.2017.
 */
public class View {
    public static final String WRONG_INPUT = "Некорректный ввод! ";
    public static final String WRONG_INPUT_ONLY_NUMBERS = "Должны быть только цифры!";
    public static final String WRONG_INPUT_ONLY_LETTERS = "Должны быть только буквы" +
                                                            " русского или английского алфавита!\n Возможно, первая буква должна быть большой?\n";
    public static final String WRONG_INPUT_ONLY_ENGLISH_AND_NUMBER = "Должны быть только буквы английского алфавита " +
                                                                        "и цифры";
    public static final String WRONG_INPUT_MOBILE_PHONE_NUMBER = "Введите номер телефона, как указано";
    public static final String WRONG_INPUT_EMAIL = "Почта не может так выглядеть";
    public static final String WRONG_INPUT_INDEX = "Может быть необязательный буквенный символ и -, и номер индекса";
    public static final String WRONG_INPUT_DATE = "Следуйте указаниям!";

    public static final String INPUT = "Введите ";
    public static final String EXAMPLE_HOME_PHONE = "Пример: +38-044-2367989 или 0512-423687";
    public static final String SСHEDULE_MOBILE_PHONE_NUMBER = "Шаблон: +38(050)123-45-67";
    public static final String SСHEDULE_DATE = "Шаблон: 12.9.2000";

    public void printMessage(String message){
        System.out.println(message);
    }
    public void printInputMessage(String message){
        System.out.print(INPUT + message);
    }
    public void printWrongMessage(String message){
        System.out.println(WRONG_INPUT + message);
    }
}
