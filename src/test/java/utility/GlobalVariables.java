package utility;

/*
 * Global variables are generally static in nature, can be initialized at the start of a
test, and remain available throughout the entire test run. Variables for application
defaults, timeouts, property file locations, paths, and so on can be stored in this
class. To be clear, test data is not stored in this class. Test data will be
encapsulated in a different file format, and will be discussed in later chapters.
Here is an example of some default global variables:

 */

public class GlobalVariables {
	public static final String PLATFORM = "Windows 10";
	public static final String ENVIRONMENT = "C1";
	public static final String BROWSER = "chrome";
	
	
	// test output path defaults
	public static final String TEST_OUTPUT_PATH = "testOutput/";
	public static final String LOGFILE_PATH = TEST_OUTPUT_PATH + "Logs/";
	public static final String REPORT_PATH = TEST_OUTPUT_PATH + "Reports";
	
	
	// timeout defaults
	public static final int TIMEOUT_MINUTE = 60;
	public static final int TIMEOUT_SECONDS = 1;
	public static final int TIMEOUT_ZERO = 0;
	
}
