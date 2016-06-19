package com.devarchi33.domain.mongo.sports;

import com.devarchi33.domain.constant.SportTypeName;
import com.devarchi33.domain.constant.baseball.TeamName;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

/**
 * Created by donghoon on 2016. 6. 19..
 */
@Data
@Document(collection = "teams")
public class Team implements SportType {

    private SportTypeName type;

    @Id
    private TeamName name;
    private TeamName beforeName;
    private Integer since;
    private Integer championshipCount = 0;
    private List<Integer> championshipYear;
    private Integer wins = 0;
    private Integer loses = 0;
    private Integer draws = 0;

}
