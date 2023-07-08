package kortesa.lina.BookingManagementProject.data;

import kortesa.lina.BookingManagementProject.web.model.response.BookingRest;
import org.springframework.data.repository.CrudRepository;

public interface BookingRepository extends CrudRepository<BookingRest, Long> {
}
