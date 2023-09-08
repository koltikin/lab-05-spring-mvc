package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.impl.CartServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

import static com.cydeo.service.impl.CartServiceImpl.CART;

@Controller
@AllArgsConstructor
public class CartController {

    private final CartService cartService;
    @GetMapping("/cart")
    public String getCart(Model model){

        model.addAttribute("cartList", CartServiceImpl.CART);
        return "cart/show-cart";
    }
    @GetMapping("/cart/{productId}/{quantity}")
    public String addToCart(@PathVariable("productId") UUID productId,
                @PathVariable("quantity") Integer quantity) {

            cartService.addToCart(productId, quantity);

            return "redirect:/cart";
    }

    @GetMapping("/deleteCart/{productId}")
    public String deleteFromCart(@PathVariable("productId") UUID productId) {

        cartService.deleteFromCart(productId);

        return "redirect:/cart";
    }

}
