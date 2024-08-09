package decorator.pizza;

public abstract class Pizza {

    private String description = "--";

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public abstract double getCost();
}
