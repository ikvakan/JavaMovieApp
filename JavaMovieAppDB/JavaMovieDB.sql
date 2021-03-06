CREATE DATABASE [JavaMovieAppDB]

USE [JavaMovieAppDB]
GO
/****** Object:  Table [dbo].[Movie]    Script Date: 24.10.2020. 11:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Movie](
	[IDMovie] [int] IDENTITY(1,1) NOT NULL,
	[Title] [nvarchar](200) NOT NULL,
	[Description] [nvarchar](900) NOT NULL,
	[Director] [nvarchar](200) NOT NULL,
	[Actors] [nvarchar](500) NOT NULL,
	[Duration] [nvarchar](50) NOT NULL,
	[Genre] [nvarchar](50) NOT NULL,
	[PubDate] [nvarchar](50) NOT NULL,
	[PicturePath] [nvarchar](500) NOT NULL,
 CONSTRAINT [PK_Movie] PRIMARY KEY CLUSTERED 
(
	[IDMovie] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserMovies]    Script Date: 24.10.2020. 11:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserMovies](
	[IDUser] [int] NOT NULL,
	[IDMovie] [int] NOT NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Users]    Script Date: 24.10.2020. 11:48:50 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Users](
	[IdUser] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_Users] PRIMARY KEY CLUSTERED 
(
	[IdUser] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[UserMovies]  WITH CHECK ADD  CONSTRAINT [FK_UserMovies_Movie1] FOREIGN KEY([IDMovie])
REFERENCES [dbo].[Movie] ([IDMovie])
GO
ALTER TABLE [dbo].[UserMovies] CHECK CONSTRAINT [FK_UserMovies_Movie1]
GO
ALTER TABLE [dbo].[UserMovies]  WITH CHECK ADD  CONSTRAINT [FK_UserMovies_Users1] FOREIGN KEY([IDUser])
REFERENCES [dbo].[Users] ([IdUser])
GO
ALTER TABLE [dbo].[UserMovies] CHECK CONSTRAINT [FK_UserMovies_Users1]
GO
/****** Object:  StoredProcedure [dbo].[createMovie]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO



--INSERT ADMIN
insert into Users
 ([UserName],[Password]) values('Admin','123')






create procedure [dbo].[createMovie]
	@Title nvarchar(50),
	@Desciption nvarchar(900),
	@Director nvarchar(200),
	@Actors nvarchar(500),
	@Duration nvarchar(50),
	@Genre nvarchar(50),
	@PubDate nvarchar(50),
	@PicturePath nvarchar(500),
	@Id int output

as
begin
	insert into Movie values (@Title,@Desciption,@Director,@Actors,@Duration,@Genre,@PubDate,@PicturePath)
	set @Id=SCOPE_IDENTITY()
end

GO
/****** Object:  StoredProcedure [dbo].[createUser]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE procedure [dbo].[createUser]
	@UserName nvarchar(50),
	@Password nvarchar(50),
	@Id int output
as
begin
	insert into Users values(@UserName,@Password)
	set @Id=SCOPE_IDENTITY()
end
GO
/****** Object:  StoredProcedure [dbo].[deleteMovie]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[deleteMovie]
	@id int
as
begin
	delete from Movie
	where IDMovie=@id
end
GO
/****** Object:  StoredProcedure [dbo].[deleteMovieForUser]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[deleteMovieForUser]
	@Id int
as
begin
	delete from UserMovies
	where IDUser=@Id
end
GO
/****** Object:  StoredProcedure [dbo].[insertIntoUserMovies]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[insertIntoUserMovies]
	@IdUser int,
	@IdMovie int
as
begin
	insert into UserMovies (IDUser,IDMovie) values (@IdUser,@IdMovie) 
end
GO
/****** Object:  StoredProcedure [dbo].[selectMovie]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[selectMovie]
	@IdMovie INT
AS 
BEGIN 
	SELECT 
		* 
	FROM 
		Movie
	WHERE 
		IDMovie = @IdMovie
END
GO
/****** Object:  StoredProcedure [dbo].[selectMovieForUser]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[selectMovieForUser]
	@id int
as
begin
	select m.* from Movie as m
inner join UserMovies as um on m.IDMovie=um.IDMovie
inner join Users as u on u.IdUser=um.IDUser
where u.IdUser=@id
end

GO
/****** Object:  StoredProcedure [dbo].[selectMovies]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[selectMovies]
AS 
BEGIN 
	SELECT * FROM Movie
END
GO
/****** Object:  StoredProcedure [dbo].[selectUser]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[selectUser]
	@Id int
as
begin
	select * from Users
	where IdUser=@Id
end
GO
/****** Object:  StoredProcedure [dbo].[selectUsers]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create procedure [dbo].[selectUsers]
as
begin
	select * from Users
end
GO
/****** Object:  StoredProcedure [dbo].[updateMovie]    Script Date: 24.10.2020. 11:48:51 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

create procedure [dbo].[updateMovie]
	@Title nvarchar(50),
	@Desciption nvarchar(900),
	@Director nvarchar(200),
	@Actors nvarchar(500),
	@Duration nvarchar(50),
	@Genre nvarchar(50),
	@PubDate nvarchar(50),
	@PicturePath nvarchar(500),
	@Id int 
as
begin
	update Movie set 
		Title=@Title,
		Description=@Desciption,
		Director=@Director,
		Actors=@Actors,
		Duration=@Duration,
		Genre=@Genre,
		PubDate=@PubDate,
		PicturePath=@PicturePath

	where
	IDMovie=@id
end
GO
