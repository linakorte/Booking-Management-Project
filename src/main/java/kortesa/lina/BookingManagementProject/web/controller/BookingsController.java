package kortesa.lina.BookingManagementProject.web.controller;

import jakarta.validation.Valid;
import kortesa.lina.BookingManagementProject.biz.model.Booking;
import kortesa.lina.BookingManagementProject.data.BookingRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

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
    public String saveBooking(@Valid Booking booking, Errors errors) {
        if (!errors.hasErrors()) {
            bookingRepository.save(booking);
            return "redirect:bookings";
        }
        return "bookings";
    }

    @PostMapping(params = "delete=true")
    public String deleteBookings(@RequestParam Optional<List<Long>> selections) {
        if (selections.isPresent()) {
            bookingRepository.deleteAllById(selections.get());
        }
        return "redirect:bookings";
    }

    @PostMapping(params = "edit=true")
    public String editBooking(@RequestParam Optional<List<Long>> selections, Model model) {
        System.out.println(selections);
        if (selections.isPresent()) {
            Optional<Booking> booking = bookingRepository.findById(selections.get().get(0));
            model.addAttribute("booking", booking);
        }
        return "bookings";
    }
}
