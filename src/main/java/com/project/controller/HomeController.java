package com.project.controller;

import com.project.global.GlobalData;
import com.project.service.CategoryService;
import com.project.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class HomeController {

    private ProductService productService;
    private CategoryService categoryService;

    public HomeController(ProductService productService, CategoryService categoryService) {
        this.productService = productService;
        this.categoryService = categoryService;
    }

    @GetMapping({"/", "/home"})
    public String home(Model model) {

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "index";
    }

    @GetMapping("/shop")
    public String shop(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        model.addAttribute("categories", categoryService.getAllCategories());

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("/shop/category/{id}")
    public String shopByCategory(Model model, @PathVariable("id") Long id) {
        model.addAttribute("products", productService.getAllProductsByCategoryId(id));
        model.addAttribute("categories", categoryService.getAllCategories());

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "shop";
    }

    @GetMapping("shop/viewproduct/{id}")
    public String viewProduct(Model model, @PathVariable("id") Long id) {
        model.addAttribute("product", productService.getProductById(id).get());

        model.addAttribute("cartCount", GlobalData.cart.size());
        return "viewProduct";
    }
}
