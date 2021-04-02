/**
 * 书籍列表类，用来存放多本书
 */

package MyBookSystem;

public class BookList {
    private Book[] books=new Book[100];
    private int size=0;

    public BookList() {
/**
 * books[0] = new Book("三国演义", "罗贯中", 100, "古典小说");
 *         books[1] = new Book("西游记", "吴承恩", 100, "古典小说");
 *         books[2] = new Book("金瓶梅", "兰陵笑笑生", 110, "古典小说");
 * books[0]={"西游记","吴承恩",100,"古典小说"};
 *这种写法错误的原因是因为数组里面存放的是一个Book类型的对象，要通过New这个关键给创建出来
 **/
      books[0]=new Book("西游记","吴承恩",100,"古典名著");
      books[1]=new Book("三国演义","吴承恩",100,"古典名著");
      books[2]=new Book("红楼梦","曹雪芹",100,"古典名著");
      size=3;
    }

    public int getSize() {
        return size;
    }

    public Book getBooks(int index) {
        return books[index];  //返回某本书
    }

    public void setBooks(int index ,Book book) {
       books[index]=book;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
