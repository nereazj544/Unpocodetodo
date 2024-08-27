# -*- coding: utf-8 -*-
"""
Comentario?
"""

import datetime


def edad(anio_nac) : 
    """
    Esta funcion calcula los años que cumplo en el año acutal
    """
    hoy = datetime.datetime.today()
    return hoy.year - anio_nac

mi_edad = edad(2004)

# mostrar el resultado en pantalla

print("Este año cumplo: ", mi_edad, " años")
    