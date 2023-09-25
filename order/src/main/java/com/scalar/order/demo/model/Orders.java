package com.scalar.order.demo.model;

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
@Table(name = "orders")
public class Orders {

	@Id
	@Column(name = "id", length = 10)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "custname", nullable = false, length = 100)
	private String custname;

	@Column(name = "status", nullable = false, length = 50)
	private String status;//New | Processing | Completed | Cancelled
	
	@Column(name = "bookid", nullable = false)
	private Integer bookid;

	@Override
	public String toString() {
		return "Order{" 
				+ "id=" + id 
				+ ", custname='" + custname + '\'' 
				+ ", status='" + status + '\'' 		
				+ ", bookid =" + bookid 
				+ '}';
	}
	
	public Orders(Integer id, String custname, String status, Integer bookid) {
		this.id = id;
		this.custname = custname;
		this.status = status;
		this.bookid = bookid;
	}

	public Orders() {}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Orders user = (Orders) o;

		if (!custname.equals(user.custname))
			return false;

		return true;
	}

	@Override
	public int hashCode() {
		return custname.hashCode();
	}

}
