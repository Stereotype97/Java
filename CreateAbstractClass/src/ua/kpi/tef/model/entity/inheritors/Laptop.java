package ua.kpi.tef.model.entity.inheritors;

import ua.kpi.tef.model.entity.Product;

/**
 * Created by Димон on 27.03.2017.
 */
    public class Laptop extends Product implements Screen{

    protected float screenDiagonal;
    protected String operatingSystem;

    public void setScreenDiagonal(float screenDiagonal) {
        this.screenDiagonal = screenDiagonal;
    }
    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;}

    public float getScreenDiagonal() {

        return screenDiagonal;
    }
    public String getOperatingSystem() {
        return operatingSystem;
    }

    //Constructors
    public Laptop(){
        super();
        screenDiagonal = SIZE_15_6;
        operatingSystem = "Windows";
    }

    public Laptop(String name, String fabricator, int amount,
                       String dateOfManufacture, String dateOfExpiration, String provider,
                       String numberOfProvider, String numberOfFabricator,  float price,
                       float screenDiagonal, String operatingSystem) {

        super(name, fabricator, amount, dateOfManufacture, dateOfExpiration,
                provider, numberOfProvider, numberOfFabricator, price);

        this.screenDiagonal = screenDiagonal;
        this.operatingSystem = operatingSystem;
    }


    //Overload functions
    /**Overload function clone()*/
    public Laptop clone(){
        return (Laptop) super.clone();
    }

    /**Overload function equals()*/
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() == object.getClass()) {

            Laptop laptop = (Laptop)object;
            return this.name == laptop.name && this.fabricator == laptop.fabricator
                    && this.amount == laptop.amount && this.dateOfManufacture == laptop.dateOfManufacture
                    && this.dateOfExpiration == laptop.dateOfExpiration && this.provider == laptop.provider
                    && this.numberOfProvider == laptop.numberOfProvider && this.numberOfFabricator == laptop.numberOfFabricator
                    && this.screenDiagonal == laptop.screenDiagonal && this.operatingSystem == laptop.operatingSystem;
        }
        else
            return false;
    }

    /**Overload function hashCode()*/
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + fabricator.hashCode();
        result = 31 * result + amount;
        result = 31 * result + dateOfManufacture.hashCode();
        result = 31 * result + dateOfExpiration.hashCode();
        result = 31 * result + provider.hashCode();
        result = 31 * result + numberOfProvider.hashCode();
        result = 31 * result + numberOfFabricator.hashCode();
        result = 31 * result + (int)price;
        result = 31 * result + (int)screenDiagonal;
        result = 31 * result + operatingSystem.hashCode();
        return result;
    }

    /**Overload function toString()*/
    public String toString() {
        return getClass().getName() + "{\n" +
                "\tname: " + name + '\n' +
                "\tfabricator: " + fabricator + '\n' +
                "\tamount: " + amount + '\n' +
                "\tdateOfManufacture: " + dateOfManufacture + '\n' +
                "\tdateOfExpiration: " + dateOfExpiration + '\n' +
                "\tprovider: " + provider + '\n' +
                "\tnumberOfProvider: " + numberOfProvider + '\n' +
                "\tnumberOfFabricator: " + numberOfFabricator + '\n' +
                "\tprice: " + price + '\n' +
                "\tscreenDiagonal: " + screenDiagonal + '\n' +
                "\toperatingSystem: " + operatingSystem + '\n' +
                '}';
    }
}
