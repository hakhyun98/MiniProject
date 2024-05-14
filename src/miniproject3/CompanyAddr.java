package miniproject3;

public class CompanyAddr extends Addr{
	
	public String companyNm;
	public String teamNm;
	public String rank;
	
	public CompanyAddr(String name, String phone, String email, String addr, String group, String companyNm, String teamNm, String rank) {
		super(name,phone,email,addr,group);
		this.companyNm = companyNm;
		this.teamNm = teamNm;
		this.rank = rank;
	}
	
	public String getCompanyNm() {
		return companyNm;
	}

	public void setCompanyNm(String companyNm) {
		this.companyNm = companyNm;
	}

	public String getTeamNm() {
		return teamNm;
	}

	public void setTeamNm(String teamNm) {
		this.teamNm = teamNm;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}
	
	@Override
	public void printAddr() {
		super.printAddr();
		System.out.println("회사명 : " + companyNm);
		System.out.println("부서이름 : " + teamNm);
		System.out.println("직급 : " + rank);
	}
}
//