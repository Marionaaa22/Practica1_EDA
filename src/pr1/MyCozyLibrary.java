package pr1;

import java.util.*;

import pr1.exceptions.UnexpectedDuplicateException;
import pr1.exceptions.UnknownBookException;


public class MyCozyLibrary //TODO: Complete header
{

	/* You must use a List. Never downcast the list when working with attribute allBooks*/
	private List<Book> allBooks;
	
	public MyCozyLibrary () {
		/* COMPLETE */

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
