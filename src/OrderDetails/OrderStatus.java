package OrderDetails;

/**
 * An enumeration representing the status of an order in an online shopping system.
 */
public enum OrderStatus {
    /**
     * The order is open and has not yet been processed.
     */
    Open,
    /**
     * The order has been closed and processed successfully.
     */
    Closed,
    /**
     * The order has been cancelled by the customer or the system.
     */
    Cancelled
}