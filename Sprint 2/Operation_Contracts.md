### makeLesson(location, startTime, endTime, mode)
Precondition : location is available at time slot between startTime and endTime
Postcondition : a new lesson is added to the system and made available to instructors

### addInstructor(name,lesson)
Precondition : instructor is registered and lesson exists in the system
Postcondition : instructor is assigned to the lesson

### addOffering(lesson, instructor)
Precondition : instructor has been assigned to the lesson
Postcondition : offering is added to the system and made available to the public
