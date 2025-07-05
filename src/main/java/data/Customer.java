package data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Customer {
    private String name;
    private double shippingFee = 20;
    private double balance = 50;
    public void pay(double total) {
        balance = balance - total;
    }
    
}
