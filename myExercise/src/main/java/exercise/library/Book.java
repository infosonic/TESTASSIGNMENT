package exercise.library;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Book
{
    private String isbn;
    private String title;
    private String description;

    public Book(String isbn, String title, String description)
    {
        this.isbn = isbn;
        this.title = title;
        this.description = description;
    }

    public String getDescription()
    {
        return description;
    }

    public String getIsbn()
    {
        return isbn;
    }

    public String getTitle()
    {
        return title;
    }
    
    @Override
    public String toString() {
    	return new StringBuilder()
		.append("[")
		.append(getIsbn())
		.append("] ")
		.append(getTitle())
		.append(" - ")
		.append(firstTenWords(getDescription()))
		.append("...").toString();
    }    

	private String firstTenWords(String description) {
		Pattern pattern = Pattern.compile("([\\S]+\\s*){10}");
	    Matcher matcher = pattern.matcher(description);
	    matcher.find();
		return matcher.group().trim();
	}
}
