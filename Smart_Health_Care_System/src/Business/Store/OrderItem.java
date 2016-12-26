package Business.Store;

/**
 *
 * @author Apoorva
 */
public class OrderItem {

    private MedicineProduct product;
    private int quantity;
    private Double price;
    
    
    public MedicineProduct getProduct() {
        return product;
    }
    
    public void setProduct(MedicineProduct product) {
        this.product = product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    
    @Override
    public String toString() {
        return product.getProdName();
    }
    
}
