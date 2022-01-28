import requests
from pprint import pprint


def recommendation(title):
    BASE_URL = 'https://api.themoviedb.org/3'
    path = '/search/movie'
    params = {
        'api_key' : 'your key',
        'region' : 'KR',
        'query' : f'{title}',
        'language' : 'ko'
    }
    response = requests.get(BASE_URL + path, params=params).json()

    if response['results']:
        movie_id = response['results'][0]['id']
    else:
        return None

    RECOMEND_URL = BASE_URL + f'/movie/{movie_id}/recommendations'
    response = requests.get(RECOMEND_URL,params=params).json()

    recomend_movies = []
    for movie in response['results']:
        recomend_movies.append(movie['title'])

    return recomend_movies
    # 여기에 코드를 작성합니다.  


if __name__ == '__main__':
    """
    제목에 해당하는 영화가 있으면
    해당 영화의 id를 기반으로 추천 영화 목록 구성.
    추천 영화가 없을 경우 [].
    영화 id검색에 실패할 경우 None.
    """
    pprint(recommendation('기생충'))
    ['조커', '조조 래빗', '1917', ..., '토이 스토리 4', '스파이더맨: 파 프롬 홈']
    pprint(recommendation('그래비티'))
    # []  => 추천 영화 없음
    pprint(recommendation('검색할 수 없는 영화'))
    # => None
