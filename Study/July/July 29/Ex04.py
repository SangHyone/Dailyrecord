import pprint

from pymongo import MongoClient
from datetime import datetime

client = MongoClient("mongodb+srv://sksrka0206:tkdgus1!@cluster0.ayhw2.mongodb.net/?retryWrites=true&w=majority")
collection = client.test.books
for book in collection.find():
    #print(book)
    pprint.pprint(book)