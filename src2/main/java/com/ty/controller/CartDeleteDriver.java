package com.ty.controller;

import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartDeleteDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s=new Scanner(System.in);
		System.out.println("enter the id to delete");
		int id=s.nextInt();
		Cart c=new Cart();
		c.setId(id);
		CartDAO cd=new CartDAO();
		String res=cd.deleteCart(id);
		System.out.println(res);
		
	}

}
