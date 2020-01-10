package leetcode;

public class Java122 {
	public static void main(String[] args) {
		int prices[] = {2,1,4,5,2,9,7};
		System.out.println(maxProfit(prices));
	}

	public static int maxProfit(int[] prices) {
		int sum=0;
		int len = prices.length;
		
		for(int i =0;i<len-1;i++) {
			if(prices[i]<prices[i+1])
				sum+=(prices[i+1]-prices[i]);
		}
		return sum;
	}
//	public static int maxProfit(int[] prices) {
//		int size = prices.length;
//		int sum = 0;
//		int cur = 0;
//		int buy = 0;
//
//		outer: for (int i = 0; i < size - 1; i++) {
//			buy = prices[i];
//			cur=0;
//			for (int j = i + 1; j < size; j++) {
//				if (buy > prices[j])
//					continue outer;
//				if (prices[j] > cur) {
//					cur = prices[j];
//					sum+=cur-buy;
//					buy=cur;
//					i=j;
//					if(j==size-1)
//						return sum;
//				}
//				if (prices[j] < cur) {
//					continue outer;
//				}
//			}
//		}

//		return sum;
//	}
}
