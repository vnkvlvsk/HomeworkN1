package HomeworkN3.builder;

public class Order {
    private String customerName;
    private String item;
    private int quantity;
    private String address;

    private Order() {}

    public static Builder builder() {
        return new Builder();
    }

    public String toString() {
        return "Заказ: " + customerName + ", товар: " + item +
               ", кол-во: " + quantity + ", адрес: " + address;
    }

    public static class Builder {
        private Order order = new Order();

        public Builder customerName(String name) {
            order.customerName = name;
            return this;
        }

        public Builder item(String item) {
            order.item = item;
            return this;
        }

        public Builder quantity(int quantity) {
            order.quantity = quantity;
            return this;
        }

        public Builder address(String address) {
            order.address = address;
            return this;
        }

        public Order build() {
            return order;
        }
    }
}
