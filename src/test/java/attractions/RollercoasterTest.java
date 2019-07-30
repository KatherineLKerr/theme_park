package attractions;

import org.junit.Before;
import org.junit.Test;
import people.Visitor;

import static org.junit.Assert.assertEquals;

public class RollercoasterTest {

    RollerCoaster rollerCoaster;
    Visitor visitor1;
    Visitor visitor2;
    Visitor visitor3;
    Visitor visitor4;
    Visitor visitor5;

    @Before
    public void setUp() {
        rollerCoaster = new RollerCoaster("Blue Ridge", 10);
        visitor4 = new Visitor(14, 210.00, 15.00);
    }


    @Test
    public void hasName() {
        assertEquals("Blue Ridge", rollerCoaster.getName());
    }

    @Test
    public void hasRating() {
        assertEquals(10, rollerCoaster.getRating());
    }

    @Test
    public void hasVisitCount() {
        assertEquals(0, rollerCoaster.getVisitCount());
    }

    @Test
    public void cantAccessIfTooShort() {
        visitor1 = new Visitor(14, 100.00, 15.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor1));
    }

    @Test
    public void cantAccessIfTooYoung() {
        visitor2 = new Visitor(9, 200.00, 15.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor2));
    }

    @Test
    public void cantAccessIfTooShortAndYoung() {
        visitor3 = new Visitor(1, 100.00, 15.00);
        assertEquals(false, rollerCoaster.isAllowedTo(visitor3));
    }

    @Test
    public void canAccessIfOver145cmAnd12Years() {
        assertEquals(true, rollerCoaster.isAllowedTo(visitor4));
    }

    @Test
    public void canChargeForTicket() {
        visitor5 = new Visitor(15, 180, 23);
        assertEquals(8.40, rollerCoaster.priceFor(visitor5), 0.01);
    }

    @Test
    public void canChargeDoubleForTallPeople() {
        assertEquals(16.80, rollerCoaster.priceFor(visitor4), 0.01);
    }
}