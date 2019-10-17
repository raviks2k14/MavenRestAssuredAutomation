package com.rvtech;

public class RegistrationFailureResponse {
	
	public String FaultId;
	
	public String getFaultId() {
		return FaultId;
	}

	public void setFaultId(String faultId) {
		FaultId = faultId;
	}

	public String getFault() {
		return fault;
	}

	public void setFault(String fault) {
		this.fault = fault;
	}

	public String fault;

}
