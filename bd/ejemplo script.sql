select * 
from		dbo.encuesta a
inner join	dbo.pregunta b
on			a.id = b.id_encuesta
left join	dbo.opcion_respuesta c
on			b.id = c.id_pregunta

select		*
from		dbo.encuesta_resultado a
inner join	dbo.detalle_resultado b
on			a.id = b.id_encuesta_resultado
left join	dbo.opcion_resultado c
on			b.id = c.id_detalle_resultado