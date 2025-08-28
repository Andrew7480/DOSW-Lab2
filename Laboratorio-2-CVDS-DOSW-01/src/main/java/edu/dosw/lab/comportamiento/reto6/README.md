-- PATRON DE DISEÑO --
Chain of responsability

-- JUSTIFICACION --

Como no podiamos otorgar cada ticket a un tecnico en especifico, lo que hacemos es una cadena de responsabilidades entre tecnicos
en la cual le asignamos un tcket a un tecnico de a cuerdo a su nivel, pero si la prioridad no es la adecuada le otorgamos la responsabilidad a otro tecnico,
de modo que si el tecnico basico no puede solucionarlo (nivel =/ basico), lo escala al tecnico intermedio y de igual manera al tecnicoavanzado,
tenemos que evaluar que para que el tecnico pueda solucionar un problema, su nivel debe ser igual que el nivel del tecnico, si su prioridad es mayor al del tecnico pasa a otro tecnico,
pero si es menor directamente debe ser un problema de escalamiento.