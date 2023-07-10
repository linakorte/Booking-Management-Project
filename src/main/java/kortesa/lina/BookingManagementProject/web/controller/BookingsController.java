package kortesa.lina.BookingManagementProject.web.controller;

import kortesa.lina.BookingManagementProject.biz.model.Booking;
import kortesa.lina.BookingManagementProject.data.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bookings")
public class BookingsController {
    private BookingRepository bookingRepository;

    public BookingsController(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    @ModelAttribute("bookings")
    public Iterable<Booking> getBookings() {
        return bookingRepository.findAll();
    }

    @ModelAttribute
    public Booking getBooking() {
        return new Booking();
    }

    @GetMapping
    public String showBookingsPage() {
        return "bookings";
    }

    @PostMapping
    public String saveBooking(Booking booking) {
        bookingRepository.save(booking);
        return "redirect:bookings";
    }
}
