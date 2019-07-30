package stalls;

import behaviours.IReviewed;

public class IceCreamStall extends Stall implements IReviewed {

    private int rating;

    public IceCreamStall(String name, String ownerName, ParkingSpot parkingSpot, int rating) {
        super(name, ownerName, parkingSpot);
        this.rating = rating;
    }

    public int getRating() {
        return this.rating;
    }
}
