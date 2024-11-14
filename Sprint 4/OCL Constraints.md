
# Formal Specifications - OCL Expressions

1. “Offerings are unique. In other words, multiple offerings on the same day and
time slot must be offered at a different location.” 

```
context Offering
    inv: Offering.allInstances() -> forAll(o1, o2 |
        o1 <> o2 implies (
            (o1.date <> o2.date or o1.startTime >= o2.endTime or o2.startTime >= o1.endTime) or
            o1.location <> o2.location
        )
    )
```

2. "Any client who is underage must necessarily be accompanied by an adult who
acts as their guardian."

```
context Client
    inv: self.age < 18 implies not self.guardian.isEmpty()
```

3. "The city associated with an offering must be one the city’s that the instructor has
indicated in their availabilities." 

```
context Offering
    inv: self.instructor.availableCities *implies* includes(self.city)
```
*we assume `availableCities` is a collection of `cities` that the `Instructor` has defined.

4. "A client does not have multiple bookings on the same day and time slot." 

```
context Client
    inv: self.bookings->forAll(b1, b2 |
        b1 <> b2 implies (
            b1.date <> b2.date or b1.startTime >= b2.endTime or b2.startTime >= b1.endTime
        )
    )
```