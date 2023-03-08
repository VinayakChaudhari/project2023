package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dto.CartItemDto;
import com.app.pojos.Cart;
import com.app.pojos.CartItem;
import com.app.pojos.Subject;
import com.app.pojos.User;
import com.app.repository.CartItemsRepository;
import com.app.repository.SubjectRepository;
import com.app.repository.UserRepository;

@Service
@Transactional
public class CartItemServiceImpl implements CartItemService {

	@Autowired
	private CartItemsRepository cartItemRepo;
	@Autowired
	private UserRepository userRepo;
	@Autowired
	private SubjectRepository subjectRepo;
	@Autowired
	private SubjectService subjectService;

	@Override
	public String addCartItem(CartItemDto newCartItem) {
		// TODO Auto-generated method stub
		System.out.println("inside cartimplementation !!");
		User user = userRepo.findById(newCartItem.getUserId()).get();
		// System.out.println(user);

		List<Subject> subjectList = subjectService.getAllSubject(newCartItem.getCourseId());
		Subject productToAdd = new Subject();

		for (Subject p : subjectList) {
			if (p.getId() == 4) {
				productToAdd = p;
				// System.out.println(productToAdd);
			}
		}
		System.out.println("before cartItem");
		CartItem cartItem = new CartItem();
		cartItem.setCartSubject(productToAdd);
		System.out.println(cartItem.getCartSubject());
		System.out.println("after cartItem");

		if (user.getCart() == null) {
			Cart cart = new Cart();
			cart.addCartItem(cartItem);
			user.addCart(cart);
			int totalItems = user.getCart().getTotalItems();
			user.getCart().setTotalItems(totalItems);
		} else {
			user.getCart().addCartItem(cartItem);
		//	user.addCart(user.getCart());
			int totalItems = user.getCart().getTotalItems();
			user.getCart().setTotalItems(totalItems + 1);
		}

		return "hospital booked successfully !!";
	}

}
