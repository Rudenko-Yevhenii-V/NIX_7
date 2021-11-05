package com.example.sweater.domain;
// 00 0 0 0 0 0      00 00       0000000000000000000000000      00 00         00 00             00 00         00
// 00              00    00                 00                 00   00        00   00          00   00        00
// 00             00      00                00                00     00       00    00        00     00       00
// 00            00        00               00               00       00      00   00        00       00      00
// 00           00          00              00              00         00     00   00       00         00     00
// 00           00          00              00              00         00     00      00    00         00     00
// 00            00        00               00               00       00      00       00    00       00      00
// 00             00      00                00                00     00       00      00      00     00       00
// 00              00   00                  00                 00   00        00    00         00   00
// 00               00 00                   00                  00 00         00 00             00 00         00

import javax.persistence.*;
//гооврит что сущность для базы данных
@Entity
//клас для создания таблицы Message в бд и возможности манипуляции с полями таблици
public class Message {
    //поля для базы данных
    //познач что ид
    @Id
    //то что будет автоматически генерировать ид
    @GeneratedValue(strategy=GenerationType.AUTO)
    //само поле ид
    private Integer id;
    //поле текст
    private String text;
    //поле тег
    private String tag;

    //добавляем автора статей
    //аннотация много статей к 1 автору
    @ManyToOne(fetch = FetchType.EAGER)
    //как записана в базе будет строка
    @JoinColumn(name = "user_id")
    //само поле автор
    private User author;
    //поле имя файла
    private String filename;


    //конструкторы пустой и ... для класса меседж
    public Message() {
    }
    public Message(String text, String tag, User user) {
        this.author = user;
        this.text = text;
        this.tag = tag;
    }

    //проверяет есть ли у нас автор если нет то возвращает "<none>"
    public String getAuthorName() {
        return author != null ? author.getUsername() : "<none>";
    }


    //геттеры и  сеттеры для полей
    public User getAuthor() {
        return author;
    }
    public void setAuthor(User author) {
        this.author = author;
    }

    public void setText(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }
    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getFilename() {
        return filename;
    }
    public void setFilename(String filename) {
        this.filename = filename;
    }
}
