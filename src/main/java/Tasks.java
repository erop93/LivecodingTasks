public class NewLivecoding {
    public static void main(String[] args) {exec_task1();}/*

    //Задача:
    static void exec_task1() {
        var book = new Book("My Java", 100);
        System.out.println("book = " + book);
    }

    @ToString
    static class Book {
        private String title;
        private double price;
        private boolean isPopular;

        {
            price = 200;
            System.out.println("Новый экземпляр класса");
        }

        public Book() {
            this("default_book", 0.0, false);
        }

        public Book(String title) {
            this.title = title;
        }

        public Book(String title, double price) {
            this(title);
            this.price = price;
        }

        public Book(String title, double price, boolean isPopular) {
            this(title, price);
            this.isPopular = isPopular;
        }


    }
}
