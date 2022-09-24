package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class DeleteUserDAODriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the email id to delete");
		String email=s.next();
		User u=new User();
		UserDAO ud=new UserDAO();
		String res=ud.deleteDetails(email);
		System.out.println(res);

	}

}
