package stalls;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class TobaccoStallTest {

    TobaccoStall tobaccoStall;
    Visitor visitor1;
    Visitor visitor2;

    @Before
    public void setUp() throws Exception {
        tobaccoStall = new TobaccoStall("Jacks Drum", "Jack Jarvis", ParkingSpot.B1);
    }

    @Test
    public void hasName() {
        assertEquals("Jacks Drum", tobaccoStall.getName());
    }

    @Test
    public void hasOwner() {
        assertEquals("Jack Jarvis", tobaccoStall.getOwnerName());
    }

    @Test
    public void hasParkingSpot() {
        assertEquals(ParkingSpot.B1, tobaccoStall.getParkingSpot());
    }

    @Test
    public void canAccessIfLessThan15() {
        visitor1 = new Visitor(5, 4.5, 10.0);
        assertEquals(true, tobaccoStall.isAllowedTo(visitor1));
    }

    @Test
    public void cannotAccessIfMoreThan15() {
        visitor2 = new Visitor(25, 5.9, 50.0);
        assertEquals(false, tobaccoStall.isAllowedTo(visitor2));
    }
}
