package com.oodles.book.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;


@Entity
@Data
public class Books {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long bookid;
	@Column
	private String bookname;
	@Column
	private String price;
	
	@OneToMany(cascade =CascadeType.MERGE)
	//@OneToMany(cascade=CascadeType.ALL, mappedBy="id")
	private List<Author> author;
	

}
