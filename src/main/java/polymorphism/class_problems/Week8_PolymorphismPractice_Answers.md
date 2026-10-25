# Week 8 - Polymorphism Practice Answers

## Quiz questions

1. **C — Polymorphism.** Call the overridden method through the common `Document` reference instead of checking each concrete type.
2. **A, B, C.** A car is a vehicle, a rectangle is a shape, and a database connection can be modeled as a network resource. A helper containing a calculator is a has-a relationship.
3. **C — Runtime method dispatch.** The runtime object type determines which override runs.
4. **C — Inheritance-based polymorphism.** A common `Shape` reference can invoke the right `calculateArea()` override.
5. **A, C, D.** `Book` extends behavior, the base class supplies common library behavior, and a DVD can be referenced as a `LibraryItem`. A DVD-specific fixed period is not itself shared behavior.
6. **A, C.** An `Animal` reference to a `Dog` runs `Dog.makeSound()`, and `Dog.makeSound()` overrides the base method.
7. **C.** A new `WalletPayment` can be added without changing the processor's common iteration logic.
8. **A.** Reusing inheritance without a genuine is-a relationship creates tight coupling and a misleading design.
9. **A, C.** A generic sender can work with the common base type, and new notification types can be added with minimal changes to the sender.
10. **A, B, C.** Polymorphic collections simplify iteration, allow uniform processing, and reduce explicit casting.

## Concept questions

1. **Reuse and extension:** A base `Employee` can store shared details such as name and ID. `FullTimeEmployee` inherits those details and overrides `calculatePay()` to include a monthly salary, while `ContractEmployee` calculates pay from hours worked.
2. **Is-a relationship:** A derived object must be a valid kind of its base type, such as `Car` is a `Vehicle`. This keeps substituting a derived object for its base type meaningful and safe.
3. **Method overriding:** A subclass provides its own implementation of an inherited instance method with the same signature. For example, `FullTimeEmployee.calculatePay()` can return a salary while `HourlyEmployee.calculatePay()` returns hours multiplied by the hourly rate.
4. **Runtime polymorphism:** A base reference can point to a derived object. At runtime, Java dispatches an overridden instance-method call to the implementation belonging to the actual object type.
5. **Polymorphic collection:** A `Vehicle[]` can hold `Car` and `Motorcycle` objects. A loop calling `startEngine()` on each element invokes each object's implementation while using one common processing loop.
6. **Polymorphism versus type checks:** Repeated type-specific conditionals require editing the central method whenever a new type is introduced. Overridden methods move each variation into its own class and leave common processing stable.
7. **Adding a new type:** If the processor accepts `PaymentMethod` objects and calls `calculateFee()`, a new `WalletPayment` implements that operation. The processor loop does not need a new type branch.
8. **Inherited versus overridden behavior:** A class inherits a method when the existing behavior is suitable unchanged. It overrides a method when its specific rules differ, such as an SUV having a different fare calculation from a general cab.
9. **Inheritance without is-a:** It couples unrelated classes and suggests substitutability that may not be valid. Composition is usually more suitable when one class merely uses or contains another.
10. **Vehicle rentals:** A common `Rental` base type can store duration and customer details and define common calculations. `CarRental` can add passenger/car-specific rules, while `TruckRental` can add cargo or mileage rules; common checkout code processes both through `Rental` references.
