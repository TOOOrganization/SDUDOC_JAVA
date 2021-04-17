package cn.edu.sdu.sdudoc.sdudocmbg.repository;

import cn.edu.sdu.sdudoc.sdudocmbg.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, String> {
}
