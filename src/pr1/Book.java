package pr1;

public class Book implements Comparable<Book> {

    private BookTag tag;
    private int year;
    private String title;
    private int numCopies;

    public Book(BookTag tag, int year, String title) {
        this.tag = tag;
        this.year = year;
        this.title = title.toUpperCase();
        this.numCopies = 1;
    }

    public BookTag getTag() {
        return this.tag;
    }

    public int getYear() {
        return this.year;
    }

    public String getTitle() {
        return this.title;
    }

    public int getNumCopies() {
        return this.numCopies;
    }

    /**
     * Adds num to numCopies. Can be used to increase or decrease number of copies by the given parameter.
     * numCopies is always >=0
     *
     * @param num
     * @return
     */
    public int modifyNumCopies(int num) {
        numCopies = Math.max(0, numCopies + num);
        return numCopies;
    }

    @Override
    public int compareTo(Book other) {

        return tag.compareTo(other.tag);
    }

    @Override
    public boolean equals(Object arg) {
        if (arg == this) {
            return true;
        }
        if (!(arg instanceof Book)) {
            return false;
        }
        Book other = (Book) arg;
        return this.compareTo(other) == 0;
    }

    @Override
    public String toString() {
        return tag + "-(" + year + ")-" + title;
    }

    @Override
    public int hashCode() {
        return tag.hashCode();
    }

    @Override
    public Book clone() {
        return new Book(tag.clone(), year, new String(title));
    }

}
