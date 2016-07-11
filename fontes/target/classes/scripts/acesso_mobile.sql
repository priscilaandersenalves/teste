USE [MPFPODB1_DUMP]
GO

/****** Object:  Table [dbo].[acesso_mobile]    Script Date: 18/03/2016 14:33:40 ******/
DROP TABLE [dbo].[acesso_mobile]
GO

/****** Object:  Table [dbo].[acesso_mobile]    Script Date: 18/03/2016 14:33:40 ******/
SET ANSI_NULLS ON
GO

SET QUOTED_IDENTIFIER ON
GO

SET ANSI_PADDING ON
GO

CREATE TABLE [dbo].[acesso_mobile](
	[idUsuario] [int] NULL,
	[idLoja] [int] NULL,
	[idEmpresa] [int] NULL,
	[senhaMobile] [varchar](32) NOT NULL
) ON [PRIMARY]

GO

SET ANSI_PADDING OFF
GO


