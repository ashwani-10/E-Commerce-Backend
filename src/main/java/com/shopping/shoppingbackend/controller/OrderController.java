//package com.shopping.shoppingbackend.controller;
//
//import com.shopping.shoppingbackend.Model.Product;
//import com.shopping.shoppingbackend.requestbody.SingleProductDTO;
//import com.shopping.shoppingbackend.service.OrderService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.UUID;
//
//@RestController
//@RequestMapping("order")
//public class OrderController {
//    @Autowired
//    OrderService orderService;
//
//    @PostMapping("/placeSingleOrder")
//    public ResponseEntity placeUserSingleOrder(@RequestBody SingleProductDTO singleProductDTO, @RequestParam String shopperEmail){
//        orderService.placeUserSingleOrder(singleProductDTO,shopperEmail);
//        return new ResponseEntity<>("Ordered Placed Successfully", HttpStatus.CREATED);
//    }
//
//    @PostMapping("/placeCartOrder")
//    public ResponseEntity placeUserCartOrder(@RequestParam String shopperEmail){
//        orderService.placeUserCartOrder(shopperEmail);
//        return new ResponseEntity<>("Ordered Placed Successfully", HttpStatus.CREATED);
//    }
//    @GetMapping("orderHistory")
//    public List<List<Product>> getUserOrderHistory(@RequestParam String shopperEmail){
//       return orderService.getUserOrderHistory(shopperEmail);
//    }
//
//    @PutMapping("/cancelOrder")
//    public void cancelUserOrder(@RequestParam UUID orderId,@RequestParam String shopperEmail){
//        orderService.cancelUserOrder(orderId,shopperEmail);
//    }
//}
