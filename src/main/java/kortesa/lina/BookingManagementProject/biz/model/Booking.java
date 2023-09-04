package kortesa.lina.BookingManagementProject.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Visitor can not be empty")
    private String visitor;

    @NotNull(message = "Date of arrival must be specified")
    private LocalDate arrivalDate;

    @NotNull(message = "Date of departure must be specified")
    private LocalDate departureDate;
    private int lengthOfStay;

    @DecimalMin(value = "1", message = "Amount of people must be at least 1")
    @NotNull(message = "Amount of people must be specified")
    private int amountOfPeople;

    private String docFilename;
}
