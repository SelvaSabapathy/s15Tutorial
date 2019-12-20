package com.sabapathy.tutorial.api.mvc.controller;

import com.sabapathy.tutorial.api.mvc.mapper.MvcUserMapper;
import com.sabapathy.tutorial.api.mvc.model.MvcLoginRequest;
import com.sabapathy.tutorial.api.mvc.model.MvcRoleRequest;
import com.sabapathy.tutorial.api.mvc.model.MvcUserRequest;
import com.sabapathy.tutorial.service.api.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.Arrays;
import java.util.HashSet;

@Slf4j

@Controller
@RequestMapping("/tutorial")
public class MvcLoginController {

    @Autowired
    private MvcUserMapper mvcUserMapper;

    @Autowired
    private UserService userService;

    private boolean isCaptchaMatching() {
        log.debug("Verifying the captcha...");
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        Object generatedCaptcha = request.getSession().getAttribute("captchaSecurityCode");

        String userEnteredCaptcha = request.getParameter("captcha");
        return userEnteredCaptcha.equals(generatedCaptcha);
    }

    @GetMapping("/register")
    public ModelAndView register() {
        return new ModelAndView("register", "register", new MvcUserRequest());
    }

    @PostMapping(value = "/save")
    public String save(@Valid @ModelAttribute("register") MvcUserRequest mvcUserRequest, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("message", "Error - " + bindingResult.getFieldErrors().get(0).getDefaultMessage());
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:register";
        }

        if (!isCaptchaMatching()) {
            redirectAttributes.addFlashAttribute("message", "Error - Captcha entered is incorrect");
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:register";
        }

        log.debug("MVC User Request: " + mvcUserRequest);

        mvcUserRequest.setRoles(new HashSet<MvcRoleRequest>(Arrays.asList(new MvcRoleRequest("USER"))));
        userService.addUser(mvcUserMapper.toUser(mvcUserRequest));

        redirectAttributes.addFlashAttribute("message", "Successfully registered");
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");

        return "redirect:register";
    }

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("login", "login", new MvcLoginRequest());
    }

    @PostMapping(value = "/auth")
    public String auth(@Valid @ModelAttribute("login") MvcLoginRequest mvcLoginRequest, BindingResult bindingResult) {
        log.debug("MVC Login Request: " + mvcLoginRequest);

//        userService.(mvcUserMapper.toUser(mvcUserRequest));

        return "home";
    }
}
