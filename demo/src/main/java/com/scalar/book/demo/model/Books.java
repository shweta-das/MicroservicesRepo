package com.scalar.book.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Entity
@Table(name = "books")
public class Books {

	@Id
	@Column(name = "id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "title", nullable = false, length = 100)
	private String title;

	@Column(name = "author", nullable = false, length = 100)
	private String author;
	
	@Column(name = "price", nullable = false, length = 100)
	private Double price;

	@Override
	public String toString() {
		return "Book{" 
				+ "bookid=" + id 
				+ ", title='" + title + '\'' 
				+ ", author='" + author + '\'' 		
				+ ", price =" + price 
				+ '}';
	}
	
	public Books(Integer id, String title, String author, Double price) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = price;
	}

	public Books() {}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Books user = (Books) o;

		if (!title.equals(user.title))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return title.hashCode();
	}

}
