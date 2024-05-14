package miniproject1;

import java.util.Scanner;

public class SmartPhone {

	Addr[] addrList;
	int count = 0;
	Scanner sc;

	// 생성자
	public SmartPhone() {
		addrList = new Addr[10];
		sc = new Scanner(System.in);
	}

	// 입력 메소드 Addr객체 return
	public Addr inputAddrData() {
		System.out.print("이름:");
		String name = sc.nextLine();
		System.out.print("전화번호:");
		String phone = sc.nextLine();
		System.out.print("이메일:");
		String email = sc.nextLine();
		System.out.print("주소:");
		String addr = sc.nextLine();
		System.out.print("그룹(친구/가족):");
		String group = sc.nextLine();

		return new Addr(name, phone, email, addr, group);
	}

	// 추가 메소드
	public void addAddr(Addr Addr) {
		if (count == 10) {
			System.out.println("데이터가 가득 찼습니다.삭제 후 다시 등록해 주세요.");
		} else {
			addrList[count] = Addr;
			count++;
			System.out.println(">>>>데이터가 저장되었습니다.(" + count + ")");
		}
	}

	// 객체 출력 메소드
	public void printAddr(Addr Addr) {
		System.out.println("이름:" + Addr.getName());
		System.out.println("전화번호:" + Addr.getPhone());
		System.out.println("이메일:" + Addr.getEmail());
		System.out.println("주소:" + Addr.getAddr());
		System.out.println("그룹(친구/가족):" + Addr.getGroup());
		System.out.println("------------------------");
	}

	// 모든객체 출력 메소드
	public void printAllAddr() {
		for (int i = 0; i < count; i++) {
			printAddr(addrList[i]);
		}
	}

	// name으로 찾는 메소드
	public void searchAddr(String name) {
		for (int i = 0; i < count; i++) {
			if (addrList[i].getName().equals(name)) {
				printAddr(addrList[i]);
			}
		}
	}

	// name으로 값 찾아서 삭제하는 메소드
	public void deleteAddr(String name) {
		for (int i = 0; i < count; i++) {
			if (addrList[i].getName().equals(name)) {
				for (int j = i; j < count; j++) {
					addrList[j] = addrList[j + 1];
				}
				addrList[count - 1] = null;
				count--;
				break;
			}
		}

	}

	// name으로 값을 찾아 수정해 newAddr에 저장해 addrList에 할당
	public void editAddr(String name, Addr newAddr) {
		for (int i = 0; i < count; i++) {
			if (addrList[i].getName().equals(name)) {
				addrList[i] = newAddr;
				break;
			}
		}
	}
}