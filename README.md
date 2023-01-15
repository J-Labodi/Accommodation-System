# Accomodation-System

The aim of the project was to design and implement an accomodation booking system for the Univeristy of the West of England, which enables the UWE Accommodation Office to schedule hall activities and keep track of the hall rooms through maintaining the list of room leases by the developed accommodation system.

The developer team has been assignbed with the task of plan, design, develop & test an MVP that utilises;
* OOP principles
* GoF design patterns
* SOLID principles 

The acommodation system has been completed in Agile settings, developing the project by continous iteration. The entire project is divided into twenty 
sprint periods and each, 1 week-long sprint period included a small portion of work to be done.


Contirubotors:


## Project Description

The main responsibility of the UWE accommodation office is to provide the necessary help 
for all the registered students who are entitled and require their accommodation on-campus.
The on-campus accommodation comprises of many halls of residence, and each hall has a 
number of rooms. The accommodation office has a hall manager who supervises the 
operation of the halls. Each hall has a warden who oversees the regular cleaning and 
maintenance of all the rooms in that hall. Each hall of residence has a name, number, 
address, telephone number. The halls provide only single rooms which have a room number 
and monthly rent rate. The total number of rooms provided by the accommodation office 
should also be available. The hall number uniquely identifies each room in all of the halls 
controlled by the accommodation office, and is used when renting a room to a student. <br/><br/>
The UWE Bristol Accommodation Services allow students renting rooms for the entire 12-
month academic year from September to August. Each individual rental agreement between 
a student and the accommodation office is uniquely identified using a lease number. The 
data stored on each lease includes the lease number, duration of the lease (in months), 
address details of the hall, room number, student’s name and ID number.
The room scheduling is coordinated by the hall manager. That is, the hall manager 
generates and maintains the room schedule, keeps a record of all the students staying in 
the halls and reviews applications for future bookings. The hall manager can edit and view 
room details. The view should show all the detailed information about a single room in a 
hall, including its room number, room status (namely, occupied or unoccupied), monthly 
rent rate and other details describing the room. The hall manager should be able to 
determine from this description whether a particular room is available and its suitability for a 
new student to occupy. On the other hand, a warden can view the room details but he has 
limited editing privileges and can only change a room’s cleaning status which can be “clean”, 
“dirty”, or “off-line”. An off-line room is one that cannot be occupied because it requires 
maintenance beyond a normal cleaning.

### Design 

#### Use Case Diagram
<img src="https://user-images.githubusercontent.com/79979904/212549501-d1c771c7-e752-446b-bf52-18969cb3dc7f.png" width="150%">

#### Class Diagram

![image](https://user-images.githubusercontent.com/79979904/212549621-5a61e305-454b-4425-ac01-be6f200f0ed8.png)

#### Sequence Diagram 1: View Number of Rooms in a Hall
![image](https://user-images.githubusercontent.com/79979904/212549780-b9512b2b-72e3-4b71-a7a8-fa2818094bb7.png)

#### Sequence Diagram 2: Change Room's Cleaning Status

![image](https://user-images.githubusercontent.com/79979904/212549908-d60a03fb-8a05-4097-9d64-7535486bc862.png)


#### Sequence Diagram 3: Display Hall Details

![image](https://user-images.githubusercontent.com/79979904/212549916-efd07ed7-8a09-47b6-ba04-a908384731df.png)





### Implementation 

#### Work Plan 

The developer team identified the following subtasks within the project that required to be delivered in 
order to successfully complete the project:
* Implementation of low-level class design (Sprint no. 1)
* Develop GUI in Java FX that is suitable to implement the functional requirements related to each 
of the different types of users that will interact with the system (Sprint no. 2 & 3)
* Connect class design to GUI, implementing logic that would result in meeting the system 
requirements <br/>

The above-mentioned high-level tasks are represented in the following product backlog, displaying the 
desired functionalities in detail as well as their priority, sprint number and their status of 
implementation. <br/><br/>

<img src="https://user-images.githubusercontent.com/79979904/212549335-54fe73ec-018c-468a-b702-e99c04994e28.png" width="50%">

<img src="https://user-images.githubusercontent.com/79979904/212548709-83db27d8-7b9a-4293-9840-fc175fb26517.png" width="50%">

<img src="https://user-images.githubusercontent.com/79979904/212548755-e9890e0d-5734-4f67-ab8e-46c6df022e65.png" width="50%">

### Developed System 

#### Login 

<img src="https://user-images.githubusercontent.com/79979904/212553249-e6c547eb-dffe-42f2-b047-f59a84cf5aea.png" width="300">

#### Hall Manager View

<img src="https://user-images.githubusercontent.com/79979904/212552651-3e503aba-3119-4498-8c97-95c651a7956d.jpg" width="700">

#### Warden View

<img src="https://user-images.githubusercontent.com/79979904/212552786-e1c9cb63-8227-47d2-87bf-1fec3f31e345.png" width="700">

#### Superuser View

<img src="https://user-images.githubusercontent.com/79979904/212552821-7058b1af-31e2-48a2-9af8-a45cf85647a2.png" width="700">


### Testing 
#### List of test cases and their outcome

![image](https://user-images.githubusercontent.com/79979904/212553924-1ff250d9-17d6-4560-978a-3979e401530f.png)

![image](https://user-images.githubusercontent.com/79979904/212553960-e4c942d0-1d2d-4893-8d7c-32527d8ec2c2.png)

![image](https://user-images.githubusercontent.com/79979904/212553982-1ffbfad6-1bb5-4b45-901d-63c8edc2b462.png)

## Run the application locally

* In order to run the MVP of Accommodation System in a local environment, download the project and run the LoginController.java file from the src/uweaccommodationsystem/gui directory (JavaFX required). 
* Login page accepts the following usernames:
- character "h" to access the Hall Manager view
- character "w" to access the Warden view
- character "a" to access the Superuser view <br/> 
(password is not required)

