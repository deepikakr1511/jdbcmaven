package jdbc_maven;

public class Product {
	private int pid;
	private String pname;
	private double price;
	private String manufacturer;
	private double discount;
	private int warrenty;
	private String mfgdate;
	private double gst;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public double getDiscount() {
		return discount;
	}
	public void setDiscount(double discount) {
		this.discount = discount;
	}
	public int getWarrenty() {
		return warrenty;
	}
	public void setWarrenty(int warrenty) {
		this.warrenty = warrenty;
	}
	public String getMfgdate() {
		return mfgdate;
	}
	public void setMfgdate(String mfgdate) {
		this.mfgdate = mfgdate;
	}
	public double getGst() {
		return gst;
	}
	public void setGst(double gst) {
		this.gst = gst;
	}
	@Override
	public String toString() {
		return "Product [pid=" + pid + ", pname=" + pname + ", price=" + price + ", manufacturer=" + manufacturer
				+ ", discount=" + discount + ", warrenty=" + warrenty + ", mfgdate=" + mfgdate + ", gst=" + gst + "]\n";
	}
	
	
	
	

}
