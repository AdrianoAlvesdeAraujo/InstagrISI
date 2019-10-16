package com.ServerSpring.Instagrao.repository;

import com.ServerSpring.Instagrao.models.Instagrao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InstagraoRepository extends JpaRepository<Instagrao, Long> {

}
