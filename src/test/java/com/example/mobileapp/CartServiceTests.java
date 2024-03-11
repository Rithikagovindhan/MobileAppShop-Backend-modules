package com.example.mobileapp;

import com.example.mobileapp.cart.Cart;
import com.example.mobileapp.cart.CartExceptions;
import com.example.mobileapp.cart.CartRepository;
import com.example.mobileapp.cart.CartServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class CartServiceTests {

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private CartRepository cartRepository;

    @Test
    public void testAddProductToCart() throws CartExceptions {
        Cart cart = new Cart(1, 1, new ArrayList<>());
        when(cartRepository.save(cart)).thenReturn(cart);

        Cart savedCart = cartService.addProductToCart(cart);
        assertEquals(cart, savedCart);
    }

    @Test
    public void testDeleteCartProductById() throws CartExceptions {
        Cart cart = new Cart(1, 1, new ArrayList<>());
        Optional<Cart> optionalCart = Optional.of(cart);
        when(cartRepository.findById(1)).thenReturn(optionalCart);

        Cart deletedCart = cartService.deleteCartProductById(1);
        assertEquals(cart, deletedCart);
        verify(cartRepository, times(1)).delete(cart);
    }

    @Test
    public void testGetAllCartProducts() throws CartExceptions {
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart(1, 1, new ArrayList<>()));
        when(cartRepository.findAll()).thenReturn(cartList);

        List<Cart> allCartProducts = cartService.getAllCartProducts();
        assertEquals(cartList, allCartProducts);
    }

    @Test
    public void testGetCartProductsByCartId() throws CartExceptions {
        Cart cart = new Cart(1, 1, new ArrayList<>());
        Optional<Cart> optionalCart = Optional.of(cart);
        when(cartRepository.findById(1)).thenReturn(optionalCart);

        List<Cart> cartProducts = cartService.getCartProductsByCartId(1);
        assertEquals(1, cartProducts.size());
        assertEquals(cart, cartProducts.get(0));
    }
}
