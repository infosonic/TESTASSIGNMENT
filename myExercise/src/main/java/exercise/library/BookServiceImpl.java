/**
 * 
 */
package exercise.library;

import static exercise.library.Utility.ISBN_PREFIX;
import exercise.library.assembly.ApplicationContext;
import exercise.library.repository.BookRepository;

/**
 * @author ajayrai
 * This is implementation of BookService. the methods will throw
 * unchecked exception for validation.
 *
 */
public class BookServiceImpl implements BookService {


	/* (non-Javadoc)
	 * @see exercise.library.BookService#retrieveBook(java.lang.String)
	 */
	public Book retrieveBook(String isbn) throws BookNotFoundException {
		doValidation(isbn);
		BookRepository repository = ApplicationContext.getBookRepositoryInstance();
		Book book = repository.retrieveBook(isbn) ;
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book;
	}

	private void doValidation(String isbn) {
		if (isbn == null || !isbn.startsWith(ISBN_PREFIX)) {
			throw new InvalidParameterException("book isbn must begin with ISBN");
		}
	}

	/* (non-Javadoc)
	 * @see exercise.library.BookService#getBookSummary(java.lang.String)
	 */
	public String getBookSummary(String isbn) throws BookNotFoundException {
		doValidation(isbn);
		BookRepository repository = ApplicationContext.getBookRepositoryInstance();
		Book book = repository.retrieveBook(isbn) ;
		if (book == null) {
			throw new BookNotFoundException();
		}
		return book.toString();
	}
}
