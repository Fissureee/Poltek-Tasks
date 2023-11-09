USE TSQL

--Number 1
SELECT
    orderid,
    orderdate,
    val,
    ROW_NUMBER() OVER (ORDER BY orderdate) AS rowno
FROM Sales.OrderValues;

--Number 2
SELECT
    orderid,
    orderdate,
    val,
    RANK() OVER (ORDER BY orderdate) AS rankno
FROM Sales.OrderValues;


--Number 3
--Fungsi RANK dan fungsi ROW_NUMBER adalah dua fungsi analitik dalam SQL yang digunakan untuk menghasilkan nomor baris (row number) atau peringkat data dalam hasil kueri. Perbedaan utama antara keduanya adalah dalam cara mereka menangani nilai yang memiliki urutan yang sama (nilai yang sama).


--Number 4
SELECT
    orderid,
    orderdate,
    custid,
    val,
    RANK() OVER (PARTITION BY custid ORDER BY val DESC) AS orderrankno
FROM Sales.OrderValues;

--Number 5
SELECT
    custid,
    val,
    YEAR(orderdate) AS orderyear,
    ROW_NUMBER() OVER (PARTITION BY custid, YEAR(orderdate) ORDER BY val DESC) AS orderrankno
FROM Sales.OrderValues;

--Number 6
SELECT custid, orderyear, orderrankno, val
FROM (
    SELECT
        custid,
        YEAR(orderdate) AS orderyear,
        ROW_NUMBER() OVER (PARTITION BY custid, YEAR(orderdate) ORDER BY val DESC) AS orderrankno,
		val
    FROM Sales.OrderValues
) ranked_orders
WHERE orderrankno <= 2;


--Number 7
WITH OrderRows AS (
    SELECT
        orderid,
        orderdate,
        val,
        ROW_NUMBER() OVER (ORDER BY orderdate, orderid) AS rowno
    FROM Sales.OrderValues
)

--Number 8
SELECT
    curr.orderid,
    curr.orderdate,
    curr.val,
    prev.val AS prevval,
    curr.val - prev.val AS diffprev
FROM OrderRows curr
LEFT JOIN OrderRows prev ON curr.rowno = prev.rowno + 1


--Number 9
SELECT
    orderid,
    orderdate,
    val,
    LAG(val, 1) OVER (ORDER BY orderdate) AS prevval,
    val - LAG(val, 1) OVER (ORDER BY orderdate) AS diffprev
FROM Sales.OrderValues;


--Number 10
WITH SalesMonth2007 AS (
    SELECT
        MONTH(orderdate) AS monthno,
        SUM(val) AS val
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = 2007
    GROUP BY MONTH(orderdate)
)

--Number 11
SELECT
    sm.monthno,
    sm.val,
    AVG(val) OVER (ORDER BY sm.monthno ROWS BETWEEN 2 PRECEDING AND CURRENT ROW) AS avglast3months,
    val - FIRST_VALUE(val) OVER (ORDER BY sm.monthno) AS diffjanuary,
    LEAD(val, 1) OVER (ORDER BY sm.monthno) AS nextval
FROM SalesMonth2007 sm;


--Number 12
SELECT
    custid,
    orderid,
    orderdate,
    val,
    (val / SUM(val) OVER (PARTITION BY custid)) * 100 AS percoftotalcust
FROM Sales.OrderValues
ORDER BY custid, percoftotalcust DESC;

--Number 13
SELECT
    custid,
    orderid,
    orderdate,
    val,
    (val / SUM(val) OVER (PARTITION BY custid)) * 100 AS percoftotalcust,
    SUM(val) OVER (PARTITION BY custid, orderdate ORDER BY orderid) AS runval
FROM Sales.OrderValues;


--Number 14
WITH SalesMonth2007 AS
(
    SELECT
        MONTH(orderdate) AS monthno,
        val
    FROM Sales.OrderValues
    WHERE YEAR(orderdate) = 2007
)
SELECT
    monthno,
    val,
    AVG(val) OVER (ORDER BY monthno ROWS BETWEEN 2 PRECEDING AND CURRENT ROW) AS avglast3months,
    SUM(val) OVER (ORDER BY monthno) AS ytdval
FROM SalesMonth2007;
