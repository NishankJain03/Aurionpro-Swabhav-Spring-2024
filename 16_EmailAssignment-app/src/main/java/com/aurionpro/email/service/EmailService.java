package com.aurionpro.email.service;

import com.aurionpro.email.entity.EmailDetails;

public interface EmailService {
	String sendMailWithAttachment(EmailDetails details);
}
