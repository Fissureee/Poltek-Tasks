USE TSQL;
GO
--Number 1
CREATE VIEW Sales.CustGroups
AS
SELECT custid, CHOOSE(custid % 3 + 1, N'A', N'B', N'C') AS custgroup, country
FROM Sales.Customers;
SELECT custid, custgroup, country FROM Sales.CustGroups;

--Number 2
WITH PivotedData AS (
    SELECT country, [A], [B], [C]
    FROM (
        SELECT country, CustGroup
        FROM Sales.custgroups
    ) AS SourceData
    PIVOT (
        COUNT(CustGroup)
        FOR CustGroup IN ([A], [B], [C])
    ) AS PivotTable
)
SELECT country, [A] AS A, [B] AS B, [C] AS C
FROM PivotedData
GROUP BY country, [A], [B], [C];

--Number 3
ALTER VIEW Sales.CustGroups AS
SELECT
	custid,
	CHOOSE(custid % 3 + 1, N'A', N'B', N'C') AS custgroup,
	country,
	city,
	contactname
FROM Sales.Customers;

WITH PivotedData AS (
    SELECT country, [A], [B], [C]
    FROM (
        SELECT country, CustGroup
        FROM Sales.custgroups
    ) AS SourceData
    PIVOT (
        COUNT(CustGroup)
        FOR CustGroup IN ([A], [B], [C])
    ) AS PivotTable
)
SELECT country, [A] AS A, [B] AS B, [C] AS C
FROM PivotedData
GROUP BY country, [A], [B], [C];


--Number 4
WITH PivotedData AS (
    SELECT country, city, contactname, [A], [B], [C]
    FROM (
        SELECT country, CustGroup, city, contactname
        FROM Sales.custgroups
    ) AS SourceData
    PIVOT (
        COUNT(CustGroup)
        FOR CustGroup IN ([A], [B], [C])
    ) AS PivotTable
)
SELECT country, city, contactname, [A] AS A, [B] AS B, [C] AS C
FROM PivotedData
GROUP BY country, [A], [B], [C], city, contactname;

--Number 5
WITH PivotCustGroups AS (
    SELECT custid, country, custgroup
    FROM Sales.CustGroups
)
SELECT *
FROM PivotCustGroups
PIVOT (
    COUNT(custgroup)
    FOR custgroup IN ([A], [B], [C])
) AS PivotTable;

--Number 6
--Hasil dari query di atas akan mirip dengan praktikum bagian 1 jika data dalam view Sales.CustGroups tidak berubah; namun, persisnya akan tergantung pada data dan struktur yang ada dalam view tersebut.

--Number 7
--Penggunaan CTE dalam query PIVOT membuat kode lebih bersih dan mudah dibaca, memisahkan logika pengambilan data dari operasi PIVOT, dan mengurangi duplikasi kode. Ini menghasilkan kode yang lebih efisien dan mudah dipahami. CTE juga dapat membantu dalam pengelolaan kode yang kompleks.

--Number 8
WITH SalesByCategory AS (
    SELECT
        o.custid,
        NULLIF(od.qty * od.unitprice, 0) AS salesvalue,
        c.categoryname
    FROM Sales.Orders o
    JOIN Sales.OrderDetails od ON o.orderid = od.orderid
    JOIN Production.Products p ON od.productid = p.productid
    JOIN Production.Categories c ON p.categoryid = c.categoryid
    WHERE YEAR(o.orderdate) = 2008
)

SELECT
    custid,
    SUM(NULLIF(CASE WHEN categoryname = 'Beverages' THEN salesvalue ELSE 0 END, 0)) AS Beverages,
    SUM(NULLIF(CASE WHEN categoryname = 'Condiments' THEN salesvalue ELSE 0 END, 0)) AS Condiments,
    SUM(NULLIF(CASE WHEN categoryname = 'Confections' THEN salesvalue ELSE 0 END, 0)) AS Confections,
    SUM(NULLIF(CASE WHEN categoryname = 'Dairy Products' THEN salesvalue ELSE 0 END, 0)) AS [Dairy Products],
    SUM(NULLIF(CASE WHEN categoryname = 'Grain/Cereals' THEN salesvalue ELSE 0 END, 0)) AS [Grain/Cereals],
    SUM(NULLIF(CASE WHEN categoryname = 'Meat/Poultry' THEN salesvalue ELSE 0 END, 0)) AS [Meat/Poultry],
    SUM(NULLIF(CASE WHEN categoryname = 'Produce' THEN salesvalue ELSE 0 END, 0)) AS Produce,
    SUM(NULLIF(CASE WHEN categoryname = 'Seafood' THEN salesvalue ELSE 0 END, 0)) AS Seafood
FROM SalesByCategory
GROUP BY custid;