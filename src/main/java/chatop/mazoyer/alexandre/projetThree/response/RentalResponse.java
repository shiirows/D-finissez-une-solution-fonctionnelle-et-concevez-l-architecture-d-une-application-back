package chatop.mazoyer.alexandre.projetThree.response;

import java.util.List;

import chatop.mazoyer.alexandre.projetThree.DTO.RentalDto;


public class RentalResponse {
    private List<RentalDto> rentals;

    public RentalResponse(List<RentalDto> rentals) {
        this.rentals = rentals;
    }

    public List<RentalDto> getRentals() {
        return rentals;
    }

    public void setRentals(List<RentalDto> rentals) {
        this.rentals = rentals;
    }
}
