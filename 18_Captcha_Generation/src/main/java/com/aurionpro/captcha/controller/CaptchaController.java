package com.aurionpro.captcha.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.captcha.entity.CaptchaGenerator;
import com.aurionpro.captcha.entity.CaptchaSettings;

import cn.apiclub.captcha.Captcha;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/app")
public class CaptchaController {
	
	@GetMapping("/generate")
    public void generateCaptcha(HttpServletResponse response, HttpSession session) throws IOException {
        Captcha captcha = CaptchaGenerator.generateCaptcha(260, 80);
        session.setAttribute("captchaAnswer", captcha.getAnswer());
        response.setContentType("image/jpeg");
        ImageIO.write(captcha.getImage(), "jpeg", response.getOutputStream());
    }
    
	@PostMapping("/verify")
    public Map<String, String> verifyCaptcha(@RequestBody Map<String, String> request, HttpSession session) {
        String userCaptchaResponse = request.get("captcha");
        String sessionCaptchaAnswer = (String) session.getAttribute("captchaAnswer");

        Map<String, String> response = new HashMap<>();

        if (sessionCaptchaAnswer != null && sessionCaptchaAnswer.equals(userCaptchaResponse)) {
            response.put("message", "Captcha Verified Successfully");
        } else {
            response.put("message", "Invalid Captcha");
        }

        return response;
    }
}
