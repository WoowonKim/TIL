import requests
from pprint import pprint


def vote_average_movies():
    vote_gt_8 = []
    BASE_URL = 'https://api.themoviedb.org/3'
    path = '/movie/popular'
    params = {
        'api_key' : 'your key',
        'region' : 'KR',
        'language' : 'ko'
    }
    response = requests.get(BASE_URL + path, params=params).json()
    for movie in response['results']:
        if movie['vote_average'] >= 8:
            vote_gt_8.append(movie)
    return vote_gt_8
    # 여기에 코드를 작성합니다.  


if __name__ == '__main__':
    """
    popular 영화목록중 vote_average가 8 이상인 영화목록 출력.
    """
    pprint(vote_average_movies())
    # => 영화정보 순서대로 출력
