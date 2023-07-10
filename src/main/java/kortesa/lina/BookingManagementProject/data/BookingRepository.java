package kortesa.lina.BookingManagementProject.data;

import kortesa.lina.BookingManagementProject.biz.model.Booking;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends CrudRepository<Booking, Long> {
}
