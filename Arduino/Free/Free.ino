#include "DHT.h"
#define DHTPIN 2
#define DHTTYPE DHT11
DHT dht(DHTPIN, DHTTYPE);
//librerias del DHT 11

int redPin = 9;
int greenPin = 10;
int bluePin = 11;

int r = 0;
int g = 0;
int b = 0;

int valMov = 0;
int valMic = 0;
int valLuz = 0;

String dato = "l";

void setup() {
  Serial.begin(9600); //Se inicia la comunicación serial
  dht.begin(); //Se inicia el sensor

  pinMode(redPin, OUTPUT);
  pinMode(greenPin, OUTPUT);
  pinMode(bluePin, OUTPUT);
}

void loop() {
  int valHum = dht.readHumidity(); //se lee la humedad
  int valTemp = dht.readTemperature(); // se lee la temperatura*8

  if (Serial.available() != 0) {
    dato = Serial.read();
  }

  if (dato == "48") {
    setColor(255, 10, 0);
    delay(500);
    dato = "l";
  } else {
    setColor(191, 113, 241);
  }

  if (dato == "49") {
    setColor(0, 255, 10);
    delay(500);
    dato = "l";
  } else {
    setColor(191, 113, 241);
  }

  if (dato == "50") {
    setColor(255, 10, 0);
    delay(500);
    dato = "l";
  } else {
    setColor(191, 113, 241);
  }

  if (dato == "51") {
    setColor(0, 255, 10);
    delay(500);
    dato = "l";
  } else {
    setColor(191, 113, 241);
  }

  valMov = digitalRead(3);

  valMic = analogRead(2);
  valLuz = map(analogRead(3), 0, 1023, 0, 100);

  Serial.print(valHum);
  Serial.print("//");
  Serial.print(valTemp);
  Serial.print("//");
  Serial.print(valMov);
  Serial.print("//");
  Serial.print(valMic);
  Serial.print("//");
  Serial.print(valLuz, DEC);
  Serial.print("//");
  Serial.print(dato);
  Serial.println();
}

void setColor(int red, int green, int blue) {
  while ( r != red || g != green || b != blue ) {
    if ( r < red ) r += 1;
    if ( r > red ) r -= 1;
    if ( g < green ) g += 1;
    if ( g > green ) g -= 1;
    if ( b < blue ) b += 1;
    if ( b > blue ) b -= 1;
    _setColor();
    delay(3);
  }
}

void _setColor() {
  analogWrite(redPin, r);
  analogWrite(greenPin, g);
  analogWrite(bluePin, b);

}
