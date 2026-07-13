public class Exercise6 {

    // Book Class
    static class Book {

        int bookId;
        String title;
        String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public void display() {
            System.out.println("Book ID : " + bookId);
            System.out.println("Title   : " + title);
            System.out.println("Author  : " + author);
        }
    }

    // Linear Search by Title
    public static Book linearSearch(Book[] books, String title) {

        for (int i = 0; i < books.length; i++) {

            if (books[i].title.equalsIgnoreCase(title)) {
                return books[i];
            }
        }

        return null;
    }

    // Binary Search by Title (Array should be sorted)
    public static Book binarySearch(Book[] books, String title) {

        int low = 0;
        int high = books.length - 1;

        while (low <= high) {

            int mid = (low + high) / 2;

            int result = books[mid].title.compareToIgnoreCase(title);

            if (result == 0) {
                return books[mid];
            }

            else if (result < 0) {
                low = mid + 1;
            }

            else {
                high = mid - 1;
            }
        }

        return null;
    }

    // Main Method
    public static void main(String[] args) {

        // Unsorted Array for Linear Search
        Book[] bookList = {
                new Book(103, "Java Programming", "James Gosling"),
                new Book(101, "Python Basics", "Guido van Rossum"),
                new Book(105, "Data Structures", "Mark Allen"),
                new Book(102, "Operating Systems", "Abraham Silberschatz"),
                new Book(104, "Computer Networks", "Andrew Tanenbaum")
        };

        // Sorted Array by Title for Binary Search
        Book[] sortedBookList = {
                new Book(104, "Computer Networks", "Andrew Tanenbaum"),
                new Book(105, "Data Structures", "Mark Allen"),
                new Book(103, "Java Programming", "James Gosling"),
                new Book(102, "Operating Systems", "Abraham Silberschatz"),
                new Book(101, "Python Basics", "Guido van Rossum")
        };

        String searchTitle = "Java Programming";

        // Linear Search
        System.out.println("===== Linear Search =====");

        Book result1 = linearSearch(bookList, searchTitle);

        if (result1 != null) {
            System.out.println("Book Found");
            result1.display();
        } else {
            System.out.println("Book Not Found");
        }

        System.out.println();

        // Binary Search
        System.out.println("===== Binary Search =====");

        Book result2 = binarySearch(sortedBookList, searchTitle);

        if (result2 != null) {
            System.out.println("Book Found");
            result2.display();
        } else {
            System.out.println("Book Not Found");
        }
    }
}