package cn.three.core.database.kit;

import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SimpleSortBuilder {
	
	/**
	 * 调用的时候使用SimpleSortBuilder.generateSort("name","xh_d");表示先以name升序，之后以xh降序
	 */
	public static Sort generateSort(Map<String,String> fields) {
		List<Order> orders = new ArrayList<Order>();
		for(String f:fields.keySet()) {
			if (fields.get(f).equalsIgnoreCase("DESC")){
				orders.add(generateOrderDesc(f));
			}else{
				orders.add(generateOrderAsc(f));
			}
		}
		return new Sort(orders);
	}

	private static Order generateOrderDesc(String f) {
		return new Order(Direction.DESC,f);
	}
	private static Order generateOrderAsc(String f) {
		return new Order(Direction.ASC,f);
	}

}
