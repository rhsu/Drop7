package tutorial;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test 
{
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{
			Pattern pattern = Pattern.compile("[[1-7[E]][\\s]]{13}");
			System.out.println("Enter input string to match");
			Matcher matcher = pattern.matcher(scanner.nextLine());
			
			boolean found = false;
			while(matcher.find())
			{
				System.out.println(String.format("The text was found \"%s\" starting at indext %d and ending at index %d.%n",
						matcher.group(), matcher.start(), matcher.end()));
				found = true;		
			}
			
			if(!found)
			{
				System.out.println("No match found");
			}
		}
	}
}
