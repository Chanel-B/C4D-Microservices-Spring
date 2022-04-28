package com.user.repository;

import com.user.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ArticlesRepository extends JpaRepository<Articles, Integer> {

}
