package com.example.demo;

import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Team;
import com.example.demo.entities.embeddables.Address;
import com.example.demo.entities.embeddables.Member;
import com.example.demo.repositories.TeamRepository;

@SpringBootTest
class DemoApplicationTests {
	@Autowired
	private TeamRepository teamRepo;

	private Random rnd = new Random();

	@Test
	void persistTeam() {
		Assertions.assertNotNull(teamRepo, () -> "TeamRepo should be autowired");
		Team team = getRandomTeam();

		int teamId = teamRepo.save(team).getId();

		Optional<Team> persistedTeam = teamRepo.findById(teamId);

		Assertions.assertTrue(persistedTeam.isPresent());

		Member teamLead = persistedTeam.get().getTeamLead();
		Member teamMember = persistedTeam.get().getTeamMembers().iterator().next();

		Assertions.assertAll( //
				() -> Assertions.assertNull(teamLead.getDisplayName(), () -> "teamlead should not have a displayName"),
				() -> Assertions.assertNull(teamMember.getDisplayName(),
						() -> "a teammember should not have a displayName"),
				() -> Assertions.assertNull(teamLead.getAddress().getDisplayName(),
						() -> "teamlead-address should not have a displayName"),
				() -> Assertions.assertNull(teamMember.getAddress().getDisplayName(),
						() -> "a teammember-address should not have a displayName") //
		);

	}

	private Team getRandomTeam() {
		Team team = new Team();

		team.setTeamName("Team" + rnd.nextInt());
		team.setTeamLead(getRandomMember());
		team.getTeamMembers().add(getRandomMember());

		return team;
	}

	private Member getRandomMember() {
		Member member = new Member();

		member.setFirstName("firstName" + rnd.nextInt());
		member.setLastName("lastName" + rnd.nextInt());
		member.setDisplayName("Transient DisplayName for Member");
		member.setAddress(getRandomAddress());

		return member;
	}

	private Address getRandomAddress() {
		Address address = new Address();

		address.setCity("city" + rnd.nextInt());
		address.setStreet("street" + rnd.nextInt());
		address.setDisplayName("Transient DisplayName for City");

		return address;
	}

}
