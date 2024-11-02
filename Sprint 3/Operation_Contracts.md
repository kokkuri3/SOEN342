## makeLesson(location, startTime, endTime, mode)
### Precondition 
- Location is available at time slot between startTime and endTime.
### Postcondition
- A new lesson is added to the system and made available to instructors.


## addInstructor(name,lesson)
### Precondition
- Instructor is registered and lesson exists in the system.
### Postcondition 
- Instructor is assigned to the lesson.


## addOffering(lesson, instructor)
### Precondition 
- Instructor has been assigned to the lesson.
### Postcondition 
- Offering is added to the system and made available to the public.


## registerClient(age, name, phoneNumber, email)
### Preconditions 
- Age, name, phoneNumber, and email are valid and provided by the client.
- If age < 18, a guardian must also be registered.
### Postcondition
- A Client object is created and registered in the system.
- The client is marked as eligible for booking if age >= 18, otherwise details of the guardian are available.
