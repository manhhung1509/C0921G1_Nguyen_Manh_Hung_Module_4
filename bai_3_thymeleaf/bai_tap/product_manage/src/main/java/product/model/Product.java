package product.model;

public class Product {
    private int id;
    private String name;
    private String manufacture;
    private String country;

    public Product() {
    }

    public Product(int id, String name, String manufacture, String country) {
        this.id = id;
        this.name = name;
        this.manufacture = manufacture;
        this.country = country;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
