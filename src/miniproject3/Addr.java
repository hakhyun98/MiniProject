package miniproject3;

public class Addr implements ShowData{
	
	private String name;
	private String phone;
	private String email;
	private String addr;
	private String group;
	
	//생성자
	public Addr(String name, String phone, String email, String addr, String group) {
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.addr = addr;
		this.group = group;
	}
	public Addr() {}
	
	//getter(), setter()
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}
	
	@Override
	public void showData(Addr addr) {
		System.out.println("이름 : " + addr.getName());
		System.out.println("전화번호 : " + addr.getPhone());
	}
	
	public void printAddr() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phone);
		System.out.println("이메일 : " + email);
		System.out.println("주소 : " + addr);
		System.out.println("그룹 : " + group);
	}
}
