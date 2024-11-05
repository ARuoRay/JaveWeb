package javaweb.model.dto;

import lombok.Data;

@Data
public class ProductDto {
	
	private Integer productId;
	private String productName;
	private double price;
	private Integer stock;
}
