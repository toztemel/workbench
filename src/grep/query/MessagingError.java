package query;

public class MessagingError {
	
	
//	OP_CONTEXT_SMSC = 0;
//	OP_CONTEXT_SMPP = 1;
//	OP_CONTEXT_UCP = 2;
//	OP_CONTEXT_GSM_MAP_ERROR = 3;
//	OP_CONTEXT_FIXED_LINE_SMS_P1 = 5
//	OP_CONTEXT_GSM_SMS_SMTL_ERROR= 6
//	OP_CONTEXT_IS41_ERROR= 7
//	OP_CONTEXT_USSD = 8
//	OP_CONTEXT_PARLAYX_SMS = 9

	private String errorContext;

	private String errorCode;
	
	public MessagingError(String errorContext, String errorCode) {
		this.errorContext = errorContext;
		this.errorCode = errorCode;
	}
	
	public String getErrorContext() {
		return errorContext;
	}

	public String getErrorCode() {
		return errorCode;
	}

}