package miniproject4;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class SmartPhone {

	List<Addr> addrList;
	Scanner sc;

	// 생성자
	public SmartPhone() {
		addrList = new LinkedList<>();
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
		addrList.add(addr);
		System.out.println(">>>>데이터가 저장되었습니다.(" + addrList.size() + ")");
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
			for (int i = 0; i < addrList.size(); i++) {
				printAddr(addrList.get(i));
			}
		}
	}

	// name으로 찾는 메소드
	public void searchAddr(String name) {
		for (int i = 0; i < addrList.size(); i++) {
			if (addrList.get(i).getName().equals(name)) {
				printAddr(addrList.get(i));
				break;
			}
		}
	}

	// name으로 값 찾아서 삭제하는 메소드
	public void deleteAddr(String name) {
		for (int i = 0; i < addrList.size(); i++) {
			if (addrList.get(i).getName().equals(name)) {
				addrList.remove(i);
				break;
			}
		}
	}

	// name으로 값을 찾아 수정해 newAddr에 저장해 addrList에 할당
	public void editAddr(String name, Addr newAddr) {
		for (int i = 0; i < addrList.size(); i++) {
			if (addrList.get(i).getName().equals(name)) {
				addrList.set(i, newAddr);
				break;
			}
		}
	}
}
