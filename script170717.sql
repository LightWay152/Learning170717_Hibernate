USE [Java]
GO
/****** Object:  Table [dbo].[Courses]    Script Date: 07/17/2017 20:57:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Courses](
	[Id] [char](3) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[Schoolfee] [float] NULL,
	[LearnerCount] [int] NULL,
	[StartDate] [date] NULL,
	[Status] [bit] NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY],
UNIQUE NONCLUSTERED 
(
	[Name] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Courses] ([Id], [Name], [Schoolfee], [LearnerCount], [StartDate], [Status]) VALUES (N'AND', N'Lập trình Android', 2500000, 22, CAST(0xFE3C0B00 AS Date), 0)
INSERT [dbo].[Courses] ([Id], [Name], [Schoolfee], [LearnerCount], [StartDate], [Status]) VALUES (N'ANG', N'AngularJS', 1500000, 25, CAST(0x0E3D0B00 AS Date), 0)
INSERT [dbo].[Courses] ([Id], [Name], [Schoolfee], [LearnerCount], [StartDate], [Status]) VALUES (N'JAV', N'Lập trình web với Java', 4000000, 25, CAST(0xFE3C0B00 AS Date), 0)
INSERT [dbo].[Courses] ([Id], [Name], [Schoolfee], [LearnerCount], [StartDate], [Status]) VALUES (N'MVC', N'Lập trình ASP.NET MVC 5', 3000000, 26, CAST(0xFE3C0B00 AS Date), 0)
INSERT [dbo].[Courses] ([Id], [Name], [Schoolfee], [LearnerCount], [StartDate], [Status]) VALUES (N'PHP', N'Lập trình web với PHP', 2500000, 24, CAST(0xFE3C0B00 AS Date), 0)
INSERT [dbo].[Courses] ([Id], [Name], [Schoolfee], [LearnerCount], [StartDate], [Status]) VALUES (N'SEO', N'Internet Marketing', 1500000, 23, CAST(0xFE3C0B00 AS Date), 0)
/****** Object:  Table [dbo].[Categories]    Script Date: 07/17/2017 20:57:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Categories](
	[Id] [char](3) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'ABC', N'Tên Loại')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'LAP', N'Laptop')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'MOB', N'Mobile')
INSERT [dbo].[Categories] ([Id], [Name]) VALUES (N'REM', N'Remote')
/****** Object:  Table [dbo].[Products]    Script Date: 07/17/2017 20:57:39 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Products](
	[Id] [int] IDENTITY(1000,1) NOT NULL,
	[Name] [nvarchar](50) NOT NULL,
	[CategoryId] [char](3) NULL,
PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX  = OFF, STATISTICS_NORECOMPUTE  = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS  = ON, ALLOW_PAGE_LOCKS  = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
SET ANSI_PADDING OFF
GO
SET IDENTITY_INSERT [dbo].[Products] ON
INSERT [dbo].[Products] ([Id], [Name], [CategoryId]) VALUES (1000, N'iPhone 9', N'MOB')
INSERT [dbo].[Products] ([Id], [Name], [CategoryId]) VALUES (1001, N'Samsung Galaxy', N'MOB')
INSERT [dbo].[Products] ([Id], [Name], [CategoryId]) VALUES (1002, N'Sony Vaio', N'LAP')
INSERT [dbo].[Products] ([Id], [Name], [CategoryId]) VALUES (1003, N'Canon 2017', N'MOB')
SET IDENTITY_INSERT [dbo].[Products] OFF
/****** Object:  Default [DF__Courses__Learner__0BC6C43E]    Script Date: 07/17/2017 20:57:39 ******/
ALTER TABLE [dbo].[Courses] ADD  DEFAULT ((0)) FOR [LearnerCount]
GO
/****** Object:  Default [DF__Courses__StartDa__0CBAE877]    Script Date: 07/17/2017 20:57:39 ******/
ALTER TABLE [dbo].[Courses] ADD  DEFAULT (getdate()) FOR [StartDate]
GO
/****** Object:  Default [DF__Courses__Status__0DAF0CB0]    Script Date: 07/17/2017 20:57:39 ******/
ALTER TABLE [dbo].[Courses] ADD  DEFAULT ((0)) FOR [Status]
GO
/****** Object:  Default [DF__Products__Catego__0EA330E9]    Script Date: 07/17/2017 20:57:39 ******/
ALTER TABLE [dbo].[Products] ADD  DEFAULT ('MOB') FOR [CategoryId]
GO
/****** Object:  Check [CK__Courses__Learner__0F975522]    Script Date: 07/17/2017 20:57:39 ******/
ALTER TABLE [dbo].[Courses]  WITH CHECK ADD CHECK  (([LearnerCount]>=(15) AND [LearnerCount]<=(30)))
GO
/****** Object:  ForeignKey [FK__Products__Catego__108B795B]    Script Date: 07/17/2017 20:57:39 ******/
ALTER TABLE [dbo].[Products]  WITH CHECK ADD FOREIGN KEY([CategoryId])
REFERENCES [dbo].[Categories] ([Id])
ON UPDATE CASCADE
ON DELETE SET DEFAULT
GO
