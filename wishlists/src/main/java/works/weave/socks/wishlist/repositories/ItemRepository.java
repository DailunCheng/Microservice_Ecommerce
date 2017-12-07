package works.weave.socks.wishlist.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import works.weave.socks.wishlist.entities.Item;

@RepositoryRestResource
public interface ItemRepository extends MongoRepository<Item, String> {
}

