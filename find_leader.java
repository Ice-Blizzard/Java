// finding leader in linear time without new array

import java.util.Scanner;

public class task {
public static void main(String[] args) {
	Scanner scan = new Scanner(System.in);
	
	System.out.println("Podaj n");
	int n = scan.nextInt();
	
	System.out.println("Podaj k");
	int k = scan.nextInt();
	
	int[] votes = new int[n];
	for(int i = 0; i < n; i++) {
		votes[i] = scan.nextInt();
	}

	int count = 0;
	int maybe_leader = -1;

	for(int i = 0; i < n; i++) {
		// new maybe_leader
		if(count == 0) {
			maybe_leader = votes[i];
			count = 1;
		}
		else {
			// number not equal to maybe_leader
			if(maybe_leader != votes[i]) {
				count--;
			}
			// number equal to maybe_leader
			else {
				count++;
			}
		}
	}
	
	// checking if our maybe_leader is real leader
	boolean is_leader = false;
	int votes_on_maybe_leader = 0;
	if(maybe_leader != -1) {
		for(int i = 0; i < n && !is_leader; i++) {
			if(maybe_leader == votes[i]) {
				votes_on_maybe_leader++;
			}
			if(votes_on_maybe_leader > n/2) {
				is_leader = true;
			}
		}
	}
	
	if(is_leader) {
		System.out.println(maybe_leader);
	}
	
	else {
		System.out.println(0);
	}
	
	}
}
