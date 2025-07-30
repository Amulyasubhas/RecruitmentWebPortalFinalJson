// package com.recruit.springboot.RecruitmentWebPortal.entity;

// public enum Client {
//     REACH_INDIA,
//     ROBOSOFT
// }



package com.recruit.springboot.RecruitmentWebPortal.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum Client {
    REACH_INDIA,
    ROBOSOFT;

    @JsonCreator
    public static Client fromString(String value) {
        for (Client client : Client.values()) {
            if (client.name().equalsIgnoreCase(value)) {
                return client;
            }
        }
        throw new IllegalArgumentException("Invalid Client: " + value);
    }

    @JsonValue
    public String toValue() {
        return this.name();
    }
}
