package com.devarchi33.persistance.mongo.repository.sports;

import com.devarchi33.domain.mongo.sports.baseball.Batter;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

/**
 * Created by donghoon on 2016. 6. 18..
 */
public interface BaseballlPlayerRepository extends MongoRepository<Batter, String> {

    //TODO: After delete refactoring.
    @Query(value = "{ 'name' : ?0 }")
    Batter findByBatterName(String name);
}
