from pymongo import MongoClient

# 방법1 - URI
# mongodb_URI = "mongodb://localhost:27017/"
# client = MongoClient(mongodb_URI)

# 방법2 - HOST, PORT
client = MongoClient("mongodb+srv://sksrka0206:tkdgus1!@cluster0.ayhw2.mongodb.net/?retryWrites=true&w=majority")

print(client.list_database_names())

for name in client.list_database_names():
    print(name)