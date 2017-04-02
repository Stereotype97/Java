package ua.kpi.tef.model.entity;

/**
 * Created by Dima Skorobogatskii on 13.03.2017.
 */

public class Notebook {
    private String surname;
    private String name;
    private String patronymic;
    private String nickname;
    private String description;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String mobilePhoneAlternative;
    private String eMail;
    private String skypeLogin;
    private Address address;
    private String dateOfFirstRecord;
    private String dateOfLastChange;
    private String birthday;

    public Notebook(){
        address = new Address();
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setGroup(String group) {
        this.group = group;
    }
    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }
    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }
    public void setMobilePhoneAlternative(String mobilePhoneAlternative) {
        this.mobilePhoneAlternative = mobilePhoneAlternative;
    }
    public void setEmail(String eMail) {
        this.eMail = eMail;
    }
    public void setSkypeLogin(String skypeLogin) {
        this.skypeLogin = skypeLogin;
    }
    public void setAddress(Address address) {
        this.address = address;
    }
    public void setDateOfFirstRecord(String dateOfFirstRecord) {
        this.dateOfFirstRecord = dateOfFirstRecord;
    }
    public void setDateOfLastChange(String dateOfLastChange) {
        this.dateOfLastChange = dateOfLastChange;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSurname() {
        return surname;
    }

    public String getDescription() {
        return description;
    }

    public Address getAddress(){
        return address;
    }
}
