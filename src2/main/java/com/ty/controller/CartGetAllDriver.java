package com.ty.controller;

import java.util.List;
import java.util.Scanner;

import com.ty.dao.CartDAO;
import com.ty.dto.Cart;

public class CartGetAllDriver {

	public static void main(String[] args) {
		Scanner s=new Scanner(System.in);
		CartDAO cd=new CartDAO();
		List<Cart> l=cd.getAllCart();
		System.out.println(l);
	}

}
