package pr1;

import pr1.exceptions.UnexpectedDuplicateException;
import pr1.exceptions.UnknownBookException;

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

		for(Book llistaBook : allBooks){
			if(llistaBook.equals(book)) {
				throw new UnexpectedDuplicateException("No es pot afegir");
			}
		}
		allBooks.add(book);
	}

	@Override
	public void removeBook(Book book) {
		if (book == null) {
			throw new NullPointerException("El llibre no pot ser nul");
		}

		Iterator<Book> ite = allBooks.iterator();

		while(ite.hasNext()){
			if(ite.next().equals(book)){
				ite.remove();
				return;
			}

		}
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
			if(b.getYear() >= year){
				resultat.add(b);
			}
		}

		Collections.sort(resultat, new ByYearComparator());
		return resultat;
	}

	@Override
	public Book[] containsWord(String word) {
		List<Book> llista = new ArrayList<Book>();

		for(Book b: allBooks){
			if(b.getTitle().contains(word)){
				llista.add(b);
			}
		}

		Book [] arrayList = llista.toArray( new Book[0]);
		Arrays.sort(arrayList);
		return arrayList;
	}

	@Override
	public int modifyBookCopies(BookTag tag, int num) {

		for(Book llistaBook: allBooks){
			if(llistaBook.getTag().equals(tag)){
				llistaBook.modifyNumCopies(num);
				if(llistaBook.getNumCopies() == 0){
					removeBook(llistaBook);
					return 0;
				}
				return llistaBook.getNumCopies();
			}
		}
		throw new UnknownBookException("La etiqueta especificada no te cap llibre en aquesta colecció");
	}

	// inner comparator class.
	private static class ByYearComparator implements Comparator<Book> {

		@Override
		public int compare(Book book1, Book book2) {
			return Integer.compare(book1.getYear(), book2.getYear() );
		}
		
	}

}
