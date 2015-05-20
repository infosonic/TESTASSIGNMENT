/**
 * 
 */
package exercise.library.assembly;

import exercise.library.BookService;
import exercise.library.BookServiceImpl;
import exercise.library.repository.BookRepository;
import exercise.library.repository.BookRepositoryImpl;

/**
 * @author ajayrai
 * This is ApplicationContext class used to do the dependency injection.
 * We can use other open framework to do that.
 */

public class ApplicationContext {
	// this can be done in a better way by using any IOC container.
	// but we are not implementing any IOC container here,for the test purpose
	//it will suffice because it is called by single thread and return the same instance.
	static BookService bookService = new BookServiceImpl();
	static BookRepository bookRepository = new BookRepositoryImpl();
	
	public static BookService getBookServiceInstance() {
		return bookService;
	}
	
	public static BookRepository getBookRepositoryInstance() {
		return bookRepository;
	}
	
}
