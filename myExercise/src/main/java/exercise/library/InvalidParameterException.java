/**
 * 
 */
package exercise.library;

/**
 * @author ajayrai
 * This is a runtime exception,  informing the client about the validation error
 * Client should be aware of the rules regading the api, If it is not followed
 * InvalidParameterException will be thrown containing the message.
 */
public class InvalidParameterException extends RuntimeException {
	
	public InvalidParameterException(String message) {
		super(message);
	}

}
