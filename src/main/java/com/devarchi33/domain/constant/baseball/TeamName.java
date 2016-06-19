package com.devarchi33.domain.constant.baseball;

import lombok.Getter;

/**
 * Created by donghoon on 2016. 6. 18..
 */
public enum TeamName {

    NONE("NONE"), KIA("타이거즈"), SAMSUNG("라이온즈"), LOTTE("자이언츠"), LG("트윈스"), DOOSAN("베어스"), NC("다이노스"), KT("위즈"),
    SK("와이번스"), NEXEN("히어로즈"), HANHWA("이글스"), HAETAE("타이거즈"), HYUNDAE("유니콘스"), MBC("청룡"), OB("베어스"), BINGGRAE("이글스"),
    SSANBANGUL("레이더스");

    @Getter
    private String name;

    TeamName(String name) {
        this.name = name;
    }

}
