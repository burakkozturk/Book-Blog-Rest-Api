package com.bookblog.demo.repository;

import com.bookblog.demo.entity.Scribble;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ScribbleRepository extends JpaRepository<Scribble, Long> {
}
