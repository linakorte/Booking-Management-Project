package kortesa.lina.BookingManagementProject.web.controller;

import kortesa.lina.BookingManagementProject.data.BookingService;
import kortesa.lina.BookingManagementProject.web.model.response.BookingRest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookings")
public class BookingController {

    private BookingService bookingService;

    @Autowired
    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public Iterable<BookingRest> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public BookingRest getBookingById(@PathVariable Long id) throws ChangeSetPersister.NotFoundException {
        return bookingService.getBookingById(id);
    }
}
