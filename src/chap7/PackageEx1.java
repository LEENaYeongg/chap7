package chap7;

import java.util.Date;

import chap7.test.Pack2;

/* 패키지 예제
 * package
 * 	클래스들의 모임
 * 	클래스의 이름은 패키지 명을 포함한다.
 *  package 설정은 파일의 처음에 한번만 가능하다.
 *   = 하나에 파일에 있는 모든 클래스는 같은 패키지에 속한 클래스다. 
 *   
 *   import : 클래스 이름의 패키지명을 생략할 수 있도록 미리 사용될 클래스의 이름을 선언.
 *   클래스의 패키지명을 생략 할 수 있는 경우
 *   1. 같은 패키지에 속한 클래스는 패키지 명을 생략 가능함.
 *   2. 
 * 
 * */
class Pack1 {
	void method() {
		System.out.println("chap7.Pack1 클래스의 method() 메서드");
	}
}
public class PackageEx1 {
	public static void main(String[] args) {
		 java.util.Date today = new java.util.Date();
	      System.out.println(today);
	      Date today2 = new Date();
	      Pack1 p = new Pack1();
	      p.method();
	      //Pack2의 method 호출하기
	      Pack2 p2 = new Pack2() ;//에러 이유: Pack2는 같은 패키지에 없음. 따라서 직접 패키지 명을 써주거나, import 필수
	    p2.method();

	}

}
