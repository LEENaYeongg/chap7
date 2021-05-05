package chap7;

/*final 변수 : 변경 불가 변수. 상수.
 *final 변수도 생성자에서 한번은 값을 설정할 수 있다.
 *단 명시적 초기화가 되면 안된다. => 객체별로 다른 상수값을 설정할 수 있다.
 *const 예약어로 상수 표현을 안한다.
 * */
class FinalValue {
	final int NUM;
	final int[] ARR;
	FinalValue(int num){
		this.NUM = num; //상수값 변경 가능.
		ARR = new int[5];
		for(int i=0; i<ARR.length; i++) {
			ARR[i] = (i+1) *10;
		}
	}
}

public class FinalValueEx1 {
	public static void main(String[] args) {
		FinalValue f1 = new FinalValue(100);
//		f1.NUM = 200;
		System.out.println(f1.NUM);
		FinalValue f2 = new FinalValue(200);
		System.out.println(f2.NUM);
		for(int a : f1.ARR) System.out.print(a+ ",");
		System.out.println();
		f1.ARR[0] = 100;
		f1.ARR[1] = 200;
		for(int a : f1.ARR) System.out.print(a+ ",");
//		f1.ARR = new int[10]; ==> ARR이 상수이기 때문에 배열 변경은 안되지만 각각의 상수는 변경 가능.
	}

}
