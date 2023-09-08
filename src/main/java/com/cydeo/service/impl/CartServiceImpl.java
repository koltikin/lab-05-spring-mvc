package com.cydeo.service.impl;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class CartServiceImpl implements CartService {
    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){

        Product product = productService.findProductById(productId);
        CartItem cartItem = new CartItem();

        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));

        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        CART.getCartItemList().add(cartItem);

        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        CartItem cartItem = CART.getCartItemList().stream().
                filter(product->product.getProduct().getId().equals(productId)).findFirst().get();
        CART.getCartItemList().remove(cartItem);

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(cartItem.getTotalAmount()));

        return true;
    }
}
