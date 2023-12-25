public class Good {
    double price;
    String name;

    public Good(String name, double price) {
        this.price=price;
        this.name=name;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }
}
