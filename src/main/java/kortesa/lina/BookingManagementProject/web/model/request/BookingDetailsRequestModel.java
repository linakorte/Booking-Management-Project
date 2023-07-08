package kortesa.lina.BookingManagementProject.web.model.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class BookingDetailsRequestModel {

    @NotNull(message="Visitor name cannot be null")
    @Size(min=2, message = "Visitor name must not be less than 2 characters")
    private String visitor;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int lenghtOfStay;
    private int amountOfPeople;

    public String getVisitor() {
        return visitor;
    }

    public void setVisitor(String visitor) {
        this.visitor = visitor;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public void setArrivalDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public LocalDate getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(LocalDate departureDate) {
        this.departureDate = departureDate;
    }

    public int getLenghtOfStay() {
        return lenghtOfStay;
    }

    public void setLenghtOfStay(int lenghtOfStay) {
        this.lenghtOfStay = lenghtOfStay;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int amountOfPeople) {
        this.amountOfPeople = amountOfPeople;
    }
}
