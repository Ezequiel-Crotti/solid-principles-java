// SRP Practice Exercise — starter code. Refactor this so each responsibility
// (data, calculation, printing, saving, emailing) lives in its own class.
// See README.md in this folder for the full task and requirements.

class Invoice {
    private String customerName;
    private double[] itemPrices;

    public Invoice(String customerName, double[] itemPrices) {
        this.customerName = customerName;
        this.itemPrices = itemPrices;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double[] getItemPrices() {
        return itemPrices;
    }

    public void setItemPrices(double[] itemPrices) {
        this.itemPrices = itemPrices;
    }
}

class Email{
    public void emailInvoice(String emailAddress) {
        System.out.println("Emailing invoice to " + emailAddress);
    }
}

class Save{
    public void saveToFile(String filename) {
        System.out.println("Saving invoice to " + filename);
    }
}

class Calculate{
    public static double calculateTotal(double[] itemPrices) {
        double total = 0;
        for (double price : itemPrices) {
            total += price;
        }
        return total;
    }
}

class Print{
    public void printInvoice(Invoice invoice) {
        System.out.println("Invoice for: " + invoice.getCustomerName());
        for (double price : invoice.getItemPrices()) {
            System.out.println(" - $" + price);
        }
        System.out.println("Total: $" + Calculate.calculateTotal(invoice.getItemPrices()));
    }
}

public class Starter {
    public static void main(String[] args) {
        Invoice invoice = new Invoice("Jane Doe", new double[] { 19.99, 42.50, 5.00 });
        Invoice invoice1 = new Invoice("Yo", new double[] { 20.00, 4.50, 15.00 });
        Email email = new Email();
        Save guardar = new Save();
        Print imprimir = new Print();

        imprimir.printInvoice(invoice);
        guardar.saveToFile("invoice-001.txt");
        email.emailInvoice("invoice-001.txt");
        System.out.println("Total: $" + Calculate.calculateTotal(invoice1.getItemPrices()));
    }
}
