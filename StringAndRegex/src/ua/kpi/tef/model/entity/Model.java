package ua.kpi.tef.model.entity;

/**
 * Created by Dima Skorobogatskii on 13.03.2017.
 */
public class Model {
    public Notebook notebook;

    public Model(){
        notebook = new Notebook();
    }
    public void setNotebook(Notebook notebook){
        this.notebook = notebook;
    }

    public Notebook getNotebook() {
        return notebook;
    }
}
