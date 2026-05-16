import java.util.Scanner;

class Q1B {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int count = 0;
		
        for(int i = 0; i < s.length(); i++) {
            for(int j = i;j < s.length(); j++) {
                if(s.charAt(i) == s.charAt(j))
                    count++;
            }
        }
        System.out.println(count);
    }
}