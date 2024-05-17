package com.bookblog.demo.service;

import com.bookblog.demo.entity.Scribble;
import com.bookblog.demo.repository.ScribbleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ScribbleService {

    @Autowired
    private ScribbleRepository scribbleRepository;

    public Scribble createScribble(Scribble scribble) {
        return scribbleRepository.save(scribble);
    }

    public Optional<Scribble> getScribbleById(Long id) {
        return scribbleRepository.findById(id);
    }

    public List<Scribble> getAllScribbles() {
        return scribbleRepository.findAll();
    }

    public Scribble updateScribble(Long id, Scribble scribbleDetails) {
        Scribble scribble = scribbleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Scribble not found"));

        scribble.setContent(scribbleDetails.getContent());
        // update other fields as necessary

        return scribbleRepository.save(scribble);
    }

    public void deleteScribble(Long id) {
        scribbleRepository.deleteById(id);
    }
}
