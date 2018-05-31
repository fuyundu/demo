package java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// 集合讲的是数据，流讲的是计算。
public class FirstStreamTest {
	public static void main(String[] args) {
		// 集合讲的是数据，流讲的是计算
		// 内部迭代时，项目可以透明地并行处理，或者用更优化的顺序进行处理。Streams库的内部迭代可以自动选择一种适合硬件的数据表示和并行实现。
		// 数组转列表
		/*
		 * 
		 * menu.stream()
		    .filter(d -> d.getCalories() > 300)
		    .map(Dish::getName)
		    .limit(3)
		    .collect(toList());
		filter、map和limit可以连成一条流水线；
		collect触发流水线执行并关闭它
		
		中间操作
	        诸如filter或sorted等中间操作会返回另一个流。这让多个操作可以连接起来形成一个查询。重要的是，除非流水线上触发一个终端操作，否则中间操作不会执行任何处理——它们很懒
	        。这是因为中间操作一般都可以合并起来，在终端操作时一次性全部处理。

		终端操作
		终端操作会从流的流水线生成结果。
		
		
		截断流 
		 * 
		 * */
//		Dish[] arrayDish = new Dish[1000000];
//		
//	    int max=1000000;
//        int min=1;
//        Random random = new Random();
// 
//		for(int i=0;i<1000000;i++) {
//			int s = random.nextInt(max)%(max-min+1) + min;
//			if(s<5) {
//				System.out.println(s);
//			}
//			arrayDish[i] = new Dish("pork", false, s, Dish.Type.MEAT);
//		}

		List<Dish> menu = Arrays.asList(
		new Dish("pork", false, 800, Dish.Type.MEAT),
		new Dish("beef", false, 700, Dish.Type.MEAT), 
		new Dish("chicken", false, 400, Dish.Type.MEAT),
		new Dish("french fries", true, 530, Dish.Type.OTHER), 
		new Dish("rice", true, 350, Dish.Type.OTHER),
		new Dish("season fruit", true, 120, Dish.Type.OTHER), 
		new Dish("pizza", true, 550, Dish.Type.OTHER),
		new Dish("prawns", false, 300, Dish.Type.FISH), 
		new Dish("salmon", false, 450, Dish.Type.FISH));
		
		// List<Dish> menu = Arrays.asList(arrayDish);

		List<String> lsName = menu.stream()
				.filter(d -> d.getCalories() < 800) // 谓词过滤，数学中的关系，函数都可以看成谓词
				 // 方法引用
				.map(Dish::getName) // 也可以这样写.map(d -> d.getName())
				//.skip(2) // 跳过前几条,跳过前几个元素
				//.limit(2) // 在结果集中取指点定的个数,可以利用skip和limit分页了
				.collect(Collectors.toList());
		
		System.out.println(lsName);
		
		List<List<Integer>> outer = new ArrayList<>();
		List<Integer> inner1 = new ArrayList<>();
		inner1.add(1);
		List<Integer> inner2 = new ArrayList<>();
		inner2.add(2);
		List<Integer> inner3 = new ArrayList<>();
		inner3.add(3);
		List<Integer> inner4 = new ArrayList<>();
		inner4.add(4);
		List<Integer> inner5 = new ArrayList<>();
		inner5.add(5);
		outer.add(inner1);
		outer.add(inner2);
		outer.add(inner3);
		outer.add(inner4);
		outer.add(inner5);
		
		// flatMap扁平化操作，就是将outer里同的子List都展开
		List<Integer> outInteger = outer.stream().flatMap(inner -> inner.stream().map(i -> i+1)).collect(Collectors.toList());
		
		System.out.println(outInteger);
		
		menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT), 
			new Dish("chicken", false, 400, Dish.Type.MEAT)
	    );
		
		// 查找和匹配anyMatch \allMatch noneMatch(和allMatch相反),都是一个终端操作，返回boolean类型
		// 任意包含返回true，只要有一个匹配
		boolean aa = menu.stream().anyMatch(Dish::isVegetarian);
		System.out.println(aa);
		
		// 全部包含返回 true,即所有都必须匹配
		aa = menu.stream().allMatch(Dish::isVegetarian);
		System.out.println(aa);
		
		// none 一个也没有包含返回true，所有元素条件都不匹配
		aa = menu.stream().noneMatch(Dish::isVegetarian);
		System.out.println(aa);


	}
}
