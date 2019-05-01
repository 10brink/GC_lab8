import java.util.InputMismatchException;
import java.util.Scanner;

public class classInfo {

	public static void main(String[] args) {
		// code written by Nick TenBrink
		String[] stuNames = { "bob", "mary", "sue", "nick", "oscar", "felicia" };
		String[] stuHome = { "Detroit, MI", "Windsor, Canada", "the moon", "ypsilanti", "a trashcan", "compton" };
		String[] stuFood = { "coney dog", "poutine", "moonrocks", "pad thai", "literally garbage", "grits" };

		System.out.print("welcome to java class. ");
		String escape = "";
		do {
			System.out.println("which student would you like to learn about (1-6)");

			Scanner scan = new Scanner(System.in);
			int inputnum;

			boolean flag = true;
			do {
				while (scan.hasNextInt() == false) {
					// checks if input is integer
					String input = scan.next();
					System.out.println("you entered: " + input);
					System.out.println("please enter a valid number" + " ");
				}
				inputnum = scan.nextInt();

				int actualnum = inputnum - 1;
				// changes input to index #
				try {
					// inputnum = scan.nextInt();

					// int actualnum = inputnum - 1;
					System.out.println("student " + inputnum + " is " + stuNames[actualnum]);
					flag = false;
				} catch (ArrayIndexOutOfBoundsException e) {
					System.out.println("student does not exist");
					System.out.println("enter a number 1-6: ");
				} catch (InputMismatchException e) {
					System.out.println("student does not exist");
					scan.next();
				}
			} while (flag);

			String inputStr = "";
			do {
				System.out.println("what would you like to know about " + stuNames[inputnum - 1]);
				System.out.println("enter \"hometown\" or \"food\" ");
				inputStr = scan.next();

				if (inputStr.equalsIgnoreCase("hometown")) {
					System.out.println(stuNames[inputnum - 1] + "'s hometown is " + stuHome[inputnum - 1]);
				} else if (inputStr.equalsIgnoreCase("food")) {
					System.out.println(stuNames[inputnum - 1] + "'s favorite food is " + stuFood[inputnum - 1]);
				} else {
					System.out.println("data does not exist");
				}

			} while (!(inputStr.equalsIgnoreCase("food") || inputStr.equalsIgnoreCase("hometown")));
			// scan.close();
			System.out.println("do you want to know more (yes/no) ");
			escape = scan.next();
		} while (!escape.equalsIgnoreCase("no"));

		System.out.println("goodbye");

	}

}

