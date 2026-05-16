import java.util.Scanner;

class Q1A {
    static int match(String s,int start,int end) {
        if(start==end)
            return 1;
        int count=0;
        if(s.charAt(start) == s.charAt(end))
            count=1;
        return count + match(s,start+1,end);
    }

    static int find(String s,int index) {
        if(index>=s.length())
            return 0;
        return match(s,index,s.length()-1) + find(s,index+1);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        System.out.println(find(s,0));
    }
}