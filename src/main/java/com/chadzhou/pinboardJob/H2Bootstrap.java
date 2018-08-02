package com.chadzhou.pinboardJob;

import com.chadzhou.pinboardJob.entity.PinboardEntity;
import com.chadzhou.pinboardJob.repository.PinboardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
public class H2Bootstrap implements CommandLineRunner {
    @Autowired
    PinboardRepository pinboardRepository;

    @Override
    public void run(String... args) throws Exception {
        pinboardRepository.save(new PinboardEntity("500"));
        pinboardRepository.save(new PinboardEntity("600"));
        pinboardRepository.save(new PinboardEntity("700"));

        Iterable<PinboardEntity> pinboardEntities = pinboardRepository.findAll();
        System.out.println("printing out data");
        for (PinboardEntity pinboardEntity : pinboardEntities) {
            System.out.println(pinboardEntity.getPinboardId());
        }
    }
}
