package grep.query;

public interface SearchEngine {

	SmscEdrResultSet searchEdrWithMessageId(MessageId messageId);

	SmscEdrResultSet searchEdrWithSingleAddress(Address anAddress);

	SmscEdrResultSet searchEdrWithABParties(Address aParty, Address bParty);

	SmscEdrResultSet searchEdrWithErrorCode(MessagingError parameterObject);

}