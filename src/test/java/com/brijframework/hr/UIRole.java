package org.brijframework.hr;
public enum UIRole{
	OWNER("OWNER"),
	MANAGER("MANAGER"),
	SUPERVISER("SUPERVISER"),
	ADMIN("ADMIN"),
	CROW("CROW"),
	USER("USER");
	public String id;
	private UIRole(String id) {
		this.id=id;
	}
	@Override
	public String toString() {
		return super.toString();
	}
}
