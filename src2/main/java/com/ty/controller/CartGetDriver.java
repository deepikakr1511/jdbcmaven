package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartGetDriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id");
		int id=s.nextInt();
		CartDAO cd=new CartDAO();
		Cart c=cd.getCart(id);
		System.out.println(c.getId());
		System.out.println(c.getEmail());
		System.out.println(c.getPassword());
		System.out.println(c.getUsername());
		System.out.println(c.getAddress());
	}

}
