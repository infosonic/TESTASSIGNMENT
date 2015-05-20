package exercise.library.repository;

import exercise.library.Book;

public interface BookRepository {
	Book retrieveBook(String isbn);
}
