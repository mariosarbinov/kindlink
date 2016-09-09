package com.example;

public class ContactData {
	private String name;
	private String email;
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setContent(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof ContactData)) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (this.email.equals(((ContactData) obj).getEmail())
				&& this.name.equals(((ContactData) obj).getName())
				&& this.message.equals(((ContactData) obj).getMessage())) {
			return true;
		}
		return false;
	}
}
