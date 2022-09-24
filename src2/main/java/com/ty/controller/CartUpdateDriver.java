package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartUpdateDriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id to upadte");
		int id=s.nextInt();
		System.out.println("enter email to update");
		String email=s.next();
		System.out.println("enter password to upadte ");
		String pas=s.next();
		System.out.println("enter username  to update");
		String us=s.next();
		System.out.println("enter address  to update");
		String address=s.next();
		Cart c=new Cart();
		c.setId(id);
		c.setEmail(email);
		c.setPassword(pas);
		c.setUsername(us);
		c.setAddress(address);
		CartDAO cd=new CartDAO();
		Cart res=cd.updateCart(c);
		System.out.println(res);

	}

	

}
