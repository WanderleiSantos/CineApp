package net.itinajero.app.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.server.authentication.logout.SecurityContextServerLogoutHandler;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Repository
@RequestMapping("/admin")
public class LoginController {

    @GetMapping(value = "/logout")
    public String logout(HttpServletRequest servletRequest){
        SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
        logoutHandler.logout(servletRequest, null, null);
        return "redirect:/formLogin";
    }

    @GetMapping(value = "/index")
    public String mostrarPrincipalAdmin(Authentication authentication){
        return "admin";
    }



}
