package by.tutorials.sweater.repo;

import by.tutorials.sweater.domain.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepo extends CrudRepository<Message, Long> {


}
