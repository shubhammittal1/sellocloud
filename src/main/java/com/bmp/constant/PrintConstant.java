package com.bmp.constant;

public enum PrintConstant {

	BMP_PRINT("bmpexpress"),INDIAPOST_PRINT("indiapost"),INDIAPOST_GGN_PRINT("indiapostggn"),
	INDIAPOST_HYD_PRINT("indiaposthyd");

	private final String printConstant;
	
	private PrintConstant(String printConstant) {
		this.printConstant = printConstant;
	}
	
	public String getPrintConstant() {
		return printConstant;
	}
	
	public static PrintConstant getPrintConstant(String printConstant) {
		if (printConstant != null) {
			for (PrintConstant printConst : values()) {
				if (printConstant.equalsIgnoreCase(printConst.getPrintConstant())) {
					return printConst;
				}
			}
			return PrintConstant.BMP_PRINT;
		}
		return null;
	}
}
