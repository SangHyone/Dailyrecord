from pymongo import MongoClient
from datetime import datetime

client = MongoClient("mongodb+srv://sksrka0206:tkdgus1!@cluster0.ayhw2.mongodb.net/?retryWrites=true&w=majority")
collection = client.test.books
booksData = [
    {
        "id": "01",
        "language": "Java",
        "edition": "third",
        "author": "Herbert Schildt",
        'published_date': datetime.now()
    },

    {
        "id": "07",
        "language": "C++",
        "edition": "second",
        "author": "E.Balagurusamy",
        'published_date': datetime.now()
    }
]

collection.insert_many(booksData)