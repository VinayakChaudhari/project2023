

package com.app.pojos;

import javax.persistence.*;


@Entity
@Table(name="cart_items")
public class CartItem extends BaseEntity {
	
	
	//CartItem *---->1 Cart
	@ManyToOne
	@JoinColumn(name="cart_id")
	private Cart cart;
	//CartItem 1--->1 Product
	@OneToOne
	@JoinColumn(name="subject_id")
	private Subject cartSubject;
	public CartItem(){
		// TODO Auto-generated constructor stub
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	public Subject getCartSubject() {
		return cartSubject;
	}
	
	public void setCartSubject(Subject cartSubject) {
		this.cartSubject = cartSubject;
	}


	
	
	
}

