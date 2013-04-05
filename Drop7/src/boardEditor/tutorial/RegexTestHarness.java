package boardEditor.tutorial;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Scanner;

public class RegexTestHarness
{
	public static void main(String [] args)
	{
		Scanner scanner = new Scanner(System.in);
		while(true)
		{			
			System.out.println("Enter your regex:");
			Pattern pattern = Pattern.compile(scanner.nextLine());
			System.out.println("Enter input string to search");
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