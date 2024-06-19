package com.example.dbexample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CartController {

    @Autowired
    private CartRepository cartRepository;
    
    @GetMapping("/cart")
    public String cart(Model model) {
        Long count = cartRepository.count();
        model.addAttribute("count",count);
        Cart cart = new Cart();
        cart.setItem("dummy");
        cartRepository.save(cart);
        return "cart-list";
    }
}