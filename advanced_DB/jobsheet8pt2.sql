CREATE VIEW Sales.PivotCustGroups AS
WITH PivotCustGroups AS
(
	SELECT
		custid,
		country,
		custgroup
	FROM Sales.CustGroups
)
SELECT 
	country,
	p.A,
	p.B,
	p.C
FROM PivotCustGroups
PIVOT (COUNT(custid) FOR custgroup IN (A, B, C)) AS p;

--Number 9
SELECT
    country,
    A,
    B,
    C
FROM Sales.PivotCustGroups;

--Number 10
SELECT
    'A' AS custgroup,
	country,
    A AS numberofcustomers
FROM Sales.PivotCustGroups

UNION ALL

SELECT
    'B' AS custgroup,
	country,
    B AS numberofcustomers
FROM Sales.PivotCustGroups

UNION ALL

SELECT
    'C' AS custgroup,
	 country,
    C AS numberofcustomers
FROM Sales.PivotCustGroups
ORDER BY country, custgroup;

--Number 11
SELECT
    country,
    city,
    COUNT(*) AS noofcustomers
FROM Sales.Customers
GROUP BY GROUPING SETS
    ((country, city), (country), (city), ());

--Number 12
SELECT
    YEAR(orderdate) AS orderyear,
    MONTH(orderdate) AS ordermonth,
    DAY(orderdate) AS orderday,
    SUM(val) AS salesvalue
FROM Sales.OrderValues
GROUP BY CUBE (YEAR(orderdate), MONTH(orderdate), DAY(orderdate));


--Numnber 13
SELECT
    YEAR(orderdate) AS orderyear,
    MONTH(orderdate) AS ordermonth,
    DAY(orderdate) AS orderday,
    SUM(val) AS salesvalue
FROM Sales.OrderValues
GROUP BY ROLLUP (YEAR(orderdate), MONTH(orderdate), DAY(orderdate));

--Number 14
--Lebih baik menggunakan subklausa ROLLUP daripada CUBE dalam query langkah 1. Dengan ROLLUP, kita dapat mendapatkan subtotal berdasarkan hierarki data yang telah ditentukan, seperti tahun, bulan, dan hari, tanpa harus memunculkan semua kemungkinan kombinasi subtotal yang mungkin. Itu membuat hasilnya lebih terstruktur dan sesuai dengan kebutuhan dalam melakukan agregasi data. Jadi, pilihan yang lebih tepat dalam konteks ini adalah ROLLUP.


--Number 15
SELECT
    GROUPING_ID(YEAR(orderdate), MONTH(orderdate)) AS groupid,
    YEAR(orderdate) AS orderyear,
    MONTH(orderdate) AS ordermonth,
    SUM(val) AS salesvalue
FROM Sales.OrderValues
GROUP BY GROUPING SETS (
    (YEAR(orderdate), MONTH(orderdate)),
    (YEAR(orderdate)),
    ()
)
ORDER BY groupid, orderyear, ordermonth;
