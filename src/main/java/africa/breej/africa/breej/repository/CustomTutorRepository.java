package africa.breej.africa.breej.repository;

import africa.breej.africa.breej.model.auth.Tutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.HashMap;

public interface CustomTutorRepository {
    Page<Tutor> findTutorByFilters(HashMap<String, Object> filters, LocalDateTime from, LocalDateTime to, Pageable pageable);

}
