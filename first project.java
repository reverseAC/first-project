import java.util.Scanner;

public class Operations {

	public static String str = "";// 保存题目

	public static int sum = 0;// 保存结果

	public static int num = 0;// 保存题目中数字的总个数

	public static int num1 = 0;// 题目中已有数字个数

	public static int score = 0;//保存分数
	// 主函数
	public static void main(String[] args) {
		// int w = 1 + (int) (Math.random() * 100); //用于算式中的随机数
		// System.out.println(w);
		System.out.println("您希望算式中有几个数：");
		Scanner scan = new Scanner(System.in 

);
		num = scan.nextInt();

		// 共10题，每题10分
		for (int i = 0; i < 10; i++) {

			GreateTopic(); //生成算式
			
			System.out.print(i + 1 + ". ");  //打印算式
			System.out.print(str + "=");
			
			Scanner scan1 = new Scanner(System.in );  //输入答案
			int sum1 = scan1.nextInt();
			
			
			if(sum1 == sum){
				score += 10;
				System.out.println("正确！当前分数：" + score);
			}else{
				System.out.println("错误！");
			}
//			System.out.println(sum);
		}
	}

	// 生成题目
	private static void GreateTopic() {
		str = "";
		sum = 0;
		num1 = num; // 用前都重置
		Topic();
	}

	private static void Topic() {
		if (num1 > 1) {
			int j = num1; // 记录这是第几层的调用
			num1--;
			Topic();// 递归
			int w = (int) (Math.random() * 100); // 用于算式中的随机数

			int t = (int) (Math.random() * 100); // 用于判断选用何种运算的随机数
			int f = (int) (Math.random() * 100); // 同t
			if (t > 50) {  //加法
				if (f > 50) {
					sum = sum + w;
					str = str + "+" + String.valueOf(w) ;
				} else {
					sum = sum - w;
					str = str + "-" + String.valueOf(w) ;
				}
			} else {  //减法
				if (f > 50) {
					sum = w + sum;
					str = String.valueOf(w) + "+" + str;
				} else {
					if (j < 3) {  //当数字小于2个，不用加括号
						sum = w - sum;
						str = String.valueOf(w) + "-" + str;
					} else {
						sum = w - sum;
						str = String.valueOf(w) + "-" + "(" + str + ")";
					}
				}
			}
		} else {
			// 最后一层，也是输出的第一层
			int w = (int) (Math.random() * 100);
			sum = sum + w;
			str = str + String.valueOf(w);
		}
	}

}
