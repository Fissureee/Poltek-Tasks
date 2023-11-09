USE TSQL;

--Number 1
SELECT productid, productname, supplierid, unitprice, discontinued
FROM Production.Products
WHERE categoryid = 1;


--Number 2
CREATE VIEW Production.ProductsBeverages AS
SELECT productid, productname, supplierid, unitprice, discontinued
FROM Production.Products
WHERE categoryid = 1;

SELECT productid, productname, supplierid, unitprice, discontinued
FROM Production.ProductsBeverages;

--Number 3
SELECT productid, productname
FROM Production.ProductsBeverages
WHERE supplierid = 1;


--Number 4
/*
Msg 1033, Level 15, State 1, Procedure ProductsBeverages, Line 5
The ORDER BY clause is invalid in views, inline functions, derived tables, subqueries, and common table expressions, unless TOP, OFFSET or FOR XML is also specified.

Pesan kesalahan ini menjelaskan bahwa perintah ORDER BY tidak valid dalam definisi VIEW.Disini tidak dapat menggunakan ORDER BY dalam definisi VIEW seperti yang dicoba.
*/

--Number 5
/*
Tidak, baris yang dihasilkan dari VIEW "Production.ProductsBeverages" tidak akan selalu urut berdasarkan kolom "productname" ketika query dieksekusi terhadap VIEW tersebut. Meskipun dalam definisi VIEW terdapat klausa ORDER BY, urutan data yang dihasilkan dari VIEW biasanya tidak dijamin secara khusus ketika data diambil dari VIEW.

Urutan data pada VIEW tanpa perintah ORDER BY dalam pernyataan SELECT yang mengambil data dari VIEW tidak dijamin dan mungkin akan bervariasi tergantung pada berbagai faktor, termasuk optimizer query. Oleh karena itu, jika Anda ingin hasil yang diurutkan berdasarkan "productname" ketika mengambil data dari VIEW, Anda sebaiknya selalu menggunakan klausa ORDER BY dalam pernyataan SELECT yang mengambil data dari VIEW, seperti yang dijelaskan pada soal sebelumnya.
*/


--Number 6
/*

Setelah mengeksekusi T-SQL di atas, pesan error yang terjadi adalah "Msg 8120, Level 16, State 1, Procedure ProductsBeverages, Line 6 [Batch Start Line 3]: Column 'unitprice' is invalid in the select list because it is not contained in either an aggregate function or the GROUP BY clause."

Penyebab error tersebut adalah penggunaan klausa CASE dengan kondisi "unitprice > 100" di dalam pernyataan SELECT. Dalam pernyataan SELECT, ketika Anda menggunakan klausa CASE, Anda harus mengelompokkan kolom non-agregat atau menggunakan fungsi agregasi seperti SUM, COUNT, MAX, dll.
*/

--Number 7
ALTER VIEW Production.ProductsBeverages AS
SELECT
  productid, productname, supplierid,
  SUM(unitprice) AS totalunitprice,
  discontinued,
  CASE WHEN SUM(unitprice) > 100 THEN N'high' ELSE N'normal' END AS pricecategory
FROM Production.Products
WHERE categoryid = 1
GROUP BY productid, productname, supplierid, discontinued;


--Number 8
SELECT p.productid, p.productname
FROM (
    SELECT
        productid, productname, supplierid, unitprice, discontinued,
        CASE WHEN unitprice > 100 THEN N'high' ELSE N'normal' END AS pricetype
    FROM Production.Products
    WHERE categoryid = 1
) p
WHERE p.pricetype = N'high';


--Number 9
SELECT
    o.custid,
    SUM(od.qty * od.unitprice) AS totalsalesamount,
    AVG(SUM(od.qty * od.unitprice)) OVER (PARTITION BY o.custid) AS avgsalesamount
FROM Sales.Orders AS o
JOIN Sales.OrderDetails AS od ON o.orderid = od.orderid
GROUP BY o.custid;


--Number 10
WITH SalesByYear AS (
    SELECT
        YEAR(orderdate) AS orderyear,
        SUM(val) AS curtotalsales
    FROM Sales.OrderValues
    GROUP BY YEAR(orderdate)
),
PrevYearSales AS (
    SELECT
        orderyear,
        LAG(curtotalsales) OVER (ORDER BY orderyear) AS prevtotalsales
    FROM SalesByYear
)
SELECT
    SY.orderyear,
    SY.curtotalsales,
    PY.prevtotalsales,
    CASE
        WHEN PY.prevtotalsales IS NOT NULL THEN 
            ((SY.curtotalsales - PY.prevtotalsales) / PY.prevtotalsales) * 100
        ELSE NULL
    END AS percentgrowth
FROM SalesByYear SY
LEFT JOIN PrevYearSales PY ON SY.orderyear = PY.orderyear
ORDER BY orderyear;


--Number 11
WITH ProductBeverages AS (
    SELECT
        productid, productname, supplierid, unitprice, discontinued,
        CASE WHEN unitprice > 100 THEN N'high' ELSE N'normal' END AS pricetype
    FROM Production.Products
    WHERE categoryid = 1
)

SELECT productid, productname
FROM ProductBeverages
WHERE pricetype = N'high';


--Number 12
WITH c2008 AS (
    SELECT
        custid,
        SUM(val) AS salesamt2008
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = 2008
    GROUP BY custid
)

SELECT
    c.custid,
    c.contactname,
    c2008.salesamt2008
FROM Sales.Customers AS c
JOIN c2008 ON c.custid = c2008.custid;


--Number 13
WITH c2007 AS (
    SELECT
        custid,
        SUM(val) AS salesamt2007
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = 2007
    GROUP BY custid
),
c2008 AS (
    SELECT
        custid,
        SUM(val) AS salesamt2008
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = 2008
    GROUP BY custid
)

SELECT
    c.custid,
    c.contactname,
    ISNULL(c2008.salesamt2008, 0) AS salesamt2008,
    ISNULL(c2007.salesamt2007, 0) AS salesamt2007,
    CASE
        WHEN c2007.salesamt2007 IS NOT NULL AND c2008.salesamt2008 IS NOT NULL
        THEN (c2008.salesamt2008 - c2007.salesamt2007) * 100.0 / c2007.salesamt2007
        ELSE 0
    END AS percentgrowth
FROM Sales.Customers AS c
LEFT JOIN c2007 ON c.custid = c2007.custid
LEFT JOIN c2008 ON c.custid = c2008.custid
ORDER BY percentgrowth DESC;


--Number 14
SELECT custid, SUM(val) AS totalsalesamount
FROM Sales.OrderValues
WHERE YEAR(orderdate) = 2007
GROUP BY custid;


--Number 15
CREATE FUNCTION dbo.fnGetSalesByCustomer
(@orderyear AS INT)
RETURNS TABLE
AS
RETURN
(
    SELECT custid, SUM(val) AS totalsalesamount
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = @orderyear
    GROUP BY custid
);

SELECT *
FROM dbo.fnGetSalesByCustomer(2007);


--Number 16
CREATE FUNCTION dbo.fnGetSalesByCustomer
(@orderyear AS INT)
RETURNS TABLE
AS
RETURN
(
    SELECT custid, SUM(val) AS totalsalesamount
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = @orderyear
    GROUP BY custid
);


--Number 17
SELECT custid, totalsalesamount
FROM dbo.fnGetSalesByCustomer(2007);


--Number 18
WITH SalesPerProduct AS (
    SELECT
        od.productid,
        p.productname,
        SUM(od.qty * od.unitprice) AS totalsalesamount
    FROM Sales.OrderDetails AS od
    JOIN Sales.Orders AS o ON od.orderid = o.orderid
    JOIN Production.Products AS p ON od.productid = p.productid
    WHERE o.custid = 1
    GROUP BY od.productid, p.productname
)

SELECT TOP 3 productid, productname, totalsalesamount
FROM SalesPerProduct
ORDER BY totalsalesamount DESC;

--Number19
CREATE FUNCTION dbo.fnGetTop3ProductsForCustomer
(@custid AS INT) RETURNS TABLE
AS
RETURN
(
    SELECT TOP 3
        od.productid,
        p.productname,
        SUM(od.qty * od.unitprice) AS totalsalesamount
    FROM Sales.OrderDetails AS od
    JOIN Sales.Orders AS o ON od.orderid = o.orderid
    JOIN Production.Products AS p ON od.productid = p.productid
    WHERE o.custid = @custid
    GROUP BY od.productid, p.productname
    ORDER BY totalsalesamount DESC
);


--Number 20
SELECT p.productid, p.productname, p.totalsalesamount
FROM dbo.fnGetTop3ProductsForCustomer(1) AS p;

