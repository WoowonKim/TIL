import json


def dec_movies(movies):
    dec_movie = []
    for movie in movies:
        id = movie.get('id')
        dir = 'data/movies/' + str(id) + '.json'
        movies_spe_json = open(dir, encoding='UTF8')
        movies_moreinfo = json.load(movies_spe_json)
        release_date = movies_moreinfo['release_date']
        if int(release_date[5:7]) == 12:
            dec_movie.append(movies_moreinfo['title'])
    return dec_movie


# 아래의 코드는 수정하지 않습니다.
if __name__ == '__main__':
    movies_json = open('data/movies.json', encoding='UTF8')
    movies_list = json.load(movies_json)
    
    print(dec_movies(movies_list))