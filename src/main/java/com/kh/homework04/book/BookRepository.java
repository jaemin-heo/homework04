package com.kh.homework04.book;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BookRepository {
    private final EntityManager em;

    public int insert(BookEntity entity) {
        em.persist(entity);
        return 1;
    }

    public BookEntity selectOne(Long no) {
        String jpql = "select b from BookEntity b where b.no = :no and b.delYn = 'N'";
        return em.createQuery(jpql, BookEntity.class).setParameter("no", no).getSingleResult();
    }

    public List<BookEntity> selectList() {
        String jpql = "select b from BookEntity b where b.delYn = 'N' order by b.no desc";
        return em.createQuery(jpql, BookEntity.class).getResultList();
    }
}
