import java.util.*;

class Fibonacci {
	static Map<Integer, Integer> fibMap = new HashMap<Integer, Integer>();

	public static void main(String[] args) {
		fibMap.put(1, 0);
	        fibMap.put(2, 1);

		System.out.println(fib(Integer.parseInt(args[0])));
	}

	static int fib(int n ) {
		if(fibMap.containsKey(n)) return fibMap.get(n);
		
		fibMap.put(n, fib(n-1)+fib(n-2));
		return fibMap.get(n); 
	}
}
