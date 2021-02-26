package com.yadav.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yadav.entity.ContactDtlsEntity;

public interface ContactRepository  extends JpaRepository<ContactDtlsEntity, Serializable>{

}
