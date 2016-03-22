package query.zgrep.remote;

import query.MessageId;

public class MessageIdQuery implements SearchQuery {

	private final MessageId messageId;

	public MessageIdQuery(MessageId messageId) {
		this.messageId = messageId;
	}

	@Override
	public String getCommand() {
		return "zgrep -e \"" + messageId.getMessageId()+ "\" /space/SMSC*.zip " ;
	}

}
