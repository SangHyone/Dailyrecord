import pprint

from pymongo import MongoClient
from datetime import datetime

client = MongoClient("mongodb+srv://sksrka0206:tkdgus1!@cluster0.ayhw2.mongodb.net/?retryWrites=true&w=majority")
collection = client.myDB.table2
for hanja in collection.find({"d":"특급"}):
    # print(book)
    pprint.pprint(hanja)