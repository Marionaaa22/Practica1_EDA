package pr1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


public class MyCozyLibrary implements SmallLibrary
{
	/* You must use a List. Never downcast the list when working with attribute allBooks*/
	private List<Book> allBooks;

	public MyCozyLibrary () {

		allBooks = new ArrayList<>();
	}

	@Override
	public int getNumBooks() {

		int numBooks = allBooks.size();

		return numBooks;
	}

	@Override
	public int totalNumCopies() {
		return 0;
	}

	@Override
	public void addBook(Book book) {

	}

	@Override
	public void removeBook(Book book) {

	}

	@Override
	public Book getBook(BookTag tag) {
		return null;
	}

	@Override
	public List<Book> booksFromYear(int year) {
		List<Book> bookYear = new ArrayList<>();
		
		return List.of();
	}

	@Override
	public Book[] containsWord(String word) {
		return new Book[0];
	}

	@Override
	public int modifyBookCopies(BookTag tag, int num) {
		return 0;
	}

	/* COMPLETE */

	
	// inner comparator class.
	private static class ByYearComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			
			/* COMPLETE */

			return -1; //TODO: Change this!
		}
		
	}

}
