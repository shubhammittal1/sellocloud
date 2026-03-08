package com.bmp.constant;

public enum WalletResponse {
	LowBalance("Wallet is low."),RateCardNotFound("Rate card not found.");
	
	private String response;
	private WalletResponse(String response) 
    { 
        this.response = response; 
    } 
}
