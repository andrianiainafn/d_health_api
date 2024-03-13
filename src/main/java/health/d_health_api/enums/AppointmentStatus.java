package health.d_health_api.enums;

import lombok.Getter;

@Getter
public enum AppointmentStatus {
    CANCELLED,
    RESCHEDULED,
    CONFIRMED,
    PENDING,
    ALL
}
