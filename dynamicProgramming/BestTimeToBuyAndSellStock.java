package dynamicProgramming;


public class BestTimeToBuyAndSellStock {
	public int maxProfit(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int curProfit = 0;
		int minPrice = prices[0];
		int maxProfit = 0;
		for(int i=1;i<prices.length;i++) {
			maxProfit = Math.max(prices[i]-minPrice, maxProfit);
			minPrice = Math.min(prices[i], minPrice);
		}
		return maxProfit;
	}

	public static int maxProfit2(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int curProfit = 0;
		int maxProfit = 0;
		for(int i=1;i<prices.length;i++) {
			curProfit = Math.max(prices[i]-prices[i-1],0);
			maxProfit += curProfit;
		}
		return maxProfit;
	}
	
	public static int maxProfit3(int[] prices) {
		if(prices == null || prices.length == 0)
			return 0;
		int maxProfit = 0;
		int[] lm = new int[prices.length];
		int[] rm = new int[prices.length];
		int minPrice = prices[0];
		lm[0] = 0;
		for(int i=1;i<prices.length;i++) {
			maxProfit = Math.max(maxProfit, prices[i]-minPrice);
			lm[i] = maxProfit;
			minPrice = Math.min(minPrice, prices[i]);
		}
		maxProfit = 0;
		int maxPrice = prices[prices.length-1];
		rm[prices.length-1] = 0;
		for(int i=prices.length-2;i>=0;i--) {
			maxProfit = Math.max(maxProfit, maxPrice-prices[i]);
			rm[i] = maxProfit;
			maxPrice = Math.max(maxPrice, prices[i]);
		}
		
		int sum = 0;
		for(int i=0;i<prices.length;i++) 
			sum = Math.max(lm[i] + rm[i],sum);
		
		return sum;

	}
	
	
//	local[i][j] = max(global[i - 1][j - 1] + max(diff, 0), local[i - 1][j] + diff)
//	global[i][j] = max(local[i][j], global[i - 1][j])，
	public static int maxProfit4(int k,int[] prices) {
		int[] local = new int[k+1];
		int[] global = new int[k+1];
		if(k > prices.length)
			return maxProfit2(prices);
		for(int i=0; i<prices.length; i++) {
			int diff = prices[i]-prices[i-1];
			for(int j=k;j>=1;j--) {
				local[j] = Math.max(global[j-1]+Math.max(diff, 0),local[j]+diff);
				global[j] = Math.max(global[j], local[j]);
			}
		}
		return global[k];
		
		
	}
	public static void main(String[] args) {
		int[] a = new int[100000000];
		maxProfit4(1000000, new int[]{106,373,495,46,359,919,906,440,783,583,784,73,238,701,972,308,165,774,990,675,737,990,713,157,211,880,961,132,980,136,285,239,628,221,948,939,28,541,414,180,171,640,297,873,59,814,832,611,868,633,101,67,396,264,445,548,257,656,624,71,607,67,836,14,373,205,434,203,661,793,45,623,140,67,177,885,155,764,363,269,599,32,228,111,102,565,918,592,604,244,982,533,781,604,115,429,33,894,778,885,145,888,577,275,644,824,277,302,182,94,479,563,52,771,544,794,964,827,744,366,548,761,477,434,999,86,1000,5,99,311,346,609,778,937,372,793,754,191,592,860,748,297,610,386,146,220,7,113,657,438,482,700,158,884,877,964,777,139,809,489,383,92,581,970,899,947,864,443,490,825,674,906,402,270,416,611,949,476,775,899,837,796,227,232,226,11,266,889,215,6,182,430,5,706,994,128,359,841,439,263,491,689,638,485,763,695,135,800,763,54,569,387,112,316,193});
	}
}
