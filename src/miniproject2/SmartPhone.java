package miniproject2;

import java.util.Scanner;

public class SmartPhone {

	Addr[] addrList;
	int count = 0;
	Scanner sc;
	Addr addr;

	// 생성자
	public SmartPhone() {
		addr = new Addr();
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
		System.out.print("그룹(친구/가족/회사/거래처):");
		String group = sc.nextLine();
		if (group.equals("회사")) {
			System.out.print("회사명 : ");
			String companyNm = sc.nextLine();
			System.out.print("부서명 : ");
			String teamNm = sc.nextLine();
			System.out.print("직급 : ");
			String rank = sc.nextLine();
			System.out.print(rank);
			return new CompanyAddr(name, phone, email, addr, group, companyNm, teamNm, rank);
		} else if (group.equals("거래처")) {
			System.out.print("거래처 : ");
			String customerNm = sc.nextLine();
			System.out.print("거래품목 : ");
			String product = sc.nextLine();
			System.out.print("직급 : ");
			String rank = sc.nextLine();
			return new CustomerAddr(name, phone, email, addr, group, customerNm, product, rank);
		}
		return new Addr(name, phone, email, addr, group);
	}

	// 추가 메소드
	public void addAddr(Addr addr) {
		if (count == 10) {
			System.out.println("데이터가 가득 찼습니다.삭제 후 다시 등록해 주세요.");
		} else {
			addrList[count] = addr;
			count++;
			System.out.println(">>>>데이터가 저장되었습니다.(" + count + ")");
		}
	}

	// 객체 출력 메소드
	public void printAddr(Addr addr) {
		System.out.println("이름:" + addr.getName());
		System.out.println("전화번호:" + addr.getPhone());
		System.out.println("이메일:" + addr.getEmail());
		System.out.println("주소:" + addr.getAddr());
		System.out.println("그룹(친구/가족/회사/거래처):" + addr.getGroup());
		if (addr.getGroup().equals("회사")) {
			CompanyAddr company = (CompanyAddr) addr;
			System.out.println("회사명 : " + company.getCompanyNm());
			System.out.println("부서명 : " + company.getTeamNm());
			System.out.println("직급 : " + company.getRank());
		} else if (addr.getGroup().equals("거래처")) {
			CustomerAddr customer = (CustomerAddr) addr;
			System.out.println("거래처 : " + customer.getCustomerNm());
			System.out.println("거래 품목 : " + customer.getProduct());
			System.out.println("직급 : " + customer.getRank());
		}
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

	// 이름과 연락처만 출력하는 메소드
	public void printContact() {
		for (int i = 0; i < count; i++) {
			addr.showData(addrList[i]);
			System.out.println("------------------------");
		}
	}
}
