package miniproject3;

public class CustomerAddr extends Addr{
	public String customerNm;
	public String product;
	public String rank;
	
	public CustomerAddr(String name, String phone, String email, String addr, String group,String customerNm, String product, String rank) {
		super(name,phone,email,addr,group);
		this.customerNm = customerNm;
		this.product = product;
		this.rank = rank;
	}
	
	public String getCustomerNm() {
		return customerNm;
	}

	public void setCustomeryNm(String customerNm) {
		this.customerNm = customerNm;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
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
		System.out.println("거래처 : " + customerNm);
		System.out.println("거래품목: " + product);
		System.out.println("직급 : " + rank);
	}

}
//