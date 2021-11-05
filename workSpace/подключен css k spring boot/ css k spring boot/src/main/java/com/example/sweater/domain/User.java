package com.example.sweater.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;
//entity говорит что будет сущность которую надо сохранить в базу данных
@Entity
//название таблици в бд
@Table(name = "usr")
public class User implements UserDetails {
    //что это идентификатор
    @Id
    //автоматичкская генерация ид
    @GeneratedValue(strategy = GenerationType.AUTO)
    //поля для базы данных
    private Long id;
    private String username;
    private String password;
    private boolean active;
    //формирует дополнительные таблици  и fetch = FetchType.EAGER гооврит что жадно подгружает
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    // @CollectionTable даное поле будет хранится в отдельной табл которой мы не описывали мапинг
    //@JoinColumn поле по которому будет соединяятся таблици  типа foreign key
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)

    private Set<Role> roles;

    public boolean isAdmin() {
        return roles.contains(Role.ADMIN);
    }

    // имплементированые методы с UserDetails   (((( public class User implements UserDetails
    //устоновили все true и один is Active() и последний getRoles()
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return isActive();
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

//геттеры и сеттеры для полей
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }
    public void setActive(boolean active) {
        this.active = active;
    }

    public Set<Role> getRoles() {
        return roles;
    }
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
