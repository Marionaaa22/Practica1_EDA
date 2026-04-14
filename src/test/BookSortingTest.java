package test;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;


import org.junit.jupiter.api.Test;
import pr1.Book;
import pr1.BookTag;

import java.util.Arrays;

public class BookSortingTest {

    BookTag [] sortedTags = {
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

    String [] titles = {
            "monster-sized lists",
            "exposed attributes of a shy collection",
            "Eden Garden of data iterators",
            "arraylists in action",
            "a vector with two arrays",
            "two arrays and a list with a vector",
            "linkedlists store it better",
            "a house of full lists",
            "glamourous collections",
            "after-school hours of a collection",
            "Iterate me after class!",
            "ArrayLists shows their attributes",
            "fully-equipped iterators"
    };

    Book [] books, sortedBooks;

    @BeforeEach
    void setUp(){
        books = new Book[sortedTags.length];
        sortedBooks = new Book[sortedTags.length];

        for (int i=0; i<sortedTags.length; i++) {
            sortedBooks[i] = new Book(sortedTags[i], 2024, titles[i]);
            books[i] = new Book(sortedTags[sortedTags.length-1-i], 2024, titles[sortedTags.length-1-i]);
        }
    }

    @Test
    void checkBookSorting(){
        Arrays.sort(books);
        for(int i=0; i<books.length; i++){
            Assertions.assertEquals(books[i], sortedBooks[i]);
        }
    }




}