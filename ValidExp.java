
import java.util.Scanner;
import java.util.Stack;

public class ValidExp {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a string from these characters (,),{,},[,] : ");
		String str= sc.nextLine();
		if(checkValidExpression(str))
			System.out.println("The given string is a valid expression.");
		else
			System.out.println("The given string is not a valid expression.");
	}

	private static boolean checkValidExpression(String string) {
		if(string.length()%2 !=0) return false;
		
		Stack<Character> openStack = new Stack<Character>();
		for(char a : string.toCharArray()) {
			if(a == '(' || a=='[' || a=='{' ) {
				openStack.add(a);
				continue;
			}
			if(!openStack.isEmpty() && (a==')' || a=='}' || a==']')){
				char topElement = openStack.pop();
				if(!((topElement == '(' && a == ')') || (topElement == '{' && a == '}') || (topElement == '[' && a == ']')))
					return false;
			}
		}
		if(!openStack.isEmpty()) return false;
		return true;
	}

}
