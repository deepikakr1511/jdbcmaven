package jdbc_maven;

import java.util.Scanner;

public class PersonDriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean data = true;
		do {
			System.out.println("enter the choice :");
			System.out.println("1.save person\n2.update person\n3.get person");
			int choice = s.nextInt();
			switch (choice) {
			case 1:
				System.out.println("enter the id ");
				int id = s.nextInt();
				System.out.println("enter the name ");
				String name = s.next();
				System.out.println("enter the address");
				String address = s.next();
				System.out.println("enter the phone no ");
				long phone = s.nextLong();
				System.out.println("enter the pincode ");
				int pin = s.nextInt();
				Person p = new Person();
				p.setId(id);
				p.setName(name);
				p.setAddress(address);
				p.setPhone(phone);
				p.setPin(pin);
				DAO d = new DAO();
				String res = d.savePerson1(p);
				System.out.println(res);
				break;

			case 2:
				System.out.println("enter the id to update ");
				int id1 = s.nextInt();
				System.out.println("enter the name to be updated ");
				String name1 = s.next();
				System.out.println("enter the address to be updated");
				String address1 = s.next();
				System.out.println("enter the phone no  to be updated");
				long phone1 = s.nextLong();
				System.out.println("enter the pincode no to be updated");
				int pin1 = s.nextInt();
				Person p1 = new Person();
				p1.setId(id1);
				p1.setName(name1);
				p1.setAddress(address1);
				p1.setPhone(phone1);
				p1.setPin(pin1);
				DAO d1 = new DAO();
				String rs = d1.updatePerson1(p1);
				System.out.println(rs);
				break;
			case 3:
				System.out.println("enter id to be fected :");
				int id3 = s.nextInt();
				DAO d2 = new DAO();
				Person p2 = d2.getPerson1(id3);
				System.out.println(p2.getId());
				System.out.println(p2.getName());
				System.out.println(p2.getAddress());
				System.out.println(p2.getPhone());
				System.out.println(p2.getPin());
				break;
			}
		} while (data);
	}

}
