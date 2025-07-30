// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Client2Status {
//     CLIENT2_SELECT,
//     CLIENT2_REJECT,
//     HOLD,
//     CLIENT2_FEEDBACK_PENDING,
//     CANDIDATE_MISSED_INTERVIEW,
//     RESCHEDULED,
//     POSITION_CLOSED
// }


package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Client2Status {
    CLIENT2_SELECT,
    CLIENT2_REJECT,
    HOLD,
    CLIENT2_FEEDBACK_PENDING,
    CANDIDATE_MISSED_INTERVIEW,
    RESCHEDULED,
    POSITION_CLOSED;

    @JsonCreator
    public static Client2Status fromString(String value) {
        for (Client2Status status : Client2Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Client2Status: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
