package code.practice.jerry.models;

public class Food {

    private String id;

    private String name;

    private String date;


    public Food(String id, String name, String date) {
        this.id = id;
        this.name = name;
        this.date =  date;
    }

    public Food(){
    }

    public Food(String name, String date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
