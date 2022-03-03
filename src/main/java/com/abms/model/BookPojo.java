package com.abms.model;

public class BookPojo {
	
	private String BookId; 
	private String Author;
	private String Title;
	private Float price;
	private String Available;
	private String MemberId;
	private String IssueDate;
	private String DueDate;
	private String ReturnedDate;
	private String PublisherId;
	
	public String getPublisherId() {
		return PublisherId;
	}
	public void setPublisherId(String publisherId) {
		PublisherId = publisherId;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		BookId = bookId;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		Author = author;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public Float getPrice() {
		return price;
	}
	public void setPrice(Float price) {
		this.price = price;
	}
	public String getAvailable() {
		return Available;
	}
	public void setAvailable(String available) {
		Available = available;
	}
	public String getMemberId() {
		return MemberId;
	}
	public void setMemberId(String memberId) {
		MemberId = memberId;
	}	
	public String getIssueDate() {
		return IssueDate;
	}
	public void setIssuedate(String issueDate) {
		IssueDate = issueDate;
	}
	public String getDueDate() {
		return DueDate;
	}
	public void setDuedate(String dueDate) {
		DueDate = dueDate;
	}
	public String getReturnedDate() {
		return ReturnedDate;
	}
	public void setReturneddate(String returnedDate) {
		ReturnedDate = returnedDate;
	}
}
