package com.devarchi33.domain.constant.baseball;

import lombok.Getter;

/**
 * Created by donghoon on 2016. 6. 18..
 */

public enum Position {
    
    PITCHER(1), CATCHER(2), FIRST(3), SECOND(4), THIRD(5), SHORTSTOP(6), LEFT(7), CENTER(8), RIGHT(9), DH(10);

    @Getter
    private int num;

    Position(int num) {
        this.num = num;
    }

}
