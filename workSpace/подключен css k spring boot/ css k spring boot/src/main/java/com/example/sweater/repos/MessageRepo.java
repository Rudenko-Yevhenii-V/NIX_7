package com.example.sweater.repos;

import com.example.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
//позволяет получить полный список или по идентификатору для работы с базой данных
public interface MessageRepo extends CrudRepository<Message, Long> {
    //найти по тегу в бд
    List<Message> findByTag(String tag);

}
