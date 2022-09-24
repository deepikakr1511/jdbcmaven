package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class GetUserDAODriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the email id");
		String email=s.next();
		System.out.println("enter the password");
		String pwd=s.next();
		UserDAO ud=new UserDAO();
		User u=ud.getDetails(email,pwd);
		if(u!=null)
		{
			System.out.println("welcome "+u.getFname());
		}
		else
		{
			System.out.println("inavlid email and password ");
		}
		

	}

}
