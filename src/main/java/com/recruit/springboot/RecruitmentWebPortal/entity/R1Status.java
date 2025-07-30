// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum R1Status {
//     R1_SELECT,
//     R1_REJECT,
//     HOLD,
//     R1_FEEDBACK_PENDING,
//     CANDIDATE_MISSED_INTERVIEW,
//     RESCHEDULED,
//     POSITION_CLOSED
// }


package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum R1Status {
    R1_SELECT,
    R1_REJECT,
    HOLD,
    R1_FEEDBACK_PENDING,
    CANDIDATE_MISSED_INTERVIEW,
    RESCHEDULED,
    POSITION_CLOSED;

    @JsonCreator
    public static R1Status fromString(String value) {
        for (R1Status status : R1Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid R1Status: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
