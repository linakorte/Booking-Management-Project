package kortesa.lina.BookingManagementProject.web.controller;

import jakarta.validation.Valid;
import kortesa.lina.BookingManagementProject.biz.model.Booking;
import kortesa.lina.BookingManagementProject.data.BookingRepository;
import kortesa.lina.BookingManagementProject.data.FileStorageRepository;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/bookings")
public class BookingsController {
    public static final String DISPO = """
            attachment; filename="%s"
            """;
    private BookingRepository bookingRepository;
    private FileStorageRepository fileStorageRepository;

    public BookingsController(BookingRepository bookingRepository,
                              FileStorageRepository fileStorageRepository) {

        this.bookingRepository = bookingRepository;
        this.fileStorageRepository = fileStorageRepository;
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

    @GetMapping("/images/{resource}")
    public ResponseEntity<Resource> getResource(@PathVariable String resource) {
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, String.format(DISPO, resource))
                .body(fileStorageRepository.findByName(resource));
    }

    @PostMapping
    public String saveBooking(@Valid Booking booking, Errors errors, @RequestParam("docFilename") MultipartFile docFile) throws IOException {
        if (!errors.hasErrors()) {
            fileStorageRepository.save(docFile.getOriginalFilename(),docFile.getInputStream());
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
