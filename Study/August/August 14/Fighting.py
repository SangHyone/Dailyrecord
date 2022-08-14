import re
from urllib.request import Request, urlopen
from bs4 import BeautifulSoup
from urllib import parse
from urllib.parse import parse_qsl, urlsplit
import requests
import json
import os
from urllib import request

# 책의 주소를 저장할 리스트 리턴하는 함수
def get_book_list():
    book_list = []
    for i in range(1, 4):
        url = "http://103.204.13.68:8901/bbs/board.php?bo_table=toons&stx=%EB%8D%94+%ED%8C%8C%EC%9D%B4%ED%8C%85&is=32&sord=&type=&page={}".format(i)
        # print(url)
        urlTicker = Request(url, headers={'User-Agent': 'Mozilla/5.0'})
        res = urlopen(urlTicker)
        soup = BeautifulSoup(res, "html.parser")
        # print(soup.select_one("title").string)
        comic_list = soup.select("ul#comic-episode-list li");
        # print(len(comic_list), '개')
        for li in comic_list:
            btn = li.select_one('button')
            link = btn['onclick']
            link = 'http://103.204.13.68:8901/bbs/' + link[15:len(link)-1]
            book_list.append(link)
            # print(link)
    return book_list


def get_url_encoding_address(urlAddress):
    urlAddr = parse.urlparse(urlAddress)
    data = dict(parse_qsl(urlsplit(urlAddr.query).path))
    data['stx'] = parse.quote(data['stx'])
    encoding_query = parse.urlencode(data, doseq=False)
    address = urlAddress[:urlAddress.index('?')+1] + encoding_query
    return address


def image_download(path, index, image_url, ext):
    os.makedirs(path, exist_ok=True)
    file_name = "{}/{}.{}".format(path, index, ext)
    opener = request.build_opener()
    opener.addheaders = [('User-Agent','Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1941.0 Safari/537.36')]
    request.install_opener(opener)
    request.urlretrieve(image_url, file_name)
    return file_name


def get_image_list(link):
    page_source = requests.get(link).text
    matched = re.search(r'var img_list = (.+?);', page_source, re.S)
    json_string = matched.group(1)
    img_list = json.loads(json_string)
    return img_list


if __name__ == "__main__":
    book_list = get_book_list();
    print('전체 :', len(book_list), '개', type(book_list))
    name = 'fighting'
    for i, link in enumerate(book_list[::-1]):
        path = "{}/{:03d}".format(name, i+1)
        link = get_url_encoding_address(link)
        img_list = get_image_list(link)
        for j, image_url in enumerate(img_list):
            index = "{:03d}".format(j)
            image_download(path, index, image_url, 'jpg')
            # print(image_url)
        print(path + "에 저장완료!!!!")
        print("*" * 200)
