1. I have a doubt, are we even considering in this design about future availability of room, because room status if reserved for that particular time only else available. so will system create multiple room objects? Need to see solution from other platforms. Current UML/Solution is more like a happy path thing where all rooms are avaialbel, you just come and book room, do checkin and do checkout. Assume that avaialbility check of room is already done by some other service (then it will be more like a booking.com problem).

2. doubt cleared - first thing is that UML is very high level, see actual code and understand the flow, extra things are - decorator patter, something called specification pattern. UML Entities deep down are same but soem things are extra. like services and decorator/state pattern

3. Also they are looking into booking right now types hotel management system, not something like booking.com where you do reservation.

4. They have state pattern also but kinda unnecessary but yes you can add for extensibility reasons,in future if you want to add some other functionalities, state pattern will let you separate things depending on current room state.