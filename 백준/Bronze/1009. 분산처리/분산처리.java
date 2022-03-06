import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int num=1, ans=0; 
			for(int i = 1; i <= b; i++) {
				num = num*a;
				ans = num%10;
				num = num%10;
				if(ans == 0) ans = 10;
			}
			System.out.println(ans);
		}
	}
}
