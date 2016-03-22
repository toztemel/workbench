package grep.query;

import java.io.Serializable;

public class SmscEdr implements Serializable {

	private static final long serialVersionUID = 7997549269016755624L;


	
	private String contentEncryptAlias;

	private String sequenceNumber;

	private String timeStamp;

	private String cdrType;

	private String origAgentId;

	private String origAgentType;

	private String setDestAgentType;

	private String destAgentId;

	private String origAddress;

	private String destAddress;

	private String operationResult;

	private String operationState;

	private String attemptCount;

	private String cdrKey;

	private String operationErrorCode;

	private String userMessageReference;

	private String operationErrorContext;

	private String dataCodingScheme;

	private String protocolIdentifier;

	private String messageLength;

	private String notificationRequest;

	private String serviceCenterTimestamp;

	private String origImsi;

	private String destImsi;

	private String origMSCAddress;

	private String destMSCRoutingIndicator;

	private String destMSCAddress;

	private String origMSCRoutingIndicator;

	private String prepaidData;

	private String originalOrigAddress;

	private String originalOrigSubAddress;

	private String messageContent;

	private String originalDestAddress;

	private String originalDestSubAddress;

	private String origMIN;

	private String destMIN;

	private String teleserviceIndentifier;

	private String origESN;

	private String destESN;

	private String smsType;

	private String origAddressNPI;

	private String origAddressTON;

	private String destAddressNPI;

	private String destAddressTON;

	private String isLastPart;

	private String chargingId;

	private String chargingAmount;

	private String expiryTime;

	private String concatInfo;

	private String sMPPClientId;

	private String sourceAddressMNPInfo;

	private String destAddressMNPInfo;

	private String sourceProtocolSpecificId;

	private String destProtocolSpecificId;



	private EdrString edrString;

	// public String getEdr() {
	// return edr;
	// }
	//
	// public void setEdr(String edr) {
	// this.edr = edr;
	// }

	public void setContentEncryptKeyAlias(String string) {
		this.contentEncryptAlias = string;
	}

	public void setSequenceNumber(String string) {
		this.sequenceNumber = string;
	}

	public void setTimestamp(String string) {
		this.timeStamp = string;
	}

	public void setCdrType(String string) {
		this.cdrType = string;
	}

	public void setOrigAgentId(String string) {
		this.origAgentId = string;
	}

	public void setOrigAgentType(String string) {
		this.origAgentType = string;
	}

	public void setDestAgentType(String string) {
		this.setDestAgentType = string;
	}

	public void setDestAgentId(String string) {
		this.destAgentId = string;
	}

	public void setOrigAddress(String string) {
		this.origAddress = string;
	}

	public void setDestAddress(String string) {
		this.destAddress = string;
	}

	public void setOperationResult(String string) {
		this.operationResult = string;
	}

	public void setOperationState(String string) {
		this.operationState = string;
	}

	public void setAttemptCount(String string) {
		this.attemptCount = string;
	}

	public void setCdrKey(String string) {
		this.cdrKey = string;
	}

	public void setOperationErrorCode(String string) {
		this.operationErrorCode = string;
	}

	public void setUserMessageReference(String string) {
		this.userMessageReference = string;
	}

	public void setOperationErrorContext(String string) {
		this.operationErrorContext = string;
	}

	public void setDataCodingScheme(String string) {
		this.dataCodingScheme = string;

	}

	public void setProtocolIdentifier(String string) {
		this.protocolIdentifier = string;

	}

	public void setMessageLength(String string) {
		this.messageLength = string;

	}

	public void setNotificationRequest(String string) {
		this.notificationRequest = string;

	}

	public void setServiceCenterTimestamp(String string) {
		this.serviceCenterTimestamp = string;

	}

	public void setOrigImsi(String string) {
		this.origImsi = string;

	}

	public void setDestImsi(String string) {
		this.destImsi = string;

	}

	public void setOrigMSCAddress(String string) {
		this.origMSCAddress = string;

	}

	public void setDestMSCRoutingIndicator(String string) {
		this.destMSCRoutingIndicator = string;

	}

	public void setDestMSCAddress(String string) {
		this.destMSCAddress = string;

	}

	public void setOrigMSCRoutingIndicator(String string) {
		this.origMSCRoutingIndicator = string;

	}

	public void setPrepaidData(String string) {
		this.prepaidData = string;

	}

	public void setOriginalOrigAddress(String string) {
		this.originalOrigAddress = string;

	}

	public void setOriginalOrigSubAddress(String string) {
		this.originalOrigSubAddress = string;

	}

	public void setMessageContent(String string) {
		this.messageContent = string;

	}

	public void setOriginalDestAddress(String string) {
		this.originalDestAddress = string;

	}

	public void setOriginalDestSubAddress(String string) {
		this.originalDestSubAddress = string;

	}

	public void setOrigMIN(String string) {
		this.origMIN = string;

	}

	public void setDestMIN(String string) {
		this.destMIN = string;

	}

	public void setTeleserviceIdentifier(String string) {
		this.teleserviceIndentifier = string;

	}

	public void setOrigESN(String string) {
		this.origESN = string;

	}

	public void setDestESN(String string) {
		this.destESN = string;

	}

	public void setSMSType(String string) {
		this.smsType = string;

	}

	public void setOrigAddressNPI(String string) {
		this.origAddressNPI = string;

	}

	public void setOrigAddressTON(String string) {
		this.origAddressTON = string;

	}

	public void setDestAddressNPI(String string) {
		this.destAddressNPI = string;

	}

	public void setDestAddressTON(String string) {
		this.destAddressTON = string;

	}

	public void setIsLastPart(String string) {
		this.isLastPart = string;

	}

	public void setChargingId(String string) {
		this.chargingId = string;
	}

	public void setChargingAmount(String string) {
		this.chargingAmount = string;
	}

	public void setExpiryTime(String string) {
		this.expiryTime = string;
	}

	public void setConcatInfo(String string) {
		this.concatInfo = string;
	}

	public void setSMPPClientId(String string) {
		this.sMPPClientId = string;
	}

	public void setSourceAddressMNPInfo(String string) {
		this.sourceAddressMNPInfo = string;
	}

	public void setDestAddressMNPInfo(String string) {
		this.destAddressMNPInfo = string;
	}

	public void setSourceProtocolSpecificId(String string) {
		this.sourceProtocolSpecificId = string;
	}

	public void setDestProtocolSpecificId(String string) {
		this.destProtocolSpecificId = string;
	}

	public String getContentEncryptAlias() {
		return contentEncryptAlias;
	}

	public void setContentEncryptAlias(String contentEncryptAlias) {
		this.contentEncryptAlias = contentEncryptAlias;
	}

	public String getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	public String getSetDestAgentType() {
		return setDestAgentType;
	}

	public void setSetDestAgentType(String setDestAgentType) {
		this.setDestAgentType = setDestAgentType;
	}

	public String getMessageLength() {
		return messageLength;
	}

	public String getTeleserviceIndentifier() {
		return teleserviceIndentifier;
	}

	public void setTeleserviceIndentifier(String teleserviceIndentifier) {
		this.teleserviceIndentifier = teleserviceIndentifier;
	}

	public String getSmsType() {
		return smsType;
	}

	public void setSmsType(String smsType) {
		this.smsType = smsType;
	}

	public String getsMPPClientId() {
		return sMPPClientId;
	}

	public void setsMPPClientId(String sMPPClientId) {
		this.sMPPClientId = sMPPClientId;
	}

	public String getSequenceNumber() {
		return sequenceNumber;
	}

	public String getCdrType() {
		return cdrType;
	}

	public String getOrigAgentId() {
		return origAgentId;
	}

	public String getOrigAgentType() {
		return origAgentType;
	}

	public String getDestAgentId() {
		return destAgentId;
	}

	public String getOrigAddress() {
		return origAddress;
	}

	public String getDestAddress() {
		return destAddress;
	}

	public String getOperationResult() {
		return operationResult;
	}

	public String getOperationState() {
		return operationState;
	}

	public String getAttemptCount() {
		return attemptCount;
	}

	public String getCdrKey() {
		return cdrKey;
	}

	public String getOperationErrorCode() {
		return operationErrorCode;
	}

	public String getUserMessageReference() {
		return userMessageReference;
	}

	public String getOperationErrorContext() {
		return operationErrorContext;
	}

	public String getDataCodingScheme() {
		return dataCodingScheme;
	}

	public String getProtocolIdentifier() {
		return protocolIdentifier;
	}

	public String getNotificationRequest() {
		return notificationRequest;
	}

	public String getServiceCenterTimestamp() {
		return serviceCenterTimestamp;
	}

	public String getOrigImsi() {
		return origImsi;
	}

	public String getDestImsi() {
		return destImsi;
	}

	public String getOrigMSCAddress() {
		return origMSCAddress;
	}

	public String getDestMSCRoutingIndicator() {
		return destMSCRoutingIndicator;
	}

	public String getDestMSCAddress() {
		return destMSCAddress;
	}

	public String getOrigMSCRoutingIndicator() {
		return origMSCRoutingIndicator;
	}

	public String getPrepaidData() {
		return prepaidData;
	}

	public String getOriginalOrigAddress() {
		return originalOrigAddress;
	}

	public String getOriginalOrigSubAddress() {
		return originalOrigSubAddress;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public String getOriginalDestAddress() {
		return originalDestAddress;
	}

	public String getOriginalDestSubAddress() {
		return originalDestSubAddress;
	}

	public String getOrigMIN() {
		return origMIN;
	}

	public String getDestMIN() {
		return destMIN;
	}

	public String getOrigESN() {
		return origESN;
	}

	public String getDestESN() {
		return destESN;
	}

	public String getOrigAddressNPI() {
		return origAddressNPI;
	}

	public String getOrigAddressTON() {
		return origAddressTON;
	}

	public String getDestAddressNPI() {
		return destAddressNPI;
	}

	public String getDestAddressTON() {
		return destAddressTON;
	}

	public String getIsLastPart() {
		return isLastPart;
	}

	public String getChargingId() {
		return chargingId;
	}

	public String getChargingAmount() {
		return chargingAmount;
	}

	public String getExpiryTime() {
		return expiryTime;
	}

	public String getConcatInfo() {
		return concatInfo;
	}

	public String getSourceAddressMNPInfo() {
		return sourceAddressMNPInfo;
	}

	public String getDestAddressMNPInfo() {
		return destAddressMNPInfo;
	}

	public String getSourceProtocolSpecificId() {
		return sourceProtocolSpecificId;
	}

	public String getDestProtocolSpecificId() {
		return destProtocolSpecificId;
	}

	public void setEdrString(EdrString edr) {
		this.edrString = edr;
		
	}

	public String getEdrString() {
		return this.edrString.getString();
	}

}