package ua.kpi.tef.model.entity.inheritors;

import ua.kpi.tef.model.entity.Product;

/**
 * Created by Димон on 27.03.2017.
 */
public class MilkProduct extends Product {

    TypeOfMilkProduct typeOfMilkProduct;

    //Constructors
    public MilkProduct(){
        super();
        typeOfMilkProduct = TypeOfMilkProduct.MILK;
    }

    public MilkProduct(String name, String fabricator, int amount,
                       String dateOfManufacture, String dateOfExpiration, String provider,
                       String numberOfProvider, String numberOfFabricator,  float price,
                       TypeOfMilkProduct typeOfMilkProduct){

        super(name, fabricator, amount, dateOfManufacture, dateOfExpiration,
                provider, numberOfProvider, numberOfFabricator, price);
        this.typeOfMilkProduct = typeOfMilkProduct;
    }


    //Overload functions
    /**Overload function clone()*/
    @Override
    public MilkProduct clone(){
            return (MilkProduct) super.clone();
    }

    /**Overload function equals()*/
    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() == object.getClass()) {

            MilkProduct product = (MilkProduct) object;
            return this.name == product.name && this.fabricator == product.fabricator
                    && this.amount == product.amount && this.dateOfManufacture == product.dateOfManufacture
                    && this.dateOfExpiration == product.dateOfExpiration && this.provider == product.provider
                    && this.numberOfProvider == product.numberOfProvider && this.numberOfFabricator == product.numberOfFabricator
                    && this.typeOfMilkProduct == product.typeOfMilkProduct;
        }
        else
            return false;
    }

    /**Overload function hashCode()*/
    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 13 * result + fabricator.hashCode();
        result = 23 * result + amount;
        result = 31 * result + dateOfManufacture.hashCode();
        result = 37 * result + dateOfExpiration.hashCode();
        result = 31 * result + provider.hashCode();
        result = 23 * result + numberOfProvider.hashCode();
        result = 13 * result + numberOfFabricator.hashCode();
        result = 11 * result + (int)price;
        result = 7 * result + typeOfMilkProduct.hashCode();
        return result;
    }

    /**Overload function toString()*/
    @Override
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
                "\ttypeOfMilkProduct: " + typeOfMilkProduct + '\n' +
                '}';
    }

}
