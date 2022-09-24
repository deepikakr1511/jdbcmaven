package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartInsertDriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id");
		int id=s.nextInt();
		System.out.println("enter email ");
		String email=s.next();
		System.out.println("enter password ");
		String pas=s.next();
		System.out.println("enter username ");
		String us=s.next();
		System.out.println("enter address ");
		String address=s.next();
		Cart c=new Cart();
		c.setId(id);
		c.setEmail(email);
		c.setPassword(pas);
		c.setUsername(us);
		c.setAddress(address);
		CartDAO cd=new CartDAO();
		Cart res=cd.saveCart(c);
		System.out.println(res);

	}

}
