package kortesa.lina.BookingManagementProject.data;

import kortesa.lina.BookingManagementProject.biz.model.Booking;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

//@Component
public class BookingDataLoader implements ApplicationRunner{
    private BookingRepository bookingRepository;

    public BookingDataLoader(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Iterable<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (bookingRepository.count() == 0) {
            List<Booking> bookings = List.of(
                    new Booking(null, "Dim Zaf", LocalDate.of(2023,06,30), LocalDate.of(2023, 7, 9), 9, 6)
            );
            bookingRepository.saveAll(bookings);
        }
    }

}
