import socket
import threading

HOST = '127.0.0.1'
PORT = 1234
LISTENER_LIMIT = 5
active_clients = []  # List of connected clients

# Function to listen for messages from clients
def listen_for_messages(client, username):
    while True:
        try:
            message = client.recv(2048).decode('utf-8')
            if message:
                final_msg = f"{username}~{message}"
                send_messages_to_all(final_msg)  # Send message to all clients
            else:
                print("Received empty message from client")
                break  # Disconnect client if message is empty
        except:
            remove_client(client)
            break

# Function to send a message to a single client
def send_message_to_client(client, message):
    try:
        client.sendall(message.encode())
    except:
        remove_client(client)

# Function to send messages to all connected clients
def send_messages_to_all(message):
    for client in active_clients:
        send_message_to_client(client, message)

# Function to remove a disconnected client
def remove_client(client):
    if client in active_clients:
        active_clients.remove(client)
        client.close()

# Function to handle new client connections
def client_handler(client):
    try:
        username = client.recv(2048).decode('utf-8')
        if username:
            active_clients.append(client)
            welcome_message = f"SERVER~{username} joined the chat!"
            send_messages_to_all(welcome_message)
            threading.Thread(target=listen_for_messages, args=(client, username)).start()
        else:       
            client.close()
    except:
        client.close()

# Main function
def main():
    server = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    try:
        server.bind((HOST, PORT))
        server.listen(LISTENER_LIMIT)
        print(f"Server running on {HOST}:{PORT}")

        while True:
            client, address = server.accept()
            print(f"New connection: {address}")
            threading.Thread(target=client_handler, args=(client,)).start()
    except Exception as e:
        print(f"Error: {e}")
    finally:
        server.close()

if __name__ == '__main__':
    main()
