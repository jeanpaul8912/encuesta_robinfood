CREATE TABLE dbo.encuesta(
	id int IDENTITY(1,1) NOT NULL,
	id_restaurante int,
	codigo varchar(20),
	descripcion varchar(500)
	CONSTRAINT PK_encuesta PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.encuesta_resultado(
	id int IDENTITY(1,1) NOT NULL,
	id_encuesta int,
	id_cliente int,
	fechahora datetime,
	id_estado_encuesta int,
	CONSTRAINT PK_encuesta_resultado PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.detalle_resultado(
	id int IDENTITY(1,1) NOT NULL,
	id_encuesta_resultado int,
	id_pregunta int,
	respuesta nvarchar(2000)
	CONSTRAINT PK_detalle_resultado PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.estado_encuesta(
	id int IDENTITY(1,1) NOT NULL,
	codigo varchar(20),
	descripcion varchar(500)
	CONSTRAINT PK_estado_encuesta PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.pregunta(
	id int IDENTITY(1,1) NOT NULL,
	id_encuesta int,
	codigo varchar(20),
	descripcion varchar(500)
	CONSTRAINT PK_pregunta PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.tipo_pregunta(
	id int IDENTITY(1,1) NOT NULL,
	codigo varchar(20),
	descripcion varchar(500)
	CONSTRAINT PK_tipo_pregunta PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.opcion_resultado(
	id int IDENTITY(1,1) NOT NULL,
	id_detalle_resultado int,
	id_opcion_respuesta int,
	respuesta varchar(2000)
	CONSTRAINT PK_opcion_resultado PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)

CREATE TABLE dbo.opcion_respuesta(
	id int IDENTITY(1,1) NOT NULL,
	id_pregunta int,
	codigo varchar(20),
	descripcion varchar(500)
	CONSTRAINT PK_opcion_respuesta PRIMARY KEY CLUSTERED 
	(
		id ASC
	)
)
