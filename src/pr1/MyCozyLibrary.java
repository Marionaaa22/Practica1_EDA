package pr1;

import pr1.exceptions.UnexpectedDuplicateException;
import java.util.Comparator;
import java.util.*;


public class MyCozyLibrary implements SmallLibrary
{
	/* You must use a List. Never downcast the list when working with attribute allBooks*/
	private List<Book> allBooks;

	public MyCozyLibrary () {

		allBooks = new ArrayList<>();
	}

	@Override
	public int getNumBooks() {

		return allBooks.size();
	}

	@Override
	public int totalNumCopies() {
		int copies = 0;
		for (Book book : allBooks) {
			copies += book.getNumCopies();
		}
		return copies;
	}

	@Override
	public void addBook(Book book) {
		if (book == null) {
			throw new NullPointerException("El llibre no pot ser nul");
		}

		if (allBooks.contains(book)) {
			throw new UnexpectedDuplicateException("No es pot afegir");
		}
		else {
			allBooks.add(book);
		}

	}

	@Override
	public void removeBook(Book book) {
		if (book == null) {
			throw new NullPointerException("El llibre no pot ser nul");
		}

		if (!allBooks.contains(book)) {
			throw new pr1.exceptions.UnknownBookException("No es pot eliminar");
		}

		allBooks.remove(book);
	}

	@Override
	public Book getBook(BookTag tag) {
		for (Book book : allBooks){
			if (book.getTag().equals(tag)){
				return book;
			}
		}
		return null;
	}

	@Override
	public List<Book> booksFromYear(int year) {

		List<Book> resultat = new ArrayList<>();

		for(Book b: allBooks){
			if(b.getYear() == year){
				resultat.add(b);
			}
		}

		resultat.sort(new ByYearComparator());
		return resultat;
	}

	@Override
	public Book[] containsWord(String word) {
		List<Book> resultat = new ArrayList<>();

		for(Book b: allBooks){
			if(b.getTitle().contains(word.toUpperCase())){
				resultat.add(b);
			}
		}

		Collections.sort(resultat);
		return resultat.toArray(new Book[0]);
	}

	@Override
	public int modifyBookCopies(BookTag tag, int num) {
		Book b = getBook(tag);

		if (b == null){
			throw new pr1.exceptions.UnknownBookException("El llibre no pot ser nul");
		}

		int copies = b.modifyNumCopies(num);

		if(copies == 0){
			allBooks.remove(b);
		}

		return copies;
	}

	/* COMPLETE */

	
	// inner comparator class.
	private static class ByYearComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			return Integer.compare(book1.getYear(), book2.getYear() );
		}
		
	}

}
