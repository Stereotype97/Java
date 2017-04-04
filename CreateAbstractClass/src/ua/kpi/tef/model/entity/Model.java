package ua.kpi.tef.model.entity;

import ua.kpi.tef.model.entity.inheritors.Laptop;

/**
 * Created by Димон on 20.03.2017.
 */
public class Model {

    Laptop laptop;

    public Model() {
        laptop = new Laptop();
    }

    public Laptop getLaptop() {
        return laptop;
    }

    public void setLaptop(Laptop laptop) {
        this.laptop = laptop;
    }
}