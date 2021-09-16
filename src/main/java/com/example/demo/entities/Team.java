package com.example.demo.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import com.example.demo.entities.embeddables.Member;

import lombok.Data;

@Entity
@Data
public class Team {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer id;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "member", joinColumns = @JoinColumn(name = "teamid"))
	private Set<Member> teamMembers = new HashSet<>();

	public String teamName;

	@Embedded
	private Member teamLead;

}
