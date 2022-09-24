package jdbc_maven;

import java.util.List;
import java.util.Scanner;

public class ProductDAODriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean data = true;
		do {
			System.out.println("enter the choice :");
			System.out.println("1.save product\n2.update product\n3.delete product\n4.get product\n5.get all product");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the pid ");
				int pid = s.nextInt();
				System.out.println("enter the pname ");
				String pname = s.next();
				System.out.println("enter the price ");
				double price = s.nextDouble();
				System.out.println("enter the manufacturer");
				String manufacturer = s.next();
				System.out.println("enter the discount ");
				double discount = s.nextDouble();
				System.out.println("enter the warrenty ");
				int warrenty = s.nextInt();
				System.out.println("enter the mfgdate ");
				String mgfdate = s.next();
				System.out.println("enter the gst ");
				double gst = s.nextDouble();
				Product p = new Product();
				p.setPid(pid);
				p.setPname(pname);
				p.setPrice(price);
				p.setManufacturer(manufacturer);
				p.setDiscount(discount);
				p.setWarrenty(warrenty);
				p.setMfgdate(mgfdate);
				p.setGst(gst);
				ProductDAO pd = new ProductDAO();
				Product res = pd.insertProduct(p);
				System.out.println(res);
				break;
			case 2:
				System.out.println("enter the pid to update");
				int pid1 = s.nextInt();
				System.out.println("enter pname to update ");
				String pname1 = s.next();
				System.out.println("enter price to update ");
				double price1 = s.nextDouble();
				System.out.println("enter manufacturer to update");
				String manufacturer1 = s.next();
				System.out.println("enter discount to update ");
				double discount1 = s.nextDouble();
				System.out.println("enter warrenty to update");
				int warrenty1 = s.nextInt();
				System.out.println("enter mfgdate to update ");
				String mgfdate1 = s.next();
				System.out.println("enter gst to update ");
				double gst1 = s.nextDouble();
				Product p1 = new Product();
				p1.setPid(pid1);
				p1.setPname(pname1);
				p1.setPrice(price1);
				p1.setManufacturer(manufacturer1);
				p1.setDiscount(discount1);
				p1.setWarrenty(warrenty1);
				p1.setMfgdate(mgfdate1);
				p1.setGst(gst1);
				ProductDAO pd1 = new ProductDAO();
				Product res1 = pd1.updateProduct(p1);
				System.out.println(res1);
				break;
			case 3:
				System.out.println("enter the pid to delete");
				int pid2 = s.nextInt();
				ProductDAO pd2 = new ProductDAO();
				String res2 = pd2.deleteProduct(pid2);
				System.out.println(res2);
				break;
			case 4:
				System.out.println("enter the pid ");
				int pid3 = s.nextInt();
				ProductDAO pd3 = new ProductDAO();
				Product p3 = pd3.getProduct(pid3);

				System.out.println(p3.getPid());
				System.out.println(p3.getPname());
				System.out.println(p3.getPrice());
				System.out.println(p3.getManufacturer());
				System.out.println(p3.getDiscount());
				System.out.println(p3.getWarrenty());
				System.out.println(p3.getMfgdate());
				System.out.println(p3.getGst());
				break;
			case 5:
				ProductDAO pd4 = new ProductDAO();
				List<Product> p4 = pd4.getAllProduct();
				System.out.println(p4);
				
				break;
			}
		} while (data);

	}
}
