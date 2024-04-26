package miniproject;

import java.util.Scanner;

public class SmartPhoneMain {

	public static void main(String[] args){

		Scanner sc = new Scanner(System.in);
		SmartPhone smartphone = new SmartPhone();

		System.out.println("#데이터 2개를 입력합니다.");
		for (int i = 0; i < 2; i++) {
			Addr newAddr = smartphone.inputAddrData();
			smartphone.addAddr(newAddr);
		}

		while (true) {
			printMenu();
			int num = sc.nextInt();

			switch (num) {
			case 1:
				Addr newAddr = smartphone.inputAddrData();
				smartphone.addAddr(newAddr);
				break;
			case 2:
				smartphone.printAllAddr();
				break;
			case 3:
				System.out.print("찾을 이름을 입력하세요:");
				String serName = sc.nextLine();
				smartphone.searchAddr(serName);
				break;
			case 4:
				System.out.print("삭제할 이름을 입력하세요:");
				String delName = sc.nextLine();
				smartphone.deleteAddr(delName);
				break;
			case 5:
				System.out.print("수정할 이름을 입력하세요:");
				String editName = sc.nextLine();
				Addr newAddr1 = smartphone.inputAddrData();
				smartphone.editAddr(editName, newAddr1);
				break;
			case 6:
				System.out.println("프로그램을 종료합니다.");
				System.exit(0);
				break;
			default :
				System.out.println("올바른 메뉴를 선택해 주세요.");
			}
		}

	}

	public static void printMenu(){
		System.out.println("주소관리 메뉴-----------");
		System.out.println(">>1.연락처 등록");
		System.out.println(">>2.모든 연락처 출력");
		System.out.println(">>3.연락처 검색");
		System.out.println(">>4.연락처 삭제");
		System.out.println(">>5.연락처 수정");
		System.out.println(">>6.프로그램 종료");
		System.out.println("-------------------");

	}

}
