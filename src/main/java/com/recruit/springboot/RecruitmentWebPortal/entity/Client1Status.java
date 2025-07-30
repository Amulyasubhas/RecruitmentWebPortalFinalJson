// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Client1Status {
//     CLIENT1_SELECT,
//     CLIENT1_REJECT,
//     HOLD,
//     CLIENT1_FEEDBACK_PENDING,
//     CANDIDATE_MISSED_INTERVIEW,
//     RESCHEDULED,
//     POSITION_CLOSED
// }


package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Client1Status {
    CLIENT1_SELECT,
    CLIENT1_REJECT,
    HOLD,
    CLIENT1_FEEDBACK_PENDING,
    CANDIDATE_MISSED_INTERVIEW,
    RESCHEDULED,
    POSITION_CLOSED;

    @JsonCreator
    public static Client1Status fromString(String value) {
        for (Client1Status status : Client1Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Client1Status: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
