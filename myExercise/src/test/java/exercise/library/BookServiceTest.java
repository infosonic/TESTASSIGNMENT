/**
 * 
 */
package exercise.library;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import exercise.library.assembly.ApplicationContext;

/**
 * @author ajayrai
 * This is a junit test to test the BookService and make sure the service should follow
 * following Acceptance criteria for Book retrieveBook(String isbn) :
      o Input 'INVALID-TEXT' should throw an Exception, informing the client that the book isbn must begin with 'ISBN'.
      o Input 'ISBN-777' should throw BookNotFoundException.
      o Input 'ISBN-001' should return the book entitled 'Harry Potter and the Deathly Hallows'.
	Following Acceptance criteria for String getBookSummary(String isbn):
      o Input 'INVALID-TEXT' should throw an Exception, informing the client that the book isbn must begin with 'ISBN'.
      o Input 'ISBN-777' should throw BookNotFoundException.
      o Input 'ISBN-001' should return '[ISBN-001] Harry Potter and the Deathly Hallows - Sorcery and Magic.'
      o Input 'ISBN-002' should return '[ISBN-002] The Player of Games - Jernau Morat Gurgeh. The Player of Games. Master of every...'
      o Input 'ISBN-003' should return '[ISBN-003] Genius: Richard Feynman and Modern Physics - A brilliant interweaving of Richard Feynman's colourful life

 */
public class BookServiceTest {

	private BookService bookService;
	
	@Before
	public void setup() {
		bookService = ApplicationContext.getBookServiceInstance();
	}
	@Test
	public void testInvalidISBNForretrieveBook() throws Exception {
		try {
			bookService.retrieveBook("INVALID-TEXT");
			Assert.fail("It must throw the InvalidParameterException");
		} catch(InvalidParameterException invalidKey) {
			Assert.assertEquals("book isbn must begin with ISBN", invalidKey.getMessage());
		}		
	}
	
	@Test
	public void testInvalidBookNotFoundExcptionForretrieveBook() throws Exception {
		try {
			bookService.retrieveBook("ISBN-777");
			Assert.fail("It must throw checked BookNotFoundException");
		} catch(BookNotFoundException invalidKey) {
			Assert.assertTrue("Got BookNotFoundException", true);
		}		
	}	
	
	@Test
	public void testValidForretrieveBook() throws Exception {
		Book book = bookService.retrieveBook("ISBN-001");
		Assert.assertEquals("Harry Potter and the Deathly Hallows", book.getTitle());
	}


	@Test
	public void testInvalidISBNForgetBookSummary() throws Exception {
		try {
			bookService.getBookSummary("INVALID-TEXT");
			Assert.fail("It must throw the InvalidParameterException");
		} catch(InvalidParameterException invalidKey) {
			Assert.assertEquals("book isbn must begin with ISBN", invalidKey.getMessage());
		}	
	}
	
	@Test
	public void testInvalidBookNotFoundExcptionForgetBookSummary() throws Exception {
		try {
			bookService.retrieveBook("ISBN-777");
			Assert.fail("It must throw checked BookNotFoundException");
		} catch(BookNotFoundException invalidKey) {
			Assert.assertTrue("Got BookNotFoundException", true);
		}		
	}
	
	@Test
	public void testValidForgetBookSummary() throws Exception {
		Assert.assertEquals("[ISBN-001] Harry Potter and the Deathly Hallows - Sorcery and Magic....", bookService.getBookSummary("ISBN-001"));
		Assert.assertEquals("[ISBN-002] The Player of Games - Jernau Morat Gurgeh. The Player of Games. Master of every...", bookService.getBookSummary("ISBN-002"));
		Assert.assertEquals("[ISBN-003] Genius: Richard Feynman and Modern Physics - A brilliant interweaving of Richard Feynman's colourful life and a...", bookService.getBookSummary("ISBN-003"));
		
	}

}
