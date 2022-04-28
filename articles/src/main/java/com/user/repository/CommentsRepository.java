package com.user.repository;

import com.user.model.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<Comments, Integer> {

}
