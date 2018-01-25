import java.util.Arrays;

public class Iso {
public static boolean isIsomopr(String s1, String s2) {
	int m = s1.length();
	int n = s2.length();
	if(m != n ) {
		return false;
	}
	Boolean[] visited = new Boolean[256];
	Arrays.fill(visited, Boolean.FALSE);
	int[] map = new int[256];
	Arrays.fill(map, -1);
	for(int i = 0; i<n;i++) {
		if(map[s2.charAt(i)] == -1) {
			if(visited[s1.charAt(i)] == true) {
				return false;
			}
			visited[s1.charAt(i)] = true;
			map[s2.charAt(i)] = s1.charAt(i);
		}else if(map[s2.charAt(i)] != s1.charAt(i)) {
			return false;
		}
	}
	return true;
}
	public static void main(String[] args) {
		boolean result = isIsomopr("xzz", "abb");
		if(result) {
			System.out.println("True");
		}else {
			System.out.println("False");
		}
			

	}

}
