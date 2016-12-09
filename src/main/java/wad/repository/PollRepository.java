
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Poll;


public interface PollRepository extends JpaRepository<Poll, Long>{
    
}
