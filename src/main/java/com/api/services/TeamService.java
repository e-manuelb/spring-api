package com.api.services;

import com.api.repositories.TeamRepository;
import com.api.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
public class TeamService {

    @Autowired
    protected TeamRepository teamRepository;

    public Team save(Team team) {
        teamRepository.save(team);

        return team;
    }

    public List<Team> list() {
        return teamRepository.findAll();
    }

    public Team getById(Integer id) {
        return teamRepository.findById(id).get();
    }

    public Team update(Team team, Integer id) {
        Team existTeam = teamRepository.findById(id).get();

        if (team.getName() != null) {
            existTeam.setName(team.getName());
        }

        if (team.getYear() != null) {
            existTeam.setName(team.getYear());
        }

        team.setUpdatedAt(Instant.now());

        teamRepository.save(existTeam);

        return existTeam;
    }

    public void delete(Integer id) {
        teamRepository.deleteById(id);
    }

}
