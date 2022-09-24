package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.UserDAO;
import com.ty.dto.User;

public class GetAllUserDAODriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		UserDAO ud=new UserDAO();
		List<User> u=ud.getAllDetails();
		System.out.println(u);
	}

}
