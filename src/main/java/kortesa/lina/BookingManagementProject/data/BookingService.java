package kortesa.lina.BookingManagementProject.data;

import kortesa.lina.BookingManagementProject.web.model.response.BookingRest;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

@Service
public class BookingService {
    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Iterable<BookingRest> getAllBookings() {
        return bookingRepository.findAll();
    }

    public BookingRest getBookingById(Long id) throws ChangeSetPersister.NotFoundException {
        return bookingRepository.findById(id)
                .orElseThrow(() -> new ChangeSetPersister.NotFoundException());
    }

}
