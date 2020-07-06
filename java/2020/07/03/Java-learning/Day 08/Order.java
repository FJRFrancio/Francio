public class Order {

    public Order(int orderId,String orderName){
        this.orderId = orderId;
        this.orderName = orderName;
    }

    int orderId;
    String orderName;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    @Override
    public boolean equals(Object obj) {
        boolean flag = false;
        if (obj instanceof Order){
            Order o = (Order) obj;

            if (this.orderId == o.orderId && this.orderName.equals(o.orderName)){
                flag = true;
            }
        }


        return flag;
    }
    
}