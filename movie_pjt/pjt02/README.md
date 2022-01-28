# PJT 02

## Python을 활용한 데이터 수집 II



### A. 인기 영화 조회 

> 인기 영화의 개수를 출력합니다.

- 요청 

  - requests를 이용하여 인기 영화 정보(Get Popular)에 요청을 보냅니다.

- 결과 

  - popular를 기준으로 받아온 데이터에서 영화 리스트의 개수를 계산합니다.
  - 계산한 정보를 반환하는 함수 popular_count를 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - 이 문제는 TMDB API를 활용하여 인기영화 정보를 수집하는 과정이다. TMDB에서 제공하는 문서를 통해 인기 영화 정보를 requests를 이용하여 수집하고, 수집한 데이터를 기준으로 인기 영화의 개수를 출력하였다.
  - 이 문제의 포인트는 API 문서를 읽고 요청을 보내 원하는 정보를 수집하는 것이다. 수집한 json데이터를 파이썬의 내장함수를 이용하여 영화 리스트의 개수를 출력하였다.

  

### B. 특정 조건에 맞는 인기 영화 조회 I 

> popular를 기준으로 가져온 영화 목록 중 평점이 8 이상인 영화들의 목록을 출력합니다. 

- 요청 

  - requests를 이용하여 인기 영화 정보(Get Popular)에 요청을 보냅니다

- 결과 

  - 받아온 데이터에서 vote_average를 기준으로 점수가 8 이상인 영화들의 목록을 리스트로 반환하는 함수 vote_average_movies를 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - 이 문제는 requests를 이용하여 인기 영화 정보에 요청을 보내고, 그 중 평점이 8 이상인 영화들의 목록을 출력하는 코드이다. 
  - for문을 이용하여 리스트에 담긴 영화 정보 딕셔너리에 접근하고, 영화의 평점을 숫자 8과 비교하여 if문을 활용해 평점이 8점 이상인 영화들을 append메서드를 이용하여 반환할 리스트에 추가하였다. 

  

### C. 특정 조건에 맞는 인기 영화 조회 II

> 영화목록을 평점순으로 출력하는 함수를 완성합니다. 해당 기능은 향후 커뮤니티 서비스에서 기본으로 제공되는 영화 정보로 사용됩니다. 

- 요청 

  - requests를 이용하여 인기 영화 정보(Get Popular)에 요청을 보냅니다.

- 결과 

  - 받아온 데이터 중 평점이 높은 영화 다섯개의 정보를 리스트로 반환하는 함수 ranking을 완성합니다

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - B번 문제와 비슷하게 평점이 높은 영화 5개를 정렬하여 출력하는 문제인데. 왠지 for문과 if문을 사용하지 않고 sort()나 sorted 함수로 쉽게 표현 할 수 있을거 같아 파이썬 공용문서를 찾아보았다.
  - sorted를 사용하여 반환할 리스트를 사용하였는데, response['results']에 담겨있는 영화로부터 sorted의 key라는 인자를 사용하여, 영화의 평점순으로 나열되어있는 리스트를 만들고, 맨 처음 5개를 반환하는 함수를 만들었다.

  

###  D. 특정 영화 추천 영화 조회

> 제공된 영화 제목을 기준으로 추천영화 목록을 출력합니다.

- 요청 

  - requests를 이용하여 영화 검색(Search Movies) 요청을 보냅니다.
  - 응답 받은 결과를 바탕으로 id를 찾아 추천영화 목록 조회 (Get Recommendations) URL을 생성합니다.
  - requests를 이용하여 URL에 요청을 보냅니다.

- 결과 

  - TMDB에서 추천받은 영화 리스트에서 제목을 리스트에 저장합니다.
  - 저장된 리스트를 반환하는 함수 recommendation을 완성합니다.
  - 올바르지 않은 영화 제목으로 id가 없는 경우 None을 반환합니다.
  - id값은 있지만 추천영화가 없는 경우 빈 리스트를 반환합니다.

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - 이번 문제는 영화 제목을 입력받아 requests를 이용하여 영화 검색 요청을 보낸다. 응답으로 받은 영화으의 id를 이용하여 추천영화를 받기위한 URL을 만든 후, 해당 URL을 통해 추천 영화를 반환한다.
  - 추천영화가 없는 경우 빈 리스트를 반환하기 위해 빈 리스트를 만들고, 추천 URL을 통해 받은 영화들의 제목을 for문을 이용하여 리스트에 추가하였다.  또한 if문을 이용하여 검색결과가 없는 경우 None을 반환하도록 하였다. 


###  E. 배우, 감독 리스트 출력 

> 영화에 출연한 배우들과 감독의 정보가 저장된 딕셔너리를 출력합니다. 

- 요구 사항 

  -  requests를 이용하여 영화 검색(Search Movies) 요청을 보냅니다
  - 응답 받은 결과를 바탕으로 id를 찾아 크레딧 조회 (Get Credits) URL을 생성합니다.
  - requests를 이용하여 URL에 요청을 보냅니다

- 결과 

  - cast_id 값이 10보다 작은 배우의 이름을 리스트에 저장합니다.
  - department 값이 Directing인 감독의 이름을 리스트에 저장합니다.
  - 반환되는 딕셔너리는 cast, crew 두개의 key를 가지고 각각 배우리스트와 감독리스트를 value로 갖습니다.
  - 완성된 딕셔너리를 반환하는 함수 credits을 완성합니다.

- 문제 접근 방법 및 코드 설명

  ```python
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
  ```

  - 이번 문제는 영화 제목을 입력받아 해당 영화의 감독과 배우 리스트를 출력하는 문제이다. 이전 문제와 같이 f스트링을 이용하여 요청을 보낼 URL을 작성하고 데이터를 받는다.
  - 입력받은 영화 제목을 이용하여 URL을 만들어 요청을 보내고 받은 데이터로 부터 영화의 ID를 이용해 새로 URL을 제작해 Credit정보를 받아왔다. 수집한 데이터로부터 list comprehension 을 통해 원하는 값만 저장하여 반환하였다.

## 후기

- 이번 프로젝트를 통해 API가 무엇인지 알게되었고, API를 이용하여 내가 원하는정보를 수집하는데에 필요한 지식들을 습득할 수 있었다. 또한, 내가 무언가를 하려고 할때 필요한 문서로부터 정보를 얻어내는 능력도 향상된 것 같다.
