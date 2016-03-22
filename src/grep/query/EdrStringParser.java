package query;

public class EdrStringParser {
//	sequenceNum,timestamp,cdrType,origAgentType,origAgentId,destAgentType,destAgentId,origAddress,destAddress,userMsgRef,
//	result,reasonContext,reason,attemptCount,cdrKey,dcs,protocolIdentifier,msgLength,notificationRequested,
//	serviceCentreTimestamp,origImsi,destImsi,origMscRoutingIndicator,origMscAddress,destMscRoutingIndicator,
//	destMscAddress,prepaidData,msgContent,smsType,origAddressNpi,origAddressTon,destAddressNpi,destAddressTon,isLastPart,
//	chargingId,concatInfo,sourceAddressMNPInfo,destAddressMNPInfo
	
	// ,20121218080007,2,3,1542821307,,1542821307,905074955721,905543264788,87,0,0,0,0,-001463808156:600a08:13bac7a2f52:3b01,0,,0,0,20121218080000,,286032400284461,,905590101003,,905590101003,,,1,,,,,1,,,E001,
	
	
			
			
			
	public SmscEdr parseEdrString(EdrString edrString) {
		edrFields = edrString.getString().split(",", -1);
		SmscEdr smscEdr = new SmscEdr();
		smscEdr.setEdrString(edrString);
		
		smscEdr.setSequenceNumber(getNextField());
		smscEdr.setTimestamp(getNextField());
		smscEdr.setCdrType(getNextField());
		smscEdr.setOrigAgentType(getNextField());
		smscEdr.setOrigAgentId(getNextField());
		smscEdr.setDestAgentType(getNextField());
		smscEdr.setDestAgentId(getNextField());
		smscEdr.setOrigAddress(getNextField());
		smscEdr.setDestAddress(getNextField());
		smscEdr.setUserMessageReference(getNextField());
		smscEdr.setOperationResult(getNextField());
		smscEdr.setOperationErrorContext(getNextField());
		smscEdr.setOperationErrorCode(getNextField());
		// smscEdr.setOperationState(getNextField());
		smscEdr.setAttemptCount(getNextField());
		smscEdr.setCdrKey(getNextField());
		smscEdr.setDataCodingScheme(getNextField());
		smscEdr.setProtocolIdentifier(getNextField());
		smscEdr.setMessageLength(getNextField());
		smscEdr.setNotificationRequest(getNextField());
		smscEdr.setServiceCenterTimestamp(getNextField());
		smscEdr.setOrigImsi(getNextField());
		smscEdr.setDestImsi(getNextField());
		smscEdr.setOrigMSCRoutingIndicator(getNextField());
		smscEdr.setOrigMSCAddress(getNextField());
		smscEdr.setDestMSCRoutingIndicator(getNextField());
		smscEdr.setDestMSCAddress(getNextField());
		smscEdr.setPrepaidData(getNextField());
		smscEdr.setMessageContent(getNextField());
//		smscEdr.setOriginalOrigAddress(getNextField());
//		smscEdr.setOriginalOrigSubAddress(getNextField());
//		smscEdr.setOriginalDestAddress(getNextField());
//		smscEdr.setOriginalDestSubAddress(getNextField());
//		smscEdr.setOrigMIN(getNextField());
//		smscEdr.setDestMIN(getNextField());
//		smscEdr.setTeleserviceIdentifier(getNextField());
//		smscEdr.setOrigESN(getNextField());
//		smscEdr.setDestESN(getNextField());
		 smscEdr.setSMSType(getNextField());
		 smscEdr.setOrigAddressNPI(getNextField());
		 smscEdr.setOrigAddressTON(getNextField());
		 smscEdr.setDestAddressNPI(getNextField());
		 smscEdr.setDestAddressTON(getNextField());
		 smscEdr.setIsLastPart(getNextField());
		 smscEdr.setChargingId(getNextField());
//		 smscEdr.setChargingAmount(getNextField());
		// smscEdr.setExpiryTime(getNextField());
		 smscEdr.setConcatInfo(getNextField());
//		 smscEdr.setSMPPClientId(getNextField());
//		 smscEdr.setDestAddressTON(getNextField());
		 smscEdr.setSourceAddressMNPInfo(getNextField());
		 smscEdr.setDestAddressMNPInfo(getNextField());
//		 smscEdr.setSourceProtocolSpecificId(getNextField());
//		 smscEdr.setDestProtocolSpecificId(getNextField());
//		 smscEdr.setContentEncryptKeyAlias(getNextField());

		resetIndex();
		return smscEdr;
	}

	private void resetIndex() {
		index = 0;
	}

	String[] edrFields;
	int index = 0;

	private String getNextField() {
		String string = edrFields[index];
		index++;
		return string;
	}

}
