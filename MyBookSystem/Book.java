/**
 * Book类，用来存储一本书的信息
 */
package MyBookSystem;

public class Book {
    private String name;
    private String authur;
    private double price;
    private String type;
    private boolean isborrowd=false;

    public Book(String name, String authur, double price, String type) {
        this.name = name;
        this.authur = authur;
        this.price = price;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public boolean isIsborrowd() {
        return isborrowd;
    }

    public void setIsborrowd(boolean isborrowd) {
        this.isborrowd = isborrowd;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", authur='" + authur + '\'' +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", isborrowd=" + isborrowd +
                '}';
    }
}
