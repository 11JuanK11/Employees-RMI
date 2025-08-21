package com.example2.demo2;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;


@Controller
@RequestMapping("/orders")
public class OrderController {

    private final RestTemplate restTemplate;
    private final List<Order> ordenes = new ArrayList<>();

    public OrderController(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    @GetMapping
    public String showOrders(Model model) {
        Product[] products = restTemplate.getForObject(
                "http://localhost:8081/products/", Product[].class);

        model.addAttribute("productos", products);
        model.addAttribute("ordenes", ordenes);
        model.addAttribute("orden", new Order(0, "", 1));

        return "orders-list";
    }

    @PostMapping
    public String createOrder(@ModelAttribute Order orden) {
        orden.setId(ordenes.size() + 1);
        ordenes.add(orden);
        return "redirect:/orders";
    }
}