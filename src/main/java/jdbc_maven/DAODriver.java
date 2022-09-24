package jdbc_maven;

import java.util.Scanner;

public class DAODriver {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		boolean data = true;
		do {
			System.out.println("enter the choice :");
			System.out.println("1.save person\n2.update person\n3.delete person\n4.get person");
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
				DAO d = new DAO();
				String v = d.savePerson(id, name, address, phone, pin);
				System.out.println(v);
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
				DAO d1 = new DAO();
				String v1 = d1.updatePerson(id1, name1, address1, phone1, pin1);
				System.out.println(v1);
				break;
			case 3:
				System.out.println("enter id to be deleted :");
				int id3 = s.nextInt();
				DAO d2 = new DAO();
				String v2 = d2.DeletePerson(id3);
				System.out.println(v2);

				break;
			case 4:
				System.out.println("enter id to be fected :");
				int id4 = s.nextInt();
				DAO d3 = new DAO();
				String v3 = d3.getPerson(id4);
				System.out.println(v3);
				break;
			}
		} while (data);

	}

}
