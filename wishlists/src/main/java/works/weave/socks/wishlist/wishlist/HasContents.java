package works.weave.socks.wishlist.wishlist;

import java.util.function.Supplier;

public interface HasContents<T extends Contents> {
    Supplier<T> contents();
}
