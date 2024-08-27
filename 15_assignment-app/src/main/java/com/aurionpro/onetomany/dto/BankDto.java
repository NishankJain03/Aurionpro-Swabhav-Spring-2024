package com.aurionpro.onetomany.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class BankDto {
	
	private int bankId;
	private String bankName;
	private String ifscNo;
}
