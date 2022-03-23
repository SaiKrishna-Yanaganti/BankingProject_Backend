package com.lti.model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Customer")
public class Customer {
	
	private String title;
	private String firstName;
	private String lastName;
	private String middleName;
	private String mobileNumber;
	private String email;
	private String aadharNumber;
	private String dob;
	private String address;
	private long accountNumber;
	@Id
	private String userName;
	private String password;
	private int accountBalance;
	private String accountStatus;

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAadharNumber() {
		return aadharNumber;
	}

	public void setAadharNumber(String aadharNumber) {
		this.aadharNumber = aadharNumber;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(int accountBalance) {
		this.accountBalance = accountBalance;
	}
	

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Customer(String title, String firstName, String lastName, String middleName, String mobileNumber,
			String email, String aadharNumber, String dob, String address, long accountNumber, String userName,
			String password, int accountBalance,String accountStatus) {
		super();
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.aadharNumber = aadharNumber;
		this.dob = dob;
		this.address = address;
		this.accountNumber = accountNumber;
		this.userName = userName;
		this.password = password;
		this.accountBalance = accountBalance;
		this.accountStatus = accountStatus;
	}

	@Override
	public String toString() {
		return "Customer [title=" + title + ", firstName=" + firstName + ", lastName=" + lastName + ", middleName="
				+ middleName + ", mobileNumber=" + mobileNumber + ", email=" + email + ", aadharNumber=" + aadharNumber
				+ ", dob=" + dob + ", address=" + address + ", accountNumber=" + accountNumber + ", userName="
				+ userName + ", password=" + password + ", accountBalance=" + accountBalance + ", accountStatus="+accountStatus+"]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(aadharNumber, accountBalance, accountNumber, address, dob, email, firstName, lastName,
				middleName, mobileNumber, password, title, userName,accountStatus);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(aadharNumber, other.aadharNumber) && Objects.equals(accountBalance, other.accountBalance)
				&& Objects.equals(accountNumber, other.accountNumber) && Objects.equals(address, other.address)
				&& Objects.equals(dob, other.dob) && Objects.equals(email, other.email)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(lastName, other.lastName)
				&& Objects.equals(middleName, other.middleName) && Objects.equals(mobileNumber, other.mobileNumber)
				&& Objects.equals(password, other.password) && Objects.equals(title, other.title)
				&& Objects.equals(userName, other.userName)&& Objects.equals(accountStatus, other.accountStatus);
	}
	

}
