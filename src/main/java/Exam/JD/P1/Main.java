package Exam.JD.P1;

import java.util.HashMap;
import java.util.Scanner;

/*
计算分子量：给出一种至多只含 C、H、O、N 四种元素的有机物的分子式(不带括号)，求分子量。
已知：C、H、O、N 的原子量分别为12, 1, 16, 14。
例如：C6H5OH的分子量为94，CH3COOH的分子量为60。
思路：就是从左到右遍历，用element记录上一个分子是C、H、O还是N，当前数字读完后，用对应数字和分子量相乘，计算出一部分
	  分子量，然后累加到最后的sum上。
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();	//输入的分子式
		HashMap<Character, Integer> map = new HashMap<>();	//记录各分子的分子量。
		map.put('C', 12);
		map.put('H', 1);
		map.put('O', 16);
		map.put('N', 14);
		int num = 0, sum = 0;	//num表示某一个元素element的个数，sum为最终分子量。
		char[] charArray = line.toCharArray();
		char element = charArray[0];
		for (int i = 1; i < charArray.length; i++) {
			char c = charArray[i];
			if (c >= '0' && c <= '9') num = num * 10 + (c - '0');	//读到数字，但可能是不止一位，所以记录一下数字大小。
			else {//读到元素，那此时num就是上一元素的数量，求积并累加到结果上。
				if(num == 0) sum = sum + map.get(element);		//num为0，说明该元素后面就是其他元素，没有数字，也就是该元素只有一个，乘1就行。
				else sum = sum + num * map.get(element);	//num不为0，乘对应元素分子量并累加。
				num = 0;	//累加完，恢复num为0；element更新记录此次读取到的元素，以便下一次计算。
				element = c;
			}
		}

		//最后一位不管是元素还是数字，都会少计算最后一类元素的分子量，补上这一步。
		if(num == 0) sum = sum + map.get(element);
		else sum = sum + num * map.get(element);

		System.out.println(sum);	//得到结果，输出。
	}
}
