import java.util.Stack;

public class Balance {
	static int[] balancedOrNot(String[] expressions, int[] maxReplacements) 
	{
		
int[] result = new int[expressions.length];
for(int i=0;i<result.length;i++) {
	result[i] = balancedOrNot(expressions[i], maxReplacements[i]);
}
return result;
    }
	static int balancedOrNot(String expressions, int maxReplacements) 
	{
		Stack<Character> s = new Stack<Character>(); 
		int countg = 0;
		for(int i=0;i<expressions.length();i++) {
			char ex  = expressions.charAt(i);
			
			if(ex == '<') {
				s.push(ex);
			}else {
				if(s.size() > 0 && s.peek() == '<') {
					s.pop();
				}else if(i ==0) {
					return 0;
				}
				else  {
					countg++;
					
				}
			}
		}
if(countg > maxReplacements) {
	return 0;
}

		
return 1;

    }

	public static void main(String[] args) {
		String[] ex = {"<>>>","<>>>>"};
		int[] max = {2,2};
		int[] res = balancedOrNot(ex, max);
		for(int i=0;i<res.length;i++) {
			System.out.println(res[i]);
		}
		
	}

}
