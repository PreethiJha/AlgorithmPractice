import java.awt.Point;
import java.util.Stack;

public class StackCustomImpl {
	static Stack<Point> stack = new Stack<Point>();
	static Point followInstruction(Point point, String instruction) {
		Point result = null;
		int x = point.x;
		int y = point.y;
		
		switch (instruction) {
		case "up":
			Point p = new Point(x, ++y);
			result = p;
			stack.push(p);
			break;
		case "down":
			Point p1 = new Point(x, --y);
			result = p1;
			stack.push(p1);
			break;
		case "left":
			Point p2 = new Point(--x, y);
			result = p2;
			stack.push(p2);
			break;
		case "right":
			Point p3 = new Point(++x, y);
			result = p3;
			stack.push(p3);
			break;
		case "undo":
			if(stack!=null && !stack.isEmpty()){result = stack.pop();};
			break;
		case "previous":
			if(stack!=null && !stack.isEmpty()){result = stack.peek();}
			break;
		}
		return result;
	}

	static int resolveExpression(String str) {
		int result = 0;
		char[] expression = str.toCharArray();
		int val1 = 0;
		int val2 = 0;
		StackCustom stack = null;
		for (int i = 0; i < expression.length; i++) {
			if (Character.isDigit(expression[i])) {
				if (stack == null) {
					stack = new StackCustom(
							Character.getNumericValue(expression[i]));
				} else {
					stack.push(Character.getNumericValue(expression[i]));
				}
			} else {
				switch (expression[i]) {
				case '+':
					val1 = stack.pop();
					val2 = stack.pop();
					result = val1 + val2;
					stack.push(result);
					break;
				case '-':
					val1 = stack.pop();
					val2 = stack.pop();
					result = val1 - val2;
					stack.push(result);
					break;
				case '*':
					val1 = stack.pop();
					val2 = stack.pop();
					result = val1 * val2;
					stack.push(result);
					break;
				case '/':
					val1 = stack.pop();
					val2 = stack.pop();
					result = val1 / val2;
					stack.push(result);
					break;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		/*
		 * StackCustom stack = new StackCustom(23); stack.push(20);
		 * stack.push(27); stack.push(3); stack.push(7); stack.push(2);
		 * stack.printStack(); int minStackVal = stack.getMin();
		 * System.out.println("Minimum value of stack at this point is =" +
		 * minStackVal); int popStack = stack.pop();
		 * System.out.println("Poped value of stack =" + popStack); int
		 * minStackVal1 = stack.getMin();
		 * System.out.println("Minimum value of stack at this point is =" +
		 * minStackVal1); int popStack1 = stack.pop();
		 * System.out.println("Poped value of stack =" + popStack1); int
		 * minStackVal2 = stack.getMin();
		 * System.out.println("Minimum value of stack at this point is =" +
		 * minStackVal2);
		 */
		/*int result = resolveExpression("248*+");
		System.out.println("Result ::" + result);*/
		Point newP = new Point(3,4);
		System.out.println("New Points ::x="+newP.x+" y="+newP.y);
		Point result = followInstruction(newP,"up");
		System.out.println("UP:: x="+result.x+" y="+result.y);
		result=followInstruction(result,"down");
		System.out.println("DOWN ::x="+result.x+" y="+result.y);
		result=followInstruction(result,"left");
		System.out.println("LEFT ::x="+result.x+" y="+result.y);
		result=followInstruction(result,"previous");
		System.out.println("PREVIOUS :: x="+result.x+" y="+result.y);
		result=followInstruction(result,"undo");
		System.out.println("UNDO :: x="+result.x+" y="+result.y);
		result=followInstruction(result,"undo");
		System.out.println("UNDO :: x="+result.x+" y="+result.y);
		result=followInstruction(result,"previous");
		System.out.println("PREVIOUS :: x="+result.x+" y="+result.y);
	}

}
