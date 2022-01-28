import requests


def popular_count():
    BASE_URL = 'https://api.themoviedb.org/3'
    path = '/movie/popular'
    params = {
        'api_key' : 'your key',
        'region' : 'KR',
        'language' : 'ko'
    }
    response = requests.get(BASE_URL + path, params=params).json()
    return len(response['results'])
    # 여기에 코드를 작성합니다.  


if __name__ == '__main__':
    """
    popular 영화목록의 개수 출력.
    """
    print(popular_count())
    # => 20
