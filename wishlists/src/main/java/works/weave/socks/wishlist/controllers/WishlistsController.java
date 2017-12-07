package works.weave.socks.wishlist.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import works.weave.socks.wishlist.wishlist.WishlistDAO;
import works.weave.socks.wishlist.wishlist.WishlistResource;
import works.weave.socks.wishlist.entities.Wishlist;


@RestController
@RequestMapping(path = "/wishlists")
public class WishlistsController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private WishlistDAO wishlistDAO;

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
    public Wishlist get(@PathVariable String customerId) {
        return new WishlistResource(wishlistDAO, customerId).value().get();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{customerId}", method = RequestMethod.DELETE)
    public void delete(@PathVariable String customerId) {
        new WishlistResource(wishlistDAO, customerId).destroy().run();
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/{customerId}/merge", method = RequestMethod.GET)
    public void mergeWishlists(@PathVariable String customerId, @RequestParam(value = "sessionId") String sessionId) {
        logger.debug("Merge wishlists request received for ids: " + customerId + " and " + sessionId);
        WishlistResource sessionWishlist = new WishlistResource(wishlistDAO, sessionId);
        WishlistResource customerWishlist = new WishlistResource(wishlistDAO, customerId);
        customerWishlist.merge(sessionWishlist.value().get()).run();
        delete(sessionId);
    }
}
