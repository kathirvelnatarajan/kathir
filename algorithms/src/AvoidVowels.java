
public class AvoidVowels {

	public static void main(String[] args) {
		String s="helloWorldpoora";
		String vowels = "aeiou";
		char temp = '0';
		char[] vc = vowels.toCharArray();
		char[] sc = s.toCharArray();
		char[] nc = new char[sc.length];
		for(int i=0;i<vc.length;i++) {
			for(int j=0;j<sc.length;j++) {
				if(sc[j] == vc[i]) {
					 sc[j] = '0';
				}
			}
			nc[i] = temp;
		}
		for(int k=0;k<sc.length;k++) {
			if(sc[k] != '0') {
			System.out.println(sc[k]);
			}
		}
	}

}
