package chap7;

import java.util.Date;

import chap7.test.Pack2;

/* ��Ű�� ����
 * package
 * 	Ŭ�������� ����
 * 	Ŭ������ �̸��� ��Ű�� ���� �����Ѵ�.
 *  package ������ ������ ó���� �ѹ��� �����ϴ�.
 *   = �ϳ��� ���Ͽ� �ִ� ��� Ŭ������ ���� ��Ű���� ���� Ŭ������. 
 *   
 *   import : Ŭ���� �̸��� ��Ű������ ������ �� �ֵ��� �̸� ���� Ŭ������ �̸��� ����.
 *   Ŭ������ ��Ű������ ���� �� �� �ִ� ���
 *   1. ���� ��Ű���� ���� Ŭ������ ��Ű�� ���� ���� ������.
 *   2. 
 * 
 * */
class Pack1 {
	void method() {
		System.out.println("chap7.Pack1 Ŭ������ method() �޼���");
	}
}
public class PackageEx1 {
	public static void main(String[] args) {
		 java.util.Date today = new java.util.Date();
	      System.out.println(today);
	      Date today2 = new Date();
	      Pack1 p = new Pack1();
	      p.method();
	      //Pack2�� method ȣ���ϱ�
	      Pack2 p2 = new Pack2() ;//���� ����: Pack2�� ���� ��Ű���� ����. ���� ���� ��Ű�� ���� ���ְų�, import �ʼ�
	    p2.method();

	}

}
