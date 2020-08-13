package com.bluetasks.bluetasksbackend.domain.task;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.bluetasks.bluetasksbackend.domain.user.AppUser;

import org.hibernate.validator.constraints.Length;

@Entity
public class Task {

    @Id
    @GeneratedValue
    private Integer id;
    
    @NotEmpty(message = "Descrição obrigatória")
    @Length(min = 3, max = 40, message = "Tamanho Inválido")
    private String description;

    @NotNull(message = "Data Obrigatória")
    @FutureOrPresent(message = "A data da tarefa não pode estar no passado")
    private LocalDate whenToDo;

    private Boolean done = false;

    @ManyToOne
    @JoinColumn(name = "appUserId")
    @NotNull(message = "Usuário é obrigatório")
    private AppUser appUser;

    public Task() { }

    public Task(String description, LocalDate whenToDo, Boolean done) {
        this.description = description;
        this.whenToDo = whenToDo;
        this.done = done;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getWhenToDo() {
        return whenToDo;
    }

    public void setWhenToDo(LocalDate whenToDo) {
        this.whenToDo = whenToDo;
    }

    public Boolean getDone() {
        return done;
    }

    public void setDone(Boolean done) {
        this.done = done;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
 
}