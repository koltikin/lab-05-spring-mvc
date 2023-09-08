package com.cydeo.controller;


import com.cydeo.model.Product;
import com.cydeo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;
    @GetMapping("/list")
    public String productList(Model model){

        model.addAttribute("products",productService.listProduct());
        return "/product/list";
    }

    @GetMapping("/create-product")
    public String createProduct(Model model){

        model.addAttribute("product",new Product());


        return "/product/create-product";
    }

    @PostMapping("/create-product")
    public String saveProduct(@ModelAttribute("product") Product product){

        productService.productCreate(product);

        return "redirect:/list";
    }

}
