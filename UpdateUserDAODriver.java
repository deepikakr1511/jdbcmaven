package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class UpdateUserDAODriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the email to update ");
		String email=s.next();
		System.out.println("enter the fname to update ");
		String fname=s.next();
		System.out.println("enter the lname to upadte");
		String lname=s.next();
		System.out.println("enter the pwd  to upadte");
		String pwd=s.next();
		System.out.println("enter the phone to update");
		long phone=s.nextLong();
		System.out.println("enter the dob to update");
		String dob=s.next();
		System.out.println("enter the gender to update ");
		String gender=s.next();
		User u=new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setEmail(email);
		u.setPwd(pwd);
		u.setPhone(phone);
		u.setDob(dob);
		u.setGender(gender);
		UserDAO ud=new UserDAO();
		User res=ud.updateDetails(u);
		System.out.println(res);
		

	}
	

}
