package com.devarchi33.domain.mongo;

import com.devarchi33.domain.constant.Type;
import com.devarchi33.domain.constant.baseball.Position;
import com.devarchi33.domain.constant.baseball.Team;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 18..
 */
@Data
@Document(collection = "baseball.batters")
public class Batter implements Player {

    private Type type = Type.BASEBALL;

    @Id
    private String id;
    private String name;
    private Team team;
    private Position mainPosition;
    private List<Position> positions;
    private int gameCount = 0;
    private int atBat = 0;
    private int hit = 0;
    private int secondHit = 0;
    private int thirdHit = 0;
    private int homeRun = 0;
    private Float avg = 0.000f;

    public void setAvg() {
        this.avg = (this.atBat != 0 ? (float) this.hit / this.atBat : 0);
    }

}
