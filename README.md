# Customer-Order System
Basic customer-order save system for homework.


# Program Input:

(Name, Sector, RegistrationMonth)
Customer("Emre", "IT", "May")

Customer("Ali", "Finance", "June")

Customer("Mete", "Human Resources", "June")

Customer("Alpay", "Communication", "July")

Customer("Büşra", "IT", "July")

Customer("Selin", "Finance", "July")

Customer("Cemre", "Communication", "June")

Customer("Caner", "Human Resources", "May")



(CustomerName, Amount)
Invoice("Emre", 200.0)

Invoice("Emre", 250.0)

Invoice("Emre", 100.0)

Invoice("Ali", 2000.0)

Invoice("Mete", 100.0);

Invoice("Mete", 300.0)

Invoice("Alpay", 4000.0);

Invoice("Alpay", 400.0)

Invoice("Büşra", 100.0)

Invoice("Selin", 20.0)

Invoice("Selin", 100.0)

Invoice("Cemre", 2000.0)

Invoice("Caner", 100.0)
        
        
# Program Output(without user registration and invoice save):  

## All Customers:
---------------------
Name: Mete

Sector: Human Resources

Registration Month: June

---------------------

---------------------

Name: Selin

Sector: Finance

Registration Month: July

---------------------

---------------------

Name: Cemre

Sector: Communication

Registration Month: June

---------------------

---------------------

Name: Caner

Sector: Human Resources

Registration Month: May

---------------------

---------------------

Name: Emre

Sector: IT

Registration Month: May

---------------------

---------------------

Name: Büşra

Sector: IT

Registration Month: July

---------------------

---------------------

Name: Alpay

Sector: Communication

Registration Month: July

---------------------

---------------------

Name: Ali

Sector: Finance

Registration Month: June

---------------------

*******************************


## Customers with 'C' in their name:

---------------------

Name: Cemre

Sector: Communication

Registration Month: June

---------------------

---------------------

Name: Caner

Sector: Human Resources

Registration Month: May

---------------------

*******************************


## Sum of total amounts of customers who registered in june: 

4400.0

*******************************


## All Invoices:

---------------------

Name: Emre

Total Amount: 200.0


---------------------

---------------------

Name: Emre

Total Amount: 250.0

---------------------

---------------------

Name: Emre

Total Amount: 100.0


---------------------

---------------------

Name: Ali

Total Amount: 2000.0


---------------------

---------------------

Name: Mete

Total Amount: 100.0


---------------------

---------------------

Name: Mete

Total Amount: 300.0


---------------------

---------------------

Name: Alpay

Total Amount: 4000.0


---------------------

---------------------

Name: Alpay

Total Amount: 400.0


---------------------

---------------------

Name: Büşra

Total Amount: 100.0


---------------------

---------------------

Name: Selin

Total Amount: 20.0


---------------------

---------------------

Name: Selin

Total Amount: 100.0


---------------------

---------------------

Name: Cemre

Total Amount: 2000.0


---------------------

---------------------

Name: Caner

Total Amount: 100.0


---------------------

*******************************


## Invoices over 1500TL:

---------------------

Name: Ali

Total Amount: 2000.0


---------------------

---------------------

Name: Alpay

Total Amount: 4000.0


---------------------

---------------------

Name: Cemre

Total Amount: 2000.0


---------------------

*******************************


## Average of the invoices over 1500TL: 

2666.6


## Customers who has invoice below 500TL:

Emre

Mete

Büşra

Selin

Caner

*******************************


## Sectors of companies whose invoice average is below 750 in June:

Human Resources


Process finished with exit code 0

