package cn.edu.sdu.repository.ds1;

import cn.edu.sdu.entity.ds1.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds1BookRepository")
public interface BookRepository extends JpaRepository<Book, String> {
}
