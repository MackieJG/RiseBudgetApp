package com.example.risebudget.repositories;

import com.example.risebudget.models.Pot;
import org.hibernate.metamodel.model.convert.spi.JpaAttributeConverter;
import org.springframework.stereotype.Repository;

@Repository
public interface PotRepo extends JpaAttributeConverter<Pot, Long> {
}
