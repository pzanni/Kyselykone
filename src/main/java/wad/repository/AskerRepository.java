
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Asker;


public interface AskerRepository extends JpaRepository<Asker, Long>{
    Asker findByUsername(String username);
}
