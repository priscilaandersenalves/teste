USE [MPFPODB1_DUMP]
GO


/****** Object:  Table [dbo].[acesso_mobile]    Script Date: 24/02/2016 14:04:03 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

CREATE TABLE [dbo].[acesso_mobile](
	[idUsuario] [int] NOT NULL,
	[idLoja] [int] NOT NULL,
	[idEmpresa] [int] NOT NULL,
	[senhaMobile] [varchar](32) NULL,
 CONSTRAINT [acesso_mobile] PRIMARY KEY CLUSTERED 
(
	[idUsuario] ASC,
	[idLoja] ASC,
	[idEmpresa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO



INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41020281,10,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41071128,11,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41071129,12,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41071130,13,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41071274,30,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41071293,47,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,41071305,60,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,42999877,152,'teste');
INSERT INTO [dbo].[acesso_mobile] ([idUsuario] ,[idLoja] ,[idEmpresa]  ,[senhaMobile]) VALUES (1 ,42999888,9,'teste');
GO