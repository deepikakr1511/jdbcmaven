package jdbc_maven;

import java.util.Scanner;

public class MobileDAODriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean data = true;
		do {
			System.out.println("enter the choice :");
			System.out.println("1.insert mobile\n2.update mobile\n3.delete mobile\n4.get mobile");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the id ");
				int id = s.nextInt();
				System.out.println("enter the name ");
				String name = s.next();
				System.out.println("enter the brand");
				String brand = s.next();
				System.out.println("enter the colour ");
				String colour = s.next();
				System.out.println("enter the price ");
				double price = s.nextDouble();
				System.out.println("enter the ram ");
				int ram = s.nextInt();
				Mobile m = new Mobile();
				m.setId(id);
				m.setName(name);
				m.setBrand(brand);
				m.setColour(colour);
				m.setPrice(price);
				m.setRam(ram);
				MobileDAO md = new MobileDAO();
				String res = md.insertMobile(m);
				System.out.println(res);
				break;

			case 2:
				System.out.println("enter the id to update ");
				int id1 = s.nextInt();
				System.out.println("enter the name to be updated ");
				String name1 = s.next();
				System.out.println("enter the brand to be updated");
				String brand1 = s.next();
				System.out.println("enter the colour  to be updated");
				String colour1 = s.next();
				System.out.println("enter the price to be updated");
				double price1 = s.nextDouble();
				System.out.println("enter the ram ");
				int ram1 = s.nextInt();
				Mobile m1 = new Mobile();
				m1.setId(id1);
				m1.setName(name1);
				m1.setBrand(brand1);
				m1.setColour(colour1);
				m1.setPrice(price1);
				m1.setRam(ram1);
				MobileDAO md1 = new MobileDAO();
				String res1 = md1.updateMobile(m1);
				System.out.println(res1);
				break;
			case 3:
				System.out.println("enter id to be deleted :");
				int id3 = s.nextInt();
				MobileDAO md2 = new MobileDAO();
				String v2 = md2.deleteMobile(id3);
				System.out.println(v2);

			case 4:
				System.out.println("enter id to be fected :");
				int id4 = s.nextInt();
				MobileDAO md3 = new MobileDAO();
				Mobile m2 = md3.getMobile(id4);
				System.out.println(m2.getId());
				System.out.println(m2.getName());
				System.out.println(m2.getBrand());
				System.out.println(m2.getColour());
				System.out.println(m2.getPrice());
				System.out.println(m2.getRam());
				break;
			}
		} while (data);
	}

}
