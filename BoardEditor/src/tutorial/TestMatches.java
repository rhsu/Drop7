package tutorial;
		
import Utilities.Constants;

public class TestMatches 
{
	public static void main(String[] args)
	{
		boolean b = Constants.EXAMPLE.matches(Constants.REGEX);
		System.out.println(b);
	}
}
