const int Trigger = 2;  //Declaramos que el trigger del sensor esta en el pin 2
const int Echo = 3;     // el pin numero 3 esta para el echo del sensor
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600);   //inciamos la comunicacion a 9600
  pinMode(Trigger, OUTPUT); //indicamos el pin 2 como pin de salida 
  pinMode(Echo, INPUT);  //se indica el pin 3 como entrada
  digitalWrite(Trigger, LOW); // inicializamos el pin como un 0
}

void loop() {
  long t;
  long d;
  // put your main code here, to run repeatedly:
  digitalWrite(Trigger, HIGH);  //iniciamos el pulso
  delayMicroseconds(10);        //hacemos el pulso de 10 us
  digitalWrite(Trigger, LOW);   //finalizamos el pulso

  t = pulseIn(Echo, HIGH);      //recibimos la lecutra del sensor
  // Velocidad del sonido es 340m/s = 59cm/us
  d = t/59;   //Distancia en centimetros

  Serial.println(d);
  delay(1000); // pausa en ms
}
