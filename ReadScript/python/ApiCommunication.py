import requests
from datetime import datetime
import json



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
          `/+++ooooooooooooo/`           Front-end powered by Vue
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


def get_tank_info(id_tank):
    """ 
    Obtiene informacion del tanque de la base de datos
    
    return: dictionary, informacion del tanque con las llaves:lecture_range, lecture_range_s
    """ 
    tank_info = requests.get(f"http://192.168.2.102:8080/api/tank/{id_tank}")
    return tank_info.json()


def set_new_event(event_code, event_name, id_sensor):
    """
    set a new event in the API
    
    param: eventCode, Int, codigo del evento

    param: idSensor, Int, id del sensor que se esta leyendo
    
    return: none
    """ 
    date_time = int(datetime.now().timestamp())
    print(date_time)
    data_post = {
        "eventCode": event_code,
        "timeEvent": date_time,
        "idSensor": id_sensor
    }
    answer = requests.post('http://192.168.2.102:8080/api/event', data=data_post)
    print(f"Nuevo evento:{event_code}: {event_name}")


def set_new_lecture(value, id_sensor):
    """
    envia la lectura a la API para ser registrada en base de datos
    
    param: value
    """
    date_time = int(datetime.now().timestamp())
    data_post = {
        "timeLecture": date_time,
        "lecture": value,
        "idSensor": id_sensor
    }
    answer = requests.post('http://192.168.2.102:8080/api/sensorlecture', data=data_post)
    print(f"guardando una nueva lectura {value}|{id_sensor}" )
    

def create_tank():
    # tank_info = requests.get('http://192.168.2.102:8080/api/tank')
    tank_info = {}
    sensor_info = {}
    with open('config.json') as file:
        data = json.load(file)
        tank_info = data["tank_initial_info"]
        tank = {
        "name": str(tank_info['name']),
        "description": str(tank_info["description"]),
        "units": str(tank_info["units"]),
        "maxVolume": float(tank_info["maxVolume"]),
        "fullread": float(tank_info["fullread"]),
        "emptyread": float(tank_info["emptyread"]),
        "stateCode": int(tank_info["stateCode"])}
        sensor_info = data["sensor_info"]
        sensor = {
             "description": str(sensor_info["description"]),
             "name": str(sensor_info["name"]),
             "state": bool(sensor_info["state"]),
             "type": str(sensor_info["type"]),
             "idTank": int(sensor_info["idTank"])
            }
    answer = requests.post('http://192.168.2.102:8080/api/tank', data=tank_info)
    answer2 = requests.post('http://192.168.2.102:8080/api/sensor', data=sensor)
    print(answer)
    print("-----")
    print(answer2)

    
    