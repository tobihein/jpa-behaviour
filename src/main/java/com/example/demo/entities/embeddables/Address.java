package com.example.demo.entities.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Transient;

import lombok.Data;

@Embeddable
@Data
public class Address {
	private String street;
	private String city;

	@Transient
	private String displayName;

}
