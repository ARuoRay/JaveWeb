package javaweb.service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javaweb.model.dto.OrderDto;
import javaweb.model.entity.Order;
import javaweb.model.entity.Product;
import javaweb.repository.OrderDao;
import javaweb.repository.OrderDaoImpl;
import javaweb.repository.ProductDao;
import javaweb.repository.ProductDaoImpl;

public class OrderService {
	private OrderDao orderDao=new OrderDaoImpl();
	private ProductDao productDao=new ProductDaoImpl();
	// 同時新增多筆訂單
		// userId: 使用者 id
		// productIds: 每一件商品的 id   [1, 2, 3, 4, 5]
		// unitPrices: 每一件商品的單價    [10, 20, 30, 40, 50]
		// amounts:    每一件商品的購買數量 [5, 0, 3, 0, 2]
	    //                        i:  0  1  2  3  4
	
	public void batchAddOrders(Integer userId,String[] productIds,String[] unitPrices,String[] amounts) {
		List<Order>orders=new ArrayList<>();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		for (int i=0;i<productIds.length;i++) {
			Integer productId=Integer.parseInt(productIds[i]);
			Double unitPrice=Double.parseDouble(unitPrices[i]);
			Integer amount=Integer.parseInt(amounts[i]);
			
			//
			if(amount<=0) {
				continue;
			}
			
			Order order=new Order();
			order.setUserId(userId);
			order.setOrderDate(sdf.format(new Date()));
			order.setProductId(productId);
			order.setQuantity(amount);
			order.setUnitPrice(unitPrice);
			order.setSubtotal((int)(order.getQuantity()*order.getUnitPrice()));
			order.setOrderStatus("Pending");
			
			orders.add(order);
			
			
			
			
		}
		orderDao.batchAddOrders(orders);
	}
	
	// 查找該使用者的所有訂單，根據訂單狀態進行篩選
}
