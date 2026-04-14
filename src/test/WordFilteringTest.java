package test;


import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import static test.AuxiliaryMethods.doubleInclusion;
import static test.AuxiliaryMethods.sortedOk;
import static test.AuxiliaryMethods.shuffle;

import pr1.Book;
import pr1.BookTag;
import pr1.MyCozyLibrary;
import pr1.SmallLibrary;

public class WordFilteringTest {
    private BookTag [] sortedTags = {
            new BookTag("AAAA", 23, "ZZ"),
            new BookTag("AAAA", 28, "ZZ"),
            new BookTag("AAAA", 28, "JJ"),
            new BookTag("AAAA", 28, "BA"),
            new BookTag("AAAK", 23, "ZZ"),
            new BookTag("AAAK", 28, "ZZ"),
            new BookTag("AAAK", 28, "JJ"),
            new BookTag("AAAK", 28, "BA"),
            new BookTag("DAAA", 21, "BB"),
            new BookTag("DAAA", 22, "CC"),
            new BookTag("DAAA", 23, "JJ"),
            new BookTag("DAAA", 24, "ZZ"),
            new BookTag("TAAA", 99, "RR")
    };


    private String [] titles = {
            "monster-sized lists", // 0
            "exposed attributes of a shy collection", // 1
            "Eden Garden of data iterators", // 2
            "arraylists in action", // 3
            "a vector with two arrays", // 4
            "two arrays and a list with a vector", // 5
            "linkedlists store it better", // 6
            "a house of full lists", // 7
            "glamourous collections", // 8
            "after-school hours of a collection", // 9
            "Iterate me after class!", // 10
            "ArrayLists shows their attributes", // 11
            "fully-equipped iterators" // 12
    };

    private Book [] copyBooks;
    private Book [] books;

    private List<Book> books_list;
    private List<Book> books_array;
    private List<Book> books_attributes;
    private List<Book> books_house;

    private SmallLibrary sl;

    @BeforeEach
    void setUp(){
        books = new Book[sortedTags.length];
        for (int i=0; i<sortedTags.length; i++) {
            books[i] = new Book(sortedTags[i], 2025, titles[i]);
        }

        copyBooks = Arrays.copyOf(books, books.length);
        books_list = Arrays.asList(copyBooks[0],copyBooks[3], copyBooks[5],copyBooks[6], copyBooks[7],copyBooks[11]);
        books_array = Arrays.asList(copyBooks[3], copyBooks[4], copyBooks[5],copyBooks[11]);
        books_attributes = Arrays.asList(copyBooks[1], copyBooks[11]);
        books_house = Arrays.asList(copyBooks[7]);

        shuffle(books);

        sl = new MyCozyLibrary();

        for (int i=0; i<books.length; i++) {
            sl.addBook(books[i].clone());
        }
    }

    @Test
    void containsWordList(){
        testContainsWord(books_list,"LIST");
    }

    @Test
    void containsWordArray(){
        testContainsWord(books_array,"ARRAY");
    }

    @Test
    void containsWordAttributes(){
        testContainsWord(books_attributes,"ATTRIBUTES");
    }

    @Test
    void containsWordHouse(){
        testContainsWord(books_house,"HOUSE");
    }

    private void testContainsWord(List<Book> expected, String word){
        Book[] result = sl.containsWord(word);
        assertEquals(expected.size(), result.length);
        assertTrue(doubleInclusion(expected,Arrays.asList(result)));
        assertTrue(sortedOk(expected,Arrays.asList(result)));
    }


}
