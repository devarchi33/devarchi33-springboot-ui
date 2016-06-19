package com.devarchi33.service.baseball;

import com.devarchi33.domain.mongo.sports.Team;
import com.devarchi33.persistance.mongo.repository.sports.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 19..
 */
@Service
public class TeamService {

    @Autowired
    private TeamRepository repository;

    public Team save(Team team) {
        repository.save(team);
        return team;
    }

    public List<Team> findAll() {
        return repository.findAll();
    }

    public Team findByTeamName(String name) {
        return repository.findByTeamName(name);
    }
}
