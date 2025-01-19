import paho.mqtt.client as mqtt


mqtt_server = "192.168.43.173"  
PORT = 1883
reciever_topic = "sensor" 
sender_topic = "esp/potentiometer"

def on_connect(client, userdata, flags, rc):
    if rc == 0:
        print("Connected to MQTT broker")
        client.subscribe(reciever_topic) 
    else:
        print(f"Failed to connect, return code {rc}")

def on_message(client, userdata, msg):
    try:
        payload = msg.payload.decode()
        print(f"Received angle: {payload}")
        print(payload)  
        send_to_esp(payload)
    except Exception as e:
        print(f"Error decoding message: {e}")

def send_to_esp(payload):
    try:
        client.publish(sender_topic, payload)  # Send the data to ESP
        print(f"Sent to ESP: {payload}")
    except Exception as e:
        print(f"Error sending data to ESP: {e}")

client = mqtt.Client()
client.on_connect = on_connect
client.on_message = on_message

client.connect(mqtt_server, PORT, 60)

client.loop_forever()