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

public class BookFilteringSortingTest {

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

    private int [] years = {
            1996,
            1996,
            2000, // 2
            2000,
            2000,
            2005, // 5
            2005,
            2010, // 7
            2011, // 8
            2012, // 9
            2018, // 10
            2018,
            2025
    };

    private Book [] books;
    private List<Book> allBooks;

    private SmallLibrary smallLibrary;

    @BeforeEach
    void setUp(){
        books = new Book[sortedTags.length];

        for (int i=0; i<sortedTags.length; i++) {
            books[i] = new Book(sortedTags[i], years[i], titles[i]);
        }

        allBooks = Arrays.asList(Arrays.copyOf(books,books.length));


        shuffle(books);

        smallLibrary = new MyCozyLibrary();

        for (Book book : books) {
            smallLibrary.addBook(book.clone());
        }

    }

    @Test
    void testBooksFrom1900Onwards(){
        List<Book> result = smallLibrary.booksFromYear(1900);
        assertEquals(books.length,result.size());
        assertTrue(doubleInclusion(result,allBooks));
        assertTrue(sortedOk(result,allBooks));
    }


    @Test
    void testBooksFrom2000Onwards(){
        List<Book> allBooks_2000 = allBooks.subList(2, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2000);
        assertEquals(allBooks_2000.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2000));
        assertTrue(sortedOk(result, allBooks_2000));
    }


    @Test
    void testBooksFrom2005Onwards(){
        List<Book> allBooks_2005 = allBooks.subList(5, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2005);
        assertEquals(allBooks_2005.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2005));
        assertTrue(sortedOk(result, allBooks_2005));
    }


    @Test
    void testBooksFrom2010Onwards(){
        List<Book> allBooks_2010 = allBooks.subList(7, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2010);
        assertEquals(allBooks_2010.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2010));
        assertTrue(sortedOk(result, allBooks_2010));
    }


    @Test
    void testBooksFrom2011Onwards(){
        List<Book> allBooks_2011 = allBooks.subList(8, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2011);
        assertEquals(allBooks_2011.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2011));
        assertTrue(sortedOk(result, allBooks_2011));
    }


    @Test
    void testBooksFrom2012Onwards(){
        List<Book> allBooks_2012 = allBooks.subList(9, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2012);
        assertEquals(allBooks_2012.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2012));
        assertTrue(sortedOk(result, allBooks_2012));
    }


    @Test
    void testBooksFrom2018Onwards(){
        List<Book> allBooks_2018 = allBooks.subList(10, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2018);
        assertEquals(allBooks_2018.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2018));
        assertTrue(sortedOk(result, allBooks_2018));
    }


    @Test
    void testBooksFrom2025Onwards(){
        List<Book> allBooks_2025 = allBooks.subList(12, allBooks.size());
        List<Book> result = smallLibrary.booksFromYear(2025);
        assertEquals(allBooks_2025.size(),result.size());
        assertTrue(doubleInclusion(result, allBooks_2025));
        assertTrue(sortedOk(result, allBooks_2025));
    }


    @Test
    void testBooksFrom2026Onwards(){
        List<Book> result = smallLibrary.booksFromYear(2026);
        assertEquals(0,result.size());

    }


}