package com.peter.mybatis.mapper;

import java.util.List;

import com.peter.mybatis.po.Orders;
import com.peter.mybatis.po.OrdersCustom;

public interface OrdersMapper {

	
	public List<OrdersCustom> findOrderUser() throws Exception;

	public List<Orders> findOrderUserResultMap() throws Exception;
	
	
}
