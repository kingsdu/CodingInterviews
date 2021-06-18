package DoExercise.HSP_ZCY.A027_位图;

public class Code03_EvenTimesOddTimes {

	// arr中，只有一种数，出现奇数次
	public static void printOddTimesNum1(int[] arr) {
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		System.out.println(eor);//异或运算无所谓顺序，剩下的最后一定是一个奇数次的数
	}

	// arr中，有两种数，出现奇数次
	//1 异或求出a ^ b
	//2 所以 a ^ b的最后一个1一定不相同，所以可以将其分为两类：最后一位是1和最后一位不是1
	//3 将所有的数与 最后一位是1的 &，这样可以将上面的2类中其中一类拿到。
	//4 在将这一类与eor ^ 求出另一个
	public static void printOddTimesNum2(int[] arr) {
		int eor = 0;
		for (int i = 0; i < arr.length; i++) {
			eor ^= arr[i];
		}
		// eor = a ^ b
		// eor != 0
		// eor必然有一个位置上是1
		//00101101000
		//00000001000 == eor & (~eor + 1);
		int rightOne = eor & (~eor + 1); // 提取出最右的1,先把所有的数取反，+1以后，最右侧的1之前的数就会复原，其他的位与原数&都会变为0
		int onlyOne = 0; // eor'
		for (int i = 0 ; i < arr.length;i++) {//2
			if ((arr[i] & rightOne) != 0) {//rightOne位置上的有1
				onlyOne ^= arr[i];
			}
		}
		System.out.println(onlyOne + " " + (eor ^ onlyOne));
	}

	public static void main(String[] args) {
		int a = 5;
		int b = 7;

		a = a ^ b;
		b = a ^ b;
		a = a ^ b;

		System.out.println(a);
		System.out.println(b);

		int[] arr1 = { 3, 3, 2, 3, 1, 1, 1, 3, 1, 1, 1 };
		printOddTimesNum1(arr1);

		int[] arr2 = { 4, 3, 4, 2, 2, 2, 4, 1, 1, 1, 3, 3, 1, 1, 1, 4, 2, 2 };
		printOddTimesNum2(arr2);

	}

}
