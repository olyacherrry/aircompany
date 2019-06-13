import models.MilitaryTypes;
import planes.ExperimentalPlane;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.*;

/**
 * Class Airport - used for sorting listOfPlanesWithExperimental in given listOfPlanesWithExperimental.
 *
 * @author Vitali Shulha
 * @version 1.1
 * @since 4-Jan-2019
 */

public class Airport {
    private List<? extends Plane> planes;
    private static final int FIRST_INDEX = 0;

    public Airport(List<? extends Plane> planes) {
        this.planes = planes;
    }


    public List<PassengerPlane> getPassengerPlanes() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>();
        for (Plane p : planes) {
            if (p instanceof PassengerPlane) {
                passengerPlanes.add((PassengerPlane) p);
            }
        }
        return passengerPlanes;
    }

    public List<MilitaryPlane> getMilitaryPlanes() {
        List<MilitaryPlane> militaryPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof MilitaryPlane) {
                militaryPlanes.add((MilitaryPlane) plane);
            }
        }
        return militaryPlanes;
    }

    public PassengerPlane getPassengerPlaneWithBiggestPassengersCapacity() {
        List<PassengerPlane> passengerPlanes = new ArrayList<>(getPassengerPlanes());
        PassengerPlane passengerPlaneWithBiggestCapacity = passengerPlanes.get(FIRST_INDEX);
        for (PassengerPlane currentPassengerPlane : passengerPlanes) {
            if (currentPassengerPlane.getPassengersCapacity() > passengerPlaneWithBiggestCapacity.getPassengersCapacity()) {
                passengerPlaneWithBiggestCapacity = currentPassengerPlane;
            }
        }
        return passengerPlaneWithBiggestCapacity;
    }

    public List<MilitaryPlane> getTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane currentPlane : militaryPlanes) {
            if (currentPlane.getMilitaryType() == MilitaryTypes.TRANSPORT) {
                transportMilitaryPlanes.add(currentPlane);
            }
        }
        return transportMilitaryPlanes;
    }

    public List<MilitaryPlane> getBomberMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = new ArrayList<>();
        List<MilitaryPlane> militaryPlanes = getMilitaryPlanes();
        for (MilitaryPlane currentPlane : militaryPlanes) {
            if (currentPlane.getMilitaryType() == MilitaryTypes.BOMBER) {
                bomberMilitaryPlanes.add(currentPlane);
            }
        }
        return bomberMilitaryPlanes;

    }

    public List<ExperimentalPlane> getExperimentalPlanes() {
        List<ExperimentalPlane> ExperimentalPlanes = new ArrayList<>();
        for (Plane plane : planes) {
            if (plane instanceof ExperimentalPlane) {
                ExperimentalPlanes.add((ExperimentalPlane) plane);
            }
        }
        return ExperimentalPlanes;
    }

    public Airport sortByMaxDistance() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane comparedPlane1, Plane comparedPlane2) {
                return comparedPlane1.getMaxFlightDistance() - comparedPlane2.getMaxFlightDistance();
            }
        });
        return this;
    }


    public Airport sortByMaxSpeed() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane comparedPlane1, Plane comparedPlane2) {
                return comparedPlane1.getMS() - comparedPlane2.getMS();
            }
        });
        return this;
    }

    public Airport sortByMaxLoadCapacity() {
        Collections.sort(planes, new Comparator<Plane>() {
            public int compare(Plane comparedPlane1, Plane comparedPlane2) {
                return comparedPlane1.getMaxLoadCapacity() - comparedPlane2.getMaxLoadCapacity();
            }
        });
        return this;
    }

    public List<? extends Plane> getPlanes() {
        return planes;
    }

    private void print(Collection<? extends Plane> planesCollectionToPrint) {
        for (Plane currentPlane : planesCollectionToPrint) {
            System.out.println(currentPlane);
        }
    }

    @Override
    public String toString() {
        return "Airport{" +
                "listOfPlanesWithExperimental=" + planes.toString() +
                '}';
    }

}
