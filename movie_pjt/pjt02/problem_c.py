import requests
from pprint import pprint


def ranking():
    BASE_URL = 'https://api.themoviedb.org/3'
    path = '/movie/popular'
    params = {
        'api_key' : 'your key',
        'region' : 'KR',
        'language' : 'ko'
    }
    response = requests.get(BASE_URL + path, params=params).json()
    sorted_top = sorted(response['results'], key = lambda movie: movie['vote_average'], reverse=True)

    return sorted_top[0:5]
    # 여기에 코드를 작성합니다.  


if __name__ == '__main__':
    """
    popular 영화목록을 정렬하여 평점순으로 5개 영화.
    """
    pprint(ranking())
    # => 영화정보 순서대로 출력
