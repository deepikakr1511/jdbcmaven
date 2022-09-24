package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class InsertUserDAODriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the fname ");
		String fname=s.next();
		System.out.println("enter the lname ");
		String lname=s.next();
		System.out.println("enter the email ");
		String email=s.next();
		System.out.println("enter the pwd ");
		String pwd=s.next();
		System.out.println("enter the phone ");
		long phone=s.nextLong();
		System.out.println("enter the dob ");
		String dob=s.next();
		System.out.println("enter the gender ");
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
		User res=ud.saveDetails(u);
		System.out.println(res);
		

	}

}
