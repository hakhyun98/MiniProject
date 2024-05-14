package miniproject3;

import java.util.Scanner;
import java.util.regex.Pattern;

public class SmartPhone {

	Addr[] addrList;
	int count = 0;
	Scanner sc;
	Addr addresses;

	// 생성자
	public SmartPhone() {
		addresses = new Addr();
		addrList = new Addr[10];
		sc = new Scanner(System.in);
	}

	// 이름 : 공백, 한글과 영어만
	// 핸드폰 번호 : 중복, 전화번호 형식
	// 검사및 오류처리
	public String getMenu(String menuStr) {
		String str = null;
		while (true) {
			System.out.print(menuStr);
			str = sc.nextLine();
			if (str.isEmpty()) {
				try {
					throw new Exception("공백은 입력할 수 없습니다.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (menuStr.equals("전화번호: ") && existPhone(str)) {
				try {
					throw new Exception("이미 등록된 번호입니다.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (menuStr.equals("전화번호: ") && checkPhone(str)) {
				try {
					throw new Exception("전화번호 형식에 맞게 입력해주세요.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			} else if (menuStr.equals("이름: ") && checkName(str)) {
				try {
					throw new Exception("이름은 한글과 영문만 가능합니다.");
				} catch (Exception e) {
					System.out.println(e.getMessage());
					continue;
				}
			}
			break;
		}
		return str;
	}

	// 이름 정규식 (영어와 한글만 가능)
	public boolean checkName(String name) {
		boolean check = true;
		Pattern pattern = Pattern.compile("^[a-zA-Z가-힣]*$");
		if (pattern.matcher(name).find()) {
			check = false;
		}
		return check;
	}

	// 핸드폰 번호 정규식
	public boolean checkPhone(String phone) {
		boolean check = true;
		Pattern pattern = Pattern.compile("^\\d{2,3}-\\d{3,4}-\\d{4}$");
		if (pattern.matcher(phone).find()) {
			check = false;
		}
		return check;
	}

	// 핸드폰 중복 처리
	public boolean existPhone(String phone) {
		boolean isHasPhone = false;
		for (int i = 0; i < count; i++) {
			if (addrList[i].getPhone().equals(phone)) {
				isHasPhone = true;
				break;
			}
		}
		return isHasPhone;
	}

	// 입력 메소드 Addr객체 return
	public Addr inputAddrData() {
		String name = getMenu("이름: ");
		String phone = getMenu("전화번호: ");
		String addr = getMenu("주소: ");
		String email = getMenu("이메일: ");
		String group = getMenu("그룹(친구/가족/회사/거래처): ");
		if (group.equals("회사")) {
			String companyNm = getMenu("회사명: ");
			String teamNm = getMenu("부서명: ");
			String rank = getMenu("직급: ");
			return new CompanyAddr(name, phone, email, addr, group, companyNm, teamNm, rank);
		} else if (group.equals("거래처")) {
			String customerNm = getMenu("거래처: ");
			String product = getMenu("거래품목: ");
			String rank = getMenu("직급: ");
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
			addresses.showData(addrList[i]);
			System.out.println("------------------------");
		}
	}

}
