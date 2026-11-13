// OCP Practice Exercise — starter code. Refactor this so adding a new
// customer tier never requires editing DiscountCalculator again.
// See README.md in this folder for the full task and requirements.

public class Starter {
    public static void main(String[] args) {
        AplicarDescuento calculator = new AplicarDescuento();
        double amount = 200.0;

        double regularDiscount = calculator.PricingService(new RegularCustomerDiscount());
        double premiumDiscount = calculator.PricingService(new PremiumCustomerDiscount());
        double vipDiscount = calculator.PricingService(new VipCustomerDiscount());
        double studentDiscount = calculator.PricingService(new StudentCustomerDiscount());

        System.out.println("Regular pays: " + (amount - amount * regularDiscount));
        System.out.println("Premium pays: " + (amount - amount * premiumDiscount));
        System.out.println("VIP pays: " + (amount - amount * vipDiscount));
        System.out.println("Student pays: " + (amount - amount * studentDiscount));

        // Marketing just asked for a "student" tier at 15% off.
        // Can you add it without touching DiscountCalculator?
    }
}

interface DiscountPolicy {
    public double aDescontar();
}

class RegularCustomerDiscount implements DiscountPolicy {

    @Override
    public double aDescontar() {
        return 0.0;
    }
}

class PremiumCustomerDiscount implements DiscountPolicy {

    @Override
    public double aDescontar() {
        return 0.10;
    }
}

class VipCustomerDiscount implements DiscountPolicy {

    @Override
    public double aDescontar() {
        return 0.20;
    }
}

class StudentCustomerDiscount implements DiscountPolicy {

    @Override
    public double aDescontar() {
        return 0.15;
    }

}

class AplicarDescuento{
    public double PricingService(DiscountPolicy descuento){
        return descuento.aDescontar();
    }
}