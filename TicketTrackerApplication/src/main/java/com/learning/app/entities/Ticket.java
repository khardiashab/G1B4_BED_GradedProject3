package com.learning.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "short_description")
	private String shortDescription;

	@Column(name = "content")
	private String content;

	@DateTimeFormat(pattern = "MM-dd-yyyy")
	@Column(name = "created_on", columnDefinition = "DATE DEFAULT CURRENT_DATE")
	private LocalDate createdOn;

	// Constructors, getters, setters, and other methods...

	// Constructors
	public Ticket() {
		// Default constructor
	}

	public Ticket(Long id, String title, String shortDescription, String content, LocalDate createdOn) {
		this.id = id;
		this.title = title;
		this.shortDescription = shortDescription;
		this.content = content;
		this.createdOn = createdOn;
	}

	public Ticket(String title, String shortDescription, String content) {
		this.title = title;
		this.shortDescription = shortDescription;
		this.content = content;
		// this.createdOn = new Date();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", title=" + title + ", createdOn=" + createdOn + "]";
	}
}
