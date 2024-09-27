import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.Period;

	public class MenstrualApp {

		public static void main(String[] args) {
		
		Scanner console = new Scanner(System.in);
		
		System.out.print("Enter your menstrual date: ");
		   String userInput = console.nextLine();

                   int duration = printDate(userInput,LocalDate.now());		
		
		System.out.println(duration);
		

	}
		public static int printDate(String input,LocalDate todayDate) {
	
		DateTimeFormatter date = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
		LocalDate menstrual = LocalDate.parse(input,date);
                
                int years = Period.between(menstrual,todayDate).getYears();           

                return years;

	}
	

}