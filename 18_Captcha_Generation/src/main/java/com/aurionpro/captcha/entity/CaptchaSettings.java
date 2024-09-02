package com.aurionpro.captcha.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CaptchaSettings {
	private String captcha;
	private String hiddenCaptcha;
	private String realCaptcha;
}
