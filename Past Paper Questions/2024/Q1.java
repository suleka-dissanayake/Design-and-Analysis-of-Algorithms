import java.util.Scanner;

class Q1 {

    public static void main(String[] args) {

        int[] w = {15,30,25,40,50,35,45,20,10,55};
        int[] v = {600,1000,1200,2000,1500,800,900,1100,500,1300};

        int n = 10;
        int cap = 150;

        int[][] dp = new int[n+1][cap+1];

        for(int i=1;i<=n;i++) {

            for(int j=1;j<=cap;j++) {

                if(w[i-1] <= j) {

                    int a = v[i-1] + dp[i-1][j-w[i-1]];
                    int b = dp[i-1][j];

                    if(a > b)
                        dp[i][j] = a;
                    else
                        dp[i][j] = b;

                } else {

                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        System.out.println("Maximum Profit = " + dp[n][cap]);

        System.out.println("Selected Items:");

        int j = cap;

        for(int i=n;i>0;i--) {

            if(dp[i][j] != dp[i-1][j]) {

                System.out.println("I" + i);

                j = j - w[i-1];
            }
        }
    }
}