
USE[TSQL]
GO

SELECT [custid], [companyname], [contactname], [contacttitle], [address], [city], [region], [postalcode], [country], [phone], [fax]
FROM [Sales]. [Customers]
GO

--Number 1
SELECT * FROM Sales.Customers;

SELECT 
custid, companyname, contactname, contacttitle, address, city, region, postalcode, country, phone, fax
FROM Sales.Customers;


--Number 2
SELECT * FROM [Sales].[Customers];

SELECT country FROM Sales.Customers;


--Number 3
SELECT DISTINCT country FROM Sales.Customers;


--Number 4
SELECT c.contactname, c.contacttitle FROM Sales.Customers AS c;

SELECT c.contactname AS Name, c.contacttitle AS Title, c.companyname AS [Company Name] FROM Sales.Customers AS c;


--Number 5
SELECT p.categoryid, p.productname FROM Production.Products AS p;

SELECT p.categoryid, p.productname,
CASE
	WHEN p.categoryid = 1 THEN 'Beverages'
	WHEN p.categoryid = 2 THEN 'Condiments'
	WHEN p.categoryid = 3 THEN 'Confections'
	WHEN p.categoryid = 4 THEN 'Dairy Products'
	WHEN p.categoryid = 5 THEN 'Grains/Cereals'
	WHEN p.categoryid = 6 THEN 'Meat/Poultry'
	WHEN p.categoryid = 7 THEN 'Produce'
	WHEN p.categoryid = 8 THEN 'Seafood'
	ELSE 'Other'
END AS categoryname
FROM Production.Products AS p;

--Number 6
SELECT p.categoryid, p.productname,
CASE
	WHEN p.categoryid = 1 THEN 'Beverages'
	WHEN p.categoryid = 2 THEN 'Condiments'
	WHEN p.categoryid = 3 THEN 'Confections'
	WHEN p.categoryid = 4 THEN 'Dairy Products'
	WHEN p.categoryid = 5 THEN 'Grains/Cereals'
	WHEN p.categoryid = 6 THEN 'Meat/Poultry'
	WHEN p.categoryid = 7 THEN 'Produce'
	WHEN p.categoryid = 8 THEN 'Seafood'
	ELSE 'Other'
END AS categoryname,
CASE
	WHEN p.categoryid IN (1, 7, 8) THEN 'Campaign Products'
	ELSE 'Non-Campaign Products'
END AS iscampaign
FROM Production.Products AS p;

--Number 7
SELECT p.categoryid AS ID_KATEGORI, p.productname AS NAMA_PRODUK,
CASE
	WHEN p.categoryid = 1 THEN 'Beverages'
	WHEN p.categoryid = 2 THEN 'Condiments'
	WHEN p.categoryid = 3 THEN 'Confections'
	WHEN p.categoryid = 4 THEN 'Dairy Products'
	WHEN p.categoryid = 5 THEN 'Grains/Cereals'
	WHEN p.categoryid = 6 THEN 'Meat/Poultry'
	WHEN p.categoryid = 7 THEN 'Produce'
	WHEN p.categoryid = 8 THEN 'Seafood'
	ELSE 'Other'
END AS NAMA_KATEGORI,
CASE
	WHEN p.categoryid IN (1, 7, 8) THEN 'Campaign Products'
	ELSE 'Non-Campaign Products'
END AS STATUS
FROM Production.Products AS p
WHERE p.categoryid = 8;


--Number 8
SELECT * FROM HR.Employees;

SELECT HR.Employees.firstname AS FIRST_NAME, HR.Employees.lastname AS LAST_NAME, HR.Employees.city AS CITY, HR.Employees.country AS COUNTRY 
FROM HR.Employees
WHERE HR.Employees.country = 'USA' AND HR.Employees.city = 'Seattle';


--Number 9
SELECT Sales.Customers.custid, Sales.Customers.contactname, Sales.Customers.address, Sales.Customers.city, Sales.Customers.country, Sales.Customers.phone
FROM Sales.Customers
WHERE Sales.Customers.country IN('Brazil', 'UK', 'USA');

--Number 10
SELECT c.custid, c.companyname, o.orderid
FROM Sales.Customers AS c
LEFT OUTER JOIN Sales.Orders AS o ON c.custid = o.custid OR c.city = 'Paris';


--Number 11
SELECT
    c.custid,
    c.contactname,
    o.orderid,
    o.orderdate
FROM Sales.Customers AS c
JOIN Sales.Orders AS o ON c.custid = o.custid
WHERE o.orderdate >= '2008-04-01'
ORDER BY o.orderdate DESC, c.custid ASC;



--Number 12
SELECT e.empid, e.lastname, e.firstname, e.title, e.mgrid, m.lastname AS mgrlastname
FROM HR.Employees AS e
INNER JOIN HR.Employees AS m ON e.mgrid = m.empid
WHERE m.lastname = N'Buck';

--Number 13
SELECT e.empid, e.lastname, e.firstname, e.title, e.mgrid, m.lastname AS mgrlastname
FROM HR.Employees AS e
INNER JOIN HR.Employees AS m ON e.mgrid = m.empid
WHERE m.lastname = N'Buck';

--Number 14
SELECT e.empid, e.lastname, e.firstname, e.title, e.mgrid, m.lastname AS mgrlastname
FROM HR.Employees AS e
INNER JOIN HR.Employees AS m ON e.mgrid = m.empid;

--Number 16
SELECT Production.Products.productname, Production.Products.unitprice
FROM Production.Products
ORDER BY Production.Products.unitprice DESC;


--Number 17
SELECT TOP 8 Production.Products.productname, Production.Products.unitprice
FROM Production.Products
ORDER BY Production.Products.unitprice DESC;


--Number 18
SELECT Production.Products.productname, Production.Products.unitprice
FROM Production.Products
ORDER BY Production.Products.unitprice DESC
OFFSET 0 ROWS
FETCH NEXT 8 ROWS ONLY;


--Number 19
SELECT TOP 20 Sales.Orders.custid, Sales.Orders.orderid, Sales.Orders.orderdate
FROM Sales.Orders
ORDER BY Sales.Orders.orderdate, Sales.Orders.orderid;


--Number 20
SELECT Sales.Orders.custid, Sales.Orders.orderid, Sales.Orders.orderdate
FROM Sales.Orders
ORDER BY Sales.Orders.orderdate, Sales.Orders.orderid
OFFSET 20 ROWS
FETCH NEXT 20 ROWS ONLY;

--Number 21
SELECT productid, productname
FROM Production.Products
WHERE categoryid = 4
UNION
SELECT P.productid, P.productname
FROM Production.Products P INNER JOIN Sales.OrderDetails OD
ON P.productid = OD.productid
GROUP BY P.productid, P.productname
HAVING SUM(OD.qty * OD.unitprice) > 50000;


--Number 22
SELECT productid, productname
FROM Production.Products
WHERE categoryid = 4
UNION ALL
SELECT P.productid, P.productname
FROM Production.Products P INNER JOIN Sales.OrderDetails OD
ON P.productid = OD.productid
GROUP BY P.productid, P.productname
HAVING SUM(OD.qty * OD.unitprice) > 50000;


--Number 24
WITH EarliestCustomers AS
(
    SELECT TOP 10
        c.custid,
        c.companyname,
        MIN(o.orderdate) AS earliestorderdate
    FROM Sales.Customers c
    INNER JOIN Sales.Orders o ON c.custid = o.custid
    GROUP BY c.custid, c.companyname
    ORDER BY earliestorderdate
),

LatestCustomers AS
(
    SELECT TOP 10
        c.custid,
        c.companyname,
        MAX(o.orderdate) AS latestorderdate
    FROM Sales.Customers c
    INNER JOIN Sales.Orders o ON c.custid = o.custid
    GROUP BY c.custid, c.companyname
    ORDER BY latestorderdate DESC
)

SELECT * FROM EarliestCustomers
UNION
SELECT * FROM LatestCustomers;

