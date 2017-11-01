package inter.mail;

public class CustomerForm extends ActionForm{
	private String bankNo;
	private String area;
	private String email;
	private String address;
	private String mobileTel;
	private String name;
	private int ID;
	private String bankName;
	public String getBankNo(){
		return bankNo;
	}
	public void setBankNo(String bankNo){
		this.bankNo=bankNo;
	}
	public String setArea(){
		return area;
	}
	public void setArea(String area){
		this.area=area;
	}
	public String getEmail(){
		return email;
	}
}
