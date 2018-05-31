package java8.lambda;

import java.math.BigDecimal;

public class Apple {
	private BigDecimal weight;
	
	public Apple(BigDecimal weight) {
		this.weight = weight;
	}

	public BigDecimal getWeight() {
		return weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public String toString() {
		return this.weight + "";
	}
}
