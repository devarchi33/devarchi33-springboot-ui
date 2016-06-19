package com.devarchi33.persistance.mongo.repository.sports;

import com.devarchi33.domain.mongo.sports.Team;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by donghoon on 2016. 6. 19..
 */
public interface TeamRepository extends MongoRepository<Team, String> {

    @Query(value = "{ 'name' : ?0 }")
    Team findByTeamName(String name);
}
