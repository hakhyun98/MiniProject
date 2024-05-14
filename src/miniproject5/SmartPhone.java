package miniproject5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SmartPhone {

	int count = 1;
	Map<Integer, Addr> addrList;
	Scanner sc;

	// 생성자
	public SmartPhone() {
		addrList = new HashMap<>();
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
	public void addAddr(Addr addr) {
		addrList.put(count, addr);
		System.out.println(">>>>데이터가 저장되었습니다.(" + count + ")");
		count++;
	}

	// 객체 출력 메소드
	public void printAddr(Addr addr) {
		System.out.println("이름:" + addr.getName());
		System.out.println("전화번호:" + addr.getPhone());
		System.out.println("이메일:" + addr.getEmail());
		System.out.println("주소:" + addr.getAddr());
		System.out.println("그룹(친구/가족):" + addr.getGroup());
		System.out.println("------------------------");
	}

	// 모든객체 출력 메소드
	public void printAllAddr() {
		if (addrList.isEmpty()) {
			System.out.println("등록된 데이터가 없습니다.");
		} else {
			for (int i = 1; i <= addrList.size(); i++) {
				printAddr(addrList.get(i));
			}
		}
	}

	// name으로 찾는 메소드
	public void searchAddr(String name) {
		for (int i = 1; i <= addrList.size(); i++) {
			if (addrList.get(i).getName().equals(name)) {
				printAddr(addrList.get(i));
				break;
			} else if (!addrList.get(i).getName().equals(name)) {
				System.out.println("등록된 정보가 없습니다.");
				break;
			}
		}
	}

	// name으로 값 찾아서 삭제하는 메소드
	public void deleteAddr(String name) {
		for (int i = 1; i <= addrList.size(); i++) {
			if (addrList.get(i).getName().equals(name)) {
				addrList.remove(i);
				break;
			} else if (!addrList.get(i).getName().equals(name)) {
				System.out.println("등록된 정보가 없습니다.");
				break;
			}
		}
	}

	// name으로 값을 찾아 수정해 newAddr에 저장해 addrList에 할당
	public void editAddr(String name) {
		for (int i = 1; i <= addrList.size(); i++) {
			if (addrList.get(i).getName().equals(name)) {
				Addr newAddr = inputAddrData();
				addrList.put(i, newAddr);
				break;
			} else if (!addrList.get(i).getName().equals(name)) {
				System.out.println("등록된 정보가 없습니다.");
				break;
			}
		}
	}
}
