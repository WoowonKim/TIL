# PJT 01 

## Python을 활용한 데이터 수집1



### A. 제공되는 영화 데이터의 주요내용 수집

- 요구 사항 : 샘플 영화데이터가 주어집니다. 이중 서비스 구성에 필요한 정보만 뽑아 반환하는 함수를 완성합니다. 완성된 함수는 다음 문제의 기본기능으로 사용됩니다.

- 결과 

  - 제공된 데이터에서 id, title, poster_path, vote_average, overview, genre_ids 키에 해당하는 정보만 가져옵니다.
  - 가져온 정보를 새로운 dictionary로 반환하는 함수 movie_info를 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
  import json
  from pprint import pprint
  
  
  def movie_info(movie):
      id = movie.get('id')
      title = movie.get('title')
      poster_path = movie.get('poster_path')
      vote_average = movie.get('vote_average')
      overview = movie.get('overview')
      genre_ids = movie.get('genre_ids')
      result = {
          'id' : id,
          'title' : title,
          'poster_path' : poster_path,
          'vote_average' : vote_average,
          'overview' : overview,
          'genre_ids' : genre_ids,
      }
      return result
  
  
  # 아래의 코드는 수정하지 않습니다.
  if __name__ == '__main__':
      movie_json = open('data/movie.json', encoding='UTF8')
      movie_dict = json.load(movie_json)
      
      pprint(movie_info(movie_dict))
  ```

  - 이 문제는 자료로 부터 내가 원하는 데이터를 가져오는 코드이다. 입력받은 데이터가 하나의 딕셔너리 형태였기 때문에 get()함수를 이용하여 내가 원하는 정보를 얻을 수 있었다.
  - 이 문제의 포인트는 해당 자료가 내가 원하는 데이터를 가지고 있지 않을 수도 있기때문에 get()함수를 사용해 딕셔너리에서 내가 원하는 자료를 가져오는 것 같다.

  

### B. 제공되는 영화 데이터의 주요내용 수정 

- 요구 사항 : 이전단계에서 만들었던 데이터 중 genre_ids를 genre_names로 바꿔 반환하는 함수를 완 성합니다. 완성된 함수는 다음 문제의 기본기능으로 사용됩니다.

- 결과 

  - 제공된 데이터에서 id, title, poster_path, vote_average, overview, genre_ids 키에 해당하는 정보만 가져옵니다.
  - genres.json파일을 이용하여 genre_ids를 genre_names로 변환하여 dictionary 에 추가합니다.
  - 완성된 dictionary를 반환하는 함수 movie_info를 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - 이전 코드에서 가져온 genre_ids를 통해 해당 영화의 장르를 실제로 출력해 보는 코드이다. id에 해당하는 장르는 딕셔너리 형태로 genres.json에 리스트로 저장되어 있었다. 리스트 안에 있는 딕셔너리의 key 값을 genre_ids와 비교하여 일치하는 value만 뽑아오는것이 어려웠다.
  - 이 문제의 포인트는 List에 담겨있는 dictionary에서 원하는 값만 출력을 해보는 것이 포인트 인것 같다.

  

### C. 다중 데이터 분석 및 수정 

- 요구 사항 : TMDB기준 평점이 높은 20개의 영화데이터가 주어집니다. 이 중 서비스 구성에 필요한 정 보만 뽑아 반환하는 함수를 완성합니다. 완성된 함수는 향후 커뮤니티 서비스에서 제공되는 영화 목록을 제공하기 위한 기능으로 사용됩니다.

- 결과 

  - 이전 단계의 함수 구조를 재사용합니다.
  - 영화 전체 정보를 수정하여 반환하는 함수 movie_info를 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
  import json
  from pprint import pprint
  
  
  def movie_info(movies, genres):
      results = [
  
      ]
      for movie in movies:
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
          results.append(result)
      return results
          
          
  # 아래의 코드는 수정하지 않습니다.
  if __name__ == '__main__':
      movies_json = open('data/movies.json', encoding='UTF8')
      movies_list = json.load(movies_json)
  
      genres_json = open('data/genres.json', encoding='UTF8')
      genres_list = json.load(genres_json)
  
      pprint(movie_info(movies_list, genres_list))
  ```

  - 이전 코드에서 한 영화에 대해서만 내가 원하는 정보를 얻었다면, 이번엔 여러 영화들에 대한 정보들이 리스트 속에 딕셔너리형태로 담겨있는 자료로 부터 필요한 정보만 뽑아 반환하는 코드이다. 전 단계에서 리스트 안에 있는 딕셔너리 들을 FOR문을 통해 접근하는법을 알게되어 쉽게 해결할 수 있었다.
  - 이 문제의 포인트는 내가 추출한 데이터를 append()함수를 이용하여 리스트로 만드는 것인 것 같다.

  

###  D. 알고리즘을 통한 데이터 출력  

- 요구 사항 : 세부적인 영화 정보 중 수익 정보(revenue)를 이용하여 모든 영화 중 가장 높은 수익을 낸 영화를 출력하는 알고리즘을 작성합니다. 해당 데이터는 향후 커뮤니티 서비스에서 메인 페 이지 기본정보로 사용됩니다.

- 결과 

  - 수익이 가장 높은 영화의 제목을 출력하는 함수 max_revenue를 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
  import json
  
  
  def max_revenue(movies):
      max_revenue_budget = 0
      for movie in movies:
          id = movie.get('id')
          dir = 'data/movies/' + str(id) + '.json'
          movies_spe_json = open(dir, encoding='UTF8')
          movies_moreinfo = json.load(movies_spe_json)
          revenue = movies_moreinfo['revenue']
          if revenue > max_revenue_budget:
              max_revenue_budget = revenue
              max_revenue_name = movies_moreinfo['title']
      return max_revenue_name
  
   
  if __name__ == '__main__':
      movies_json = open('data/movies.json', encoding='UTF8')
      movies_list = json.load(movies_json)
      
      print(max_revenue(movies_list))
  ```

  - 이번 문제는 입력받은 데이터로부터 해당 영화의 id를 찾아내고 id를 이용하여 새로운 데이터에 접근을 해야 했었다. Python str형끼리 쉽게 합칠 수 있기에 id로 부터 데이터로의 경로를 쉽게 만들 수 있었다. 새로 접근한 데이터로부터 값을 저장해 다음 데이터와 if문과 for문으로 반복적으로 비교하여 가장 수익이 많은 영화를 알아 낼 수 있었다.
  - 이번 문제의 포인트는 가장 수익이 큰 영화를 찾아내는 알고리즘과 원하는 데이터로의 경로를 만드는 것 인것 같다.

  

###  E. 알고리즘을 통한 데이터 출력  

- 요구 사항 : 세부적인 영화 정보 중 개봉일 정보(release_date)를 이용하여 모든 영화 중 12월에 개봉 한 영화들의 제목 리스트를 출력하는 알고리즘을 작성합니다. 해당 데이터는 향후 커뮤니티 서비스에서 추천기능의 정보로 사용됩니다. 

- 결과 

  - 개봉일이 12월인 영화들의 제목을 리스트로 출력하는 함수 dec_movies를 완성합 니다.

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - 이번 코드는 세부적인 영화 정보로 부터 12일에 개봉한 영화를 리스트로 만드는 것이다. 전 코드와 유사하게 영화의 세부 데이터에 접근을 하고 개봉 날짜 정보가 동일한 형태의 str형으로 존재하는 것을 확인하여 인덱싱을 통해 쉽게 12월에 개봉하는 영화에만 접근하여 영화의 이름을 append를 활용하여 리스트에 넣을 수 있었다.



## 후기

- 이번 프로젝트를 통해 앞으로 많이 사용하게될 딕셔너리형 데이터에 익숙해 질 수 있었다. 이번 프로젝트는 딕셔너리와 리스트로 이루어진 데이터로부터 점차적으로 세부적인 데이터에 접근할 수 있는 길을 알려주었던것 같다. 이제 앞으로 어떤 데이터가 주어져도 내가 원하는 정보들만 쏙쏙 뽑아서 나만의 새로운 데이터를 만들 수 있을 것 같다!

