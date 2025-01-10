//package com.shopping.shoppingbackend.service;
//
//import com.shopping.shoppingbackend.Model.ApplicationUser;
//import com.shopping.shoppingbackend.Model.Cart;
//import com.shopping.shoppingbackend.Model.Product;
//import com.shopping.shoppingbackend.Model.UserOrder;
//import com.shopping.shoppingbackend.enums.OrderStatus;
//import com.shopping.shoppingbackend.repository.ApplicationUserRepo;
//import com.shopping.shoppingbackend.repository.CartRepo;
//import com.shopping.shoppingbackend.repository.ProductRepo;
//import com.shopping.shoppingbackend.repository.UserOrderRepo;
//import com.shopping.shoppingbackend.requestbody.SingleProductDTO;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class OrderService {
//    @Autowired
//    MailService mailService;
//
//    @Autowired
//    ProductRepo productRepo;
//
//    @Autowired
//    ApplicationUserRepo applicationUserRepo;
//
//    @Autowired
//    UserOrderRepo userOrderRepo;
//
//    @Autowired
//    CartRepo cartRepo;
//
//    @Autowired
//    UserUtils userUtils;
//
//    public void placeUserSingleOrder(SingleProductDTO singleProductDTO, String shopperEmail) {
//        ApplicationUser user = userUtils.verifyEmail(shopperEmail);
//        userUtils.isShopper(user);
//
//        Product orderedProduct = productRepo.findByName(singleProductDTO.getProductName());
//        int orderedQuantity = singleProductDTO.getProductQuantity();
//        orderedProduct.setQuantity(orderedProduct.getQuantity()-orderedQuantity);
//        int orderedTotalAmount = orderedQuantity*orderedProduct.getPrice();
//
//        List<Product> userProductList = new ArrayList<>();
//        userProductList.add(orderedProduct);
//
//        UserOrder userOrder = new UserOrder();
//        userOrder.setOrderedProductsList(userProductList);
//        userOrder.setOrderTotalAmount(orderedTotalAmount);
//        userOrder.setShopperEmail(shopperEmail);
//        userOrder.setOrderStatus(OrderStatus.PLACED);
//
//        userOrderRepo.save(userOrder);
//
//    }
//
//    public List<List<Product>> getUserOrderHistory(String shopperEmail) {
//        List<List<Product>> orderedProductsList = new ArrayList<>();
//        List<UserOrder> userOrder = userOrderRepo.findAll();
//        for(UserOrder order : userOrder){
//            if(order.getShopperEmail().equals(shopperEmail)){
//                orderedProductsList.add(order.getOrderedProductsList());
//            }
//        }
//        return orderedProductsList;
//    }
//
//    public void placeUserCartOrder(String shopperEmail) {
//        ApplicationUser user = userUtils.verifyEmail(shopperEmail);
//        userUtils.isShopper(user);
//
//        List<Cart> cartsList = cartRepo.findAll();
//        Cart userCart = null;
//
//        for(Cart cart : cartsList){
//            if(cart.getShopper().getEmail().equals(user.getEmail())){
//                userCart = cart;
//                break;
//            }
//        }
//        if(userCart == null) return;
//
//        List<Product> userProductList = userCart.getProducts();
//        UserOrder userOrder = new UserOrder();
//        userOrder.setShopperEmail(shopperEmail);
//        userOrder.setOrderTotalAmount(userCart.getTotalAmount());
//        userOrder.setOrderedProductsList(userProductList);
//        userOrder.setOrderStatus(OrderStatus.PLACED);
//
//        userOrderRepo.save(userOrder);
//    }
//
//
//    public void cancelUserOrder(UUID orderId, String shopperEmail) {
//        ApplicationUser user = userUtils.verifyEmail(shopperEmail);
//        userUtils.isShopper(user);
//
//        List<UserOrder> orderList = userOrderRepo.findAll();
//        for(UserOrder order : orderList){
//            if(order.getShopperEmail().equals(shopperEmail) && order.getOrderId().equals(orderId)){
//                order.setOrderStatus(OrderStatus.CANCELED);
//                userOrderRepo.save(order);
//                try {
//                    System.out.println("mailservice called");
//                    mailService.cancelOrderMail(user.getEmail(),orderId);
//                }catch (Exception e){
//                    System.out.println("Failure in canceling order");
//                }
//
//                return;
//            }
//        }
//    }
//}
