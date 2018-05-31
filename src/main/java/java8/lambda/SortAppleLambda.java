package java8.lambda;

import static java.util.Comparator.comparing;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class SortAppleLambda {
	public static void main(String args[]) {
		List<Apple> inventory = new ArrayList<>();
		inventory.add(new Apple(new BigDecimal("0.2")));
		inventory.add(new Apple(new BigDecimal("0.33")));
		inventory.add(new Apple(new BigDecimal("0.25")));
		inventory.add(new Apple(new BigDecimal("0.19")));
		inventory.add(new Apple(new BigDecimal("0.3")));
		
		System.out.println(inventory);
		
		//排序 方法1
		// inventory.sort((a1,a2) -> a1.getWeight().compareTo(a2.getWeight())); // 使用lambda表达式，直接写实现类的方法参数和方法体，
		
		//排序  方法2， import static java.util.Comparator.comparing
	    inventory.sort(comparing(apple -> apple.getWeight()));
	    
		// 方法引用，只写方法名不加后面的()
		inventory.sort(comparing(Apple::getWeight));
		
		// Comparator中有一个静态方法comparing()，可以用来进一步简化Lambda表达式（PS: java 8之前是不支持接口中包含静态方法的，java中为了支持Lambda表达式，接口中已经支持静态方法）
		// static <T, U> Comparator<T> comparing(...)
		
		// 排序后
		System.out.println(inventory);
		
		Function<Integer, Integer> f1 = x -> x+1;
		Function<Integer, Integer> f2 = x -> x*2;
		Function<Integer, Integer> h = f1.andThen(f2);
		int result = h.apply(1);
		
		// 不太理解操作结果
		System.out.println(result);
	}
}
