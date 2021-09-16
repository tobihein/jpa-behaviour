package com.example.demo.entities.embeddables;

import javax.persistence.Embeddable;
import javax.persistence.Embedded;
import javax.persistence.Transient;

import lombok.Data;

@Embeddable
@Data
public class Member {
	private String firstName;

	private String lastName;
	
	@Transient
	private String displayName;

	@Embedded
	private Address address;
}
