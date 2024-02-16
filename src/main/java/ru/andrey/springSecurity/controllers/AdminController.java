package ru.andrey.springSecurity.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.andrey.springSecurity.services.AdminService;

@Controller
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/admin")
    public String showAdminPage() {
        System.out.println(123);
        adminService.doAdmin();

        return "admin";
    }
}
