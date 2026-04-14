package pr1;

import java.util.*;

public interface SmallLibrary  {
	

	public int getNumBooks();
	

	public int totalNumCopies();
	

	public void addBook (Book book);


	public void removeBook (Book book);


	public Book getBook(BookTag tag);


	public List<Book> booksFromYear (int year);


	public Book [] containsWord(String word);


	public int modifyBookCopies (BookTag tag, int num);

}
