# warehouse
Clothes Warehouse - Web Application Development - Winter 2023 - Spring Framework

Part 1:
Create a clothes warehouse control application in Spring Boot
- Create a shell project using Spring Initializr 
- Create an item model that will contain following fields: id, name, brand (should be enum of fashionable brands)
(Balenciaga, Stone Island, Dior, e.g), year of creation, price 
- Create Thymeleaf page to add item to stock using HTML form 
- On addition of an item form should perform following validations (price is more than 1000, brand should be one of the list,
year of creation is more than 2021)
- Addition should be performed successfully with no errors 

- Use Bootstrap to provide styling 
Part 2:
Add Database Capabilities for Clothes Warehouse
- Implement JPA Repository for Clothes Store with pagination and sorting 
- Annotate Item with JPA model annotations so Item is interpreted as table 
- Use command line runner to populate the table with some items 
- On addition of the item it should be save to the database
- After addition you should be redirected to the list page (that you would need to create) that lists all the items 
- Use bootstrap for styling of the list 
- Create custom query to return items only for one specific brand and year 2022 and create a button on list page that on click
sorts list by brand and re-renders the list

Part 3:
Add User management and Security for Clothes Warehouse
- Implement registration and security configuration for Clothes Warehouse 
- Create three user roles: admin, warehouse employee and regular user 
- Create clothes management page available only to admin role 
- Admin should be able to delete item from the list 
- Add item screen should be available only to admin and warehouse employee 
- Use bootstrap for styling of the admin page and create custom login screen 
