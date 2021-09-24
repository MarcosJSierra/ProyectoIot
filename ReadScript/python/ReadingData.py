import serial
import ApiCommunication as api_com
import json

dato_1 = ""


def binary_to_int(binary_text):
    string_text = binary_text.decode('ascii')
    return int(string_text)


def verify_event(lecture, tank_capacity, event_codes, sensor_id, full_lecture, empty_lecture):
    percentage = ((empty_lecture - lecture)/(empty_lecture - full_lecture))
    tank_volume = tank_capacity * percentage
    percentage = percentage * 100
    if percentage == 0 or percentage < 5:
        api_com.set_new_event(event_codes["empty"], "empty", sensor_id)
    elif percentage >= 5 and percentage <=25:
        api_com.set_new_event(event_codes["25_percent"], "25_percent", sensor_id)
    elif percentage > 25 and percentage <= 50:
        api_com.set_new_event(event_codes["50_percent"], "50_percent", sensor_id)
    elif percentage > 50 and percentage <= 75: 
        api_com.set_new_event(event_codes["75_percent"], "75_percent", sensor_id)
    else:
        api_com.set_new_event(event_codes["full"], "full", sensor_id)
        

def main():
    api_com.cabecera()
    puerto_serie = serial.Serial('/dev/ttyACM0', 9600)
    tank_info = api_com.get_tank_info()
    count = 0
    totalizador = 0
    event_codes = {}
    sensor_info = {}
    with open('config.json') as file:
        data = json.load(file)
        event_codes = data["events"]
        sensor_info = data["sensor_info"]
    print(event_codes["full"])
    # print(event_codes)
    # print(f"tank_info: {tank_info}")
    while True:
        linea_binario = puerto_serie.readline()
        distancia_cm = binary_to_int(linea_binario)
        print(distancia_cm)
        totalizador = totalizador + distancia_cm
        api_com.set_new_lecture(distancia_cm)
        verify_event(distancia_cm, tank_info.get("capacity"), event_codes, sensor_info["id"], tank_info.get("full_lecture"), tank_info.get("empty_lecture"))
        
        
        
if __name__ == '__main__':
    main()