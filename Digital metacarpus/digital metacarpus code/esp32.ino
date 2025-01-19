#include "ESP8266WiFi.h"
#include "PubSubClient.h"
#include <Servo.h>

const char* ssid = "Samer";
const char* password = "07623430S";
const char* mqttServer = "broker.hivemq.com";
const int mqttPort = 1883;
const char* mqttTopic = "esp/potentiometer";

WiFiClient espClient;
PubSubClient client(espClient);

Servo myServo;
const int servoPin = D5;

void setup() {
  Serial.begin(9600);
  myServo.attach(servoPin);
  connectToWifi();
  client.setServer(mqttServer, mqttPort);
  client.setCallback(callback);
  connectToMqtt();
}

void loop() {
  if (!client.connected()) {
    reconnectToMqtt();
  }
  client.loop();
}

void callback(char* topic, byte* payload, unsigned int length) {
  String message = "";
  for (int i = 0; i < length; i++) {
    message += (char)payload[i];
  }
  int potValue = message.toInt();
  int servoSpeed = map(potValue, 0, 1023, 0, 180);
  myServo.write(servoSpeed);
  delay(500);
}

void connectToWifi() {
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
