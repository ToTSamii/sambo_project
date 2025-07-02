package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.Priem;
import com.example.repositiories.IndexRepository;

@Service
public class IndexService {

    private IndexRepository repository = new IndexRepository();
    
    public List<Priem> getIndex() {
        return repository.getTable();
    }

    public void postIndex(Priem priem) {
        repository.postTable(priem);
    }

    public void deleteIndex(int id) {
        repository.deleteTable(id);
    }

    public void putIndex(int id, Priem priem) {
        repository.putTable(id, priem);
    }

}
