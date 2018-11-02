package HamaniKhalilTP3;

public class SystemErrors {
	
	// Error messages
	public static final String	HASH_OUTOFBOUNDS_MESSAGE		= "Can't put more values, the hashtable is already full";
	public static final String	HASH_BAD_INSERTION_MESSAGE		= "Can't put empty value for key in the hashtable";
	
	// Error codes
	// Unknown error for methods that return integers
	public static final int		HASH_UNKNOWN_ERROR_INT_METHOD	= -101;
	/*
	 *  Error code used while development process to tell that the method that return integer
	 *  is not yet implemented
	 *  (this one can be thrown out after development process) 
	 */
	public static final int		HASH_NOT_IMPLEMENTED_INT_METHOD	= -102;
}
