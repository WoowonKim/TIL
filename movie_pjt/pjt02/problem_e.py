import requests
from pprint import pprint


def credits(title):
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

    CREDITS_URL = BASE_URL + f'/movie/{movie_id}/credits'
    response = requests.get(CREDITS_URL,params=params).json()

    directors = [credit['name'] for credit in response['crew'] if credit['department'] == 'Directing']
    actors = [credit['name'] for credit in response['cast'] if credit['cast_id'] < 10]
    
    res = {'cast' : actors, 'crew' : directors}

    return res
    # 여기에 코드를 작성합니다.  


if __name__ == '__main__':
    """
    제목에 해당하는 영화가 있으면
    해당 영화 id를 통해 영화 상세정보를 검색하여
    주연배우 목록(cast)과 제작진(crew).
    영화 id검색에 실패할 경우 None.
    """
    pprint(credits('기생충'))
    # => {'cast': ['Song Kang-ho', 'Lee Sun-kyun', ..., 'Jang Hye-jin'], 'crew': ['Bong Joon-ho', 'Park Hyun-cheol', ..., 'Yoon Young-woo']}
    pprint(credits('검색할 수 없는 영화'))
    # => None
