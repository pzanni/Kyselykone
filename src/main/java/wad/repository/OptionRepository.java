
package wad.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import wad.domain.Option;


public interface OptionRepository extends JpaRepository<Option, Long>{
    
}
