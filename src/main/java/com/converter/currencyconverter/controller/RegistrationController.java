package com.converter.currencyconverter.controller;

import com.converter.currencyconverter.entity.User;
import com.converter.currencyconverter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("error", " ");
        return "registration";
    }

    @PostMapping("/registration")
    public String addNewUser(String userName, String password, Model model)
    {
        String retValueEndPoint = "main";
        User   userExist = null;

        if (userName == null || userName.isEmpty())
        {
            model.addAttribute("error", "Не указан пароль!");
            retValueEndPoint = "registration";
        }
        else
        {
            userExist = userService.findUserByUserName(userName);

            if (userExist == null)
            {
                try
                {
                    userService.addNewUser(userName, password);
                    retValueEndPoint = "redirect:/login";
                }
                catch (Exception exceptionMessage)
                {
                    model.addAttribute("error", exceptionMessage);
                    retValueEndPoint = "registration";
                }
            }
            else
            {
                model.addAttribute("error", "Пользователь уже существует");
                retValueEndPoint = "registration";
            }
        }

        return retValueEndPoint;
    }

}

/*
@GetMapping("/registration")
    public String registration()
    {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user, Map<String, Object> model)
    {
       User userFromDB = userRepo.findByUsername(user.getUsername());

       if (userFromDB != null)
       {
            model.put("message", "Такой пользователь уже существует");

            return "registration";
       }

       user.setActive(true);
       user.setRoles(Collections.singleton(Role.USER));
       userRepo.save(user);

       return "redirect:/login";//Редирект на страницу ввода логина и пароля
    }
 */