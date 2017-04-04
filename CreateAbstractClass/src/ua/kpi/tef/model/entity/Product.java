package ua.kpi.tef.model.entity;

/**
 * Created by Димон on 20.03.2017.
 */
public abstract class Product implements Cloneable{
    protected String name;
    protected String fabricator;
    protected int amount;
    protected String dateOfManufacture;
    protected String dateOfExpiration;
    protected String provider;
    protected String numberOfProvider;
    protected String numberOfFabricator;
    protected float price;


    public Product(){
        name = "No";
        fabricator = "No";
        amount = 0;
        dateOfManufacture = "No";
        dateOfExpiration = "No";
        provider = "No";
        numberOfProvider = "No";
        numberOfFabricator = "No";
        price = 0F;
    }

    public Product(String name, String fabricator, int amount,
                   String dateOfManufacture, String dateOfExpiration, String provider,
                   String numberOfProvider, String numberOfFabricator,  float price){
        this.name = name;
        this.fabricator = fabricator;
        this.amount = amount;
        this.dateOfManufacture = dateOfManufacture;
        this.dateOfExpiration = dateOfExpiration;
        this.provider = provider;
        this.numberOfProvider = numberOfProvider;
        this.numberOfFabricator = numberOfFabricator;
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setFabricator(String fabricator) {
        this.fabricator = fabricator;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }
    public void setDateOfExpiration(String dateOfExpiration) {
        this.dateOfExpiration = dateOfExpiration;
    }
    public void setProvider(String provider) {
        this.provider = provider;
    }
    public void setNumberOfProvider(String numberOfProvider) {
        this.numberOfProvider = numberOfProvider;
    }
    public void setNumberOfFabricator(String numberOfFabricator) {
        this.numberOfFabricator = numberOfFabricator;
    }
    public void setPrice(float price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    @Override
    public Product clone(){
        try{
            return (Product) super.clone();
        } catch (CloneNotSupportedException e){
            throw new AssertionError("Cloning did not happen!");
        }
    }

    @Override
    public boolean equals(Object object){
        if (this == object) return true;
        if (object == null) return false;
        if (getClass() == object.getClass()) {

            Product product = (Product) object;
            return this.name == product.name && this.fabricator == product.fabricator
                    && this.amount == product.amount && this.dateOfManufacture == product.dateOfManufacture
                    && this.dateOfExpiration == product.dateOfExpiration && this.provider == product.provider
                    && this.numberOfProvider == product.numberOfProvider && this.numberOfFabricator == product.numberOfFabricator;
        }
        else
            return false;
    }

    @Override
    public int hashCode(){
        int result = name.hashCode();
        result = 13 * result + fabricator.hashCode();
        result = 23 * result + amount;
        result = 31 * result + dateOfManufacture.hashCode();
        result = 37 * result + dateOfExpiration.hashCode();
        result = 31 * result + provider.hashCode();
        result = 23 * result + numberOfProvider.hashCode();
        result = 13 * result + numberOfFabricator.hashCode();
        result = 11 * result + (int)price;
        return result;
    }

    @Override
    public String toString(){
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
                '}';
    }

    /** Checking work of methods clone(), equals(), hashcode(), toString();
    public void checkOverride(){
        Product product = new Product();
        Product product1 = product;
        System.out.println("product == product1  -  " + product.equals(product1));
        System.out.println("product.name = " + product.getName() + "\tproduct1.name = " + product1.getName());
        product1.setName("Dima");
        System.out.println("product.name = " + product.getName() + "\tproduct1.name = " + product1.getName());
        System.out.println("product == product1  -  " + product.equals(product1));
        System.out.println("AFTER_CLONE");
        product1 = product.clone();
        System.out.println("product == product1  -  " + product.equals(product1));
        System.out.println("product.name = " + product.getName() + "\tproduct1.name = " + product1.getName());
        product1.setName("Den");
        System.out.println("product.name = " + product.getName() + "\tproduct1.name = " + product1.getName());
        System.out.println("product == product1  -  " + product.equals(product1));

        System.out.println("TO_STRING");
        System.out.println(product.toString());

        System.out.println("HASH_CODE");
        System.out.println(product.hashCode());
        System.out.println("_____________________________________\n");
    }
*/
}
