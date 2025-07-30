// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum R2Status {
//     R2_SELECT,
//     R2_REJECT,
//     HOLD,
//     R2_FEEDBACK_PENDING,
//     CANDIDATE_MISSED_INTERVIEW,
//     RESCHEDULED,
//     POSITION_CLOSED
// }

package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum R2Status {
    R2_SELECT,
    R2_REJECT,
    HOLD,
    R2_FEEDBACK_PENDING,
    CANDIDATE_MISSED_INTERVIEW,
    RESCHEDULED,
    POSITION_CLOSED;

    @JsonCreator
    public static R2Status fromString(String value) {
        for (R2Status status : R2Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid R2Status: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
