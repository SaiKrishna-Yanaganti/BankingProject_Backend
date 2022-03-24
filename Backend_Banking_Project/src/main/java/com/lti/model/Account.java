package com.lti.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account")
public class Account {

	
		
		private long accountNumber;
		
		@Id
		private long transactionId;
		private String transactionType;
		private int amount;
		private long toAccount;
		private String toName;
		private LocalDate onDate;
		private String remarks;
		public Account() {
			super();
			// TODO Auto-generated constructor stub
		}
		public long getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(long accountNumber) {
			this.accountNumber = accountNumber;
		}
		public long getTransactionId() {
			return transactionId;
		}
		public void setTransactionId(long transactionId) {
			this.transactionId = transactionId;
		}
		public String getTransactionType() {
			return transactionType;
		}
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public long getToAccount() {
			return toAccount;
		}
		public void setToAccount(long toAccount) {
			this.toAccount = toAccount;
		}
		public String getToName() {
			return toName;
		}
		public void setToName(String toName) {
			this.toName = toName;
		}
		public LocalDate getOnDate() {
			return onDate;
		}
		public void setOnDate(LocalDate onDate) {
			this.onDate = onDate;
		}
		public String getRemarks() {
			return remarks;
		}
		public void setRemarks(String remarks) {
			this.remarks = remarks;
		}
		@Override
		public int hashCode() {
			return Objects.hash(accountNumber, amount, onDate, remarks, toAccount, toName, transactionId,
					transactionType , remarks);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Account other = (Account) obj;
			return Objects.equals(accountNumber, other.accountNumber) && amount == other.amount
					&& Objects.equals(onDate, other.onDate) && Objects.equals(remarks, other.remarks)
					&& Objects.equals(toAccount, other.toAccount) && Objects.equals(toName, other.toName)
					&& transactionId == other.transactionId && Objects.equals(transactionType, other.transactionType)
							&& Objects.equals(remarks, other.remarks);
		}
		public Account(long accountNumber, long transactionId, String transactionType, int amount, long toAccount,
				String toName, LocalDate onDate, String remarks) {
			super();
			this.accountNumber = accountNumber;
			this.transactionId = transactionId;
			this.transactionType = transactionType;
			this.amount = amount;
			this.toAccount = toAccount;
			this.toName = toName;
			this.onDate = onDate;
			this.remarks = remarks;
		}
		
		
		
		
	

}
