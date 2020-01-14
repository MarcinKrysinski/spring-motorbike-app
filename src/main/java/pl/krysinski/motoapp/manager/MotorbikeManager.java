package pl.krysinski.motoapp.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import pl.krysinski.motoapp.dao.MotorbikeRepository;
import pl.krysinski.motoapp.dao.entity.Motorbike;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class MotorbikeManager {

    private MotorbikeRepository motorbikeRepository;

    @Autowired
    public MotorbikeManager(MotorbikeRepository motorbikeRepository) {
        this.motorbikeRepository = motorbikeRepository;
    }

    public Optional<Motorbike> findById(Long id) {
        return motorbikeRepository.findById(id);
    }

    public Iterable<Motorbike> findAll() {
        return motorbikeRepository.findAll();
    }

    public Motorbike save(Motorbike motorbike) {
        return motorbikeRepository.save(motorbike);
    }

    public void deleteById(Long id) {
        motorbikeRepository.deleteById(id);
    }

    @EventListener(ApplicationReadyEvent.class) //wykona się przy każdym uruchomieniu aplikacji
    public void fillDb() {
        save(new Motorbike(1L, "Suzuki GS500", LocalDate.of(2005, 1, 1)));
        save(new Motorbike(2L, "Ducati Pannigale V4", LocalDate.of(2019, 4, 3)));
        save(new Motorbike(3L, "Suzuki GSXR 750", LocalDate.of(2018, 2, 23)));
    }
}
