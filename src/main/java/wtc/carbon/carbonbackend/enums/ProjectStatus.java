package wtc.carbon.carbonbackend.enums;

import lombok.Getter;

@Getter
public enum ProjectStatus {
    IN_PROGRESS(0),
    COMPLETED(1),
    PAUSED(2),
    CANCELED(3);

    private final int value;

    ProjectStatus(int value) {
        this.value = value;
    }

    public static ProjectStatus fromValue(int value) {
        for (ProjectStatus status : ProjectStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown project status value: " + value);
    }
}
