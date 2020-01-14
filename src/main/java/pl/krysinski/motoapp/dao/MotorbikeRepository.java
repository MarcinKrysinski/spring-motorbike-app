package pl.krysinski.motoapp.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.krysinski.motoapp.dao.entity.Motorbike;

@Repository
public interface MotorbikeRepository extends CrudRepository<Motorbike, Long> {
}
