import java.util.Scanner;

class Q3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        int alice = 0;
        int bob = 0;

        for(int i=0;i<s.length();i++) {

            char ch = s.charAt(i);

            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u')
                alice = alice + (s.length()-i);
            else
                bob = bob + (s.length()-i);
        }

        if(alice > bob)
            System.out.println("Alice " + alice);

        else if(bob > alice)
            System.out.println("Bob " + bob);

        else
            System.out.println("Draw");
    }
}