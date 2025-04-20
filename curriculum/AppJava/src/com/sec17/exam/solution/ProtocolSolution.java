package com.sec17.exam.solution;

public enum ProtocolSolution {
	ENTER(100), 
	EXIT(500), 
	SEND_MESSAGE(200), 
	SECRET_MESSAGE(1000);
	
	private final int code;

	private ProtocolSolution(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
	public static ProtocolSolution findByCode(int code) {
		for (ProtocolSolution protocolSolution : ProtocolSolution.values()) {
			if (protocolSolution.getCode() == code) {
				return protocolSolution;
			}
		}
		return null;
	}
	
}