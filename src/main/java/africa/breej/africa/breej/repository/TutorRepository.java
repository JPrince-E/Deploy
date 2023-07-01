package africa.breej.africa.breej.repository;

import africa.breej.africa.breej.model.auth.Tutor;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface TutorRepository extends MongoRepository<Tutor, String>, CustomTutorRepository  {
        Optional<Tutor> findByUsername(String username);

        Optional<Tutor> findByEmail(String email);

        Optional<Tutor> findByEmailAndDeleted(String email, boolean deleted);

        Optional<Tutor> findByPhoneNumber(String phoneNumber);

        Optional<Tutor> findByPhoneNumberAndDeleted(String phoneNumber, boolean deleted);

        Boolean existsByPhoneNumberAndDeleted(String phoneNumber, boolean deleted);

        Boolean existsByPhoneNumber(String phoneNumber);

        Boolean existsByEmail(String email);

        Boolean existsByEmailAndDeleted(String email, boolean deleted);
}
