import org.testng.annotations.*;
import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.MilitaryTypes;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.List;

public class AirportTest {

    public Airport currentAirport;


    @BeforeClass
    public void createPlanes() {
        currentAirport = new Airport(AllPlanes.listOfPlanesWithExperimental);
    }

    @Test
    public void testGetTransportMilitaryPlanes() {
        List<MilitaryPlane> transportMilitaryPlanes = currentAirport.getTransportMilitaryPlanes();
        boolean hasTransportMilitaryPlanes = false;
        for (MilitaryPlane currentMilitaryPlane : transportMilitaryPlanes) {
            if ((currentMilitaryPlane.getMilitaryType() == MilitaryTypes.TRANSPORT)) {
                hasTransportMilitaryPlanes = true;
                break;
            }
        }
        Assert.assertTrue(hasTransportMilitaryPlanes);
    }

    @Test
    public void testGetPassengerPlaneWithMaxCapacity() {

        PassengerPlane planeWithMaxPassengerCapacity = new PassengerPlane("Boeing-747", 980, 16100, 70500, 242);
        PassengerPlane expectedPlaneWithBiggestPassengersCapacity = currentAirport.getPassengerPlaneWithBiggestPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithBiggestPassengersCapacity, planeWithMaxPassengerCapacity);
    }

    @Test
    public void testSortPlanesByMaxLoadCapacity() {
        currentAirport.sortByMaxLoadCapacity();
        List<? extends Plane> planesSortedByMaxLoadCapacity = currentAirport.getPlanes();

        boolean nextPlaneMaxLoadCapacityIsHigherThanCurrent = true;
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Plane currentPlane = planesSortedByMaxLoadCapacity.get(i);
            Plane nextPlane = planesSortedByMaxLoadCapacity.get(i + 1);
            if (currentPlane.getMaxLoadCapacity() > nextPlane.getMaxLoadCapacity()) {
                nextPlaneMaxLoadCapacityIsHigherThanCurrent = false;
                break;
            }
        }
        Assert.assertTrue(nextPlaneMaxLoadCapacityIsHigherThanCurrent);
    }

    @Test
    public void testHasAtLeastOneBomberInMilitaryPlanes() {
        List<MilitaryPlane> bomberMilitaryPlanes = currentAirport.getBomberMilitaryPlanes();
         boolean hasAtLeastOneBomberInMilitaryPlanes = false;
        for (MilitaryPlane currentMilitaryPlane : bomberMilitaryPlanes) {
            if ((currentMilitaryPlane.getMilitaryType() == MilitaryTypes.BOMBER)) {
                hasAtLeastOneBomberInMilitaryPlanes = true;
                break;
            }
        }
        Assert.assertTrue(hasAtLeastOneBomberInMilitaryPlanes);
    }

    @Test
    public void testExperimentalPlanesHasClassificationLevelHigherThanUnclassified(){
        List<ExperimentalPlane> ExperimentalPlanes = currentAirport.getExperimentalPlanes();
        boolean hasUnclassifiedPlanes = false;
        for(ExperimentalPlane experimentalPlane : ExperimentalPlanes){
            if(experimentalPlane.getClassificationLevel() == ClassificationLevel.UNCLASSIFIED){
                hasUnclassifiedPlanes = true;
                break;
            }
        }
        Assert.assertFalse(hasUnclassifiedPlanes);
    }
}
