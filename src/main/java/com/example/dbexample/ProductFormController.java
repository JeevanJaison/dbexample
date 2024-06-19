package com.example.dbexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

@Controller
public class ProductFormController {

    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/")
    public String showAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/saveProduct")
    public String displayProduct(@ModelAttribute("product") Product product, Model model) {
        model.addAttribute("product", product);
        productRepository.save(product);
        return "product-display";
    }
}