package com.example.mobileapp.cart;

import org.springframework.stereotype.Service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CartServiceImpl implements CartService{
    @Autowired
    private CartRepository cartRepository;
    @Override
    public Cart addProductToCart(Cart cart) throws CartExceptions {
        try {
            return this.cartRepository.save(cart);
        }
        catch (Exception e){
            throw  new CartExceptions("Error in adding product to cart : "+e.getMessage());
        }
    }


    @Override
    public Cart deleteCartProductById(Integer cartId) throws CartExceptions {
        try {
            Optional<Cart> accountOpt = this.cartRepository.findById(cartId);

            if (accountOpt.isPresent()) {
                Cart deleteCartProduct = accountOpt.get();
                cartRepository.delete(deleteCartProduct);
                return deleteCartProduct;
            }
            return null; //Cartid Not found
        }catch (EmptyResultDataAccessException e){
            throw new RuntimeException("cartId not found ",e);
        }catch (Exception e){
            throw new CartExceptions("error in find cartId"+e.getMessage());}
    }

    @Override
    public List<Cart> getAllCartProducts() throws CartExceptions {
        try{
            return this.cartRepository.findAll();
        }
        catch (Exception e) {
            throw new CartExceptions("no cartItems found:"+e.getMessage());
        }
    }

    @Override
    public List<Cart> getCartProductsByCartId(Integer cartId) throws CartExceptions {
        Optional<Cart> cartOptional=cartRepository.findById(cartId);
        return cartOptional.map(List::of).orElse(List.of());
    }



}








