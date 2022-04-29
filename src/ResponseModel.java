
public class ResponseModel {
	private String FirstRelayStatus;
	private String SecondRelayStatus;
	private String SurgeProtectStatus;
	private String IPResp;
	private String GatewayResp;
	private String SubnetResp;
	private String MacResp;
	private String MajorMinorPatch;
	
	private BitInformation info;

	public BitInformation getInfo() {
		return info;
	}

	public String getFirstRelayStatus() {
		return FirstRelayStatus;
	}
	public void setFirstRelayStatus(String firstRelayStatus) {
		FirstRelayStatus = firstRelayStatus;
	}
	public String getSecondRelayStatus() {
		return SecondRelayStatus;
	}
	public void setSecondRelayStatus(String secondRelayStatus) {
		SecondRelayStatus = secondRelayStatus;
	}
	public String getSurgeProtectStatus() {
		return SurgeProtectStatus;
	}
	public void setSurgeProtectStatus(String surgeProtectStatus) {
		SurgeProtectStatus = surgeProtectStatus;
	}
	public String getIPResp() {
		return IPResp;
	}
	public void setIPResp(String iPResp) {
		IPResp = iPResp;
	}
	public String getGatewayResp() {
		return GatewayResp;
	}
	public void setGatewayResp(String gatewayResp) {
		GatewayResp = gatewayResp;
	}
	public String getSubnetResp() {
		return SubnetResp;
	}
	public void setSubnetResp(String subnetResp) {
		SubnetResp = subnetResp;
	}
	public String getMacResp() {
		return MacResp;
	}
	public void setMacResp(String macResp) {
		MacResp = macResp;
	}
	public String getMajorMinorPatch() {
		return MajorMinorPatch;
	}
	public void setMajorMinorPatch(String majorMinorPatch) {
		MajorMinorPatch = majorMinorPatch;
	}
	
	
}
