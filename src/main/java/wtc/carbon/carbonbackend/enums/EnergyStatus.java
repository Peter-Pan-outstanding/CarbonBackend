package wtc.carbon.carbonbackend.enums;

import lombok.Getter;

@Getter
public enum EnergyStatus {
    NORMAL(0),
    ABNORMAL(1),
    MAINTENANCE(2);

    private final int value;

    EnergyStatus(int value) {
        this.value = value;
    }

    public static EnergyStatus fromValue(int value) {
        for (EnergyStatus status : EnergyStatus.values()) {
            if (status.getValue() == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown status value: " + value);
    }
}
