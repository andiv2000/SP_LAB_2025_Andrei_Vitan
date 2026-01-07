package ro.uvt.info.desingpatternslab2025.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping("/")
    public String home() {
        return "Welcome to Product Management API! Use /api/products to manage products.";
    }

    @GetMapping("/health")
    public String health() {
        return "Application is running!";
    }
}
