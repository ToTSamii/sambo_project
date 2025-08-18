package com.example.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.models.Priem;
import com.example.repositiories.IndexRepository;

@Service
public class IndexService {

    private IndexRepository repository = new IndexRepository();
    
    public List<Priem> getIndex() {
        System.out.println("[Log : get-запрос на '/', (возвращение списка приёмов)]");
        return repository.getTable();
    }

    public void postIndex(Priem priem) {
        System.out.println("[Log : post-запрос на '/', (принимается приём)]");
        repository.postTable(priem);
    }

    public void deleteIndex(int id) {
        System.out.println("[Log : delete-запрос на '/', (принимается id приёма для удаления)]");
        repository.deleteTable(id);
    }

    public void putIndex(int id, Priem priem) {
        System.out.println("[Log : put-запрос на '/', (принимается id запроса и данные для замены)]");
        repository.putTable(id, priem);
    }

}
