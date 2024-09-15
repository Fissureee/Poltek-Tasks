CREATE DATABASE perpustakaan
USE perpustakaan

CREATE TABLE Books
	(BookID int PRIMARY KEY NOT NULL,
	Title varchar(55) NOT NULL,
	Author varchar(55) NOT NULL,
	GenreID int NOT NULL,
	PublicationYear int NOT NULL
	)
GO

CREATE TABLE Genres
	(GenreID int PRIMARY KEY NOT NULL,
	GenreName varchar(25) NOT NULL)
GO

CREATE TABLE Users
	(UserID int PRIMARY KEY NOT NULL,
	UserName varchar(55) NOT NULL,
	MembershipType varchar(55) NOT NULL)
GO

CREATE TABLE Loans
	(LoanID int PRIMARY KEY NOT NULL,
	BookID int FOREIGN KEY REFERENCES Books(BookID),
	UserID int FOREIGN KEY REFERENCES Users(UserID),
	LoanData datetime,
	ReturnDate datetime)
GO

--Populating the table
INSERT Genres (GenreID, Genrename)
	VALUES(1, 'Fiction'),
		(2, 'True Crime'),
		(3, 'Romance Novel'),
		(4, 'Mystery'),
		(5, 'Thriller'),
		(6, 'Science Fiction'),
		(7, 'Action Fiction'),
		(8, 'Fairy Tale'),
		(9, 'Novel'),
		(10, 'History')
GO

INSERT Books (BookID, Title, Author, GenreID,PublicationYear)
	VALUES(123, 'The Worm and The Snake', 'Snape S.', 1, 2000),
		(124, 'The Goose Chase', 'Gordon H.', 2, 2001),
		(125, 'A Day to Remember', 'Quake G.', 3, 2001),
		(126, 'Scrammble', 'Zoey C.', 4, 2004),
		(127, 'A Rainy Day', 'John D.', 5, 2003),
		(128, 'The Pizza Place', 'Freddy Z.', 6, 2002),
		(129, 'Le Goons', 'Frank C.', 7, 2005),
		(130, 'Dive in', 'Lily V.', 8, 2003),
		(131, 'Clock out', 'Chika D.', 9, 2001),
		(132, 'Zoned', 'Zack L.', 10, 2000)
GO

INSERT Users (UserID, UserName, MembershipType)
	VALUES(1, 'Andy', 'platinum'),
		(2, 'Brooke', 'gold'),
		(3, 'Zane', 'silver'),
		(4, 'Steven', 'gold'),
		(5, 'Lola', 'platinum')
GO

INSERT INTO Loans (LoanID, BookID, UserID, LoanData, ReturnDate)
	VALUES (1, 123, 5, '2022-06-01', '2022-06-08'),
		(2, 131, 3, '2022-06-02', '2022-06-09'),
		(3, 130, 2, '2022-06-03', '2022-06-10'),
		(4, 129, 1, '2022-06-04', '2022-06-11'),
		(5, 125, 4, '2022-06-05', '2022-06-12'),
		(6, 126, 2, '2022-06-06', '2022-06-13'),
		(7, 131, 4, '2022-06-07', '2022-06-14'),
		(8, 126, 5, '2022-06-08', '2022-06-15'),
		(9, 130, 3, '2022-06-09', '2022-06-16'),
		(10, 123, 3, '2022-06-10', '2022-06-17'),
		(11, 125, 1, '2022-06-11', '2022-06-18'),
		(12, 124, 5, '2022-06-12', '2022-06-19'),
		(13, 128, 5, '2022-06-13', '2022-06-20'),
		(14, 125, 5, '2022-06-14', '2022-06-21'),
		(15, 128, 1, '2022-06-15', '2022-06-22'),
		(16, 129, 2, '2022-06-16', '2022-06-23'),
		(17, 131, 2, '2022-06-17', '2022-06-24'),
		(18, 132, 3, '2022-06-18', '2022-06-25'),
		(19, 124, 1, '2022-06-19', '2022-06-26'),
		(20, 126, 1, '2022-06-20', '2022-06-27'),
		(21, 123, 4, '2022-06-21', '2022-06-28'),
		(22, 124, 4, '2022-06-22', '2022-06-29'),
		(23, 128, 2, '2022-06-23', '2022-06-30'),
		(24, 132, 4, '2022-06-24', '2022-07-01'),
		(25, 130, 3, '2022-06-25', '2022-07-02')
GO

--Books Table
SELECT 
    BookID,
    Title,
    Author,
    GenreName AS Genre,
    PublicationYear
FROM Books
JOIN Genres ON Books.GenreID = Genres.GenreID;

-- Genres table
SELECT 
    GenreID,
    GenreName
FROM Genres;

-- Users table
SELECT 
    UserID,
    UserName,
    MembershipType
FROM Users;

-- Loans table
SELECT 
    L.LoanID,
    B.Title AS BookTitle,
    U.UserName,
    L.LoanData,
    L.ReturnDate
FROM Loans L
JOIN Books B ON L.BookID = B.BookID
JOIN Users U ON L.UserID = U.UserID;