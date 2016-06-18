package com.devarchi33.service.baseball;

import com.devarchi33.domain.mongo.Batter;
import com.devarchi33.persistance.mongo.repository.BaseballlPlayerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by donghoon on 2016. 6. 18..
 */
@Service
public class BaseballService {

    private Logger logger = LoggerFactory.getLogger(BaseballService.class);

    @Autowired
    private BaseballlPlayerRepository playerRepository;

    public Batter save(Batter player) {
        logger.info("야구선수 정보 저장..");

        return playerRepository.save(player);
    }

    public Batter findByBatterName(String name) {
        return playerRepository.findByBatterName(name);
    }
}
