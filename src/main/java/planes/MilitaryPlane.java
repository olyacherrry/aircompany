package planes;

import models.MilitaryTypes;

import java.util.Objects;

public class MilitaryPlane extends Plane{

    private MilitaryTypes militaryType;

    public MilitaryPlane(String model, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, MilitaryTypes militaryType) {
        super(model, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.militaryType = militaryType;
    }

    public MilitaryTypes getMilitaryType() {
        return militaryType;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
                ", militaryType=" + militaryType +
                '}');
    }

    @Override
    public boolean equals(Object comparedObject) {
        if (this == comparedObject) return true;
        if (!(comparedObject instanceof MilitaryPlane)) return false;
        if (!super.equals(comparedObject)) return false;
        MilitaryPlane militaryPlane = (MilitaryPlane) comparedObject;
        return militaryType == militaryPlane.militaryType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), militaryType);
    }
}
