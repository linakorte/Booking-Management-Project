package kortesa.lina.BookingManagementProject.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;
    private String visitor;
    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private int lengthOfStay;
    private int amountOfPeople;
}
