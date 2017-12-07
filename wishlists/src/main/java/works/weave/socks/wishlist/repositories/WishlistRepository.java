package works.weave.socks.wishlist.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import works.weave.socks.wishlist.entities.Wishlist;

import java.util.List;

@RepositoryRestResource(exported = false)
public interface WishlistRepository extends MongoRepository<Wishlist, String> {
    List<Wishlist> findByCustomerId(@Param("custId") String id);
}

