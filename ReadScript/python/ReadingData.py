import serial
import ApiCommunication as api_com
import json

dato_1 = ""


def binary_to_int(binary_text):
    string_text = binary_text.decode('ascii')
    return int(string_text)


def verify_event(last_event, lecture, tank_capacity, event_codes, sensor_id, full_lecture, empty_lecture):
    percentage = ((empty_lecture - lecture)/(empty_lecture - full_lecture))
    tank_volume = tank_capacity * percentage
    percentage = percentage * 100
    if percentage == 0 or percentage < 5:
        if last_event != "empty":
            api_com.set_new_event(event_codes["empty"], "empty", sensor_id)
            return "empty"
    elif percentage >= 5 and percentage <= 35:
        if last_event != "25_percent":
            api_com.set_new_event(event_codes["25_percent"], "25_percent", sensor_id)
            return "25_percent"
    elif percentage > 35 and percentage <= 60:
        if last_event != "50_percent":
            api_com.set_new_event(event_codes["50_percent"], "50_percent", sensor_id)
            return "50_percent"
    elif percentage > 60 and percentage <= 90: 
        if last_event != "75_percent":
            api_com.set_new_event(event_codes["75_percent"], "75_percent", sensor_id)
            return "75_percent"
    else:
        if last_event != "full":
            api_com.set_new_event(event_codes["full"], "full", sensor_id)
            return "full"
    return last_event
        
        

def main():
    api_com.cabecera()
    puerto_serie = serial.Serial('/dev/ttyACM0', 9600)
    count = 0
    totalizador = 0
    event_codes = {}
    sensor_info = {}
    with open('config.json') as file:
        data = json.load(file)
        event_codes = data["events"]
        sensor_info = data["sensor_info"]
    tank_info = api_com.get_tank_info(int(sensor_info["idTank"]))
    print(tank_info)
    print(event_codes["full"])
    # print(event_codes)
    # print(f"tank_info: {tank_info}")
    last_event = ""
    while True:
        
        linea_binario = puerto_serie.readline()
        # if not linea_binario:
        #     continue
        distancia_cm = binary_to_int(linea_binario)
        print(distancia_cm)
        api_com.set_new_lecture(distancia_cm, sensor_info["idSensor"])
        last_event = verify_event(last_event, distancia_cm, tank_info["maxVolume"], event_codes, sensor_info["idSensor"], tank_info["fullread"], tank_info["emptyread"])
        
        
        
if __name__ == '__main__':
    main()