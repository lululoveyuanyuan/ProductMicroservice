package com.appsdeveloperblog.ws.products.rest;

import java.math.BigDecimal;

/**
 * CreateProductRestModel是一个数据传输对象（DTO）。
 * 当客户端以JSON格式向后端服务发送创建产品的请求时，Spring会使用此类
 * 将请求体中的JSON数据反序列化为Java对象。
 *
 * 典型场景：
 * 客户端发送 POST /products 请求，请求体包含：
 * {
 *   "title": "Some Product",
 *   "price": 19.99,
 *   "quantity": 5
 * }
 *
 * Spring通过 @RequestBody 注解（常见于Controller的方法参数中）将上述JSON映射为
 * CreateProductRestModel实例，然后Controller可将此实例传给Service层进行业务处理。
 *
 * 字段说明：
 * - title: 产品标题或名称
 * - price: 产品价格，使用BigDecimal确保高精度货币计算
 * - quantity: 产品库存数量
 */
public class CreateProductRestModel {

    /**
     * 产品的标题或名称。来自客户端请求的JSON字段对应为 "title"。
     * 例如： "title": "My Awesome Product"
     */
    private String title;

    /**
     * 产品价格，使用BigDecimal能精确表示货币值，避免浮点精度问题。
     * 对应JSON中的 "price" 字段。
     * 例如： "price": 29.99
     */
    private BigDecimal price;

    /**
     * 产品库存数量，对应JSON中的 "quantity" 字段。
     * 例如： "quantity": 10
     */
    private Integer quantity;

    /**
     * 获取产品标题
     * @return 产品标题（String）
     */
    public String getTitle() {
        return title;
    }

    /**
     * 设置产品标题
     * @param title 新的产品标题
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * 获取产品价格
     * @return 产品价格（BigDecimal）
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * 设置产品价格
     * @param price 新的产品价格
     */
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    /**
     * 获取产品库存数量
     * @return 产品库存数量（Integer）
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * 设置产品库存数量
     * @param quantity 新的产品库存数量
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
