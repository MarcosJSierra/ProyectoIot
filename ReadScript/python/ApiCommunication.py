def cabecera():
    print('''
                   -`                    Proyecto lotso
                  .o+`                   ------------------ 
                 `ooo/                   Powered by Arch Linux 
                `+oooo:                  Marcos Sierra 
               `+oooooo:                 Sharon Gomez 
               -+oooooo+:                Marvin lopez 
             `/:-:++oooo+:               ------------------- 
            `/++++/+++++++:              Lecture Script powered by python 3
           `/++++++++++++++:             API powered by Java Spring
          `/+++ooooooooooooo/`           Front end powered by 
         ./ooosssso++osssssso+`           
        .oossssso-````/ossssss+`          
       -osssssso.      :ssssssso.         
      :osssssss/        osssso+++.        
     /ossssssss/        +ssssooo/-        
   `/ossssso+/:-        -:/+osssso+-      
  `+sso+:-`                 `.-/+oso:     
 `++:.                           `-/+/
 .`                                 `/
    ''')

def get_tank_info():
    """ 
    Obtiene informacion del tanque de la base de datos
    
    return: dictionary, informacion del tanque con las llaves:lecture_range, lecture_range_s
    """ 
    print("obteniendo informacion del tanque")
    tank_info = {
        "capacity": 15,
        "full_lecture": 1,
        "empty_lecture": 9
    }
    return tank_info


def set_new_event(event_code, event_name, id_sensor):
    """
    set a new event in the API
    
    param: eventCode, Int, codigo del evento

    param: idSensor, Int, id del sensor que se esta leyendo
    
    return: none
    """ 
    print(f"Nuevo evento:{event_code}: {event_name}")


def set_new_lecture(value):
    """
    envia la lectura a la API para ser registrada en base de datos
    
    param: value
    """
    
    print(F"guardando una nueva lectura {value}" )