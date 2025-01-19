#include <MPU9250_asukiaaa.h>
#include <Adafruit_BMP280.h>
#include <ESP8266WiFi.h>
#include <PubSubClient.h>

//ssid or the name of the Wi-Fi and its password
const char* ssid = "WING";
const char* password = "12345678910";

//mqtt_server bigh the ip address of the rasbery pi
const char* mqtt_server = "192.168.43.173 "; 
//topic to publish to
const char* mqtt_topic = "sensor";

//make the eps8266 into a client
WiFiClient espClient;
PubSubClient client(espClient);

//the I2C pins of the esp8266
#define SDA_PIN D2
#define SCL_PIN D1

float data[5];

// connet to the Wi-Fi
void setup_wifi() {
  delay(10);
  Serial.println();
  Serial.print("Connecting to WiFi...");
  
  WiFi.begin(ssid, password);
  //wait till you are connected to the Wi-Fi
  while (WiFi.status() != WL_CONNECTED) {
    delay(1000);
    Serial.print(".");
  }
  Serial.println("Connected to WiFi");
}

// in case the mqtt connectio is lost try to reconnect
void reconnect() {
  while (!client.connected()) {
    Serial.print("Attempting MQTT connection...");
    String clientId = "ESP8266Client-";
    clientId += String(random(0xffff), HEX);
    if (client.connect(clientId.c_str())) {
      Serial.println("connected");
    } else {
      Serial.print("failed, rc=");
      Serial.print(client.state());
      delay(5000); 
    }
  }
}

// gent the accX and accY in order to get the pitch angle of the finger
float get_angle() {
  float angle, aX, aY;
  
  if (mpu.accelUpdate() == 0) {
    aX = mpu.accelX();
    aY = mpu.accelY();
  }
  angle = atan2(aX, aY) * 180 / 3.14;
  return angle;
}

// Setup MPU9250 sensor, in this case only use the acc, no need for gyro or magnetuide
void setup_mpu9250() {
  Wire.begin(SDA_PIN, SCL_PIN); 
  mpu.setWire(&Wire);             
  mpu.beginAccel();
}

void loop() {
  //if the MQTT client is disconnected, call the reconnect function
  if (!client.connected()) {
    reconnect(); 
  }
  client.loop();  

  //get the angle and make it as String type in order to send it
  String payload = String(get_angle());
  
  // Publish data to MQTT broker
  if (client.publish(mqtt_topic, payload.c_str())) {
    Serial.print("Published: ");
    Serial.println(payload);
  } else {
    Serial.println("Failed to publish data.");
  }
  
  delay(10);  
}