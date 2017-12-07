package works.weave.socks.wishlist.wishlist;

import org.slf4j.Logger;
import works.weave.socks.wishlist.entities.Wishlist;
import works.weave.socks.wishlist.entities.Item;

import java.util.List;
import java.util.function.Supplier;

import static org.slf4j.LoggerFactory.getLogger;

public class WishlistContentsResource implements Contents<Item> {
    private final Logger LOG = getLogger(getClass());

    private final WishlistDAO wishlistRepository;
    private final Supplier<Resource<Wishlist>> parent;

    public WishlistContentsResource(WishlistDAO wishlistRepository, Supplier<Resource<Wishlist>> parent) {
        this.wishlistRepository = wishlistRepository;
        this.parent = parent;
    }

    @Override
    public Supplier<List<Item>> contents() {
        return () -> parentWishlist().contents();
    }

    @Override
    public Runnable add(Supplier<Item> item) {
        return () -> {
            LOG.debug("Adding for user: " + parent.get().value().get().toString() + ", " + item.get());
            wishlistRepository.save(parentWishlist().add(item.get()));
        };
    }

    @Override
    public Runnable delete(Supplier<Item> item) {
        return () -> {
            LOG.debug("Deleting for user: " + parent.get().value().get().toString() + ", " + item.get());
            wishlistRepository.save(parentWishlist().remove(item.get()));
        };
    }

    private Wishlist parentWishlist() {
        return parent.get().value().get();
    }
}
