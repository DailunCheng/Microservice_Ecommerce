package works.weave.socks.wishlist.wishlist;

import works.weave.socks.wishlist.action.FirstResultOrDefault;
import works.weave.socks.wishlist.entities.Wishlist;

import java.util.function.Supplier;

public class WishlistResource implements Resource<Wishlist>, HasContents<WishlistContentsResource> {
    private final WishlistDAO wishlistRepository;
    private final String customerId;

    public WishlistResource(WishlistDAO wishlistRepository, String customerId) {
        this.wishlistRepository = wishlistRepository;
        this.customerId = customerId;
    }

    @Override
    public Runnable destroy() {
        return () -> wishlistRepository.delete(value().get());
    }

    @Override
    public Supplier<Wishlist> create() {
        return () -> wishlistRepository.save(new Wishlist(customerId));
    }

    @Override
    public Supplier<Wishlist> value() {
        return new FirstResultOrDefault<>(
                wishlistRepository.findByCustomerId(customerId),
                () -> {
                    create().get();
                    return value().get();
                });
    }

    @Override
    public Runnable merge(Wishlist toMerge) {
        return () -> toMerge.contents().forEach(item -> contents().get().add(() -> item).run());
    }

    @Override
    public Supplier<WishlistContentsResource> contents() {
        return () -> new WishlistContentsResource(wishlistRepository, () -> this);
    }
}
