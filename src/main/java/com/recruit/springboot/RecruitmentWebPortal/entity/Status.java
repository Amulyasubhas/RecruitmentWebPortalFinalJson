// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Status {
//     PROFILE_SHARED,
//     MEETING_LINK_SHARED,
//     YET_TO_RECEIVE_UPDATED_CV
// }

package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Status {
    PROFILE_SHARED,
    MEETING_LINK_SHARED,
    YET_TO_RECEIVE_UPDATED_CV;

    @JsonCreator
    public static Status fromString(String value) {
        for (Status status : Status.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Status: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
