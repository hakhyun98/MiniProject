package miniproject3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SmartPhone smartphone = new SmartPhone(); // SmartPhone 객체

		while (true) {
			printMenu();
			int num = 0;
			try {
				num = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("1부터 7까지만 입력해주세요.");
				sc.nextInt();
				continue;
			}
			sc.nextLine();

			switch (num) {
			case 1:
				smartphone.addAddr(smartphone.inputAddrData());
				break;
			case 2:
				System.out.print("찾을 이름을 입력하세요:");
				String serName = sc.nextLine();
				smartphone.searchAddr(serName);
				break;
			case 3:
				System.out.print("수정할 이름을 입력하세요:");
				String editName = sc.nextLine();
				smartphone.editAddr(editName, smartphone.inputAddrData());
				break;
			case 4:
				System.out.print("삭제할 이름을 입력하세요:");
				String delName = sc.nextLine();
				smartphone.deleteAddr(delName);
				break;

			case 5:
				smartphone.printAllAddr();
				break;
			case 6:
				smartphone.printContact();
				break;
			case 7:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				sc.close();
				break;
			default:
				System.out.println("1에서 7까지만 입력해주세요.");
			}
		}
	}

	// 메뉴 메소드
	public static void printMenu() {
		System.out.println("주소관리 메뉴-----------");
		System.out.println(">>1.연락처 등록");
		System.out.println(">>2.연락처 검색");
		System.out.println(">>3.연락처 수정");
		System.out.println(">>4.연락처 삭제");
		System.out.println(">>5.모든 연락처 출력");
		System.out.println(">>6.이롬,연락처 출력");
		System.out.println(">>7.프로그램 종료");
		System.out.println("-------------------");
		System.out.println("원하는 기능의 번호를 입력하세요.");

	}

}
