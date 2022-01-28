import json
from pprint import pprint


def movie_info(movie, genres):
    id = movie.get('id')
    title = movie.get('title')
    poster_path = movie.get('poster_path')
    vote_average = movie.get('vote_average')
    overview = movie.get('overview')
    genre_ids = movie.get('genre_ids')
    genre_names = [x['name'] for x in genres if x['id'] in genre_ids]
    result = {
        'id' : id,
        'title' : title,
        'poster_path' : poster_path,
        'vote_average' : vote_average,
        'overview' : overview,
        'genre_names' : genre_names,
    }    
    return result


# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    movie_json = open('data/movie.json', encoding='UTF8')
    movie = json.load(movie_json)

    genres_json = open('data/genres.json', encoding='UTF8')
    genres_list = json.load(genres_json)

    pprint(movie_info(movie, genres_list))