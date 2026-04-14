package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

import pr1.Book;
import pr1.BookTag;
import pr1.MyCozyLibrary;
import pr1.SmallLibrary;
import pr1.exceptions.UnexpectedDuplicateException;
import pr1.exceptions.UnknownBookException;
import static test.AuxiliaryMethods.*;

public class LibraryTest {
	
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
	
	private BookTag [] unknownTags = {
			new BookTag("AAAA", 31, "ZZ"),
			new BookTag("AAAA", 32, "ZZ"),
			new BookTag("AAAA", 33, "JJ"),
			new BookTag("AAAA", 33, "BA"),
			new BookTag("AAAK", 10, "ZZ"),
			new BookTag("AAAK", 10, "ZZ"),
			new BookTag("AAAK", 10, "JJ"),
			new BookTag("AAAK", 10, "BA"),
			new BookTag("DAAA", 21, "XX"),
			new BookTag("DAAA", 22, "XY"),
			new BookTag("DAAA", 23, "ZX"),
			new BookTag("DAAO", 24, "ZZ"),
			new BookTag("TAAJ", 99, "RR")
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
	
	private Book [] books;
	
	private SmallLibrary sl;
	
	@BeforeEach
	void setUp() {
		books = new Book[sortedTags.length];
		for (int i=0; i<sortedTags.length; i++) {
			books[i] = new Book(sortedTags[i], 2025, titles[i]);
		}
		shuffle(books);
		sl = new MyCozyLibrary();
	}
	
	@Test
	void checkEmptyLibrary() {	
		assertEquals(0,sl.getNumBooks());
	}
	
	@Test
	void addClonedBooksToEmptyLibrary() {
		addClonedBooks();
		assertEquals(books.length,sl.getNumBooks());
	}
	
	@Test
	void addRepeatedBooks() {
		addClonedBooks();
		for(int i=0; i<books.length; i++) {
			Book book = books[i];
			assertThrows(UnexpectedDuplicateException.class,()->sl.addBook(book));
		}
	}
	
	@Test
	void getExistingBooks() {
		addClonedBooks();
		for(int i=0; i<books.length; i++) {
			Book book = books[i];
			Book otherBook = sl.getBook(book.getTag());
			assertEquals(book,otherBook);
		}
	}
	
	@Test
	void getUnexistingBooksReturnsNull() {
		addClonedBooks();
		for(int i=0; i<unknownTags.length; i++) {
			BookTag tag = unknownTags[i];
            assertNull(sl.getBook(tag));
		}
	}
	
	@Test
	void removeClonedBook() { //New test
		addClonedBooks();
		for(int i=0; i<books.length; i++) {
			sl.removeBook(books[i]);
		}
		assertEquals(0, sl.getNumBooks());
	}
	
	@Test
	void addNonClonedBooks() {
		addBooks();
		assertEquals(books.length,sl.getNumBooks());
	}
	
	@Test
	void addNewCopyNonExistingTags() {
		addBooks();
		for(int i=0; i<unknownTags.length; i++) {
			BookTag booktag = unknownTags[i];
			assertThrows(UnknownBookException.class,()->{sl.modifyBookCopies(booktag,1);});
		}
	}
	
	@Test
	void checkInitialNumCopies(){
		addBooks();
		for(int i=0; i<sortedTags.length; i++){
			Book book = sl.getBook(sortedTags[i]);
			assertEquals(1,book.getNumCopies());
		}
	}

	@Test
	void removeBooks() {
		addBooks();
		for(int i=0; i<books.length; i++) {
			sl.removeBook(books[i]);
		}
		assertEquals(0,sl.getNumBooks());
	}


	
	private void addClonedBooks() {
		for (int i=0; i<books.length; i++) {
			sl.addBook(books[i].clone());
		}
	}
	
	private void addBooks() {
		for (int i=0; i<books.length; i++) {
			sl.addBook(books[i]);
		}
	}

}