public class Product {
    String name; 
    Double price;
    int amount;


    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", amount=" + amount + "Total :" +getAmount()*price+ "]";
    }


    public void add(int x){
        setAmount(x+getAmount());
    }

    public void sub(int x){
        setAmount(getAmount()-x);
    }
    
    public Double val (){
        return getAmount()*getPrice();
    }
    public Product(String name, Double price, int amount) {
        this.name = name;
        this.price = price;
        this.amount = amount;
      
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public int getAmount() {
        return amount;
    }
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
}
