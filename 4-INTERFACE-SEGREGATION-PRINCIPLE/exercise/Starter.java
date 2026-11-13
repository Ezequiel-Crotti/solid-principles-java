// ISP Practice Exercise — starter code. Contractor is forced to fake paid
// leave and health insurance. Split Employee into focused interfaces instead.
// See README.md in this folder for the full task and requirements.


class Contractor implements Playable {
    public double calculateSalary() {
        return 5000.0; // flat contract rate
    }

    @Override
    public void runPayroll(Playable worker) {

    }
}

class FullTimeEmployee implements Playable, PaidLeaveEligible,InsuranceEligible{

    @Override
    public void enrollInHealthInsurance() {

    }

    @Override
    public void takePaidLeave(int days) {

    }

    @Override
    public double calculateSalary() {
        return 0;
    }

    @Override
    public void runPayroll(Playable worker) {

    }
}

public class Starter {
    public static void main(String[] args) {
        Contractor contractor = new Contractor();
        System.out.println("Salary: " + contractor.calculateSalary());
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee();
        fullTimeEmployee.takePaidLeave(2); // 💥 throws at runtime
    }
}

interface Playable{
    double calculateSalary();
    void runPayroll(Playable worker);
}

interface PaidLeaveEligible{
    void takePaidLeave(int days);
}

interface InsuranceEligible{
    void enrollInHealthInsurance();
}
