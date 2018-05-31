package java8.lambda;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortApple {
	public static void main(String args[]) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(new BigDecimal("0.2")));
		inventory.add(new Apple(new BigDecimal("0.33")));
		inventory.add(new Apple(new BigDecimal("0.25")));
		inventory.add(new Apple(new BigDecimal("0.19")));
		inventory.add(new Apple(new BigDecimal("0.3")));
		
		System.out.println(inventory);
		//排序
		inventory.sort(new AppleComparaor());
		//排序后
		System.out.println(inventory);
	}
}

// 实现类方式
class AppleComparaor implements Comparator<Apple>{

	@Override
	public int compare(Apple o1, Apple o2) {
		
		return o1.getWeight().compareTo(o2.getWeight());
	}
}