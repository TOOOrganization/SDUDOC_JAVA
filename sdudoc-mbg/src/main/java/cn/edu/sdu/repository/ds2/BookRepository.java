package cn.edu.sdu.repository.ds2;

import cn.edu.sdu.entity.ds2.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository(value = "ds2BookRepository")
public interface BookRepository extends JpaRepository<Book, String> {
}
