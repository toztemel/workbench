package grep.query;

public class Address {
	private String address = "";

	public Address(String address) {
		this.setAddress(address);
	}

	public String getAddress() {
		return address;
	}

	private void setAddress(String address) {
		this.address = address;
	}
}