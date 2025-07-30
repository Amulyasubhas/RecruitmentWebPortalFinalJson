// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Onboarding {
//     YES,
//     NO,
//     HOLD,
//     POSITION_CLOSED
// }


package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Onboarding {
    YES,
    NO,
    HOLD,
    POSITION_CLOSED;

    @JsonCreator
    public static Onboarding fromString(String value) {
        for (Onboarding status : Onboarding.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Onboarding value: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
