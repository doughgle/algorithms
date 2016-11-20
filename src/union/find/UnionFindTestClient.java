package union.find;

import java.util.Scanner;

public class UnionFindTestClient {

	
	public static void main(String[] args) {
		System.out.println("Specify the number of the components:");
		try(Scanner scanner = new Scanner(System.in)) {
			int N = scanner.nextInt();
			System.out.println(N);
			
			QuickFind uf = new QuickFind(N);
			while(scanner.hasNext()) {
				int p = scanner.nextInt();
				int q = scanner.nextInt();
				if(!uf.connected(p, q)) {
					uf.union(p, q);
					System.out.println(p + " " + q);
				}
			}
			
		}
	}
}
